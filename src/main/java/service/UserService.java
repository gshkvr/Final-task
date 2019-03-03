package service;

import controller.SessionRequestContent;
import dao.UserDao;
import dao.exception.DaoException;
import dao.impl.UserDaoImpl;
import entity.User;
import entity.UserRole;
import service.exception.*;
import util.CryptUtil;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

public class UserService {
    private UserService() {
    }

    public static UserService getInstance() {
        return UserService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    private final CryptUtil cryptUtil = CryptUtil.getInstance();
    private final UserDao userDao = UserDaoImpl.getInstance();

    public void loginUser(SessionRequestContent content) throws ServiceException, NoSuchUserException {
        String login = content.getRequestParameter(User.LOGIN);
        String pass = content.getRequestParameter(User.PASSWORD);
        Optional<User> optionalUser = findUserByLogin(login);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (cryptUtil.checkPassword(pass, user.getPassword())) {
                content.setSessionAttribute(User.TABLE_NAME, login);
                content.setSessionAttribute(User.USER_ROLE, user.getRole().getValue());
                Cookie userCookie = new Cookie(User.TABLE_NAME, login);
                Cookie roleCookie = new Cookie(User.USER_ROLE, user.getRole().getValue());
                content.setCookie(userCookie);
                content.setCookie(roleCookie);
            }
        } else {
            throw new NoSuchUserException();
        }
    }

    public void registerUser(SessionRequestContent content) throws ServiceException, LoginExistsException, EmailExistsException, NotEqualPasswordsException {
        String login = content.getRequestParameter(User.LOGIN);
        if(checkLoginExists(login)){
            throw new LoginExistsException();
        }

        String email = content.getRequestParameter(User.EMAIL);
        if (checkEmailExists(email)) {
            throw new EmailExistsException();
        }

        String password = content.getRequestParameter(User.PASSWORD);
        String confirmPassword = content.getRequestParameter(User.CONFIRM_PASSWORD);
        if (!password.equals(confirmPassword)) {
            throw new NotEqualPasswordsException();
        }
        password = cryptUtil.cryptPassword(password);

        String firstName = content.getRequestParameter(User.FIRST_NAME);
        String lastName = content.getRequestParameter(User.LAST_NAME);

        User user = new User(0, UserRole.CLIENT, login, password, email, firstName, lastName);

        addUser(user);
    }

    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private Optional<User> findUserByLogin(String login) throws ServiceException {
        try {
            return userDao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> findUserByEmail(String email) throws ServiceException {
        try {
            return userDao.findUserByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean checkLoginExists(String login) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByLogin(login);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean checkEmailExists(String email) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByEmail(email);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean addUser(User user) throws ServiceException {
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteUser(int userId) throws ServiceException {
        try {
            return userDao.delete(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean makeUserAdmin(int userId) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findEntityById(userId);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                UserRole admin = UserRole.ADMIN;
                user.setRole(admin);
                return userDao.update(user);
            } else {
                throw new ServiceException("Can't make user with id = " + userId + " admin");
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

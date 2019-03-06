package service;

import builder.impl.UserBuilderImpl;
import controller.SessionRequestContent;
import dao.UserDao;
import dao.exception.DaoException;
import dao.impl.UserDaoImpl;
import entity.User;
import entity.UserRole;
import service.exception.*;
import util.CryptUtil;

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
        String login = content.getRequestParameter(UserBuilderImpl.LOGIN);
        String pass = content.getRequestParameter(UserBuilderImpl.PASSWORD);
        Optional<User> optionalUser = findUserByLogin(login);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (cryptUtil.checkPassword(pass, user.getPassword())) {
                content.setSessionAttribute(UserBuilderImpl.TABLE_NAME, user.getLogin());
                content.setSessionAttribute(UserBuilderImpl.USER_ROLE, user.getRole().getValue());
            }
        } else {
            throw new NoSuchUserException();
        }
    }

    public void registerUser(SessionRequestContent content) throws ServiceException, LoginExistsException, EmailExistsException, NotEqualPasswordsException {
        String login = content.getRequestParameter(UserBuilderImpl.LOGIN);
        if (checkLoginExists(login)) {
            throw new LoginExistsException();
        }

        String email = content.getRequestParameter(UserBuilderImpl.EMAIL);
        if (checkEmailExists(email)) {
            throw new EmailExistsException();
        }

        String password = content.getRequestParameter(UserBuilderImpl.PASSWORD);
        String confirmPassword = content.getRequestParameter(UserBuilderImpl.CONFIRM_PASSWORD);
        if (!password.equals(confirmPassword)) {
            throw new NotEqualPasswordsException();
        }
        password = cryptUtil.cryptPassword(password);

        String firstName = content.getRequestParameter(UserBuilderImpl.FIRST_NAME);
        String lastName = content.getRequestParameter(UserBuilderImpl.LAST_NAME);

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

    private boolean checkLoginExists(String login) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByLogin(login);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private boolean checkEmailExists(String email) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByEmail(email);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private boolean addUser(User user) throws ServiceException {
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteUser(SessionRequestContent content) throws ServiceException {
        try {
            String sUserId = content.getRequestParameter(UserBuilderImpl.USER_ID);
            int userId = Integer.parseInt(sUserId);
            return userDao.delete(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean makeUserAdmin(SessionRequestContent content) throws ServiceException {
        try {
            String sUserId = content.getRequestParameter(UserBuilderImpl.USER_ID);
            int userId = Integer.parseInt(sUserId);
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

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

/**
 * Provides methods to work with {@link User}
 * and "user" table.
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class UserService {
    private UserService() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static UserService getInstance() {
        return UserService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    private final CryptUtil cryptUtil = CryptUtil.getInstance();
    private final UserDao userDao = UserDaoImpl.getInstance();

    /**
     * Login user.
     *
     * @param content the content
     * @throws ServiceException    the service exception
     * @throws NoSuchUserException the no such user exception
     */
    public boolean loginUser(SessionRequestContent content) throws ServiceException, NoSuchUserException {
        String login = content.getRequestParameter(UserBuilderImpl.LOGIN);
        String pass = content.getRequestParameter(UserBuilderImpl.PASSWORD);
        Optional<User> optionalUser = findUserByLogin(login);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (cryptUtil.checkPassword(pass, user.getPassword())) {
                content.setSessionAttribute(UserBuilderImpl.TABLE_NAME, user.getLogin());
                content.setSessionAttribute(UserBuilderImpl.USER_ROLE, user.getRole().getValue());
                return true;
            } else {
                throw new NoSuchUserException();
            }
        } else {
            throw new NoSuchUserException();
        }
    }

    /**
     * Register user.
     *
     * @param content the content
     * @throws ServiceException           the service exception
     * @throws LoginExistsException       the login exists exception
     * @throws EmailExistsException       the email exists exception
     * @throws NotEqualPasswordsException the not equal passwords exception
     */
    public boolean registerUser(SessionRequestContent content) throws ServiceException, LoginExistsException, EmailExistsException, NotEqualPasswordsException {
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
        return true;
    }

    /**
     * Gets all users.
     *
     * @return the all users
     * @throws ServiceException the service exception
     */
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

    private void addUser(User user) throws ServiceException {
        try {
            userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Delete user.
     *
     * @param content the content
     * @throws ServiceException the service exception
     */
    public boolean deleteUser(SessionRequestContent content) throws ServiceException {
        try {
            String sUserId = content.getRequestParameter(UserBuilderImpl.USER_ID);
            int userId = Integer.parseInt(sUserId);
            userDao.delete(userId, true);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Make user admin.
     *
     * @param content the content
     * @throws ServiceException the service exception
     */
    public boolean makeUserAdmin(SessionRequestContent content) throws ServiceException {
        try {
            String sUserId = content.getRequestParameter(UserBuilderImpl.USER_ID);
            int userId = Integer.parseInt(sUserId);
            Optional<User> optionalUser = userDao.findEntityById(userId);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                UserRole admin = UserRole.ADMIN;
                user.setRole(admin);
                userDao.update(user);
                return true;
            } else {
                throw new ServiceException("Can't make user with id = " + userId + " admin");
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

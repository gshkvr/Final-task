package service;

import dao.impl.UserDao;
import entity.impl.User;
import entity.impl.UserRole;
import exception.DaoException;
import exception.ServiceException;

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

    private final UserDao userDao = new UserDao();

    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<User> findUserByLogin(String login) throws ServiceException {
        try {
            return userDao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<User> findUserByEmail(String email) throws ServiceException {
        try {
            return userDao.findUserByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean checkLoginExists(String login) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByLogin(login);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean checkEmailExists(String email) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findUserByEmail(email);
            return optionalUser.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean addUser(User user) throws ServiceException {
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean deleteUser(int userId) throws ServiceException {
        try {
            return userDao.delete(userId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean makeUserAdmin(int userId) throws ServiceException {
        try {
            Optional<User> optionalUser = userDao.findEntityById(userId);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                UserRole admin = UserRole.ADMIN;
                user.setRole(admin);
                return userDao.update(user);
            } else {
                throw new ServiceException("Can't make user with id = " + userId + " admin");
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}

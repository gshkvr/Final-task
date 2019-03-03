package dao;

import entity.User;
import dao.exception.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<Integer, User> {
    Optional<User> findUserByLogin(String login) throws DaoException;

    Optional<User> findUserByEmail(String email) throws DaoException;
}

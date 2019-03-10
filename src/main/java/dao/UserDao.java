package dao;

import dao.exception.DaoException;
import entity.User;

import java.util.Optional;


/**
 * Provides additional methods for work
 * with "user" table.
 *
 * @author George Kvirikashvili
 */
public interface UserDao extends Dao<Integer, User> {
    /**
     * Find optional {@link User} by login.
     *
     * @param login the login
     * @return the optional object user
     * @throws DaoException if some exception occurred
     */
    Optional<User> findUserByLogin(String login) throws DaoException;

    /**
     * Find optional {@link User} by email.
     *
     * @param email the email
     * @return the optional object user
     * @throws DaoException if some exception occurred
     */
    Optional<User> findUserByEmail(String email) throws DaoException;
}

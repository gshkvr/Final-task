package dao;

import dao.exception.DaoException;
import entity.AbstractEntity;

import java.util.List;
import java.util.Optional;


/**
 * Provides methods for work with database tables.
 * Gets information from tables and pits it into
 * objects to work with them in java environment.
 * Information puts in objects that extends
 * {@link AbstractEntity}.
 *
 * @param <K> type of additional parameter
 * @param <T> type of object which will return
 * @author George Kvirikashvili
 */
public interface Dao<K, T extends AbstractEntity> {
    /**
     * Find all records in table and
     * returns list of objects.
     *
     * @return the list of {@link T}
     * @throws DaoException if some exception occurred
     */
    List<T> findAll() throws DaoException;

    /**
     * Find optional object by id.
     *
     * @param id the id of looking object
     * @return the optional object of {@link T}
     * @throws DaoException if some exception occurred
     */
    Optional<T> findEntityById(K id) throws DaoException;

    /**
     * Delete object by id.
     *
     * @param id     the id of deleting object
     * @param commit the parameter which shows if need autocommit or not
     * @throws DaoException if some exception occurred
     */
    void delete(K id, boolean commit) throws DaoException;

    /**
     * Create new object of type {@link T}.
     *
     * @param entity the entity which saving
     * @throws DaoException if some exception occurred
     */
    void create(T entity) throws DaoException;

    /**
     * Update object.
     *
     * @param entity the entity which updating
     * @throws DaoException if some exception occurred
     */
    void update(T entity) throws DaoException;
}

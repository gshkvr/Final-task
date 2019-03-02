package dao;

import entity.AbstractEntity;
import dao.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<K, T extends AbstractEntity> {
        List<T> findAll() throws DaoException;
        Optional<T> findEntityById(K id) throws DaoException;
        boolean delete(K id) throws DaoException;
        boolean create(T entity)  throws DaoException;
        boolean update(T entity) throws DaoException;
}

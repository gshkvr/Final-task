package dao;

import builder.Builder;
import builder.BuilderFactory;
import entity.AbstractEntity;
import exception.BuilderException;
import exception.ConnectionPoolException;
import exception.DaoException;
import exception.ProxyConnectionException;
import pool.ConnectionPool;
import pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<K, T extends AbstractEntity> implements Dao<K, T> {
    private BuilderFactory builderFactory = BuilderFactory.INSTANCE;

    @Override
    public List<T> findAll() throws DaoException {
        String query = getFindAllQuery();
        return executeListQuery(query);
    }

    private List<T> executeListQuery(String query, Object... parameters) throws DaoException {
        try (ProxyConnection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            Builder<? extends AbstractEntity> builder = builderFactory.getBuilder(getTableName());
            setParameters(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                T item = (T) builder.build(resultSet);
                result.add(item);
            }
            return result;
        } catch (SQLException | BuilderException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<T> findEntityById(K id) throws DaoException {
        String query = getFindEntityByIdQuery();
        return executeEntityQuery(query, id);
    }

    protected Optional<T> executeEntityQuery(String query, Object... parameters) throws DaoException {
        List<T> queryResult = executeListQuery(query, parameters);
        return queryResult.size() == 1
                ? Optional.of(queryResult.get(0))
                : Optional.empty();
    }

    @Override
    public boolean create(T entity) throws DaoException {
        String query = getCreateQuery();
        List<String> parameters = getParametersForCreate(entity);
        return executeCreateUpdateDelete(query, parameters);
    }

    @Override
    public boolean update(T entity) throws DaoException {
        String query = getUpdateQuery();
        List<String> parameters = getParametersForUpdate(entity);
        return executeCreateUpdateDelete(query, parameters);
    }

    private List<String> getParametersForUpdate(T entity) {
        List<String> parameters = getParametersForCreate(entity);
        int id = entity.getId();
        String sId = String.valueOf(id);
        parameters.add(sId);
        return parameters;
    }

    @Override
    public boolean delete(K id) throws DaoException {
        String query = getDeleteQuery();
        List<String> parameters = new ArrayList<>();
        parameters.add(id.toString());
        return executeCreateUpdateDelete(query, parameters);
    }

    private boolean executeCreateUpdateDelete(String query, List<String> parameters) throws DaoException {
        try (ProxyConnection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            setParameters(statement, parameters);
            return statement.executeUpdate() == 1;
        } catch (SQLException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private void setParameters(PreparedStatement statement, Object[] parameters) throws SQLException {
        for (int i = 1; i <= parameters.length; i++) {
            Object parameter = parameters[i];
            if (parameter != null) {
                statement.setString(i, parameter.toString());
            } else {
                statement.setString(i, null);
            }
        }
    }

    private void setParameters(PreparedStatement statement, List parameters) throws SQLException {
        int i = 1;
        for (Object parameter : parameters) {
            if (parameter != null) {
                statement.setString(i, parameter.toString());
            } else {
                statement.setString(i, null);
            }
            i++;
        }
    }

    protected abstract List<String> getParametersForCreate(T entity);

    protected abstract String getFindAllQuery();

    protected abstract String getFindEntityByIdQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract String getTableName();
}
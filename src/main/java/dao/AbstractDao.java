package dao;

import builder.Builder;
import builder.BuilderFactory;
import builder.exception.BuilderException;
import dao.exception.ConnectionPoolException;
import dao.exception.DaoException;
import dao.exception.ProxyConnectionException;
import dao.pool.ConnectionPool;
import dao.pool.ProxyConnection;
import entity.AbstractEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<K, T extends AbstractEntity> implements Dao<K, T> {
    private final BuilderFactory builderFactory = BuilderFactory.getInstance();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<T> findAll() throws DaoException {
        String query = getFindAllQuery();
        return executeListQuery(query);
    }

    private List<T> executeListQuery(String query, Object... parameters) throws DaoException {
        try (ProxyConnection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            Builder builder = builderFactory.getBuilder(getTableName());
            setParameters(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                T item = (T) builder.build(resultSet);
                result.add(item);
            }
            return result;
        } catch (SQLException | BuilderException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e);
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
    public void create(T entity) throws DaoException {
        String query = getCreateQuery();
        List<String> parameters = getParametersForCreate(entity);
        executeCreateUpdateDelete(query, parameters, true);
    }

    @Override
    public void update(T entity) throws DaoException {
        String query = getUpdateQuery();
        List<String> parameters = getParametersForUpdate(entity);
        executeCreateUpdateDelete(query, parameters, true);
    }

    private List<String> getParametersForUpdate(T entity) {
        List<String> parameters = getParametersForCreate(entity);
        int id = entity.getId();
        String sId = String.valueOf(id);
        parameters.add(sId);
        return parameters;
    }

    @Override
    public void delete(K id, boolean commit) throws DaoException {
        String query = getDeleteQuery();
        List<String> parameters = new ArrayList<>();
        parameters.add(id.toString());
        executeCreateUpdateDelete(query, parameters, commit);
    }

    private void executeCreateUpdateDelete(String query, List<String> parameters, boolean commit) throws DaoException {
        try (ProxyConnection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            setParameters(statement, parameters);
            if (commit) {
                statement.executeUpdate();
            } else {
                connection.setAutoCommit(false);
                statement.executeUpdate();
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    private void setParameters(PreparedStatement statement, Object[] parameters) throws DaoException {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                if (parameter != null) {
                    statement.setString(i + 1, parameter.toString());
                } else {
                    statement.setString(i + 1, null);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Can't set parameters");
        }
    }

    private void setParameters(PreparedStatement statement, List parameters) throws DaoException {
        try {
            int i = 1;
            for (Object parameter : parameters) {
                if (parameter != null) {
                    statement.setString(i, parameter.toString());
                } else {
                    statement.setString(i, null);
                }
                i++;
            }
        } catch (SQLException e) {
            throw new DaoException("Can't set parameters");
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

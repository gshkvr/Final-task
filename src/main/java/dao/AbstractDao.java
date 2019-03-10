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
public abstract class AbstractDao<K, T extends AbstractEntity> implements Dao<K, T> {
    private final BuilderFactory builderFactory = BuilderFactory.getInstance();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final int ROWS_ON_PAGE = 6;

    @Override
    public List<T> findAll() throws DaoException {
        String query = getFindAllQuery();
        return executeListQuery(query);
    }

    @Override
    public List<T> findAll(int page) throws DaoException {
        String query = getFindAllPageQuery();
        return executeListQuery(query, (page - 1) * ROWS_ON_PAGE);
    }

    private List<T> executeListQuery(String query, Object... parameters) throws DaoException {
        try (ProxyConnection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            setParameters(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            return buildList(resultSet);
        } catch (SQLException | BuilderException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    private List<T> executeListQuery(String query, int parameter) throws DaoException {
        try (ProxyConnection connection = connectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            setParameter(statement, parameter);
            ResultSet resultSet = statement.executeQuery();
            return buildList(resultSet);
        } catch (SQLException | BuilderException | ProxyConnectionException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    private List<T> buildList(ResultSet resultSet) throws SQLException, BuilderException {
        Builder builder = builderFactory.getBuilder(getTableName());
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T item = (T) builder.build(resultSet);
            result.add(item);
        }
        return result;
    }

    @Override
    public Optional<T> findEntityById(K id) throws DaoException {
        String query = getFindEntityByIdQuery();
        return executeEntityQuery(query, id);
    }

    /**
     * Execute entity query optional.
     *
     * @param query      the query
     * @param parameters the parameters
     * @return the optional
     * @throws DaoException the dao exception
     */
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

    private void setParameter(PreparedStatement statement, int parameter) throws DaoException {
        try {
            statement.setInt(1, parameter);
        } catch (SQLException e) {
            throw new DaoException("Can't set parameters");
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

    /**
     * Gets parameters for create.
     *
     * @param entity the entity
     * @return the parameters for create
     */
    protected abstract List<String> getParametersForCreate(T entity);

    /**
     * Gets find all query.
     *
     * @return the find all query
     */
    protected abstract String getFindAllQuery();

    /**
     * Gets find all page query.
     *
     * @return the find all page query
     */
    protected abstract String getFindAllPageQuery();

    /**
     * Gets find entity by id query.
     *
     * @return the find entity by id query
     */
    protected abstract String getFindEntityByIdQuery();

    /**
     * Gets create query.
     *
     * @return the create query
     */
    public abstract String getCreateQuery();

    /**
     * Gets update query.
     *
     * @return the update query
     */
    public abstract String getUpdateQuery();

    /**
     * Gets delete query.
     *
     * @return the delete query
     */
    public abstract String getDeleteQuery();

    /**
     * Gets table name.
     *
     * @return the table name
     */
    protected abstract String getTableName();
}

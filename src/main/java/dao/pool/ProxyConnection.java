package dao.pool;

import dao.exception.ConnectionPoolException;
import dao.exception.ProxyConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Delegates all methods to {@link Connection}.
 * Overrides {@code close} method, instead closing,
 * returns connection to connection pool.
 *
 * @author George Kvirikashvili
 */
public class ProxyConnection implements AutoCloseable {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final Connection connection;

    /**
     * Instantiates a new Proxy connection.
     *
     * @param connection the connection
     */
    ProxyConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Return connection to connection pool.
     *
     * @throws ProxyConnectionException the proxy connection exception
     */
    public void close() throws ProxyConnectionException {
        try {
            connectionPool.returnConnection(this);
        } catch (ConnectionPoolException e) {
            throw new ProxyConnectionException("Couldn't return connection to pool", e);
        }
    }

    /**
     * Close connection.
     *
     * @throws ProxyConnectionException the proxy connection exception
     */
    void closeConnection() throws ProxyConnectionException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ProxyConnectionException("Couldn't close connection to pool", e);
        }
    }

    /**
     * Prepare statement.
     *
     * @param sql the sql
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    /**
     * Sets auto commit.
     *
     * @param autoCommit the auto commit
     * @throws SQLException the sql exception
     */
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }
}

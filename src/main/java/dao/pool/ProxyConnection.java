package dao.pool;

import dao.exception.ConnectionPoolException;
import dao.exception.ProxyConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProxyConnection implements AutoCloseable {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final Connection connection;

    ProxyConnection(Connection connection) {
        this.connection = connection;
    }

    public void close() throws ProxyConnectionException {
        try {
            connectionPool.returnConnection(this);
        } catch (ConnectionPoolException e) {
            throw new ProxyConnectionException("Couldn't return connection to pool", e);
        }
    }

    void closeConnection() throws ProxyConnectionException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ProxyConnectionException("Couldn't close connection to pool", e);
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }
}

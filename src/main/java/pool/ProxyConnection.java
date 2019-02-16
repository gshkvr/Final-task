package pool;

import exception.ConnectionPoolException;
import exception.ProxyConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProxyConnection implements AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private final Connection connection;

    public ProxyConnection(Connection connection) {
        this.connection = connection;
    }

    public void close() throws ProxyConnectionException {
        try {
            ConnectionPool.INSTANCE.returnConnection(this);
        } catch (ConnectionPoolException e) {
            LOGGER.info("Couldn't return connection to pool", e);
            throw new ProxyConnectionException(e);
        }
    }

    void closeConnection() throws ProxyConnectionException {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.info("Couldn't close connection to pool", e);
            throw new ProxyConnectionException(e);
        }
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    public void commit() throws SQLException {
        connection.commit();
    }

}

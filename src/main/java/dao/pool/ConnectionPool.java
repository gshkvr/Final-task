package dao.pool;

import dao.exception.ConnectionPoolException;
import dao.exception.ProxyConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.DbManager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return ConnectionPool.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final String DB_DRIVER = DbManager.getProperty("driver");
    private static final String DB_URL = DbManager.getProperty("url");
    private static final String DB_USER = DbManager.getProperty("user");
    private static final String DB_PASSWORD = DbManager.getProperty("password");
    private static final int DB_MAX_CONNECTIONS = Integer.parseInt(DbManager.getProperty("max_connections"));

    private final LinkedBlockingQueue<ProxyConnection> availableConnections = new LinkedBlockingQueue<>();
    private final ArrayDeque<ProxyConnection> usedConnections = new ArrayDeque<>();

    public void initialize() throws ConnectionPoolException {
        try {
            Class.forName(DB_DRIVER);
            for (int i = 0; i < DB_MAX_CONNECTIONS; i++) {
                ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD));
                availableConnections.add(connection);
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.fatal("Couldn't initialize connections in connection pool");
            throw new ConnectionPoolException(e);
        }
    }

    public ProxyConnection getConnection() throws ConnectionPoolException {
        try {
            ProxyConnection connection = availableConnections.take();
            usedConnections.push(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            return connection;
        } catch (SQLException | InterruptedException e) {
            throw new ConnectionPoolException("Exception getting connection", e);
        }
    }

    public void returnConnection(ProxyConnection connection) throws ConnectionPoolException {
        try {
            if (!connection.getAutoCommit()) {
                connection.setAutoCommit(true);
            }
            usedConnections.remove(connection);
            availableConnections.put(connection);
        } catch (SQLException | InterruptedException e) {
            throw new ConnectionPoolException("Exception returning connection", e);
        }
    }

    public final void close() throws ConnectionPoolException {
        try {
            closeConnections(usedConnections);
            closeConnections(availableConnections);
        } catch (ProxyConnectionException e) {
            LOGGER.info("Couldn't close connections in connection pool");
            throw new ConnectionPoolException(e);
        }
    }

    private void closeConnections(Queue<ProxyConnection> queue) throws ProxyConnectionException {
        ProxyConnection connection;
        while ((connection = queue.poll()) != null) {
            connection.closeConnection();
        }
    }

}

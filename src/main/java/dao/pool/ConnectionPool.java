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

/**
 * Connection pool contains queue of connections.
 *
 * @author George Kvirikashvili
 */
public class ConnectionPool {
    private ConnectionPool() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
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
    private static final int DB_MAX_CONNECTIONS = Integer.parseInt(DbManager.getProperty("max.connections"));

    private final LinkedBlockingQueue<ProxyConnection> availableConnections = new LinkedBlockingQueue<>();
    private final ArrayDeque<ProxyConnection> usedConnections = new ArrayDeque<>();

    /**
     * Initialize connections in connection pool.
     *
     * @throws ConnectionPoolException the connection pool exception
     */
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

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws ConnectionPoolException the connection pool exception
     */
    public ProxyConnection getConnection() throws ConnectionPoolException {
        try {
            ProxyConnection connection = availableConnections.take();
            usedConnections.push(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Exception getting connection", e);
        }
    }

    /**
     * Return connection.
     *
     * @param connection the connection
     * @throws ConnectionPoolException the connection pool exception
     */
    void returnConnection(ProxyConnection connection) throws ConnectionPoolException {
        try {
            usedConnections.remove(connection);
            availableConnections.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Exception returning connection", e);
        }
    }

    /**
     * Close connections in connection pool.
     *
     * @throws ConnectionPoolException the connection pool exception
     */
    public final void close() throws ConnectionPoolException {
        try {
            closeConnections(usedConnections);
            closeConnections(availableConnections);
        } catch (ProxyConnectionException e) {
            LOGGER.fatal("Couldn't close connections in connection pool");
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

package listener;

import dao.exception.ConnectionPoolException;
import dao.pool.ConnectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * The type Connection pool listener.
 * Initializes and destroys {@link ConnectionPool}
 * on {@link ServletContext} initialization
 * and destroying.
 *
 * @author George Kvirikashvili
 */
@WebListener
public class ConnectionPoolListener implements ServletContextListener {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            connectionPool.initialize();
        } catch (ConnectionPoolException e) {
            throw new ExceptionInInitializerError("Couldn't initialize connection pool");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            connectionPool.close();
        } catch (ConnectionPoolException e) {
            throw new ExceptionInInitializerError("Couldn't destroy connection pool");
        }
    }

}

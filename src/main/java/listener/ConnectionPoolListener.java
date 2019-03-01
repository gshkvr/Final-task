package listener;

import exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dao.pool.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionPoolListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.INSTANCE.initialize();
            System.out.println(LOGGER);
            LOGGER.info("Connection pool initialized");
        } catch (ConnectionPoolException e) {
            LOGGER.fatal("Connection pool didn't initialize", e);
            throw new ExceptionInInitializerError("Couldn't initialize connection pool");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.INSTANCE.close();
            LOGGER.info("Connection pool destroyed");
        } catch (ConnectionPoolException e) {
            LOGGER.info("Connection pool didn't destroy", e);
            throw new ExceptionInInitializerError("Couldn't destroy connection pool");
        }
    }

}

package dao.exception;

/**
 * The type Dao exception.
 * Indicates that some kind of Dao exception occurred.
 *
 * @author George Kvirikashvili
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = -8701662673949824535L;

    /**
     * Instantiates a new Dao exception.
     */
    public DaoException() {
        super();
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param cause the cause
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

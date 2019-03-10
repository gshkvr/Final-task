package dao.exception;

/**
 * The type Connection pool exception.
 * Indicates that some kind of Connection pool exception occurred.
 *
 * @author George Kvirikashvili
 */
public class ConnectionPoolException extends Exception {

    private static final long serialVersionUID = -3130088010799119183L;

    /**
     * Instantiates a new Connection pool exception.
     */
    public ConnectionPoolException() {
        super();
    }

    /**
     * Instantiates a new Connection pool exception.
     *
     * @param message the message
     */
    public ConnectionPoolException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Connection pool exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Connection pool exception.
     *
     * @param cause the cause
     */
    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Connection pool exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected ConnectionPoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

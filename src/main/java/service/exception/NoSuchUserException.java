package service.exception;

/**
 * The type No such user exception.
 * Indicates that there is no such user in database.
 *
 * @author George Kvirikashvili
 */
public class NoSuchUserException extends Exception {

    private static final long serialVersionUID = -4038015864921469557L;

    /**
     * Instantiates a new No such user exception.
     */
    public NoSuchUserException() {
        super();
    }

    /**
     * Instantiates a new No such user exception.
     *
     * @param message the message
     */
    public NoSuchUserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new No such user exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new No such user exception.
     *
     * @param cause the cause
     */
    public NoSuchUserException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new No such user exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected NoSuchUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

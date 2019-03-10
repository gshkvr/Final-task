package service.exception;

/**
 * The type No such news exception.
 * Indicates that there is no such news in database.
 *
 * @author George Kvirikashvili
 */
public class NoSuchNewsException extends Exception {

    private static final long serialVersionUID = 7080271732367109666L;

    /**
     * Instantiates a new No such news exception.
     */
    public NoSuchNewsException() {
        super();
    }

    /**
     * Instantiates a new No such news exception.
     *
     * @param message the message
     */
    public NoSuchNewsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new No such news exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoSuchNewsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new No such news exception.
     *
     * @param cause the cause
     */
    public NoSuchNewsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new No such news exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected NoSuchNewsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package service.exception;

/**
 * The type No such request exception.
 * Indicates that there is no such request in database.
 *
 * @author George Kvirikashvili
 */
public class NoSuchRequestException extends Exception {

    private static final long serialVersionUID = 4933381768390115761L;

    /**
     * Instantiates a new No such request exception.
     */
    public NoSuchRequestException() {
        super();
    }

    /**
     * Instantiates a new No such request exception.
     *
     * @param message the message
     */
    public NoSuchRequestException(String message) {
        super(message);
    }

    /**
     * Instantiates a new No such request exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoSuchRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new No such request exception.
     *
     * @param cause the cause
     */
    public NoSuchRequestException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new No such request exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected NoSuchRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

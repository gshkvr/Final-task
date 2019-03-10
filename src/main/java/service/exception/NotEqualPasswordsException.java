package service.exception;

/**
 * The type Not equal passwords exception.
 * Indicates that input passwords are not equal.
 *
 * @author George Kvirikashvili
 */
public class NotEqualPasswordsException extends Exception {

    private static final long serialVersionUID = 8924485845383146075L;

    /**
     * Instantiates a new Not equal passwords exception.
     */
    public NotEqualPasswordsException() {
        super();
    }

    /**
     * Instantiates a new Not equal passwords exception.
     *
     * @param message the message
     */
    public NotEqualPasswordsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Not equal passwords exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NotEqualPasswordsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Not equal passwords exception.
     *
     * @param cause the cause
     */
    public NotEqualPasswordsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Not equal passwords exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected NotEqualPasswordsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

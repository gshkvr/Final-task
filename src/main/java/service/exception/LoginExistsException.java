package service.exception;

/**
 * The type Login exists exception.
 * Indicates that login exists in database.
 *
 * @author George Kvirikashvili
 */
public class LoginExistsException extends Exception {

    private static final long serialVersionUID = 7225229618218223098L;

    /**
     * Instantiates a new Login exists exception.
     */
    public LoginExistsException() {
        super();
    }

    /**
     * Instantiates a new Login exists exception.
     *
     * @param message the message
     */
    public LoginExistsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Login exists exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LoginExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Login exists exception.
     *
     * @param cause the cause
     */
    public LoginExistsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Login exists exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected LoginExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

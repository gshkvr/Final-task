package service.exception;

/**
 * The type Email exists exception.
 * Indicates that email exists in database.
 *
 * @author George Kvirikashvili
 */
public class EmailExistsException extends Exception {

    private static final long serialVersionUID = -1945574065978012659L;

    /**
     * Instantiates a new Email exists exception.
     */
    public EmailExistsException() {
        super();
    }

    /**
     * Instantiates a new Email exists exception.
     *
     * @param message the message
     */
    public EmailExistsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Email exists exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Email exists exception.
     *
     * @param cause the cause
     */
    public EmailExistsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Email exists exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmailExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

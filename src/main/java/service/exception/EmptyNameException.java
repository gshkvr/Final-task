package service.exception;

/**
 * The type Empty name exception.
 * Indicates that name parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyNameException extends Exception {

    private static final long serialVersionUID = 2080285360063101043L;

    /**
     * Instantiates a new Empty name exception.
     */
    public EmptyNameException() {
        super();
    }

    /**
     * Instantiates a new Empty name exception.
     *
     * @param message the message
     */
    public EmptyNameException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty name exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyNameException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty name exception.
     *
     * @param cause the cause
     */
    public EmptyNameException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty name exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

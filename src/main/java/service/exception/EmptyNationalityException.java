package service.exception;

/**
 * The type Empty nationality exception.
 * Indicates that nationality parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyNationalityException extends Exception {

    private static final long serialVersionUID = -7310122496807975135L;

    /**
     * Instantiates a new Empty nationality exception.
     */
    public EmptyNationalityException() {
        super();
    }

    /**
     * Instantiates a new Empty nationality exception.
     *
     * @param message the message
     */
    public EmptyNationalityException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty nationality exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyNationalityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty nationality exception.
     *
     * @param cause the cause
     */
    public EmptyNationalityException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty nationality exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyNationalityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package service.exception;

/**
 * The type Empty type exception.
 * Indicates that type parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyTypeException extends Exception {

    private static final long serialVersionUID = 1408942568274650989L;

    /**
     * Instantiates a new Empty type exception.
     */
    public EmptyTypeException() {
        super();
    }

    /**
     * Instantiates a new Empty type exception.
     *
     * @param message the message
     */
    public EmptyTypeException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty type exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty type exception.
     *
     * @param cause the cause
     */
    public EmptyTypeException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty type exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

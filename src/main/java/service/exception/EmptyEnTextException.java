package service.exception;

/**
 * The type Empty en text exception.
 * Indicates that en text parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyEnTextException extends Exception {

    private static final long serialVersionUID = -837667400292070421L;

    /**
     * Instantiates a new Empty en text exception.
     */
    public EmptyEnTextException() {
        super();
    }

    /**
     * Instantiates a new Empty en text exception.
     *
     * @param message the message
     */
    public EmptyEnTextException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty en text exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyEnTextException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty en text exception.
     *
     * @param cause the cause
     */
    public EmptyEnTextException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty en text exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyEnTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

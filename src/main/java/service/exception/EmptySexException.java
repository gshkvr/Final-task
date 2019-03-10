package service.exception;

/**
 * The type Empty sex exception.
 * Indicates that sex parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptySexException extends Exception {

    private static final long serialVersionUID = -6674431066940053881L;

    /**
     * Instantiates a new Empty sex exception.
     */
    public EmptySexException() {
        super();
    }

    /**
     * Instantiates a new Empty sex exception.
     *
     * @param message the message
     */
    public EmptySexException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty sex exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptySexException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty sex exception.
     *
     * @param cause the cause
     */
    public EmptySexException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty sex exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptySexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

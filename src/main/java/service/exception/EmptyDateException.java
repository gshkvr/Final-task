package service.exception;

/**
 * The type Empty date exception.
 * Indicates that date parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyDateException extends Exception {

    private static final long serialVersionUID = 6530785043199283410L;

    /**
     * Instantiates a new Empty date exception.
     */
    public EmptyDateException() {
        super();
    }

    /**
     * Instantiates a new Empty date exception.
     *
     * @param message the message
     */
    public EmptyDateException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty date exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyDateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty date exception.
     *
     * @param cause the cause
     */
    public EmptyDateException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty date exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

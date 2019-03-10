package service.exception;

/**
 * The type Empty en title exception.
 * Indicates that en title parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyEnTitleException extends Exception {

    private static final long serialVersionUID = -5935373980853315130L;

    /**
     * Instantiates a new Empty en title exception.
     */
    public EmptyEnTitleException() {
        super();
    }

    /**
     * Instantiates a new Empty en title exception.
     *
     * @param message the message
     */
    public EmptyEnTitleException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty en title exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyEnTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty en title exception.
     *
     * @param cause the cause
     */
    public EmptyEnTitleException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty en title exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyEnTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package service.exception;

/**
 * The type Empty ru title exception.
 * Indicates that ru title parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyRuTitleException extends Exception {

    private static final long serialVersionUID = 7912739379216193609L;

    /**
     * Instantiates a new Empty ru title exception.
     */
    public EmptyRuTitleException() {
        super();
    }

    /**
     * Instantiates a new Empty ru title exception.
     *
     * @param message the message
     */
    public EmptyRuTitleException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty ru title exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyRuTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty ru title exception.
     *
     * @param cause the cause
     */
    public EmptyRuTitleException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty ru title exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyRuTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

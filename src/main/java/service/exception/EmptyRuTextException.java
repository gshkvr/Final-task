package service.exception;

/**
 * The type Empty ru text exception.
 * Indicates that ru text parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyRuTextException extends Exception {

    private static final long serialVersionUID = 4856332852880962885L;

    /**
     * Instantiates a new Empty ru text exception.
     */
    public EmptyRuTextException() {
        super();
    }

    /**
     * Instantiates a new Empty ru text exception.
     *
     * @param message the message
     */
    public EmptyRuTextException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty ru text exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyRuTextException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty ru text exception.
     *
     * @param cause the cause
     */
    public EmptyRuTextException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty ru text exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyRuTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

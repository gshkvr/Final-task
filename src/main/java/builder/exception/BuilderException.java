package builder.exception;

/**
 * Indicates that some kind of Builder exception occurred.
 *
 * @author George Kvirikashvili
 */
public class BuilderException extends Exception {

    private static final long serialVersionUID = -5697151538671679723L;

    /**
     * Instantiates a new Builder exception.
     */
    public BuilderException() {
        super();
    }

    /**
     * Instantiates a new Builder exception.
     *
     * @param message the message
     */
    public BuilderException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Builder exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Builder exception.
     *
     * @param cause the cause
     */
    public BuilderException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Builder exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected BuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

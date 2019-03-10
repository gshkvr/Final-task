package service.exception;

/**
 * The type Empty file exception.
 * Indicates that file parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyFileException extends Exception {

    private static final long serialVersionUID = -3943155247682910083L;

    /**
     * Instantiates a new Empty file exception.
     */
    public EmptyFileException() {
        super();
    }

    /**
     * Instantiates a new Empty file exception.
     *
     * @param message the message
     */
    public EmptyFileException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty file exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty file exception.
     *
     * @param cause the cause
     */
    public EmptyFileException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty file exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

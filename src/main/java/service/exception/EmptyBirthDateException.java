package service.exception;

/**
 * The type Empty birth date exception.
 * Indicates that birth date parameter is empty.
 *
 * @author George Kvirikashvili
 */
public class EmptyBirthDateException extends Exception {

    private static final long serialVersionUID = 7417090518352674773L;

    /**
     * Instantiates a new Empty birth date exception.
     */
    public EmptyBirthDateException() {
        super();
    }

    /**
     * Instantiates a new Empty birth date exception.
     *
     * @param message the message
     */
    public EmptyBirthDateException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Empty birth date exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmptyBirthDateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Empty birth date exception.
     *
     * @param cause the cause
     */
    public EmptyBirthDateException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Empty birth date exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected EmptyBirthDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

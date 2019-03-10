package command.exception;

/**
 * The type Command exception.
 * Indicates that some kind of Command exception occurred.
 *
 * @author George Kvirikashvili
 */
public class CommandException extends Exception {

    private static final long serialVersionUID = -8096324692832465617L;

    /**
     * Instantiates a new Command exception.
     */
    public CommandException() {
        super();
    }

    /**
     * Instantiates a new Command exception.
     *
     * @param message the message
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Command exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Command exception.
     *
     * @param cause the cause
     */
    public CommandException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Command exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected CommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

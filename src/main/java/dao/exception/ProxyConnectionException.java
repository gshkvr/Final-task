package dao.exception;

/**
 * The type Proxy connection exception.
 * Indicates that some kind of Proxy connection exception occurred.
 *
 * @author George Kvirikashvili
 */
public class ProxyConnectionException extends Exception {

    private static final long serialVersionUID = -7799340038986297204L;

    /**
     * Instantiates a new Proxy connection exception.
     */
    public ProxyConnectionException() {
        super();
    }

    /**
     * Instantiates a new Proxy connection exception.
     *
     * @param message the message
     */
    public ProxyConnectionException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Proxy connection exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ProxyConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Proxy connection exception.
     *
     * @param cause the cause
     */
    public ProxyConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Proxy connection exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected ProxyConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package dao.exception;

public class ProxyConnectionException extends Exception {

    private static final long serialVersionUID = -7799340038986297204L;

    public ProxyConnectionException() {
        super();
    }

    public ProxyConnectionException(String message) {
        super(message);
    }

    public ProxyConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProxyConnectionException(Throwable cause) {
        super(cause);
    }

    protected ProxyConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

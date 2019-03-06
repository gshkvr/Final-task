package service.exception;

public class NoSuchNewsException extends Exception {

    private static final long serialVersionUID = 7080271732367109666L;

    public NoSuchNewsException() {
        super();
    }

    public NoSuchNewsException(String message) {
        super(message);
    }

    public NoSuchNewsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchNewsException(Throwable cause) {
        super(cause);
    }

    protected NoSuchNewsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

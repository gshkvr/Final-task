package service.exception;

public class EmptyNameException extends Exception {

    private static final long serialVersionUID = 2080285360063101043L;

    public EmptyNameException() {
        super();
    }

    public EmptyNameException(String message) {
        super(message);
    }

    public EmptyNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyNameException(Throwable cause) {
        super(cause);
    }

    protected EmptyNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

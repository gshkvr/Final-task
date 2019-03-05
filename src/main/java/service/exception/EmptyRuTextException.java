package service.exception;

public class EmptyRuTextException extends Exception {

    private static final long serialVersionUID = 4856332852880962885L;

    public EmptyRuTextException() {
        super();
    }

    public EmptyRuTextException(String message) {
        super(message);
    }

    public EmptyRuTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyRuTextException(Throwable cause) {
        super(cause);
    }

    protected EmptyRuTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

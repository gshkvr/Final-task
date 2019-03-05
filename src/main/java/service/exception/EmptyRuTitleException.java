package service.exception;

public class EmptyRuTitleException extends Exception {

    private static final long serialVersionUID = 7912739379216193609L;

    public EmptyRuTitleException() {
        super();
    }

    public EmptyRuTitleException(String message) {
        super(message);
    }

    public EmptyRuTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyRuTitleException(Throwable cause) {
        super(cause);
    }

    protected EmptyRuTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

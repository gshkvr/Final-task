package service.exception;

public class EmptyEnTitleException extends Exception {

    private static final long serialVersionUID = -5935373980853315130L;

    public EmptyEnTitleException() {
        super();
    }

    public EmptyEnTitleException(String message) {
        super(message);
    }

    public EmptyEnTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyEnTitleException(Throwable cause) {
        super(cause);
    }

    protected EmptyEnTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

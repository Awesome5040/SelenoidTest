package hometask.core.exceptions;

public class TAFRuntimeException extends RuntimeException{

    public TAFRuntimeException(final String message, final Throwable exception) {
        super(message, exception);
    }

    public TAFRuntimeException(final String message) {
        super(message);
    }

}

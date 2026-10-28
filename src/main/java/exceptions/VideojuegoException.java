package exceptions;

public class VideojuegoException extends Exception {
    public VideojuegoException(String message) {
        super(message);
    }
    public VideojuegoException(String message, Throwable causa) {
        super(message, causa);
    }

}

package pl.edu.pjwstk.interpreter.exception;

public class WrongTypeException extends RuntimeException {

    public WrongTypeException() {
        super();
    }

    public WrongTypeException(String message) {
        super(message);
    }
}

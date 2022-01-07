package exception;

public class NoStudentsInGroupException extends RuntimeException {
    public NoStudentsInGroupException(String message) {
        super(message);
    }
}

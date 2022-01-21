package exception;

public class NoFacultiesInUniversity extends RuntimeException {
    public NoFacultiesInUniversity(String message) {
        super(message);
    }
}

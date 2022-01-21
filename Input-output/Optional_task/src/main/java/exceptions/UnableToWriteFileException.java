package exceptions;

public class UnableToWriteFileException extends RuntimeException{
    public UnableToWriteFileException(String message) {
        super(message);
    }
}

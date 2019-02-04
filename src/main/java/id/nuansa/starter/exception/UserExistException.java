package id.nuansa.starter.exception;

public class UserExistException extends RuntimeException {

    public UserExistException() {
        super("User already exist with this email");
    }
}

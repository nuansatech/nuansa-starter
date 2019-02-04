package id.nuansa.starter.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super("Data not found");
    }
}

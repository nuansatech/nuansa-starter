package id.nuansa.starter.exception;

public class StorageFileNotFoundException extends RuntimeException {

    public StorageFileNotFoundException() {
        super("File not found");
    }
}

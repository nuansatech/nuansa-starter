package id.nuansa.starter.exception;

import id.nuansa.starter.constant.StatusCode;
import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    public String errorMessage;
    public StatusCode statusCode;
    public HttpStatus code;

    public AppException(String errorMessage, StatusCode statusCode, HttpStatus code) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.code = code;
    }
}
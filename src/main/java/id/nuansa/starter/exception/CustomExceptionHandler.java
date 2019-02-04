package id.nuansa.starter.exception;

import id.nuansa.starter.base.MetaResponse;
import id.nuansa.starter.base.ResultResponse;
import id.nuansa.starter.constant.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = status.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = status.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, status);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ResultResponse> badRequest(AppException ex) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = ex.code.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultResponse> generalError(Exception ex) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        metaResponse.message = messageSource.getMessage("response.general.error", null, LocaleContextHolder.getLocale());
        metaResponse.debugInfo = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<ResultResponse> userExist(UserExistException ex) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = HttpStatus.BAD_REQUEST.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResultResponse> dataNotFound(DataNotFoundException ex) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = HttpStatus.NOT_FOUND.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<ResultResponse> fileNotFound(StorageFileNotFoundException ex) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.code = HttpStatus.NOT_FOUND.value();
        metaResponse.message = ex.getLocalizedMessage();

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.status = StatusCode.ERROR.name();
        resultResponse.meta = metaResponse;
        return new ResponseEntity<>(resultResponse, HttpStatus.NOT_FOUND);
    }
}

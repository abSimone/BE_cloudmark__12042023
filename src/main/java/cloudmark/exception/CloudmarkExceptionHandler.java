package cloudmark.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CloudmarkExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex.getMessage(), errors);

        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
        
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex.getMessage(), errors);

        return new ResponseEntity<>(apiError, apiError.getHttpStatus());

    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFound(RecordNotFoundException ex) {
    
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex.getMessage(), ex.getErrors());
        
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    
    }

    @ExceptionHandler(IncorrectServiceException.class)
    public ResponseEntity<Object> handleIncorrectService(IncorrectServiceException ex) {
    
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex.getMessage(), ex.getErrors());
        
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<Object> handleDuplicateRecord(DuplicateRecordException ex) {
    
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex.getMessage(), ex.getErrors());
        
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    
    }

}
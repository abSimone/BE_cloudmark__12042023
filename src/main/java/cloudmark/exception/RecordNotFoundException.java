package cloudmark.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class RecordNotFoundException extends RuntimeException {

    Map<String,String> errors = new HashMap<>();

    public RecordNotFoundException(String message, String fieldName, String error) {
        super(message);
        this.errors.put(fieldName, error);
    }

    public RecordNotFoundException(String message, Map<String,String> errors) {
        super(message);
        this.errors = errors;
    }

}
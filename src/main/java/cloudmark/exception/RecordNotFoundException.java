package cloudmark.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class RecordNotFoundException extends RuntimeException {

    Map<String,String> errors = new HashMap<>();

    public RecordNotFoundException(String message, String recordType, String error) {
        super(message);
        this.errors.put(recordType, error);
    }

}
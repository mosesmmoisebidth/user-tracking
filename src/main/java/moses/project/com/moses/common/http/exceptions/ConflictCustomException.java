package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictCustomException extends ResponseStatusException {

    public ConflictCustomException(){
        super(HttpStatus.CONFLICT, "Conflict Error");
    }

    public ConflictCustomException(String message){
        super(HttpStatus.CONFLICT, message);
    }

    public ConflictCustomException(String message, Throwable cause){
        super(HttpStatus.CONFLICT, message, cause);
    }
}
package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class UnprocessableEntityError extends ResponseStatusException {
    
    public UnprocessableEntityError(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessable Entity Error");
    }

    public UnprocessableEntityError(String message){
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

    public UnprocessableEntityError(String message, Throwable cause){
        super(HttpStatus.UNPROCESSABLE_ENTITY, message, cause);
    }

}

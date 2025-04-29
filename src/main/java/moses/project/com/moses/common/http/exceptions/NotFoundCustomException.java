package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class NotFoundCustomException extends ResponseStatusException {
    
    public NotFoundCustomException(){
        super(HttpStatus.NOT_FOUND, "Not Found Error");
    }

    public NotFoundCustomException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }

    public NotFoundCustomException(String message, Throwable cause){
        super(HttpStatus.NOT_FOUND, message, cause);
    }

}

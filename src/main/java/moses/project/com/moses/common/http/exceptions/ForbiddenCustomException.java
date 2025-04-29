package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class ForbiddenCustomException extends ResponseStatusException {
    public ForbiddenCustomException(){
        super(HttpStatus.FORBIDDEN, "Forbidden Error");
    }

    public ForbiddenCustomException(String message){
        super(HttpStatus.FORBIDDEN, message);
    }

    public ForbiddenCustomException(String message, Throwable cause){
        super(HttpStatus.FORBIDDEN, message, cause);
    }
    
}

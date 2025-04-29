package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class BadRequestCustomException extends ResponseStatusException {
    
    public BadRequestCustomException(){
        super(HttpStatus.BAD_REQUEST, "Bad Request Error");
    }

    public BadRequestCustomException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }

    public BadRequestCustomException(String message, Throwable cause){
        super(HttpStatus.BAD_REQUEST, message, cause);
    }
    
}

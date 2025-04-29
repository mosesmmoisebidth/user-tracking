package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class UnauthorizedCustomException extends ResponseStatusException {
    
    public UnauthorizedCustomException(){
        super(HttpStatus.UNAUTHORIZED, "Unauthorized Error");
    }

    public UnauthorizedCustomException(String message){
        super(HttpStatus.UNAUTHORIZED, message);
    }

    public UnauthorizedCustomException(String message, Throwable cause){
        super(HttpStatus.UNAUTHORIZED, message, cause);
    }

}

package moses.project.com.moses.common.http.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class InternalServerErrorException extends ResponseStatusException {
    
    public InternalServerErrorException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    public InternalServerErrorException(String message){
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public InternalServerErrorException(String message, Throwable cause){
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }

}

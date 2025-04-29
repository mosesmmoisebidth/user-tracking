package moses.project.response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import moses.project.com.moses.common.dtos.ResponseDto;
import moses.project.com.moses.common.enums.EResponse;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Scope("request")
public class ResponseService {
    
    private final HttpServletRequest request;

    @Autowired
    public ResponseService(HttpServletRequest request){
        this.request = request;
    }

    public <T> ResponseDto<T> makeResponse(String message, T payload, EResponse response) {
        boolean success = response == EResponse.SUCCESS;
        String path = request.getRequestURI();
        String method = request.getMethod();
        long timestamp = System.currentTimeMillis();

        return new ResponseDto<> (
            success,
            message,
            payload,
            path,
            method,
            timestamp
        );

    } 

}

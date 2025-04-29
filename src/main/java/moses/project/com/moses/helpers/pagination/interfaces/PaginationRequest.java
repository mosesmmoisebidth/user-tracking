package moses.project.com.moses.helpers.pagination.interfaces;
import lombok.Data;
import java.util.Map;

@Data
public class PaginationRequest {
    
    private int page;

    private int limit;

    private Map<String, String> order;

    private Map<String, Object> params;
    
}

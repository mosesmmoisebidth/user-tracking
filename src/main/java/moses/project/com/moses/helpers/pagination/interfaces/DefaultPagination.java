package moses.project.com.moses.helpers.pagination.interfaces;
import lombok.Data;

@Data
public class DefaultPagination {
    
    private int defaultSkip;
    private int defaultPage;
    private int defaultLimit;
    private Object defaultOrder;
    private String defaultOrderDirection;
    private int maxAllowedSize;

}

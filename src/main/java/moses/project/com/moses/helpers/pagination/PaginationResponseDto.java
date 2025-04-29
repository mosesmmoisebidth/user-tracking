package moses.project.com.moses.helpers.pagination;
import lombok.*;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponseDto<T> {

    @Schema(description = "List of items")
    private List<T> items;

    @Schema(description = "total number of items", example = "10")
    private int itemCount;
    
    @Schema(description = "total items", example = "10")
    private int totalItems;

    @Schema(description = "items per page", example = "10")
    private int itemsPerPage;

    @Schema(description = "total pages", example = "10")
    private int totalPages;

    @Schema(description = "current page", example = "10")
    private int currentPage;
    
}

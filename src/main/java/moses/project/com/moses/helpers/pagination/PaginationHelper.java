package moses.project.com.moses.helpers.pagination;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import moses.project.com.moses.helpers.pagination.interfaces.PaginationRequest;
import moses.project.com.moses.helpers.pagination.PaginationResponseDto;

public class PaginationHelper {
    
    public static <T> PaginationResponseDto<T> handlePagination(
        JpaRepository<T, ?> repository,
        PaginationRequest paginationRequest,
        Example<T> example
    ) {
        Sort sort = Sort.unsorted();
        if(paginationRequest.getOrder() != null && !paginationRequest.getOrder().isEmpty()){
            for(var entry: paginationRequest.getOrder().entrySet()){
                String field = entry.getKey();
                Sort.Direction direction = entry.getValue().equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
                sort = sort.and(Sort.by(direction, field));
            }
        }
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getLimit(), sort);
        Page<T> page = repository.findAll(example, pageable);
        return new PaginationResponseDto<T>(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            (int) page.getTotalElements(),
            page.getTotalPages(),
            page.getNumber() + 1
        );
    }
    
}

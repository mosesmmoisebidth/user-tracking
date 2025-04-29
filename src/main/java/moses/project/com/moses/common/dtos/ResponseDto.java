package moses.project.com.moses.common.dtos;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    
    @Schema(description = "Indicate Success", example = "true", required = true)
    private boolean success;

    @Schema(description = "Response Message", example = "Successful response", required = true)
    private String message;

    @Schema(description = "Generic type", example = "the payload of data given", required = true)
    private T payload;

    @Schema(description = "Path of the response", example = "Path of the API", required = true)
    private String path;

    @Schema(description = "HTTP method", example = "GET", required = true)
    private String method;

    @Schema(description = "Timestamp in milliseconds", example = "1617826799860", required = true)
    private long timestamp;

}

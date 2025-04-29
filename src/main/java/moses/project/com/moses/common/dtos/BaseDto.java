package moses.project.com.moses.common.dtos;
import lombok.*;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseDto {

    @Schema(description = "Unique identifier for incoming entity", type="string", format="uuid", example = "123eer-32892djfn-8392423fn")
    private String id;

    @Schema(description = "Timestamp when the entity was created", type="string", format="date-time", example="2023-10-10")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the entity was updated", type="string", format="date-time", example="2023-10-10")
    private LocalDateTime updatedAt;

    public BaseDto(Object entity){
        if(entity != null){

        }
    }

}

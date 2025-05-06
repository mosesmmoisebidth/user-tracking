package moses.project.com.moses.modules.permissions.dto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema;
import moses.project.com.moses.common.dtos.BaseDto;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto extends BaseDto {

    @Schema(description="slug")
    private String slug;

    @Schema(description="pemission description")
    private String description;

    @Schema(description="status of permission")
    private Boolean active;

}
package moses.project.com.moses.modules.roles.dto;
import moses.project.com.moses.common.dtos.BaseDto;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.*;
import moses.project.com.moses.modules.permissions.dto.PermissionDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends BaseDto {

    @Schema(description="name")
    private String name;

    @Schema(description="permissions")
    private List<PermissionDto> permissions;

    @Schema(description="active")
    private Boolean active;

}
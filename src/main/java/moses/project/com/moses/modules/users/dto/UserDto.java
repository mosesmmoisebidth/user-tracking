package moses.project.com.moses.modules.users.dto;
import moses.project.com.moses.modules.roles.dto.RoleDto;
import moses.project.com.moses.modules.permissions.dto.PermissionDto;
import moses.project.com.moses.modules.roles.enums.RoleEnum;
import moses.project.com.moses.modules.users.enums.UserStatus;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import moses.project.com.moses.common.dtos.BaseDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    @Schema(description="username")
    private String username;

    @Schema(description="firstname")
    private String firstName;

    @Schema(description="lastname")
    private String lastName;

    @Schema(description="email")
    private String email;

    @Schema(description="phoneNumber")
    private String phoneNumber;

    @Schema(description="role")
    private RoleEnum role;

    @Schema(description="status")
    private UserStatus status;

    @Schema(description="permissions")
    private List<PermissionDto> permissions;

    @Schema(description="roles")
    private List<RoleDto> roles;

}

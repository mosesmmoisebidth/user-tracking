package moses.project.com.moses.modules.roles.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
public class RoleResponse {
    
    @Schema(description="role dtos")
    private List<RoleDto> roles;
    
}

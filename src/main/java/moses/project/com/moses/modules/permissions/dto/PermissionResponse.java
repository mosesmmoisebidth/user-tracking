package moses.project.com.moses.modules.permissions.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class PermissionResponse {

    @Schema(description="permission dtos")
    private List<PermissionDto> permissions;
}
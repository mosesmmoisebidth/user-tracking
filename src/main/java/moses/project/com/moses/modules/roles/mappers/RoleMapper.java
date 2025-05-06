package moses.project.com.moses.modules.roles.mappers;
import moses.project.com.moses.modules.roles.entity.RoleEntity;
import moses.project.com.moses.modules.users.mappers.DtoPopulationUser;
// import moses.project.com.moses.modules.permissions.dto.DtoPopulation;
import moses.project.com.moses.modules.roles.dto.RoleDto;
import moses.project.com.moses.modules.permissions.dto.PermissionDto;
import moses.project.com.moses.modules.permissions.mappers.PermissionMapper;
import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleDto toDtoRole(RoleEntity entity, DtoPopulationUser dto){
        RoleDto role = new RoleDto();
        role.setId(entity.getId());
        role.setName(entity.getRole().toString());
        role.setCreatedAt(entity.getCreatedAt());
        role.setUpdatedAt(entity.getUpdatedAt());
        if(dto != null && Boolean.TRUE.equals(dto.getPermissions())){
            List<PermissionDto> permissions = entity.getPermissions().stream()
            .map(PermissionMapper::toDto)
            .collect(Collectors.toList());
            role.setPermissions(permissions);
        }
        return role;
    }
    
}

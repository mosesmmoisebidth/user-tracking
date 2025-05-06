package moses.project.com.moses.modules.users.mappers;
import moses.project.com.moses.modules.permissions.mappers.PermissionMapper;
import moses.project.com.moses.modules.permissions.dto.PermissionDto;
import moses.project.com.moses.modules.roles.dto.RoleDto;
import moses.project.com.moses.modules.roles.mappers.RoleMapper;
import moses.project.com.moses.modules.users.dto.UserDto;
import moses.project.com.moses.modules.users.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;

public class UsersMapper {
    
    public static UserDto toDto(UserEntity entity, DtoPopulationUser population){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        String[] nameParts = entity.getFullnames().split(" ");
        String userName = nameParts.length > 0 ? nameParts[0] : "";
        String firstName = nameParts.length > 1 ? nameParts[1] : userName;
        String lastName = nameParts.length > 2 ? nameParts[2] : firstName;
        
        dto.setUsername(userName);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(entity.getEmail());
        if(entity.getPhone_number() != null){
            dto.setPhoneNumber(entity.getPhone_number());
        }

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        
        if(population != null && Boolean.TRUE.equals(population.getRole())){
            dto.setRole(entity.getRole());
        }

        if(population != null && Boolean.TRUE.equals(population.getPermissions())){
            List<PermissionDto> permissions = entity.getPermissions().stream()
            .map(PermissionMapper::toDto)
            .collect(Collectors.toList());
            dto.setPermissions(permissions);
        }
        
        if(population != null && Boolean.TRUE.equals(population.getRoles())){
            List<RoleDto> roles = entity.getRoles().stream()
            .map(role -> RoleMapper.toDtoRole(role, population))
            .collect(Collectors.toList());
            dto.setRoles(roles);
        }

        return dto;
        
    }
}

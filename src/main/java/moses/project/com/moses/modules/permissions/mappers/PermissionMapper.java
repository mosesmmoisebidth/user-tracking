package moses.project.com.moses.modules.permissions.mappers;
import moses.project.com.moses.modules.permissions.entity.PermissionEntity;
import moses.project.com.moses.modules.permissions.dto.PermissionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PermissionMapper {
    
    public static PermissionDto toDto(PermissionEntity entity){
        return PermissionDto.builder()
        .id(entity.getId())
        .slug(entity.getSlug())
        .description(entity.getDescription())
        .active(entity.getActive())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }

}

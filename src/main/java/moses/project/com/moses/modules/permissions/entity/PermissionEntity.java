package moses.project.com.moses.modules.permissions.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import moses.project.com.moses.common.entities.CommonEntity;
import moses.project.com.moses.modules.roles.entity.RoleEntity;
import moses.project.com.moses.modules.users.entity.UserEntity;

@Entity
@Table(name="permissions", schema="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionEntity extends CommonEntity {

    public PermissionEntity(String slug, String description){
        this.slug = slug;
        this.description = description;
    }

    @Column(nullable=false, unique=true, length=60, name="slug")
    private String slug;

    @Column(nullable=false, length=160)
    private String description;

    @Column(nullable=false)
    @Builder.Default
    private Boolean active = true;

    @ManyToMany(mappedBy="permissions")
    @Builder.Default
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToMany(mappedBy="permissions")
    @Builder.Default
    private Set<UserEntity> users = new HashSet<>();


}
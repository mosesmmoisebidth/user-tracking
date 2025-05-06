package moses.project.com.moses.modules.roles.entity;

import jakarta.persistence.*;
import lombok.*;
import moses.project.com.moses.common.entities.CommonEntity;
import moses.project.com.moses.modules.roles.enums.RoleEnum;
import moses.project.com.moses.modules.users.entity.UserEntity;
import moses.project.com.moses.modules.permissions.entity.PermissionEntity;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles", schema="users")
public class RoleEntity extends CommonEntity {

    public RoleEntity(RoleEnum role, Set<PermissionEntity> permissions){
        this.role = role;
        this.permissions = permissions;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private RoleEnum role;

    @Column(nullable=false)
    private boolean active;

    @ManyToMany(mappedBy="roles")
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name="roles_permissions",
        joinColumns=@JoinColumn(name="roleId", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="permissionId", referencedColumnName="id")
    )
    private Set<PermissionEntity> permissions = new HashSet<>();

}
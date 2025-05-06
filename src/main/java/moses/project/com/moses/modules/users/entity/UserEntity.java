package moses.project.com.moses.modules.users.entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.*;
import moses.project.com.moses.common.entities.CommonEntity;
import moses.project.com.moses.modules.tokens.entity.TokenEntity;
import moses.project.com.moses.modules.roles.entity.RoleEntity;
import moses.project.com.moses.modules.permissions.entity.PermissionEntity;
import moses.project.com.moses.modules.roles.enums.RoleEnum;
import moses.project.com.moses.modules.users.enums.UserStatus;

@Entity
@Table(name="users", schema="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends CommonEntity {
    
    @Column(name="fullnames", nullable=false)
    private String fullnames;

    @Column(name="phone_number", nullable=false)
    private String phone_number;

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="password", nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable=false)
    @Builder.Default
    private RoleEnum role = RoleEnum.CANDIDATE;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name="friends", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> friends = new ArrayList<>();

    @Column(name="requests", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> requests = new ArrayList<>();

    @Column(name="blocked", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> blocked = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<TokenEntity> tokens;

    @ManyToMany
    @JoinTable(
        name="users_roles",
        joinColumns=@JoinColumn(name="userId", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="roleId", referencedColumnName="id")
    )
    @Builder.Default
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name="users_permissions",
        joinColumns=@JoinColumn(name="userId", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="permissionId", referencedColumnName="id")
    )
    @Builder.Default
    private Set<PermissionEntity> permissions = new HashSet<>();


}

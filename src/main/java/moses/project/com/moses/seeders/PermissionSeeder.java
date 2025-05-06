package moses.project.com.moses.seeders;
import moses.project.com.moses.modules.permissions.entity.PermissionEntity;
import moses.project.com.moses.modules.permissions.entity.PermissionRepository;
import moses.project.com.moses.modules.roles.entity.RoleEntity;
import moses.project.com.moses.modules.roles.entity.RoleRepository;
import moses.project.com.moses.modules.roles.enums.RoleEnum;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@Configuration
public class PermissionSeeder implements CommandLineRunner {
    
    @Autowired private PermissionRepository permissionRepository;
    @Autowired private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        seedPermissionsAndRoles();
    }

    private void seedPermissionsAndRoles() {
        List<PermissionEntity> basePermissions = List.of(
            new PermissionEntity("create.users", "Create users"),
            new PermissionEntity("read.users", "Read users"),
            new PermissionEntity("update.users", "Update users"),
            new PermissionEntity("delete.users", "Delete users")
        );

        for (PermissionEntity p : basePermissions) {
            permissionRepository.findBySlug(p.getSlug()).orElseGet(() -> permissionRepository.save(p));
        }

        List<PermissionEntity> savedPermissions = permissionRepository.findAll();
        Set<PermissionEntity> adminPermissions = new HashSet<>(savedPermissions);
        Set<PermissionEntity> employerPermissions = savedPermissions.stream()
            .dropWhile(p -> !p.getSlug().equals("read_own.jobs"))
            .collect(Collectors.toSet());

        if (roleRepository.findByRole(RoleEnum.ADMIN) == null) {
            roleRepository.save(new RoleEntity(RoleEnum.ADMIN, adminPermissions));
        }
        if (roleRepository.findByRole(RoleEnum.BUSINESS) == null) {
            roleRepository.save(new RoleEntity(RoleEnum.BUSINESS, employerPermissions));
        }
        if (roleRepository.findByRole(RoleEnum.CANDIDATE) == null) {
            roleRepository.save(new RoleEntity(RoleEnum.CANDIDATE, Set.of()));
        }
    }

}

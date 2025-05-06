package moses.project.com.moses.modules.permissions.entity;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, String> {
    Optional<PermissionEntity> findBySlug(String slug);
}
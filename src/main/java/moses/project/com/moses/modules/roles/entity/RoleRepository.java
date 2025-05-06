package moses.project.com.moses.modules.roles.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import moses.project.com.moses.modules.roles.enums.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    RoleEntity findByRole(RoleEnum role);
}
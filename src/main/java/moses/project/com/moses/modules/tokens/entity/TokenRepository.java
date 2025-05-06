package moses.project.com.moses.modules.tokens.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
// import moses.project.com.moses.modules.tokens.entity.TokenEntity;
import moses.project.com.moses.modules.tokens.enums.TokenType;


@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, String> {
    // TokenEntity findByRefreshToken(String refreshToken);
    Optional<TokenEntity> findByToken(String token);
    Optional<TokenEntity> findByIdAndType(String id, TokenType type);
    List<TokenEntity> findByParentId(UUID parentId);
    List<TokenEntity> findByUserId(String userId);

    @Transactional
    @Modifying
    @Query("UPDATE TokenEntity t SET t.isActive = false WHERE t.parentId = :parentId")
    int deactivateByParentId(String parentId);
}

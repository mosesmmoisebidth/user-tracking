package moses.project.com.moses.modules.tokens.entity;
import moses.project.com.moses.modules.tokens.enums.TokenType;
import moses.project.com.moses.modules.users.entity.UserEntity;
import moses.project.com.moses.common.entities.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name="tokens", schema="tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEntity extends CommonEntity {

    @Column(name="token", nullable=false, unique=true)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TokenType type;

    @Column(nullable=true)
    private UUID parentId;

    @Column(nullable=false)
    @Builder.Default
    private boolean isActive = true;

    @Column(nullable=false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable=false, updatable=false, insertable=false)
    private UserEntity user;

}

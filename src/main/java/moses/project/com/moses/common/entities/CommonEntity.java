package moses.project.com.moses.common.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class CommonEntity {
    
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @Column(name="id", updatable = false, nullable = false, unique = true)
    @Schema(description = "Unique identifier for the entity", example = "123eer-32892djfn-8392423fn")
    private String id;

    @Column(name = "created_at", updatable=false)
    @Schema(description = "Timestamp when the entity was created", example = "2023-10-10")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", updatable=false)
    @Schema(description = "Timestamp when the entity was created", example = "2023-10-10")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}

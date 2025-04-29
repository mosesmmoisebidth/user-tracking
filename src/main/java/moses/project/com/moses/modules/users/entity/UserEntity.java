package moses.project.com.moses.modules.users.entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.*;
import moses.project.com.moses.common.entities.CommonEntity;

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

    @Column(name="friends", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> friends = new ArrayList<>();

    @Column(name="requests", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> requests = new ArrayList<>();

    @Column(name="requests", columnDefinition="TEXT[]")
    @Builder.Default
    private List<String> blocked = new ArrayList<>();


//     fullnames
// phoneNumber
// email
// password
// friends
// requests
// blocked
// role
// status
// profilePhoto


}

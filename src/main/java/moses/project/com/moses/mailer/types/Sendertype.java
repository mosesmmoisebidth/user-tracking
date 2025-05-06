package moses.project.com.moses.mailer.types;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sendertype {
    
    private String name;

    private String email;

    private String password;
    
}

package moses.project.com.moses.mailer.types;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentType {

    private String filename;

    private byte[] content;


}
package moses.project.com.moses.mailer.types;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverType {

    private String to;

    private String subject;

    private String body;

    private List<AttachmentType> attachments;

}

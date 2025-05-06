package moses.project.com.moses.mailer;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import moses.project.com.moses.mailer.types.AttachmentType;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import moses.project.com.moses.mailer.types.ReceiverType;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MailerService {

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Autowired private JavaMailSender javaMailSender;

    public void sendEmail(
        ReceiverType receiver
    ){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(senderEmail);
            helper.setTo(receiver.getTo());
            helper.setSubject(receiver.getSubject());
            helper.setText(receiver.getBody());
            if(receiver.getAttachments() != null || !receiver.getAttachments().isEmpty()){
                for(AttachmentType atta : receiver.getAttachments()){
                    InputStreamSource source = new ByteArrayResource(atta.getContent());
                    helper.addAttachment(atta.getFilename(), source);
                }
            }
            javaMailSender.send(message);
        }catch(MessagingException ex){
            throw new RuntimeException(ex);
        }
    }



}







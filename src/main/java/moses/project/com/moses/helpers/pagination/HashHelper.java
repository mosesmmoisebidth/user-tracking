package moses.project.com.moses.helpers.pagination;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
public class HashHelper {
    
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public static String encrypt(String password){
        return encoder.encode(password);
    }

    public static boolean compare(String password, String hash){
        return encoder.matches(password, hash);
    }

}

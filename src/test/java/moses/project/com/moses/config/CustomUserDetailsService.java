package moses.project.com.moses.config;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import moses.project.com.moses.modules.users.entity.UserEntity;
import moses.project.com.moses.modules.users.entity.UserRepository;
// import moses.project.com.moses.config.CustomUserDetails;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <UserEntity> user = userRepository.findByEmail(email);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with the email"));
    }
}

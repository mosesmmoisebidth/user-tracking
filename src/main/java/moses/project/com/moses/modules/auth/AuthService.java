package moses.project.com.moses.modules.auth;
import moses.project.com.moses.modules.permissions.entity.PermissionRepository;
import moses.project.com.moses.modules.users.mappers.UsersMapper;
import moses.project.com.moses.modules.users.dto.UserDto;
import moses.project.com.moses.modules.users.entity.UserRepository;
import moses.project.com.moses.modules.tokens.TokenService;
import lombok.RequiredArgsConstructor;
import moses.project.com.moses.response.ResponseService;
// import moses.project.com.moses.common.response.ResponseService;
import moses.project.com.moses.common.dtos.ResponseDto;
import moses.project.com.moses.modules.roles.entity.RoleRepository;
import moses.project.com.moses.modules.auth.dto.AuthCredentialsRequestDto;
import moses.project.com.moses.modules.auth.dto.LoginResponseDto;
import org.springframework.stereotype.Service;
import moses.project.com.moses.modules.roles.entity.RoleEntity;
import moses.project.com.moses.modules.users.mappers.UsersMapper;
import moses.project.com.moses.modules.roles.enums.RoleEnum;
import moses.project.com.moses.common.http.exceptions.ForbiddenCustomException;
import moses.project.com.moses.common.http.exceptions.UnauthorizedCustomException;
import moses.project.com.moses.common.http.exceptions.NotFoundCustomException;
import moses.project.com.moses.common.http.exceptions.BadRequestCustomException;
import moses.project.com.moses.common.http.exceptions.InternalServerErrorException;
import moses.project.com.moses.common.http.exceptions.ConflictCustomException;
import moses.project.com.moses.modules.tokens.entity.TokenRepository;
import moses.project.com.moses.modules.auth.dto.AuthRegisterRequest;
import moses.project.com.moses.modules.users.enums.UserType;
import moses.project.com.moses.modules.users.entity.UserEntity;
import moses.project.com.moses.helpers.pagination.HashHelper;
import moses.project.com.moses.modules.tokens.dto.TokenDto;
import moses.project.com.moses.mailer.MailerService;
import moses.project.com.moses.modules.users.mappers.DtoPopulationUser;
import moses.project.com.moses.modules.tokens.entity.TokenEntity;
import java.util.Collections;
import moses.project.com.moses.mailer.types.ReceiverType;
import moses.project.com.moses.common.enums.EResponse;
import moses.project.com.moses.mailer.MailTemplates;
import moses.project.com.moses.mailer.MailerService;
import java.util.Set;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final TokenService tokenService;
    private final MailerService mailerService;
    private final MailTemplates mailTemplates;
    private final ResponseService responseService;

    public ResponseDto<LoginResponseDto> register(
        AuthRegisterRequest dto
    ){
        try{
            if(userRepository.existsByEmail(dto.getEmail())){
                throw new ConflictCustomException("User with this email already exists");
            }           
            String fullNames = dto.getEmail().split("@")[0];
            UserEntity user = new UserEntity();
            user.setFullnames(fullNames);
            user.setPhone_number(dto.getPhoneNumber());
            user.setEmail(dto.getEmail());
            user.setPassword(HashHelper.encrypt(dto.getPassword()));
            if(dto.getRole().equals(UserType.CANDIDATE)){
                user.setRole(RoleEnum.CANDIDATE);
            }else{
                user.setRole(RoleEnum.BUSINESS);
            }
            user.setPermissions(Collections.emptySet());
            if(dto.getRole().equals(UserType.CANDIDATE)){
                RoleEntity role = roleRepository.findByRole(RoleEnum.CANDIDATE);
                user.setRoles(Set.of(role));
            }
            user = userRepository.save(user);
            TokenDto tokens = tokenService.generateTokens(user);
            DtoPopulationUser population = new DtoPopulationUser();
            population.setRole(true);
            UserDto userDto = UsersMapper.toDto(user, population);
            String body = mailTemplates.render("register", Map.of("fullnames", user.getFullnames()));
            mailerService.sendEmail(new ReceiverType(user.getEmail(), "Account Creation", body, null));
            return responseService.makeResponse(
                "Account created",
                new LoginResponseDto(userDto, tokens),
                EResponse.SUCCESS
            );
        }catch(Exception ex){
            throw new InternalServerErrorException("Unknown error occured" + ex.getMessage());
        }
    }

}

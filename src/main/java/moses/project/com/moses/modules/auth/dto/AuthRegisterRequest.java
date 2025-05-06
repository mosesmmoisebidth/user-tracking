package moses.project.com.moses.modules.auth.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import moses.project.com.moses.common.validator.PasswordMatches;
import moses.project.com.moses.modules.users.enums.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class AuthRegisterRequest {
    
    @Schema(example = "xxxx@gmail.com", required = true)
    @NotBlank
    @Email
    private String email;

    @Schema(required = true)
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter.")
    @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one number.")
    @Pattern(regexp = ".*[@$!%*?&].*", message = "Password must contain at least one special character (@, $, !, %, *, ?, &).")
    private String password;

    @Schema(required=false)
    private String phoneNumber;

    @Schema(required = true)
    @NotBlank
    private String confirmPassword;

    @Schema(required = true)
    @NotBlank
    private UserType role;

    @Schema(required=false)
    private String tokenId;



}

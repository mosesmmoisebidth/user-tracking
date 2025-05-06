package moses.project.com.moses.modules.auth.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthCredentialsRequestDto {
    
    @Schema(example="xxxx@gmail.com", required=true)
    @NotBlank
    @Email
    private String email;

    @Schema(required=true)
    @NotBlank
    private String password;

    @Schema(required=false)
    private String tokenId;
    
}

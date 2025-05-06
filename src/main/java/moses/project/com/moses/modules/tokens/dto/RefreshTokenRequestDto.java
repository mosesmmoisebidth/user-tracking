package moses.project.com.moses.modules.tokens.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefreshTokenRequestDto {

    @Schema(description="Refresh token")
    @NotNull(message="Refresh token cannot be null")
    @NotBlank(message="Refresh token cannot be blank")
    private String refreshToken;
    
}

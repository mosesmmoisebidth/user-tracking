package moses.project.com.moses.modules.tokens.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    
    @Schema(description="Access token")
    private String accessToken;

    @Schema(description="Refresh token")
    private String refreshToken;
    
}

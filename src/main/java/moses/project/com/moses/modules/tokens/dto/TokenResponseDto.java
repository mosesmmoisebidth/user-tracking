package moses.project.com.moses.modules.tokens.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import moses.project.com.moses.modules.tokens.dto.TokenDto;

@Schema(description="Token response DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    
    @Schema(description="Token Dto")
    private TokenDto tokenDto;

}

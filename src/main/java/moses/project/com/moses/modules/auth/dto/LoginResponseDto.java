package moses.project.com.moses.modules.auth.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import moses.project.com.moses.modules.users.dto.UserDto;
import moses.project.com.moses.modules.tokens.dto.TokenDto;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    
    @Schema(description="user dto")
    private UserDto user;

    @Schema(description="token dto")
    private TokenDto tokens;

}
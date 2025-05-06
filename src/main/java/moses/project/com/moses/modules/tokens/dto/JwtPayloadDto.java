package moses.project.com.moses.modules.tokens.dto;
import moses.project.com.moses.modules.tokens.enums.TokenType;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtPayloadDto {

    private String sub;
    private String tid;
    private TokenType type;

}

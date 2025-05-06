package moses.project.com.moses.modules.tokens;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import moses.project.com.moses.modules.tokens.dto.JwtPayloadDto;
import moses.project.com.moses.modules.users.entity.UserEntity;
import moses.project.com.moses.modules.tokens.entity.TokenEntity;
import moses.project.com.moses.modules.tokens.dto.TokenDto;
import moses.project.com.moses.modules.tokens.enums.TokenType;
import moses.project.com.moses.modules.tokens.entity.TokenRepository;
import moses.project.com.moses.modules.tokens.JwtUtil;
import moses.project.com.moses.modules.tokens.dto.TokenResponseDto;
import moses.project.com.moses.modules.tokens.dto.RefreshTokenRequestDto;
import moses.project.com.moses.common.http.exceptions.UnauthorizedCustomException;
import moses.project.com.moses.common.http.exceptions.ForbiddenCustomException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;


@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public TokenEntity generateRefreshToken(UserEntity user){
        TokenEntity token = new TokenEntity();
        token.setId(UUID.randomUUID().toString());
        token.setUser(user);
        token.setType(TokenType.RefreshToken);
        
        JwtPayloadDto payload = new JwtPayloadDto(user.getId(), token.getId(), TokenType.RefreshToken);
        String tokenString = jwtUtil.generateToken(payload, true);
        token.setToken(tokenString);
        return tokenRepository.save(token);
    }

    public TokenDto generateTokens(UserEntity user){
        TokenEntity refreshToken = generateRefreshToken(user);
        TokenEntity accessToken = generateAccessToken(user, refreshToken.getId());
        return new TokenDto(
            accessToken.getToken(),
            refreshToken.getToken()
        );
    }

    public TokenEntity generateAccessToken(UserEntity user, String parentId){
        TokenEntity token = new TokenEntity();
        token.setId(UUID.randomUUID().toString());
        token.setUser(user);
        token.setParentId(UUID.fromString(parentId));
        token.setType(TokenType.AccessToken);

        JwtPayloadDto payload = new JwtPayloadDto(user.getId(), token.getId(), TokenType.AccessToken);
        String tokenString = jwtUtil.generateToken(payload, false);
        token.setToken(tokenString);
        return tokenRepository.save(token);
    }

    public JwtPayloadDto validateRefreshToken(String refreshToken){
        JwtPayloadDto payload = jwtUtil.validateToken(refreshToken, true);
        TokenEntity token = tokenRepository.findByIdAndType(payload.getTid(),payload.getType()).orElseThrow(() -> new ForbiddenCustomException("Invalid Token"));
        if(!token.isActive()){
            throw new UnauthorizedCustomException("Invalid Token");
        }
        return payload;
    }

    public JwtPayloadDto validateAccessToken(String accessToken){
        JwtPayloadDto payload = jwtUtil.validateToken(accessToken, false);
        TokenEntity token = tokenRepository.findByIdAndType(payload.getTid(), payload.getType()).orElseThrow(() -> new ForbiddenCustomException("Token Not Found"));
        if(!token.isActive()){
            throw new UnauthorizedCustomException("Invalid Token");
        }
        return payload;
    }

    public TokenResponseDto refreshAccessToken(RefreshTokenRequestDto dto){
        try{
            JwtPayloadDto payload = jwtUtil.validateToken(dto.getRefreshToken(), true);
            tokenRepository.deactivateByParentId(payload.getTid());
            String accessToken = jwtUtil.generateToken(payload, false);
            return new TokenResponseDto(
                new TokenDto(
                    accessToken,
                    dto.getRefreshToken()
                )
            );
        }catch(JwtException ex){
            if (ex instanceof MalformedJwtException) {
            throw new UnauthorizedCustomException("Jwt Malformed!");
            }
            if (ex instanceof ExpiredJwtException) {
                throw new UnauthorizedCustomException("Jwt Expired!");
            }
            throw new UnauthorizedCustomException("Invalid JWT: " + ex.getMessage());
    }
    }

}

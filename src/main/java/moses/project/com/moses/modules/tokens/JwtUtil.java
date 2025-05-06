package moses.project.com.moses.modules.tokens;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.security.Key;
import moses.project.com.moses.modules.tokens.dto.JwtPayloadDto;
import moses.project.com.moses.modules.tokens.enums.TokenType;

@Component
public class JwtUtil {
    
    @Value("${security.jwtAccess}")
    private String accessTokenSecret;

    @Value("${security.jwtRefresh}")
    private String refreshTokenSecret;

    @Value("${security.jwtAccessExpire}")
    private Duration accessTokenExpire;

    @Value("${security.jwtRefreshExpire}")
    private Duration refreshTokenExpire;

    public String generateToken(JwtPayloadDto payload, boolean isRefresh) {
        String secret = isRefresh ? refreshTokenSecret : accessTokenSecret;
        long expiration = isRefresh ? refreshTokenExpire.getSeconds() : accessTokenExpire.getSeconds();
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));


        return Jwts.builder()
                .setSubject(payload.getSub())
                .claim("tid", payload.getTid())
                .claim("type", payload.getType().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public JwtPayloadDto validateToken(String token, boolean isRefresh) throws JwtException {
        String secret = isRefresh ? refreshTokenSecret : accessTokenSecret;
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return new JwtPayloadDto(
            claims.getSubject(),
            claims.get("tid", String.class),
            TokenType.valueOf(claims.get("type", String.class))
        );
    }

}

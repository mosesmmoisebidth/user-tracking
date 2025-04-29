package moses.project.com.moses.common.enums;
import lombok.Getter;

@Getter
public enum ErrorType {
    
    InvalidToken("INVALID_TOKEN"),
    InactiveToken("INACTIVE_TOKEN"),
    AccessTokenExpired("ACCESS_TOKEN_EXPIRED"),
    RefreshTokenExpired("REFRESH_TOKEN_EXPIRED"),
    PermissionExists("PERMISSION_EXISTS"),
    RoleExists("ROLE_EXISTS"),
    UserExists("USER_EXISTS"),
    InvalidCurrentPassword("INVALID_CURRENT_PASSWORD"),
    InvalidCredentials("INVALID_CREDENTIALS"),
    BlockedUser("BLOCKED_USER"),
    InactiveUser("INACTIVE_USER"),
    ForeignKeyConflict("FOREIGN_KEY_CONFLICT"),
    OTPExpired("OTP_EXPIRED"),
    OTPInactive("OTP_INACTIVE");

    private final String value;

    ErrorType(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }

}

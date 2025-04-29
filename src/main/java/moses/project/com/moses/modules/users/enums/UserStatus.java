package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum UserStatus {
    
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    DELETED("DELETED"),
    BLOCKED("BLOCKED");

    private final String value;

    UserStatus(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

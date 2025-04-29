package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum UserType {
    BUSINESS("BUSINESS"),
    CANDIDATE("CANDIDATE");

    private final String value;

    UserType(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }

}

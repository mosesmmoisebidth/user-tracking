package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum ProfileEnum {
    
    YES("YES"),
    NO("NO");

    private final String value;

    ProfileEnum(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }

}

package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum GenderEnum {
    MALE("MALE"),
    FEMALE("FEMALE"),
    BOTH("BOTH"),
    NONE("NONE");

    private final String value;

    GenderEnum(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

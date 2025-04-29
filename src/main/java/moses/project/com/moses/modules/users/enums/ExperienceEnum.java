package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum ExperienceEnum {
    
    CERTIFICATE("CERTIFICATE"),
    ASSOCIATE_DEGREE("ASSOCIATE_DEGREE"),
    BACHELORS_DEGREE("BACHELORS_DEGREE"),
    MASTERS_DEGREE("MASTERS_DEGREE"),
    DOCTORATE_DEGREE("DOCTORATE_DEGREE");

    private final String value;

    ExperienceEnum(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

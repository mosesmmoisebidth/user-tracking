package moses.project.com.moses.common.enums;
import lombok.Getter;

@Getter
public enum EResponse {
    
    SUCCESS("success"),
    ERROR("error");

    private final String value;

    EResponse(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }

}

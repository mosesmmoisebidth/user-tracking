package moses.project.com.moses.modules.roles.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN("ADMIN"),
    CANDIDATE("CANDIDATE"),
    BUSINESS("BUSINESS");

    private final String value;

    RoleEnum(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }

}
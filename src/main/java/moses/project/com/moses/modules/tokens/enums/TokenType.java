package moses.project.com.moses.modules.tokens.enums;
import lombok.Getter;

@Getter
public enum TokenType {
    
    RefreshToken("REFRESH_TOKEN"),
    AccessToken("ACCESS_TOKEN");


    private final String value;

    TokenType(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

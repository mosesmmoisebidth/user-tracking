package moses.project.com.moses.common.enums;
import lombok.Getter;

@Getter
public enum DBErrorCode {

    PgNotNullConstraintViolation("23502"),
    PgForeignKeyConstraintViolation("23503"),
    PgUniqueConstraintViolation("23505");

    private final String value;

    DBErrorCode(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
    
}

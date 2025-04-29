package moses.project.com.moses.modules.users.enums;
import lombok.Getter;

@Getter
public enum ESalaryStatus {
    
    YEARLY("YEARLY"),
    HOURLY("HOURLY"),
    MONTHLY("MONTHLY"),
    DAILY("DAILY"),
    WEEKLY("WEEKLY");

    private final String value;

    ESalaryStatus(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}

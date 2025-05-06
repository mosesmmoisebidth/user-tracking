package moses.project.com.moses.common.validator;
import moses.project.com.moses.modules.auth.dto.AuthRegisterRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, AuthRegisterRequest> {

    @Override
    public boolean isValid(AuthRegisterRequest dto, ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return false;
        }
        return dto.getPassword().equals(dto.getConfirmPassword());
    }
}

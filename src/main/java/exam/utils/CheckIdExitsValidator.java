package exam.utils;

import exam.services.ISubService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CheckIdExitsValidator
        implements ConstraintValidator<CheckIdExistsConstraint, String> {

    @Autowired
    private ISubService subService;

    @Override
    public void initialize(CheckIdExistsConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank()) {
            return false;
        } else if (value != null) {
            return Optional.ofNullable(subService.findById(value)).isPresent();
        }
        return true;
    }

}

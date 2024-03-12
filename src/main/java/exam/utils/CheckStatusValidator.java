package exam.utils;

import exam.services.ISubService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CheckStatusValidator
        implements ConstraintValidator<CheckStatusConstraint, String> {

    @Autowired
    private ISubService subService;

    @Override
    public void initialize(CheckStatusConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank()) {
            return false;
        } else {
            if (Optional.ofNullable(subService.findById(value)).isPresent()) {
                if (subService.findById(value).getTrangThaiTiem() == 1 || subService.findById(value).getTrangThaiTiem() == 3) {
                    return false;
                }
            }
        }
        return true;
    }

}
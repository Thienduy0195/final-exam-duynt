package exam.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = CheckStatusValidator.class)
public @interface CheckStatusConstraint {
    String message() default "Khong the tiem cho nguoi nay!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
package exam.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = CheckIdSubValidator.class)
public @interface CheckIdSubConstraint {
    String message() default "Thong tin nguoi dang ky tiem chung da ton tai!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

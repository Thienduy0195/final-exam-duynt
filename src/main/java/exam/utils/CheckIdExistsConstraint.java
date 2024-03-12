package exam.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = CheckIdExitsValidator.class)
public @interface CheckIdExistsConstraint {
  String message() default "Thong tin nguoi dang ky tiem chung khong ton tai!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

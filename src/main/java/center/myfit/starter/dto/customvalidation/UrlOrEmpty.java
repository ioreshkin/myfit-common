package center.myfit.starter.dto.customvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation to validate that a string is either empty or a valid URL.
 */
@Constraint(validatedBy = UrlOrEmptyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlOrEmpty {

  /**
  * Default message for the validation error.
  */
  String message() default "Must be empty or a valid URL";

  /**
  * Default message for the validation error.
  */
  Class<?>[] groups() default {};

  /**
  * Default message for the validation error.
  */
  Class<? extends Payload>[] payload() default {};
}
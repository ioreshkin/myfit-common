package center.myfit.starter.dto.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator for the UrlOrEmpty annotation.
 */
public class UrlOrEmptyValidator implements ConstraintValidator<UrlOrEmpty, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.isEmpty()) {
      return true;
    }
    return value.matches("^(http|https)://.*");
  }
}
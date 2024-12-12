package center.myfit.starter.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.test.context.support.WithSecurityContext;

/** Аннотация для создания фейкового юзера для теста. */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserSecurityContextFactory.class)
public @interface WithMockUser {
  /** Почта. */
  String email() default "user@user.com";

  /** keycloakId. */
  String keycloakId() default "1";
}

package center.myfit.starter.service;

import center.myfit.starter.exception.UnauthorizedException;
import io.micrometer.common.util.StringUtils;
import java.util.Objects;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * Интерфейс получения данных о пользователе.
 *
 * @param <T> - тип объекта пользователя в системе.
 */
public interface UserAware<T> {
  String KEYCLOAK_ID_FIELD = "keycloakId";

  /**
   * Получение keycloakId пользователя.
   *
   * @return keycloakId текущего пользователя.
   */
  default String getKeycloakId() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(Authentication::getPrincipal)
        .filter(Jwt.class::isInstance)
        .map(Jwt.class::cast)
        .map(Jwt::getClaims)
        .map(it -> it.get(KEYCLOAK_ID_FIELD))
        .filter(Objects::nonNull)
        .map(String.class::cast)
        .filter(StringUtils::isNotBlank)
        .orElseThrow(() -> new UnauthorizedException("Неизвестный пользователь!"));
  }

  /**
   * Получение объекта пользователя.
   *
   * @return объект пользователя.
   */
  T getUser();
}

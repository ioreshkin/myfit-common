package center.myfit.starter.service;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * Интерфейс получения данных о пользователе.
 *
 * @param <T> - тип объекта пользователя в системе.
 */
public interface UserAware<T> {
  String KEYCLOAK_ID_FIELD = "sub";
  Logger logger = LoggerFactory.getLogger(UserAware.class);

  /**
   * Получение keycloakId пользователя.
   *
   * @return keycloakId текущего пользователя.
   */
  default String getKeycloakId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logger.debug("authentication" + authentication.getName());
    Object principal = authentication.getPrincipal();
    logger.debug("principal" + principal.toString());
    logger.debug("instanceof Jwt " + String.valueOf(principal instanceof Jwt));
    Jwt jwt = (Jwt) principal;
    Map<String, Object> claims = jwt.getClaims();
    logger.debug("claims " + claims.toString());
    String keycloakId = (String) claims.get(KEYCLOAK_ID_FIELD);
    logger.debug("keycloakId " + keycloakId);
    return keycloakId;
  }

  /**
   * Получение объекта пользователя.
   *
   * @return объект пользователя.
   */
  T getUser();
}

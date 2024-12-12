package center.myfit.starter.test;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

/** Обработчик аннотации WithMockUser. */
public class WithMockUserSecurityContextFactory
    implements WithSecurityContextFactory<WithMockUser> {
  /** Создание секьюрити контекста с фейковым юзером. */
  @Override
  public SecurityContext createSecurityContext(WithMockUser annotation) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("email", annotation.email());
    claims.put("keycloakId", annotation.keycloakId());
    HashMap<String, Object> headers = new HashMap<>();
    headers.put("alg", "RS256");
    Jwt principal = new Jwt("token", null, null, headers, claims);
    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(principal);
    SecurityContext context = SecurityContextHolder.createEmptyContext();
    context.setAuthentication(jwtAuthenticationToken);
    return context;
  }
}

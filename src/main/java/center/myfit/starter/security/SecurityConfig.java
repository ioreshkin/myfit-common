package center.myfit.starter.security;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/** Конфигурация безопасности приложения. */
@Configuration
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

  /**
   * Конфигурация {@link SecurityFilterChain}.
   *
   * @param http {@link HttpSecurity}.
   * @param corsUrl - url с которого разрешены запросы к серверу.
   * @return {@link SecurityFilterChain}.
   * @throws Exception если что-то пошло не так.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity http, @Value("${cors.url}") String corsUrl) throws Exception {

    http.csrf(AbstractHttpConfigurer::disable)
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            auth -> auth.requestMatchers("/actuator/**").permitAll().anyRequest().authenticated())
        .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
    if (StringUtils.hasText(corsUrl)) {
      http.cors(cors -> cors.configurationSource(corsConfigurationSource(corsUrl)));
    }
    return http.build();
  }

  private UrlBasedCorsConfigurationSource corsConfigurationSource(String corsUrl) {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList(corsUrl));
    configuration.setAllowedHeaders(Arrays.asList("Authorization"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}

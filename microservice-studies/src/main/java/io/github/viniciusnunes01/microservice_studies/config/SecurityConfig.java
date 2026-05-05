package io.github.viniciusnunes01.microservice_studies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						// Libera o endpoint de login
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/validate").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/refresh").permitAll()

						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

						.requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("SCOPE_admin")

						.anyRequest().authenticated())

				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
				}));

		return http.build();
	}
}
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
		http.csrf(csrf -> csrf.disable()) // Desabilita proteção CSRF (comum em APIs REST)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Não
																												// guarda
																												// sessão
																												// (API
																												// Stateless)
				.authorizeHttpRequests(auth -> auth
						// Libera o endpoint de login (qualquer um pode tentar logar)
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						// Opcional: Libera o endpoint de validar/refresh se o prof for testar
						.requestMatchers(HttpMethod.POST, "/auth/validate").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/refresh").permitAll()

						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

						// Exemplo de autorização por perfil (Requisito: Proteger rotas com autorização
						// por perfil)
						// Vamos supor que apenas o ADMIN pode deletar coisas
						.requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("SCOPE_admin")

						// Qualquer outra requisição precisa estar autenticada (ter o token)
						.anyRequest().authenticated())
				// Habilita o servidor para aceitar tokens JWT (configurado no
				// application.properties)
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
				}));

		return http.build();
	}
}
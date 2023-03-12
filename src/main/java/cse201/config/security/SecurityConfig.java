package cse201.config.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig {
	@Bean
	public JwtAuthenticationConverter jwtConverter() {
		final var converter = new JwtAuthenticationConverter();
		
		converter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		return converter;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/test/**").hasRole("ADMIN")
				.requestMatchers("/trails/**").permitAll()
			.and().cors().configurationSource(corsConfig())
			// This is an OAuth2 resource server
			.and().csrf().disable()
			.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtConverter());
		
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfig() {
		System.out.println("-------------\nADDED CORS MAPPING\n-------------");
		
		return (request) -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowCredentials(true);
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setExposedHeaders(Collections.singletonList("Authorization"));
			config.setMaxAge(3600L);
			return config;
	    };
    }
}

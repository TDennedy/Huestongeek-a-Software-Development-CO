package cse201.config.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realm = jwt.getClaim("realm_access");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> ret = ((List<String>) realm.get("roles"))
				.stream().map(role -> "ROLE_" + role)
				.map(Authority::new)
				.collect(Collectors.toList());

		return ret;
	}

}

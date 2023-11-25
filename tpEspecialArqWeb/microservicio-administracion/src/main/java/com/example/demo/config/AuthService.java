/*package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.Claim;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;


@Service("userDetailsService")
public class AuthService implements UserDetailsService {
	
	//@Autowired
	//private final UsuarioRepository usuarioRepository;
	//private final JwtService jwtService;
    //private static final String AUTHORITIES_KEY = "auth";
    private final String password = "1ASGEW34AJADHSDW51351AGBBXZ53217";
	
	//public AuthService(UsuarioRepository usuarioRepository) {
	//	this.usuarioRepository = usuarioRepository;
		//this.jwtService = jwtService;
	//}

	/*public UserDetails login(String email) {
        return usuarioRepository
                .findUserByEmailIgnoreCase( email )
                .map(this::createSpringSecurityUser)
                .orElseThrow(() -> new UsernameNotFoundException("No existe el usuario con email " + email ));
	}

	/*public AuthResponse register(RegisterRequest request) {
		Usuario user = new Usuario(request.getUsername(), request.getPassword(), request.getLastname(), new Role("ADMIN"));
		usuarioRepository.save(user);
		return new AuthResponse(jwtService.getToken((UserDetails) user));
	}
	
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                .username(username)
                .password(this.password)
                .accountLocked(false)
                .disabled(false)
                .build();
    }

	
    public List<GrantedAuthority> grantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }

        return authorities;
    }
    /*
    public Authentication getAuthentication(String token, JwtParser jwtParser) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays
                .stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .filter(auth -> !auth.trim().isEmpty())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }*/
    
    /*private org.springframework.security.core.userdetails.User createSpringSecurityUser(Usuario usuario) {
        List<GrantedAuthority> grantedAuthorities = usuario
                .getRoles()
                .stream()
                .map(Rol::getNombre)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), grantedAuthorities);
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository
                .findUserByEmailIgnoreCase( email )
                .map(this::createSpringSecurityUser)
                .orElseThrow(() -> new UsernameNotFoundException("No existe el usuario con email " + email ));
	}
	
	

}
*/
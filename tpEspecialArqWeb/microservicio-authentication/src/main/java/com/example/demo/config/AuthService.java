package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.entity.AuthResponse;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;


@Service("userDetailsService")
public class AuthService{
	
    @Autowired
    UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService,
			PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
		this.usuarioRepository = usuarioRepository;
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

    public AuthResponse login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return getAuthResponse(username);
    }

    public AuthResponse register(RegisterRequestDTO registerUser) {
        if(findByUsername(registerUser.getUsername()).isPresent())
            return new AuthResponse("Username already exists");
        Usuario newUser=new Usuario();
        newUser.setUsername(registerUser.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        if(registerUser.isAdmin())
            newUser.addRole(Rol.ADMIN);
        if(registerUser.isMaintenance())
            newUser.addRole(Rol.MAINTENANCE);
        addUsuario(newUser);
        return getAuthResponse(registerUser.getUsername());
    }

    private AuthResponse getAuthResponse(String username){
        UserDetails user= (UserDetails) findByUsername(username).orElseThrow();
        String token=jwtService.getToken(user);
        return new AuthResponse(token);
    }



    private Optional<Object> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }


    private void addUsuario(Usuario user) {
    	usuarioRepository.save(user);
    }
	
	

}

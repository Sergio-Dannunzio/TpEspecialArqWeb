/*package com.example.demo.jwt;


import org.springdoc.core.service.SecurityService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.config.AuthService;
import com.example.demo.config.JwtService;
import com.example.demo.model.Usuario;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String password = "1234asdasd141241asdasd";
    private final JwtService jwtService;
    private JwtParser jwtParser;
    private final AuthService authService;

    public JwtAuthenticationFilter(JwtService jwtService,AuthService authService) {
    	this.jwtService = jwtService;
		this.authService = authService;
	}


	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        String token = header.split(" ")[1].trim();

        //CARGAR EL USUARIO AL USERDETAILSERVICE
        String email = jwtService.getUsernameFromToken(token);

        User user = (User) authService.loadUserByUsername(email);

        //CARGAR USUARIO EN EL CONTEXTO DE SEGURIDAD
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), authService.grantedAuthorities(jwtService.getClaims(token)));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }


	public JwtParser getJwtParser() {
		return jwtParser;
	}
	
	public void setJwtParser(JwtParser jwtParser) {
		this.jwtParser = jwtParser;
	}
	
	


    /*private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer "))
        {
            return authHeader.substring(7);
        }
        return null;
    }
}*/

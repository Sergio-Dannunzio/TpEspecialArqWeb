/*package com.example.demo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.jwt.JwtAuthenticationFilter;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	  @Autowired
	  private JwtAuthenticationFilter jwtRequestFilter;
	@Bean
	  SecurityFilterChain web(HttpSecurity http) throws Exception {
		 
		  
	    http
	    
	    	.csrf( AbstractHttpConfigurer::disable )
	        
	        .authorizeHttpRequests((authorize) -> authorize
	            .requestMatchers("/publico/authenticate").permitAll()
	            .requestMatchers("/usuarios").permitAll()
	            .requestMatchers("/administradores/monopatines/").permitAll()
	          
	            
	            ).anonymous().disable()
	        
	        .cors(withDefaults())
	        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
	        .sessionManagement((session) -> session
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        );
	    ;

	    return http.build();
	  }
	  @Bean
	  PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	
	  @Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration
	      authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	  }

}*/

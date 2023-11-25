/*package com.example.demo.config;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;



@Service
public class JwtService {

    //public static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String SECRET_KEY = "523SDFS5321ASDEQGASD2151235612365AAWEGSDWQGQWF12516123531262347SDAQ1515";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
    
    private static final byte[] SECRET_KEY_BYTES = Base64.getDecoder().decode(SECRET_KEY);

    public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * 60; // 8 Horas

	public JwtService() {
	}

	/*public String getToken(UserDetails user) {
		return getToken(new HashMap<>(), user);
	}*/

	/*private String getToken(HashMap<String, Object> extraClaims, String user) {
	    return Jwts
	            .builder()
	            .setClaims(extraClaims)
	            .setSubject(user)
	            .setIssuedAt(new Date(System.currentTimeMillis()))
	            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
	            .signWith(Keys.hmacShaKeyFor(SECRET_KEY_BYTES), SignatureAlgorithm.HS256)
	            .compact();
	}
	
	  private String getToken(Map<String, Object> claims, String subject) {

		    return Jwts
		        .builder()
		        .setClaims(claims)
		        .setSubject(subject)
		        .setIssuedAt(new Date(System.currentTimeMillis()))
		        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
		        .signWith(Keys.hmacShaKeyFor(SECRET_KEY_BYTES), SignatureAlgorithm.HS256)
		        .compact();
		  }
	
    /*public String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader( AUTHORIZATION_HEADER );
        if ( StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ") ) {
            return bearerToken.substring(7);
        }
        return null;
    }*/

	/*private Key getKey() {
		byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String getUsernameFromToken(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token)
                .getSubject();
	}
	
    /*public String createToken(String username, String rol){
        return JWT.create()
                .withSubject(username)
                .withClaim("roles", rol)
                .withIssuedAt(new Date())
                .sign(ALGORITHM);
    }*/
	
    /*public Claims getClaims(String token){
	    return Jwts.parserBuilder()
	            .setSigningKey(SECRET_KEY_BYTES)
	            .setAllowedClockSkewSeconds(60000000)
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
    }
    
    public List<String> getClaims(String token){
        return JWT.require(ALGORITHM)
                .build()
                .verify(token)
                .getClaim("roles").asList(String.class);
    }
    
    /*public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
      }

      public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
      }

     /*public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(getClaims(token));
      }
    
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // Agregando información adicional como "claim"
        var rol = userDetails.getAuthorities().stream().collect(Collectors.toList()).get(0);
        claims.put("rol", rol);
        return getToken(claims, userDetails.getUsername());
      }
    
    /*public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
      }
    
    private Boolean isTokenExpired(String token) {
	    Date expirationDate = extractExpiration(token);
	    Date currentDate = new Date();

	    // Agrega un margen de tiempo (tolerancia de reloj) de, por ejemplo, 5 minutos
	    long clockToleranceMillis = 1000 * 60 * 60 * (long) 8; // 5 minutos en milisegundos

	    return expirationDate.before(new Date(currentDate.getTime() + clockToleranceMillis));
	}
}
*/
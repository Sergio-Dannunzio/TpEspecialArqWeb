package com.example.demo.jwt;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SystemSecurity {
	
    private static final List<String> allowed = List.of("AdminService");

    private static String key = "E7D3E769F3F593DADCB8634CC5B09FC90DD3A61C4A06A79CB0923662FE6FAE6B";

    private static SystemSecurity instance = null;

    public static SystemSecurity getInstance() {
        if (instance == null) {
            instance = new SystemSecurity();
        }
        return instance;
    }

    public static boolean isAllowed(String request) {
        return allowed.contains(request);
    }

    public static String getKey() {
        return key;
    }
    
	public static String getToken(){
        return Jwts.builder()
                .setSubject("AdminService")
                .signWith(SignatureAlgorithm.HS256, SystemSecurity.getKey())
                .compact();
    }

    public static String decode(String token) {
        String[] parts = token.split("\\.");
        String payload = parts[1];
        byte[] decodedPayloadBytes = java.util.Base64.getDecoder().decode(payload);
        String decodedPayload = new String(decodedPayloadBytes);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(decodedPayload);
            if (jsonNode.has("sub")) {
                return jsonNode.get("sub").asText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

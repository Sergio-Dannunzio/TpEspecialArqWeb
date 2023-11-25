package com.example.demo.security.jwt;

import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class KeyEncoder {

    private static final String SECRET_KEY="czVXeFM2emhQeEJrS2dNdGh5N3VvbXhkcEVLeWpmS3Q=";

    public static Key getKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
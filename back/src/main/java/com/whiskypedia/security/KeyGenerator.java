package com.whiskypedia.security;

import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import java.security.Key;
import io.jsonwebtoken.SignatureAlgorithm;

public class KeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(base64Key);
    }
}
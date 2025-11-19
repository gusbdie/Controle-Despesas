package com.myproject.controle_despesas.Security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "imagina aqui uma senha muito grande e foda";
    private static final long EXPIRATION_TIME = 86400000; //1 dia

    private final Key chave = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String gerarToken(String email) {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(chave, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extrairEmail(String token){
        return Jwts.parserBuilder().setSigningKey(chave).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(chave).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }
}

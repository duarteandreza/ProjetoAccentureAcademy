//package br.com.duarteandreza.projetoaccenture.accentureacademy.services;
//
//import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class TokenService {
//
//    private static final long tempoExpiracao = 1800000;
//    private String chave;
//
//    public String gerarToken(Usuario usuario) {
//        return Jwts.builder()
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setSubject(String.valueOf(usuario.getId()))
//                .setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao))
//                .signWith(SignatureAlgorithm.ES256, chave)
//                .compact();
//    }
//
//}

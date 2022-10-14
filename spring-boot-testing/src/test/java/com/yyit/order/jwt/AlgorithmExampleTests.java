package com.yyit.order.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.jupiter.api.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class AlgorithmExampleTests {

    @Test
    void create_access_token_by_hs256_test(){

        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
        .withIssuer("auth0")
        .withClaim("hab", "123456")
        .sign(algorithm);

        System.out.println(token);

    }

    @Test
    void create_access_token_by_rs256_test() throws NoSuchAlgorithmException{

        KeyPair keyPair = generateRsaKey();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Algorithm algorithm = Algorithm.RSA256(publicKey,privateKey);
        String token = JWT.create()
        .withIssuer("auth0")
        .sign(algorithm);

        System.out.println(token);
    }


    private  KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        return keyPairGenerator.generateKeyPair();
    }


    @Test
    void verify_token_for_hs256_test(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.izVguZPRsBQ5Rqw6dhMvcIwy8_9lQnrO3vpxGwPCuzs";
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer("auth0")
        .build();

        DecodedJWT jwt = verifier.verify(token);

        
    }
    
}

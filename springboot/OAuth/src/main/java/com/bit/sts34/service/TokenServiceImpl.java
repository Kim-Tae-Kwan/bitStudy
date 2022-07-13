package com.bit.sts34.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class TokenServiceImpl {
	String secret = UUID.randomUUID().toString();
	
	public String createToken(String name, long limit) {
		Date time = new Date(limit);
		System.out.println(time);
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    String token = JWT.create()
		        .withClaim("username", name)
		        .withExpiresAt(time)
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		return null;
	}
	
	public String getUser(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret); //use more secure key
		    JWTVerifier verifier = JWT.require(algorithm).build();
		    DecodedJWT jwt = verifier.verify(token);
		    
		    return jwt.getClaim("username").asString();
		} catch (JWTVerificationException exception){
		}
		
		return "err";
	}
}

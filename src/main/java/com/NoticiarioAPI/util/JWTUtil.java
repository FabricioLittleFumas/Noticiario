package com.NoticiarioAPI.util;

import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class JWTUtil {
	
	@Value("${noticiarioAPI.secret.key}")
	private String secret_key;

	// code to generate Token
	public String generateToken(String subject) {
		String tokenId= String.valueOf(new Random().nextInt(10000));
		return Jwts.builder()
				.setId(tokenId)
				.setSubject(subject)
				.setIssuer("ABC_Ltd")
				.setAudience("XYZ_Ltd")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)))
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secret_key.getBytes()))
				.compact();
	}

	// code to get Claims
	public Claims getClaims(String token) {
		token = token.substring(7);
		Claims claim =  Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
		return claim;
	}

	// code to check if token is valid
	public boolean isValidToken(String token) {
		return getClaims(token).getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	// code to check if token is valid as per username
	public boolean isValidToken(String token,String username) {
		String tokenUserName=getSubject(token);
		return (username.equals(tokenUserName) && !isTokenExpired(token));
	}
	
	// code to check if token is expired
	public boolean isTokenExpired(String token) {
		return getExpirationDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	//code to get expiration date
	public Date getExpirationDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	//code to get expiration date
	public String getSubject(String token) {
		return getClaims(token).getSubject();
	}

}

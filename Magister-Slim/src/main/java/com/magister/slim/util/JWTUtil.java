package com.magister.slim.util;

import java.sql.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTUtil {

	private static final String JWT_SECRET = "My Secret";

	private static final String ISSUER = "Magister.slim";

	private static final Algorithm JWT_ALGORITHM = Algorithm.HMAC256(JWT_SECRET);

	private static final long expiresAt = 5000L;

	public static String generateToken(String payload) {
		Date now = new Date(System.currentTimeMillis() + expiresAt);
		System.out.println(now);
		System.out.println(now);
		String token = null;
		try {
			token = JWT.create().withIssuer(ISSUER).withExpiresAt(now).withClaim("payload", payload)
					.sign(JWT_ALGORITHM);
		} catch (JWTCreationException exception) {
		}
		return token;
	}

	public static boolean verifyToken(String token) {
		try {
			JWTVerifier verifier = JWT.require(JWT_ALGORITHM).withIssuer(ISSUER).acceptLeeway(1).build(); 																						// instance
			verifier.verify(token);
		} catch (JWTVerificationException exception) {
			exception.printStackTrace();
			System.out.println("Hii");
			return false;
		}
		return true;
	}

	public static String getPayload(String token) {
		DecodedJWT jwt = null;
		String ss = null;
		try {
			jwt = JWT.decode(token);
			ss = jwt.getPayload();
			System.out.println(jwt.getExpiresAt());
		} catch (JWTDecodeException exception) {
		}
		return ss;
	}

	public static void main(String[] args) {
		String payload = "MyPayload";
		String token = generateToken(payload);
		boolean valid = verifyToken(token);
		String tokenPayload = getPayload(token);

		System.out.println(token);
		System.out.println(valid);
		System.out.println(tokenPayload);
	}
}
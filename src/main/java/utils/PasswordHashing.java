package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashing {
	private static final String PEPPER = "POIVRE";
	
	public static String SecurePassword(String password) throws NoSuchAlgorithmException {
		TokenHelper token = new TokenHelper();
		String salt = token.generateToken(20);
		String hashedPassword = sha256Password(password, salt);
		return hashedPassword;
	}
	
	private static String sha256Password(String password, String salt) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		String hash = Base64.getEncoder().encodeToString(messageDigest.digest((password + salt + PEPPER).getBytes()));
		
		hash = String.format("sha256$%s$%s", salt, hash);
		return hash;		
	}
	
	public static String getSalt(String password) {
		String[] split = password.split("\\$");
		if (split.length == 3) {
			return split[1];
		}
		System.out.println("getSalt fail");
		return null;
	}
}

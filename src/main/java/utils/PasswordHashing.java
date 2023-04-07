package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashing {
	private static final String PEPPER = "POIVRE";
	
	public static String SecurePassword(String password) throws NoSuchAlgorithmException {
		String salt = TokenHelper.generateToken(20);
		String hashedPassword = sha256Password(password, salt);
		return hashedPassword;
	}
	
	private static String sha256Password(String password, String salt) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		String hash256 = Base64.getEncoder().encodeToString(messageDigest.digest((password + salt + PEPPER).getBytes()));		
		String passHash = String.format("sha256$%s$%s", salt, hash256);
		return passHash;		
	}
	
	public static String getSalt(String password) {
		String[] split = password.split("\\$");
		if (split.length < 3) {
			return null;
		}
		return split[1];
	}
}

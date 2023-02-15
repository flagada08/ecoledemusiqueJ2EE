package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHashing {
	
	public static void getHashedPasswordSalted(String password) throws NoSuchAlgorithmException {
		hashPass(password, getRandomSalt());
		
	}
	
	private static byte[] getRandomSalt() throws NoSuchAlgorithmException {
		byte[] bSalt = new byte[8];
 
		SecureRandom.getInstance("SHA1PRNG").nextBytes(bSalt);
		return bSalt;
	}
 
	private static String hashPass(byte[] password, byte[] salt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(md.digest(combine(salt, password)));
	}
 
	private static String hashPass(String password, byte[] salt) {
		return hashPass(password.getBytes(),salt);
	}
 
	public static byte[] combine(byte[] a, byte[] b) {
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
}

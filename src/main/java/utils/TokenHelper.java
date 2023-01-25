package utils;

import java.security.SecureRandom;

/**
 * @author User-05
 *
 */
public class TokenHelper {
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private final char[] ALPHANUMERIC = (ALPHABET + ALPHABET.toUpperCase() + "0123456789").toCharArray();
	
	public String generateToken(int taille) {
		StringBuilder resultat = new StringBuilder();
		
		for(int i = 0; i < taille; i++) {
			resultat.append(ALPHANUMERIC[new SecureRandom().nextInt(ALPHANUMERIC.length)]);
		}
		return resultat.toString();
	}
	
	public String getCSRF() {
		return generateToken(100);
	}
}

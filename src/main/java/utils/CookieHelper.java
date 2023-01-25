package utils;

import javax.servlet.http.Cookie;

/**
 * @author User-05
 *
 */
public class CookieHelper {
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 7;
	
	public Cookie generateCookie(String nom, String valeur, int maxAge ) {
		Cookie cookie = new Cookie(nom, valeur);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public Cookie getAuthCookie() {
		TokenHelper token = new TokenHelper();
		String tokenValueSized = token.generateToken(50);
		
		return generateCookie("auth-token", tokenValueSized, COOKIE_MAX_AGE);
	}
	
	public Cookie destroyCookie(Cookie nom) {
		nom.setMaxAge(0);
		return nom;
	}
}

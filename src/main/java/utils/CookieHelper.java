package utils;

import javax.servlet.http.Cookie;

/**
 * @author User-05
 *
 */
public class CookieHelper {
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 7;
	
	private Cookie generateCookie(String nom, String valeur, int maxAge ) {
		Cookie cookie = new Cookie(nom, valeur);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public Cookie setAuthCookie() {
		TokenHelper token = new TokenHelper();
		String tokenValueSized = token.generateToken(50);
		
		return generateCookie("auth-token", tokenValueSized, COOKIE_MAX_AGE);
	}
	
	public Cookie destroyCookie(Cookie cookie) {
		cookie.setMaxAge(0);
		return cookie;
	}
}

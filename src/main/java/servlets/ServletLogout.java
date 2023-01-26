package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.CookieHelper;

/**
 * Servlet implementation class ServletLogout
 */
@WebServlet("/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String URL_REDIRECTION = "http://localhost:8080/ecoledemusique/index";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On récupère et on détruit la session en cours
		HttpSession session = request.getSession();
		session.invalidate();
		
		// On récupère le cookie et on le détruit
		Cookie[] cookies = request.getCookies();
		CookieHelper cookieHelper = new CookieHelper();
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("auth-token")) {
					cookieHelper.destroyCookie(cookie);
					response.addCookie(cookie);
				}
			}
		}
		// Redirection vers l'accueil via l'url
		response.sendRedirect(URL_REDIRECTION);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Musicien;
import forms.ConnexionFormMusicien;
import utils.CookieHelper;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_LOGIN = "/WEB-INF/views/login.jsp";
	public static final String URL_REDIRECTION = "http://localhost:8080/ecoledemusique/index";
	
	public static final String ATT_FORM = "form";
	public static final String ATT_MUSICIEN = "musicien";
    public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionFormMusicien form = new ConnexionFormMusicien();	
		Musicien musicien = form.connexionMusicien(request);
		
		HttpSession session = request.getSession();
		
		String mail = request.getParameter("email_connexion");
		String password = request.getParameter("password_connexion");
		
		CookieHelper cookieHelper = new CookieHelper();		
		Cookie cookie = cookieHelper.setAuthCookie();
				
		if (request.getParameter("keep_connexion") != null) {
			response.addCookie(cookie);
		} else {
			cookieHelper.destroyCookie(cookie);
		}
		
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MUSICIEN, musicien);
		
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_MUSICIEN, musicien);
			response.sendRedirect(URL_REDIRECTION);
		} else {
			session.setAttribute(ATT_SESSION_MUSICIEN, null);
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
	}
}

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

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_LOGIN = "/WEB-INF/views/login.jsp";
	public static final String VUE_PROFIL = "/restrictions/profilMusicien.jsp";
	
	public static final String ATT_MUSICIEN = "musicien";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
    public static final String COOKIE = "cookie";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookie = getCookieValue(request, COOKIE);
		
		if (cookie != null) {
			
		}
		this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionFormMusicien form = new ConnexionFormMusicien();
		
		Musicien musicien = form.connexionMusicien(request);
		
		HttpSession session = request.getSession();
		
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MUSICIEN, musicien);
		
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_MUSICIEN, musicien);
			this.getServletContext().getRequestDispatcher(VUE_PROFIL).forward(request, response);
		} else {
			session.setAttribute(ATT_SESSION_MUSICIEN, null);
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
	}
	
	private static void setCookie(HttpServletResponse response, String nom) {
		
	}
	
	private static String getCookieValue( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

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
import dao.DaoFactory;
import dao.MusicienDao;
import forms.ConnexionFormMusicien;
import utils.CookieHelper;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicienDao musicienDao;
	
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.musicienDao = daoFactory.getMusicienDao();
	}
	
	public static final String VUE_LOGIN = "/WEB-INF/views/login.jsp";
	public static final String VUE_PROFIL = "/restrictions/profilMusicien.jsp";
		
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
		ConnexionFormMusicien form = new ConnexionFormMusicien(musicienDao);
		Musicien musicien = form.connexionMusicien(request);
		
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
			HttpSession session = request.getSession();
			session.setAttribute(ATT_SESSION_MUSICIEN, musicien);
		} else {
			request.setAttribute(ATT_SESSION_MUSICIEN, null);
		}
		this.getServletContext().getRequestDispatcher(VUE_PROFIL).forward(request, response);
	}
}

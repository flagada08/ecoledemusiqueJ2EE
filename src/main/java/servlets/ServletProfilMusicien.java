package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Musicien;
import dao.DaoFactory;
import dao.MusicienDao;
import forms.ConnexionFormMusicien;

/**
 * Servlet implementation class ServletProfilMusicien
 */
@WebServlet("/profil-musicien")
public class ServletProfilMusicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicienDao musicienDao;
	
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.musicienDao = daoFactory.getMusicienDao();
	}
	
	public static final String ATT_FORM = "form";
    public static final String ATT_MUSICIEN = "musicien";
    public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
	
	public static final String VUE_MUSICIEN = "/restrictions/profilMusicien.jsp";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnexionFormMusicien form = new ConnexionFormMusicien(musicienDao);
		Musicien musicien = form.connexionMusicien(request);
		
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MUSICIEN, musicien);
		
		HttpSession session = request.getSession();
		session.getAttribute(ATT_SESSION_MUSICIEN);
		
	this.getServletContext().getRequestDispatcher(VUE_MUSICIEN).forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Musicien;
import dao.DaoFactory;
import dao.MusicienDao;
import forms.InscriptionFormMusicien;

/**
 * Servlet implementation class ServletMusicien
 */
@WebServlet("/form-musicien")
public class ServletFormMusicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_FORM = "/WEB-INF/views/formMusicien.jsp";
	public static final String VUE_LOGIN ="/WEB-INF/views/login.jsp";    
	public static final String ATT_FORM = "form";
    public static final String ATT_MUSICIEN = "musicien";
    public static final String ATT_SESSION_MUSICIEN = "sessionMusicien";
       
    private MusicienDao musicienDao;
    
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.musicienDao = daoFactory.getMusicienDao();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Objet formulaire
		InscriptionFormMusicien form = new InscriptionFormMusicien(musicienDao);
		
		// Appel à la méthode de validation de la requête qui récupère le bean
		Musicien musicien = form.inscriptionMusicien(request);
				
		// Mettre dans l'objet request, le formulaire et le bean
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MUSICIEN, musicien);
		
		if (form.getErreurs().isEmpty()) {			
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}
	}
}

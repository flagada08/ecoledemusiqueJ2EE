package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Adresse;
import models.Musicien;

/**
 * Servlet implementation class ServletMusicien
 */
@WebServlet("/form-musicien")
public class ServletFormMusicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/formMusicien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des données
		String nom = request.getParameter("nom_musicien");
		String prenom = request.getParameter("prenom_musicien");
		String numero = request.getParameter("numero_musicien");
		String rue = request.getParameter("rue_musicien");
		String codePostal = request.getParameter("code-postal_musicien");
		String ville = request.getParameter("ville_musicien");
		String telephone = request.getParameter("telephone_musicien");
		String email = request.getParameter("mail_musicien");
		String instrument = request.getParameter("instrument_musicien");
		
		Adresse adresse = new Adresse(numero, rue, codePostal, ville);
		Musicien musicien = new Musicien(nom, prenom, adresse, telephone, email, instrument);
		
		request.setAttribute("musicien", musicien);
		request.setAttribute("adresse", adresse);
		
		RequestDispatcher dispatcher;
		
		dispatcher = request.getRequestDispatcher("WEB-INF/views/profilMusicien.jsp");
		
		dispatcher.forward(request, response);
	}

}

package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	
	public static final String VUE = "/WEB-INF/views/formMusicien.jsp";
	public static final String CHAMP_NOM = "nom_musicien";
	public static final String CHAMP_PRENOM = "prenom_musicien";
    public static final String CHAMP_PASS = "password_musicien";
    public static final String CHAMP_CONF = "confirmation_password_musicien";
    public static final String CHAMP_NUM = "numero_musicien";
    
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		
		// Récupération des données
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String password = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String numero = request.getParameter(CHAMP_NUM);
		String rue = request.getParameter("rue_musicien");
		String codePostal = request.getParameter("code-postal_musicien");
		String ville = request.getParameter("ville_musicien");
		String telephone = request.getParameter("telephone_musicien");
		String email = request.getParameter("mail_musicien");
		String instrument = request.getParameter("instrument_musicien");
		
		try {
			validationNom(nom);
		} catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		
		try {
			validationPrenom(prenom);			
		} catch (Exception e) {
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		
		try {
			validationPasswords(password, confirmation);			
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		
		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put(email, e.getMessage());
		}
		
		if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
		
		// Stockage du résultat et des messages d'erreur dans l'objet request
		request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);
		
		Adresse adresse = new Adresse(numero, rue, codePostal, ville);
		Musicien musicien = new Musicien(nom, prenom, password, adresse, telephone, email, instrument);
		
		// Traitement des données
		request.setAttribute("musicien", musicien);
		request.setAttribute("adresse", adresse);
		
		request.getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() < 3) {
			throw new Exception("Nom obligatoire et doit contenir au moins 3 caractères");
		}
	}
	
	public void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.trim().length() < 3) {
			throw new Exception("Prénom obligatoire et doit contenir au moins 3 caractères");
		}
	}

	public void validationPasswords(String password, String confirmation) throws Exception {
		if (password != null && password.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
			if (!password.equals(confirmation)) {
				throw new Exception("Confirmation du mot de passe différent");
			} else if (password.trim().length() < 5) {
				throw new Exception("Le mot de passe doit être composé de 5 caractères minimum");
			}
		} else {
			throw new Exception("Les champs Mot de passe et Confirmer le mot de passe sont obligatoire");
		}
	}
	
	public void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Adresse mail invalide");
			} else {
				throw new Exception("Adresse mail obligatoire");
			}
		}
	}
	
}

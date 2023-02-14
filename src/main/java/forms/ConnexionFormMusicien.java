package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Musicien;
import dao.MusicienDao;

/**
 * @author B450
 *
 */
public class ConnexionFormMusicien {
	private static final String CHAMP_EMAIL = "email_connexion";
	private static final String CHAMP_PASS = "password_connexion";
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private Musicien musicien = new Musicien();
	private MusicienDao musicienDao;
	
	public ConnexionFormMusicien(MusicienDao musicienDao) {
		this.setMusicienDao(musicienDao);
	}
	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}
	/**
	 * @param resultat the resultat to set
	 */
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	/**
	 * @param erreurs the erreurs to set
	 */
	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	/**
	 * @return the musicienDao
	 */
	public MusicienDao getMusicienDao() {
		return musicienDao;
	}
	/**
	 * @param musicienDao the musicienDao to set
	 */
	public void setMusicienDao(MusicienDao musicienDao) {
		this.musicienDao = musicienDao;
	}
	public Musicien connexionMusicien(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String password = getValeurChamp(request, CHAMP_PASS);
				
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		musicien.setEmail(email);
		
		try {
			validationPassword(password);			
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		musicien.setPassword(password);		
		
		if (erreurs.isEmpty()) {
			musicien = musicienDao.trouver(email);
            resultat = "Succès de la connexion";
        } else {
            resultat = "Échec de la connexion";
        }
		
		return musicien;
	}
	
	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
					+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
				throw new Exception("Adresse mail invalide");
			} 
		} else {
			throw new Exception("Adresse mail requise");
		}
	}
	
	private void validationPassword(String password) throws Exception {
		if (password != null) {
			if (password.length() < 5) {
				throw new Exception("Le mot de passe doit être composé de 5 caractères minimum");
			}
		} else {
			throw new Exception("Mot de passe requis");
		}
	}
	
	private void setErreur(String input, String message) {
	    erreurs.put(input, message);
	}
	
	private static String getValeurChamp(HttpServletRequest request, String inputName) {
	    String valeur = request.getParameter(inputName);
	    if (valeur == null || valeur.trim().length() == 0) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
}

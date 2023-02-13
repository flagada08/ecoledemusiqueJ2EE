package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Musicien;
import dao.MusicienDao;

/**
 * @author User-05
 *
 */
public final class InscriptionFormMusicien {
	public static final String CHAMP_NOM = "nom_musicien";
	public static final String CHAMP_PRENOM = "prenom_musicien";
    public static final String CHAMP_PASS = "password_musicien";
    public static final String CHAMP_CONF = "confirmation_password_musicien";
    public static final String CHAMP_NUM = "numero_musicien";
    public static final String CHAMP_RUE = "rue_musicien";
    public static final String CHAMP_CPL = "code_postal_musicien";
    public static final String CHAMP_VILLE = "ville_musicien";
    public static final String CHAMP_TEL = "telephone_musicien";
    public static final String CHAMP_MAIL = "mail_musicien";
    public static final String CHAMP_INSTRU = "instrument_musicien";
    
    private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	private MusicienDao musicienDao;
	
	public InscriptionFormMusicien(MusicienDao musicienDao) {
		this.musicienDao = musicienDao;
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
	
	public Musicien inscriptionMusicien(HttpServletRequest request) {
		// Récupération des données
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String password = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String numero = getValeurChamp(request, CHAMP_NUM);
		String rue = getValeurChamp(request, CHAMP_RUE);
		String codePostal = getValeurChamp(request, CHAMP_CPL);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String telephone = getValeurChamp(request, CHAMP_TEL);
		String email = getValeurChamp(request, CHAMP_MAIL);
		String instrument = getValeurChamp(request, CHAMP_INSTRU);
		
		Musicien musicien = new Musicien();
		
		try {
			traiterNom(nom, musicien);
			traiterPrenom(prenom, musicien);
			traiterPassword(password, confirmation, musicien);
			//TODO
			musicien.setNumero(numero);
			musicien.setRue(rue);
			musicien.setCodePostal(codePostal);
			musicien.setVille(ville);		
			musicien.setTelephone(telephone);
			
			traiterMail(email, musicien);
			//TODO			
			musicien.setInstrument(instrument);
			
			if (erreurs.isEmpty()) {
				musicienDao.ajouter(musicien);
            resultat = "Succès de l'inscription";
	        } else {
	            resultat = "Échec de l'inscription";
	        }
		} catch (Exception e) {
			resultat = "Échec inscription";
			e.printStackTrace();
		}
		
//		try {
//			validationNom(nom);
//		} catch (Exception e) {
//			setErreur(CHAMP_NOM, e.getMessage());
//		}
//		musicien.setNom(nom);
		
//		try {
//			validationPrenom(prenom);			
//		} catch (Exception e) {
//			setErreur(CHAMP_PRENOM, e.getMessage());
//		}
//		musicien.setPrenom(prenom);
		
//		try {
//			validationPasswords(password, confirmation);;			
//		} catch (Exception e) {
//			setErreur(CHAMP_PASS, e.getMessage());
//			setErreur(CHAMP_CONF, e.getMessage());
//		}		
//		musicien.setPassword(password);
		
//		try {
//			validationEmail(email);
//		} catch (Exception e) {
//			setErreur(CHAMP_MAIL, e.getMessage());
//		}
//		musicien.setEmail(email);
				
//		try {
//			if (erreurs.isEmpty()) {
//					musicienDao.ajouter(musicien);
//	            resultat = "Succès de l'inscription";
//	        } else {
//	            resultat = "Échec de l'inscription";
//	        }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return musicien;
	}
	
	private void traiterNom(String nom, Musicien musicien) {
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		musicien.setNom(nom);
	}
	
	private void traiterPrenom(String prenom, Musicien musicien) {
		try {
			validationPrenom(prenom);;
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		musicien.setPrenom(prenom);
	}
	
	private void traiterPassword(String password, String confirmation, Musicien musicien) {
		try {
			validationPasswords(password, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, e.getMessage());
		}
		musicien.setPassword(password);
	}
	
	private void traiterMail(String mail, Musicien musicien) {
		try {
			validationEmail(mail);
		} catch (Exception e) {
			setErreur(CHAMP_MAIL, e.getMessage());
		}
		musicien.setEmail(mail);
	}
	
	private void validationNom(String nom) throws Exception {
		if (nom != null) {
			if (nom.length() < 3) {
			throw new Exception("Nom obligatoire et doit contenir au moins 3 caractères");
			}
		} else {
			throw new Exception("Nom requis");
		}
	}
	
	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.length() < 3) {
			throw new Exception("Prénom obligatoire et doit contenir au moins 3 caractères");
		} else if (prenom == null) {
			throw new Exception("Prénom requis");
		}
	}

	private void validationPasswords(String password, String confirmation) throws Exception {
		if (password != null && confirmation != null) {
			if (!password.equals(confirmation)) {
				throw new Exception("Confirmation du mot de passe différent");
			} else if (password.length() < 5) {
				throw new Exception("Le mot de passe doit être composé de 5 caractères minimum");
			}
		} else {
			throw new Exception("Les champs Mot de passe et Confirmer le mot de passe sont obligatoire");
		}
	}
	
	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
				throw new Exception("Adresse mail invalide");
			} else if (musicienDao.trouver(email) == null) {
				throw new Exception("Cette email est déjà utilisé");
			}
		} else {
			throw new Exception("Adresse mail obligatoire");
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

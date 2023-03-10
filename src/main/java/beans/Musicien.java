package beans;

/**
 * @author User-05
 *
 */
public class Musicien {
	private int id;
	private String nom;
	private String prenom;
	private String password;
	private String numero;
	private String rue;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	private String instrument;
	
	public Musicien() {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setPassword(password);
		this.setNumero(numero);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setTelephone(telephone);
		this.setEmail(email);
		this.setInstrument(instrument);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idMusicien the id to set
	 */
	public void setId(int idMusicien) {
		this.id = idMusicien;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the instrument
	 */
	public String getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	@Override
	public String toString() {
		return "Musicien [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", numero="
				+ numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + ", email=" + email + ", instrument=" + instrument + "]";
	}

}

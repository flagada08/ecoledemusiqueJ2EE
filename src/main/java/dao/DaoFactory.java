package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String mail;
	private String password;	
	/**
	 * @param url
	 * @param mail
	 * @param password
	 */
	public DaoFactory(String url, String mail, String password) {
		this.url = url;
		this.mail = mail;
		this.password = password;
	}
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DaoFactory instance = new DaoFactory(
				"jdbc:mysql://localhost:3306/ecoledemusique", "root", ""
				);		
		return instance;
	}
	public Connection getConnection() throws SQLException {
		Connection connexion = DriverManager.getConnection(url, mail, password);
		connexion.setAutoCommit(false);
		return connexion;
	}
	public MusicienDao getMusicienDao() {
		return new MusicienDaoImpl(this);
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
	public void close(Connection connexion) {
		try {
			connexion.close();
		} catch (Exception e) {
			
		}
	}	
}

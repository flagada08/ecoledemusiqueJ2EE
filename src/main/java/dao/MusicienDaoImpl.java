package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Musicien;

public class MusicienDaoImpl implements MusicienDao {
	private DaoFactory daoFactory;
		
	/**
	 * @param daoFactory
	 */
	public MusicienDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Musicien musicien) throws Exception {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"INSERT INTO musicien(name, firstname, password, numero, rue, code_postal, ville, telephone, email, instrument) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS
					);
			
			preparedStatement.setString(1, musicien.getNom());
			preparedStatement.setString(2, musicien.getPrenom());
			preparedStatement.setString(3, musicien.getPassword());
			preparedStatement.setString(4, musicien.getNumero());
			preparedStatement.setString(5, musicien.getRue());
			preparedStatement.setString(6, musicien.getCodePostal());
			preparedStatement.setString(7, musicien.getVille());
			preparedStatement.setString(8, musicien.getTelephone());
			preparedStatement.setString(9, musicien.getEmail());
			preparedStatement.setString(10, musicien.getInstrument());
			
			preparedStatement.executeUpdate();
			connexion.commit();
			
//			ResultSet idKey = preparedStatement.getGeneratedKeys();
//			if (idKey.next()) {
//				musicien.setId(idKey.getInt(1));
//				System.out.println(idKey);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Musicien trouver(String mail) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
		Musicien musicien = new Musicien();
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"SELECT * FROM musicien WHERE email = ?;"
					);
			preparedStatement.setString(1, mail);
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()) {
				int idMusicien = resultat.getInt("id_musicien");
				String nomMusicien = resultat.getString("name");
				String prenomMusicien = resultat.getString("firstname");
				String passwordMusicien = resultat.getString("password");
				String numeroMusicien = resultat.getString("numero");
				String rueMusicien = resultat.getString("rue");
				String codePostalMusicien = resultat.getString("code_postal");
				String villeMusicien = resultat.getString("ville");
				String telephoneMusicien = resultat.getString("telephone");
				String emailMusicien = resultat.getString("email");
				String instrumentMusicien = resultat.getString("instrument");

				musicien.setId(idMusicien);
				musicien.setNom(nomMusicien);
				musicien.setPrenom(prenomMusicien);
				musicien.setPassword(passwordMusicien);
				musicien.setNumero(numeroMusicien);
				musicien.setRue(rueMusicien);
				musicien.setCodePostal(codePostalMusicien);
				musicien.setVille(villeMusicien);
				musicien.setTelephone(telephoneMusicien);
				musicien.setEmail(emailMusicien);
				musicien.setInstrument(instrumentMusicien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return musicien;
	}

	@Override
	public List<Musicien> lister() {
		List<Musicien> musiciens = new ArrayList<Musicien>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;		
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM musicien ORDER BY id_musicien DESC;");
			
			while(resultat.next()) {
				Musicien musicien = new Musicien();
				
				int idMusicien = resultat.getInt("id_musicien");
				String nomMusicien = resultat.getString("name");
				String prenomMusicien = resultat.getString("firstname");
				String passwordMusicien = resultat.getString("password");
				String numeroMusicien = resultat.getString("numero");
				String rueMusicien = resultat.getString("rue");
				String codePostalMusicien = resultat.getString("code_postal");
				String villeMusicien = resultat.getString("ville");
				String telephoneMusicien = resultat.getString("telephone");
				String emailMusicien = resultat.getString("email");
				String instrumentMusicien = resultat.getString("instrument");
				
				musicien.setId(idMusicien);
				musicien.setNom(nomMusicien);
				musicien.setPrenom(prenomMusicien);
				musicien.setPassword(passwordMusicien);
				musicien.setNumero(numeroMusicien);
				musicien.setRue(rueMusicien);
				musicien.setCodePostal(codePostalMusicien);
				musicien.setVille(villeMusicien);
				musicien.setTelephone(telephoneMusicien);
				musicien.setEmail(emailMusicien);
				musicien.setInstrument(instrumentMusicien);
				
				musiciens.add(musicien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return musiciens;
	}

	@Override
	public boolean valider(String mail, String password) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        
        try {
        	connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"SELECT * FROM musicien WHERE password = ? AND email = ?;"
					);
			
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, mail);
			
			resultat = preparedStatement.executeQuery();
			
			if (resultat.next()) {
				return true;
			}
        } catch (Exception e){
        	e.printStackTrace();
        } finally {
        	daoFactory.close(connexion);
        }        
		return false;
	}
}

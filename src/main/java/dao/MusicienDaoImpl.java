package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Musicien;
import utils.DAOFermeture;

public class MusicienDaoImpl implements MusicienDao {
	private DaoFactory daoFactory;
		
	/**
	 * @param daoFactory
	 */
	public MusicienDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Musicien musicien) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
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
			
			int statut = preparedStatement.executeUpdate();
			connexion.commit();
			
			if (statut == 0) {
				throw new DAOException( "Échec de la création : aucune ligne ajoutée dans la table" );
			}			
			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				musicien.setId(generatedKeys.getInt(1));
			} else {
				throw new DAOException( "Échec de la création en base : aucun ID auto-généré retourné" );
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOFermeture.fermeturesSilencieuses( generatedKeys, preparedStatement, connexion );
		}
	}
	
	@Override
	public Musicien trouver(String mail) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
		Musicien musicien = null;
		
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
				
				musicien = new Musicien();
				
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
			throw new DAOException(e);
		} finally {
			DAOFermeture.fermeturesSilencieuses(resultat, preparedStatement, connexion);
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
			throw new DAOException(e);
		}
		
		return musiciens;
	}

	@Override
	public boolean validerMailPassword(String mail, String password) {
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
        	throw new DAOException(e);
        } finally {
        	daoFactory.close(connexion);
        }
		return false;
	}
}

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
	public void ajouter(Musicien musicien) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO musicien(idMusicien, name, firstname, password, idAdresse, telephone, email, instrument) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setLong(1, musicien.getId());
			preparedStatement.setString(2, musicien.getNom());
			preparedStatement.setString(3, musicien.getPrenom());
			preparedStatement.setString(4, musicien.getPassword());
			preparedStatement.setLong(5, musicien.getIdAdresse());
			preparedStatement.setString(6, musicien.getTelephone());
			preparedStatement.setString(7, musicien.getEmail());
			preparedStatement.setString(8, musicien.getInstrument());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void afficherInfoMusicien(Musicien infoMusicien) {
				
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
			resultat = statement.executeQuery("SELECT name, firstname, instrument FROM musicien;");
			
			while(resultat.next()) {
				String name = resultat.getString("name");
				String firstname = resultat.getString("firstname");
				String instrument = resultat.getString("instrument");
				
				Musicien musicien = new Musicien();
				musicien.setNom(name);
				musicien.setPrenom(firstname);
				musicien.setInstrument(instrument);
				
				musiciens.add(musicien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return musiciens;
	}
	
}

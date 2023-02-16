package dao;

import java.util.List;

import beans.Musicien;

public interface MusicienDao {
	void ajouter(Musicien musicien) throws DAOException;
	Musicien trouver(String mail) throws DAOException;
	boolean validerMailPassword(String musicien, String password);
	List<Musicien> lister();
}

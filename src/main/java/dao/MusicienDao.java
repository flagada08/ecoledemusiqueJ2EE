package dao;

import java.util.List;

import beans.Musicien;

public interface MusicienDao {
	void ajouter(Musicien musicien) throws Exception;
	Musicien trouver(String mail);
	boolean valider(String musicien, String password);
	List<Musicien> lister();
}

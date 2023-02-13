package dao;

import java.util.List;

import beans.Musicien;

public interface MusicienDao {
	void ajouter(Musicien musicien) throws Exception;
	Musicien trouver(String mail);
	Musicien trouverID(int id);
	List<Musicien> lister();
}

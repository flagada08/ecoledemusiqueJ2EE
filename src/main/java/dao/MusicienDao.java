package dao;

import java.util.List;

import beans.Musicien;

public interface MusicienDao {
	void ajouter(Musicien musicien);
	void afficherInfoMusicien(Musicien infoMusicien);
	List<Musicien> lister();
}

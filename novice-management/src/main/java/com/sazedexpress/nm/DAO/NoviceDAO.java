package com.sazedexpress.nm.DAO;

import java.util.List;
import com.sazedexpress.nm.api.Novice;

public interface NoviceDAO {
	
	List<Novice> loadNovice();
	Novice getNoviceById(int id);
	void  saveNovice(Novice novice);
	void deleteNovice(int id);
	void updateNovice(Novice novice);

}

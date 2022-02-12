package com.sazedexpress.nm.services;

import java.util.List;

import com.sazedexpress.nm.api.Novice;
import com.sazedexpress.nm.api.NoviceDTO;



public interface NoviceService {
	
	List<Novice> loadNovice();
	NoviceDTO getNoviceById(int id);
	void saveNovice(NoviceDTO noviceDTO);
	void updateNovice(NoviceDTO noviceDTO);
	void deleteNovice(int id);

}

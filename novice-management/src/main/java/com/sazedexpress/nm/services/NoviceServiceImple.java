package com.sazedexpress.nm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sazedexpress.nm.DAO.NoviceDAO;
import com.sazedexpress.nm.api.Novice;
import com.sazedexpress.nm.api.NoviceDTO;

@Service
public class NoviceServiceImple implements NoviceService{

	@Autowired
	private NoviceDAO noviceDAO;
	@Override
	public List<Novice> loadNovice() {
		List<Novice> listOfNovice=noviceDAO.loadNovice();
		return listOfNovice;
	}

	@Override
	public NoviceDTO getNoviceById(int id) {
		
		Novice novice=noviceDAO.getNoviceById(id);
		NoviceDTO noviceDTO=new NoviceDTO();
		noviceDTO.setNoviceId(novice.getId());
		noviceDTO.setStudentNameString(novice.getName());
		noviceDTO.setStudentMobile(novice.getMobile());
		noviceDTO.setCountryString(novice.getCountry());
		return noviceDTO;
	}

	@Override
	public void saveNovice(NoviceDTO noviceDTO) {
		
		Novice novice=new Novice();
		novice.setName(noviceDTO.getStudentNameString());
		novice.setMobile(noviceDTO.getStudentMobile());
		novice.setCountry(noviceDTO.getCountryString());
		noviceDAO.saveNovice(novice);
	}

	@Override
	public void updateNovice(NoviceDTO noviceDTO) {
		Novice novice=new Novice();
		novice.setId(noviceDTO.getNoviceId());
		novice.setName(noviceDTO.getStudentNameString());
		novice.setMobile(noviceDTO.getStudentMobile());
		novice.setCountry(noviceDTO.getCountryString());
		noviceDAO.updateNovice(novice);
	}

	@Override
	public void deleteNovice(int id) {
		noviceDAO.deleteNovice(id);
	}

}

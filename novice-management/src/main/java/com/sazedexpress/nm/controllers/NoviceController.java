package com.sazedexpress.nm.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sazedexpress.nm.DAO.NoviceDAO;
import com.sazedexpress.nm.api.Novice;
import com.sazedexpress.nm.api.NoviceDTO;
import com.sazedexpress.nm.services.NoviceService;

@Controller
public class NoviceController {
	
	
	
	@Autowired
	private NoviceService noviceService;
	
//	@Autowired
//	private NoviceDAO noviceDAO;
	
	@GetMapping("/showNoviceListPage")
	public String showNoviceListPage(Model model) {
		
		List<Novice> noviceList=noviceService.loadNovice();
		model.addAttribute("novices",noviceList);
		return "novice-list";
	}
	
	@GetMapping("/showNoviceEntryPage")
	public String showNoviceEntryPage(Model model) {
		
		NoviceDTO noviceDTO=new NoviceDTO();
		model.addAttribute("student", noviceDTO);
		return "novice-entry";
		
	}
	//@ResponseBody
	@PostMapping("/save-novice")
	public String saveNovice(NoviceDTO noviceDTO) {
		if (noviceDTO.getNoviceId()==0) {
			noviceService.saveNovice(noviceDTO);
		}else {
			noviceService.updateNovice(noviceDTO);
		}
		
		return "redirect:/showNoviceListPage";
		
	}
	
	@GetMapping("/updateNovice")
	public String updateService(@RequestParam("noviceId")int id,Model model) {
		NoviceDTO noviceDTO=noviceService.getNoviceById(id);
		model.addAttribute("student",noviceDTO);
		
		return "novice-entry";
	}
	
	@GetMapping("/deleteNovice")
	public String deleteNovice(@RequestParam("noviceId") int id) {
		noviceService.deleteNovice(id);
		return "redirect:/showNoviceListPage";
		
	}
	

}

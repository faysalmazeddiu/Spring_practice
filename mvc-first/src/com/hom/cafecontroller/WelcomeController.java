package com.hom.cafecontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	//@ResponseBody
	@RequestMapping("/welcome")
	public String welcomePage(Model model) {
		String title="SAZED-CAFE";
		model.addAttribute("pagetitle",title);
		return "welcome-page";
	}
	
	
	@RequestMapping("/processorder")
	public String processOrder(HttpServletRequest request,Model model) {
		
		
		String itemName=request.getParameter("item_name");
		model.addAttribute("iten_name",itemName);
		
		return "process-order";
		
	}

}

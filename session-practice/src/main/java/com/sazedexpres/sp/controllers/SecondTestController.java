package com.sazedexpres.sp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SecondTestController {
	
	/*
	 
	 
	 		 *******  NOTE :: it highly recommended to use HttpSession.*******
	 		 *
	 		NOTE ::: 
	 		
	 	==>   session data can not be access from different controller class handler method and session data will not be automatically
	 	      binded with model attributes in different controller. to access session data from different controller class , developed
	 	      need to call @SessionAttribute() in method argument label.
	 	      
	   ===>   although session data are not passed  to JSP page by model attribute, but session data will be printed form session scope.  
	 
	 
	 
	 */
	
	
	@RequestMapping("/newControllerMethod1")
	public String newControllerMethod1(@SessionAttribute("firstName") String firstName,Model model) {
		
		String newfirstNameString="Mr "+firstName;
		model.addAttribute("firstName", newfirstNameString);
			
		return "session-page";
		
	}
}

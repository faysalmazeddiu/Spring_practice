package com.sazedexpres.sp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"firstName","secondName"}) 
public class TestController {
	
	/*
	 	==> when "@SessionAttributes({"firstName","secondName"})"  are added with controller class. all session data will be 
	 	    automatically binded with Model attribute in all handler method of that controller class  where @SessionAttributes()
	 	    annptation is included. 
	 	    
	 *  ==> developer can destroy session scope by create a "SessionStatus" object in method argument section and call the method 
	  		setComplete() inside that particular handler method  
	  		
	  		ex-    public String method3(Model model3, SessionStatus status) {
	  		
	  						status.setComplete();
	  		
	  		       }
	  		       
	    ===> @SessionAttributes() annotation and associate operation should be done in  one specific controller.
	    
	    *******  NOTE :: it highly recommended to use HttpSession.*******
	 */
	
	
	
	
	@RequestMapping("/method1")
	public String method1(Model model) {
		String firstName="Md Faysal Hossain";
		String secondName="Mazed";
		model.addAttribute("firstName", firstName);
		model.addAttribute("secondName", secondName);
		model.addAttribute("nextLink", "/method2");
		return "session-page";
	}
	
	
	@RequestMapping("/method2")
	public String method2(Model model2) {
		
		// no need to write bellow 4 lines. because session data will be binded with model  automatically
		String firstName=(String)model2.getAttribute("firstName");
		String secondName=(String)model2.getAttribute("secondName");
		model2.addAttribute("firstName", firstName);
		model2.addAttribute("secondName", secondName);
		model2.addAttribute("nextLink", "/method3");
		
		return "session-page";
		
	}
	
	@RequestMapping("/method3")
	public String method3(Model model3, SessionStatus status) {
		String secondName=(String)model3.getAttribute("secondName");
		model3.addAttribute("secondName", secondName);
		//status.setComplete();
		model3.addAttribute("nextLink", "/newControllerMethod1");
		return "session-page";
		
	}
}

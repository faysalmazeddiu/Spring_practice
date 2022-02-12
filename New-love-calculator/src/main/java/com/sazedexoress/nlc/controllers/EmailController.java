package com.sazedexoress.nlc.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sazedexoress.nlc.api.EmailDTO;
import com.sazedexoress.nlc.api.UserInfoDTO;
import com.sazedexoress.nlc.services.NLCAppEmailService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class EmailController {
	
	@Autowired
	NLCAppEmailService nlcAppEmailService;
	
	/*
	  // for multiple query string receiving from URL ::::
	   
	//@RequestMapping("/sendEmail/{userName}/{hobby}/{interest}") 
	public String sendEmail(Model model, @PathVariable Map<String, String> pathVar) { 
		String userName=pathVar.get("userName");
		String hobby=pathVar.get("hobby");
		String interest=pathVar.get("interest");
		model.addAttribute("emailInfo", new EmailDTO());
		model.addAttribute("userName", userName.toUpperCase());
		return "send-email";
	}
	
	*/
	
	
	/*
	
	// for sending data one to another page by url ::
	
	@RequestMapping("/sendEmail/{userName}")
	public String sendEmail(Model model, @PathVariable("userName") String name) { 
	//public String sendEmail(@ModelAttribute("emailInfo") EmailDTO dto, @PathVariable("userName") String name) { //it work fine 
		model.addAttribute("emailInfo", new EmailDTO());
		model.addAttribute("userName", name.toUpperCase());
		return "send-email";
	}
	
	*/
	
	
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) { 
		/*
		 	// for  sending cookies data to another page ,user need to featch cookies data from cookie
		 	   by using @CookieValue() annotation and set it to model  ::::::
		 	   
		 	   Ex--- public String sendEmail(@CookieValue("NlcApp.userName")String userNameSetInCookie ,Model model) 
		 	   
			    model.addAttribute("userNameSetInCookie",userNameSetInCookie);
		*/
		model.addAttribute("emailInfo", new EmailDTO());
		
		return "send-email";
	}
	
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfoDTO") UserInfoDTO userInfoDTO,@ModelAttribute("emailInfo") EmailDTO dto) {
		
		/*
		 
		//  featch data from HttpSession session  and manupulate it and finally set in model :::::
		// ==> Ex--  public String processEmail(@ModelAttribute("emailInfo") EmailDTO dto,HttpSession session, Model model)
		
		String userNameSetInSession=(String)session.getAttribute("userNameSetInSession");
		userNameSetInSession="Mr."+userNameSetInSession;
		model.addAttribute("userNameSetInSession", userNameSetInSession);
		
		*/
		
		
		// for sending email
		try {

			nlcAppEmailService.sendEmail(userInfoDTO.getUserName(),dto.getEmailAddress(), "FRIENDS");
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>>"+e);
			return "send-email";
		}
		
		return "email-successful";
		
	}

	
	

}

package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MomController {
	
	//@ResponseBody // "@ResponseBody" annotation return anything to browser as string
	
	
	@RequestMapping("/hello")
	public String giveHello() {
		
		//return "/WEB-INF/view/hello.html";
		return "hello";
		
	}
	
	

}

package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sis")  // class lebel mapping
public class SisController {
	
	@ResponseBody
	@RequestMapping("/makeup")
	public String giveMakeup() {
		
		return "This is your makup";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/book")
	public String getBooks() {
		
		return "here is the book";
	}

}

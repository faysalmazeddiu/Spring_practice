package com.third.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentInfo {
	
	
	//@ResponseBody
	@RequestMapping("/allstudent")
	public String allStudentInfo() {
		
		return "home";
		
	}

}

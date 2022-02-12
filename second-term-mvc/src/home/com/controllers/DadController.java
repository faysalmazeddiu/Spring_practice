package home.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dadController")
public class DadController {
	
	@ResponseBody
	@RequestMapping("/permission")
	public String givePermission() {
		return "Here is dad controller for permission";
	}
	
	
	@ResponseBody
	@RequestMapping("/giveBook")
	public String giveBook() {
		
		return "Here is book for choice";
	}

}

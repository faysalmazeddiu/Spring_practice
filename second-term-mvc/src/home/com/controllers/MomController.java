package home.com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MomController {
	
	@ResponseBody
	@RequestMapping("/sugar")
	public String giveSugar() {
		return "here is sugar";
	}
	
	@RequestMapping("/indexPage")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping("/processData")
	public String processData(HttpServletRequest request,Model model) {
		String orderNameString=request.getParameter("productName");
		model.addAttribute("orderName", orderNameString);
		return "view";
	}

}

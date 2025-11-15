package com.sazedexoress.nlc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.AbstractListModel;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sazedexoress.nlc.api.UserInfoDTO;
import com.sazedexoress.nlc.services.NLCAppCalculationService;


/*
 		==> @SessionAttributes annotation are written in class lable .
 		
 		===> to set data in @SessionAttributes annotation : Ex- @SessionAttributes({"userInfoDTO"})
 		
 		===> to set multiple data in @SessionAttributes annotation : Ex- @SessionAttributes({"userInfoDTO","XXXXXXXX"})
 		
  		==>  To use @SessionAttributes annotation user need to write same modelAttribute name in the annotation section. if 
  		     user want to use @SessionAttributes annotation , in that case @ModelAttribute() annotation can not be used 
  		     in "first page load method" argument section for data binding. in that case, Model object need to be created for data binding.
  		     
  				Ex-  :: 
  				
  				public String showHomePage(Model model) {
  					model.addAttribute("userInfoDTO", new UserInfoDTO());  // in session annotation, @SessionAttributes({"userInfoDTO"})
  				}
  		===> session data can be used in jsp page by this way ---> userInfoDTO.userName
 
 */

@Controller
@SessionAttributes({"userInfoDTO"})
public class NlcAppController {
	
	@Autowired
	NLCAppCalculationService nlcAppcalculationService;
	/* 
	 // one way to modelAttribute binding with form 
	  
	@RequestMapping("/showHomePage")
	public String showHomePage(Model model) {
		UserInfoDTO userInfoDTO=new UserInfoDTO();
		model.addAttribute("userInfoDTO", userInfoDTO);
		return "home-page";
	}
	*/
	
	@RequestMapping("/showHomePage")
	public String showHomePage(Model model) {
		
		model.addAttribute("userInfoDTO", new UserInfoDTO());
		
		/*
		// ===> featching  cookies data from cookie  :::: 
		 
		 	===> if user need to featch data from cookie user need to create HttpServletRequest object in method argument section.
		 			Ex- public String showHomePage(@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO, HttpServletRequest request)
		
		Cookie cookieArr[]=request.getCookies();
		for (Cookie temp:cookieArr) {
			if (temp.getName().equals("NlcApp.userName")) {
				String setUserNameInCookie=temp.getValue();
				userInfoDTO.setUserName(setUserNameInCookie);
			}
		}
		
		*/ 
		
		
		return "home-page";
	}
	
	
	/*
	 first way : to receive form data and bind with spring provided Model class to pass it to result-page
	@RequestMapping("/process-homepage")
	public String processHomepage(@RequestParam String userName,@RequestParam String crashName,Model model){  // parameter name and query string should be same
		
		model.addAttribute("userName", userName);
		model.addAttribute("crashName", crashName);
		return "result-page";
		
	}

	//Second way :  parameter name and query string should be same like @RequestParam("userName"), @RequestParam("crushName")

	@RequestMapping("/process-homepage")
	public String showResultPage(@RequestParam("userName") String userName1,@RequestParam("crushName") String crushName1,Model model) {
		
		System.out.println("user name is "+userName1);
		System.out.println("Crush name is "+crushName1);
		
		model.addAttribute("userName", userName1);
		model.addAttribute("crushName", crushName1);
		
		return "result-page";
	}

	
	// Third way : when we lot of input  field in a form, then instead of catching all value in seperately , we can catch it by a Pojo class
	
	public String processHomepage(UserInfoDTO userInfoDTO, Model model) {
		model.addAttribute("userInfo", userInfoDTO);
		return "result-page";
	}
	
	*/
	
	@RequestMapping("/process-homepage")
	public String processHomepage(@Valid @ModelAttribute("userInfoDTO")UserInfoDTO userInfoDTO, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<ObjectError> allError=result.getAllErrors();
			for (ObjectError objectError : allError) {
				System.out.println(objectError);
			}
			
			return "home-page";
		}
		
		/*
		 
		// set session by HttpRequest or HttpSession object :::
		
		  // ====>  to use session HttpServletRequest object need to create in method argument section
		//			   Ex- public String processHomepage(@ModelAttribute("userInfoDTO")UserInfoDTO userInfoDTO, HttpServletRequest request)
		 
		//=======>  user can use data from any page by calling name of session . 
		 			   Ex-- in this method session name is "userNameSetInSession"
		   ======>  gettig session data from HttpSession , user need to use getAttribute() method
		               Ex- 
				               HttpSession session=new HttpSession();
				               session.getAttributed("userNameSetInSession");
				               
		    ==> 	to destroy HttpSession , user need to call inValidate() method
		             Ex-    
		             		HttpSession session=new HttpSession();
		             		session.inValidate()
		 
		 HttpSession session=request.getSession();  // getSession() function will automatically create session, if you dom't have session
		 session.setAttribute("userNameSetInSession", userInfoDTO.getUserName()); // set value in session
		 session.setMaxInactiveInterval(120); // setting session expiration time 
		
		
		 
		// set cookies ::::
		
		 ====> // to use cookies,  HttpServletResponse object   need to create in method argument section
		  			  Ex- public String processHomepage(@ModelAttribute("userInfoDTO")UserInfoDTO userInfoDTO, HttpServletResponse response)
		  * 
		Cookie cookie=new Cookie("NlcApp.userName", userInfoDTO.getUserName());
		cookie.setMaxAge(60*60*24); // set cookies for 24 hours by minutes
		response.addCookie(cookie); // add cookie in response
		
		*/
		String appResult=nlcAppcalculationService.calculateRelation(userInfoDTO.getUserName(), userInfoDTO.getCrashName());
		model.addAttribute("appResult", appResult);
		return "result-page";
	}
	

}

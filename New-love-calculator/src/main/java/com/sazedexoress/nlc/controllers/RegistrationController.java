package com.sazedexoress.nlc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sazedexoress.nlc.api.CommunicationDTO;
import com.sazedexoress.nlc.api.Phone;
import com.sazedexoress.nlc.api.UserRegistrationDTO;
import com.sazedexoress.nlc.propertyeditor.NameCustomEditorProperty;
import com.sazedexoress.nlc.validator.EmailValidator;
import com.sazedexoress.nlc.validator.UserNameValidatior;

@Controller
public class RegistrationController {
	
	@RequestMapping("/showRegistrationPage")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO) {
		
		// Demo code for showing implemetation for print() method in formatter interface
		
		 	Phone phone =new Phone();
			phone.setCountryCode("99");
			phone.setUserNumber("123456");
			CommunicationDTO communicationDTO=new CommunicationDTO();
			communicationDTO.setPhone(phone);
			userRegistrationDTO.setCommunicationDTO(communicationDTO);
		 
		
		System.out.println("load registration page");
		
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto,BindingResult result) {
		System.out.println("process registration info");
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors=result.getAllErrors();
			for (ObjectError err:allErrors) {
				System.out.println(err);
			}
			
			return "user-registration-page";
		}
		return "registration-success";
	}
	
	
	/*
	 property editor ::
	 
	 ===> Spring uses property editor to convert from strings data type to custome object type
	   	  and custome object type to string type.
	   	  
	 */
	
	
	
	
	// initBinder method will be executed before any other menthod of this controller
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Hello Init Binder...........");
		// logic for space removing in name input box: custom property editor
		
		StringTrimmerEditor editor=new StringTrimmerEditor(true); // it will identify  white space, and it convert white space from string  into null
		
		// register editor with binder :
		binder.registerCustomEditor(String.class, "name",editor);
		//binder.setDisallowedFields("name");
		
		
		// my own custom property editor :
		NameCustomEditorProperty nameCustomEditorProperty=new NameCustomEditorProperty();
		binder.registerCustomEditor(String.class,"name",nameCustomEditorProperty);
		
		// register validator
		binder.addValidators(new UserNameValidatior());
		binder.addValidators(new EmailValidator());
	}
	
	
}

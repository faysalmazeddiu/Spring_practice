package com.sazedexoress.nlc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sazedexoress.nlc.api.UserRegistrationDTO;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		 return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		/*
		 
		 
		//===> by typing error message as a argument "* Email should be null or empty " ::::
		 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty", " * Email should be null or empty ");
		
		
		*/
		// ===> loading error message from properties file using error code "email.empty" :::
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		
		
		// wheteher the email ending with
		String emailString=((UserRegistrationDTO) target).getCommunicationDTO().getEmail();
		if (!emailString.endsWith("@sazedexoress.com")) {
			
			/*
			 
			
			// ==> by typing error message as a argument "* Email formate should be XXXXX@sazedexoress.com" :::::
			 
			errors.rejectValue("communicationDTO.email", "email.endWith", "* Email formate should be XXXXX@sazedexoress.com");
			
			 */
			
			// ===> loading error message from properties file using error code "email.endWith" :::
			errors.rejectValue("communicationDTO.email", "email.endWith");
			
		}

	}

}

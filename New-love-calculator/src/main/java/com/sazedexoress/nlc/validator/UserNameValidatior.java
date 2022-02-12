package com.sazedexoress.nlc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sazedexoress.nlc.api.UserRegistrationDTO;

public class UserNameValidatior implements Validator{

	/*
	 
    ==> this UserNameValidatior is own custom class  was developed by implementing spring validation API . 
        it is not related with any bean or hibernate  validation. to create own custom validator, user need
        create a class and that will be implemented by Validator interface. 
        
    ==> then user need to override two method one is supports() and another is validate()
    
    ==> supports() method check the field which user want to validate, that field is available or not under the POJO class
    
    ==> validate() method is used for writting own validation logic and set error message. here user can also use some build in 
     	validation method. to use those build in validation method user need to use "ValidationUtils" method. 
     	
     	Ex- ValidationUtils.rejectIfEmptyOrWhitespace()
        
    ==> it is need to be registered by inite binder method from Controller .
    
    ===> flow ::: controller initeBinder method--->UserValidator class support()----> validate()---> controller handller method
*/
	
	
	
	// check UserNameValidtor support a given object
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	
	// here will be our custom validation logic
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", " * Username Should be empty");
		
		
		String userNameString=((UserRegistrationDTO)target).getUserName();
		if (!userNameString.contains("_")) {
			errors.rejectValue("userName", "userName.containUndersocre", " * User name should compose with a underscore");
		}
		
	}
	

}

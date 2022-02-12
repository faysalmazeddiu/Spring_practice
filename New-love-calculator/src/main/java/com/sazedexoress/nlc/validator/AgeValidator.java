package com.sazedexoress.nlc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	private int upper;
	private int lower;
	@Override
	public void initialize(Age age) { // at first initialize() function is executed , then execution will go to isValid() method
		
		// pre logic for isvalid() method
		
		this.upper=age.upper();
		this.lower=age.lower();
	}
	
	
	// you own validation logic are written here based on you logic.
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// here will be logic
		if (age==null) {
			return false;
		}
		if (age<lower || age>upper) {
			return false;
		}
		
		return true;
	}

}

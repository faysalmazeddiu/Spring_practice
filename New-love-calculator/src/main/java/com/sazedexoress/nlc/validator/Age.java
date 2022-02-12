package com.sazedexoress.nlc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	//String message() default "Age should be between {lower} to {upper}";
	String message() default "{invalidMessage}"; // load message from property file by using "invalidMessage" key. 
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	int lower() default 18;
	int upper() default 60;
}







/*    ************ WAY TO DEVELOP OWN VALIDATION ANNOTATION*************************************************
 
 
 
 

	==> To create an Own CustomValidation Annotation, at first user need to create a class . before the class name user need to use
		"@interface" . this class is Annotation class. 
		
					Ex- 	;   public @interface Age {  // this class is called  "Age Validation Annotation class"
		
							    }
	
	==> at the top of the class user need to add following annotation ::
	
				@Documented
				@Retention(RetentionPolicy.RUNTIME)
				@Target(ElementType.FIELD)
				@Constraint(validatedBy = AgeValidator.class)
				
				
	==> inside the class user need to add following variable with default value  :::
		NOTE :: message(), groups(), payload() are look like a method . but these are not method . all are variables.
	
				String message() default "{invalidMessage}"; // load message from property file by using "invalidMessage" key. 
	
				Class<?>[] groups() default { };

				Class<? extends Payload>[] payload() default { };
				
		
		
	==> after that user need to add required variable with default value  according to your validation requirement
	
	 	Ex-- 				int lower() default 18;
							int upper() default 60;
							
	===> for own validation logic implementation  user need to create another class . and that will be included with Annotation class by 
	 		adding  " @Constraint(validatedBy = here will be  XXXX.class)"
	 		
	 		Ex---   @Constraint(validatedBy = AgeValidator.class)
					public @interface Age {
					
					}
					
					
	===> finally "Valivation Annotation class" is used at top of property in POJO or DTO class.
			Ex==> 
					public class UserRegistrationDTO {
							
							@NotEmpty(message=" * can not be null or Empty")
							private String name;
							
							@Age(lower=30, upper=75)
							private Integer age;
					
					}
	
	******************************************************************************************************

*/
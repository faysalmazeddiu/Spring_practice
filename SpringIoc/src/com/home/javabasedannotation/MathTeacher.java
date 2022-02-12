package com.home.javabasedannotation;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // if a class have multiple object, @Primary  are used to make  any one object as by default injecting value among those objects 
public class MathTeacher implements Teacher{

	@Override
	public void techerInfo() {
		
		System.out.println("This is math teacher");
		
	}

}

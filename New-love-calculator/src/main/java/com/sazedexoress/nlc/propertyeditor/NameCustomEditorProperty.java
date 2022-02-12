package com.sazedexoress.nlc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NameCustomEditorProperty extends PropertyEditorSupport{
	/*
	 ==>  to create own own custom property editor , you need to take a class file under a package . then created class will
	      extend "PropertyEditorSupport" class. then override "setAsText()" function to receive your text and manupulate or
	      implement user own logic. finally for returning manupulated text or result , user need to call "setValue()" function
	      pass result by this setValue() method. 
	      
	      at last , own custom property editor class will be invoked from controlller initbinder method.
	 */
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String myString =text.toUpperCase();
		setValue(myString);
		
	}
}

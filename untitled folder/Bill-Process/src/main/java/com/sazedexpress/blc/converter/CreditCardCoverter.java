package com.sazedexpress.blc.converter;

import org.springframework.core.convert.converter.Converter;

import com.sazedexpress.blc.api.CreditCard;

public class CreditCardCoverter implements Converter<String, CreditCard>{
	
	/*
	  		==> converter need to be register by overriden addFormatter() method in application configuration file(here configueration file is BillProcessAppConfig), 
	  			where custom formatter are registered.
	  		===> As like as formatter, Converter doesn't have Parse() and Print() method for string to object and object to string conversion.
	  		===> to convert from " String to Object" and "object to string" user need to Create separate Converter Class. 
	  		
	 */

	@Override
	public CreditCard convert(String source) {
		String[] creArr=source.split("-");
		
		CreditCard creditNumberCard=new CreditCard();
		creditNumberCard.setFirstFourDegit(Integer.valueOf(creArr[0]));
		creditNumberCard.setSecondFourDegit(Integer.valueOf(creArr[1]));
		creditNumberCard.setThirdFourDegit(Integer.valueOf(creArr[2]));
		creditNumberCard.setLastFourDegit(Integer.valueOf(creArr[3]));
		
		return creditNumberCard;
	}

	

}

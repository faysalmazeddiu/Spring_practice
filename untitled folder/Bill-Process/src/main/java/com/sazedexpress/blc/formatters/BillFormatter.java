package com.sazedexpress.blc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sazedexpress.blc.api.CreditCard;



public class BillFormatter implements Formatter<CreditCard>{

	@Override
	public String print(CreditCard creditCard, Locale locale) {
		System.out.println("This is print method from credit card formatter");
		return creditCard.getFirstFourDegit().toString()+"-"+creditCard.getSecondFourDegit().toString()+"-"+creditCard.getThirdFourDegit().toString()+"-"+creditCard.getLastFourDegit().toString();
	}

	@Override
	public CreditCard parse(String creditCard, Locale locale) throws ParseException {
		System.out.println("This is parse method from credit card formatter");
		
		// split  
		String[] creArr=creditCard.split("-");
		
		CreditCard creditNumberCard=new CreditCard();
		creditNumberCard.setFirstFourDegit(Integer.valueOf(creArr[0]));
		creditNumberCard.setSecondFourDegit(Integer.valueOf(creArr[1]));
		creditNumberCard.setThirdFourDegit(Integer.valueOf(creArr[2]));
		creditNumberCard.setLastFourDegit(Integer.valueOf(creArr[3]));
		
		return creditNumberCard;
	}

}

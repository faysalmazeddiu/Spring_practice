package com.sazedexoress.nlc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sazedexoress.nlc.api.Amount;

public class AmountFormatter implements Formatter<Amount>{

	@Override
	public String print(Amount amount, Locale locale) {
		
		return amount.getAmountOfBill()+amount.getLocalDefination();
		
	}

	@Override
	public Amount parse(String paymentamount, Locale locale) throws ParseException {
		Amount amount=new Amount();
		// here will be logic 
		amount.setLocalDefination("USD");
		amount.setAmountOfBill(200000.0);
		
		return amount;
	}

}

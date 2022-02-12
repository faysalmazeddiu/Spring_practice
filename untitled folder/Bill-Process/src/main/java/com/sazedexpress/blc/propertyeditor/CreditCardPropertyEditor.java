package com.sazedexpress.blc.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.sazedexpress.blc.api.CreditCard;

public class CreditCardPropertyEditor extends PropertyEditorSupport{
	
	
	// getAsText() method work as same to formatter print method
	@Override
	public String getAsText() { // to covert object to string
		CreditCard creditCard=(CreditCard)getValue();
		return creditCard.toString();
	}
	
	
	
	
	
	// setAsText method works same as to formatter parse method
	@Override
	public void setAsText(String creditCard) throws IllegalArgumentException { // to covert string to object
        String[] creArr=creditCard.split("-");
		
		CreditCard creditNumberCard=new CreditCard();
		creditNumberCard.setFirstFourDegit(Integer.valueOf(creArr[0]));
		creditNumberCard.setSecondFourDegit(Integer.valueOf(creArr[1]));
		creditNumberCard.setThirdFourDegit(Integer.valueOf(creArr[2]));
		creditNumberCard.setLastFourDegit(Integer.valueOf(creArr[3]));
		
		setValue(creditNumberCard);
	}
}

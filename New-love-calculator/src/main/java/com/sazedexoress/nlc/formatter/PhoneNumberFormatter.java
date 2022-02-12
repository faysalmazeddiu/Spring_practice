package com.sazedexoress.nlc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sazedexoress.nlc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone phone, Locale locale) {
		System.out.println("Phone formatter print() method");
		return phone.getCountryCode()+"-"+phone.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		// check wheteher phone number is consist with "-" or not. if not then add default country  code with "-".
		System.out.println("Phone formatter parse() method");
		int index=completePhoneNumber.indexOf("-");
		String[] phoneNumberArray=completePhoneNumber.split("-");
		Phone phone=new Phone();
		if (index== -1 || completePhoneNumber.startsWith("-")) {
			phone.setCountryCode("91");
			if (completePhoneNumber.startsWith("-")) {
				phone.setUserNumber(phoneNumberArray[1]);
			}else {
				phone.setUserNumber(completePhoneNumber);
			}
			
		}else {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
			
		}
		
		
		/*

			if (index== -1) {
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[0]);
		}else if(phoneNumberArray[0].equals("")){
			phoneNumberArray[0]="91";
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}else {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}


		 	// one solution
			if (index== -1) {
				completePhoneNumber="91-"+completePhoneNumber;
			}
		 */
		return phone;
	}

	

}

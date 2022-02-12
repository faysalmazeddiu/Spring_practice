package com.sazedexoress.nlc.formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sazedexoress.nlc.api.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard>{

	@Override
	public String print(CreditCard creditCardNumber, Locale locale) {
		
		return creditCardNumber.getFirstFourDegit()+creditCardNumber.getSecondFourDegit()+creditCardNumber.getThirdFourDegit()+creditCardNumber.getLastFourDegit();
	}

	@Override
	public CreditCard parse(String creditNumber, Locale locale) throws ParseException {
		CreditCard creditNumberCard=new CreditCard();
		int index=creditNumber.indexOf("-");
		if (index != -1) {
			String[] creArr=creditNumber.split("-");
			if (creArr.length==4) {
				creditNumberCard.setFirstFourDegit(creArr[0]);
				creditNumberCard.setSecondFourDegit(creArr[1]);
				creditNumberCard.setThirdFourDegit(creArr[2]);
				creditNumberCard.setLastFourDegit(creArr[3]);
			}
			
		}else {
			if (creditNumber.length()==16) {
				char[] c=creditNumber.toCharArray();
				//System.out.println(Arrays.toString(c));
				int j=1;
				String str="";
				for (char d : c) {
					
					str+=d;
					if (j==4) {
						creditNumberCard.setFirstFourDegit(str);
						str="";
					}else if(j==8){
						creditNumberCard.setSecondFourDegit(str);
						str="";
					}else if(j==12) {
						creditNumberCard.setThirdFourDegit(str);
						str="";
					}else if(j==16) {
						creditNumberCard.setLastFourDegit(str);
						str="";
					}
					++j;
				}
				//System.out.println(creditNumberCard.toString());
			}
		}
		System.out.println(creditNumberCard.toString());
		return creditNumberCard;
	}

}

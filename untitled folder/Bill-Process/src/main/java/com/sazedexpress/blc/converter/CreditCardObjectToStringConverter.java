package com.sazedexpress.blc.converter;

import org.springframework.core.convert.converter.Converter;

import com.sazedexpress.blc.api.CreditCard;

public class CreditCardObjectToStringConverter implements Converter<CreditCard, String>{

	@Override
	public String convert(CreditCard source) {
		
		return source.toString();
	}

}

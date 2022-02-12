package com.sazedexpress.blc.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.validation.Valid;
import javax.xml.crypto.Data;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sazedexpress.blc.api.CreditCard;
import com.sazedexpress.blc.api.BillDTO;
import com.sazedexpress.blc.formatters.BillFormatter;
import com.sazedexpress.blc.propertyeditor.CreditCardPropertyEditor;
import com.sazedexpress.blc.propertyeditor.CurrencyPropertyEditor;

@Controller
public class BillController {
	
	@RequestMapping("/showBillPage")
	public String showBillPage(@ModelAttribute("billInfo") BillDTO dto) {
		
		CreditCard creditCard=new CreditCard();
		creditCard.setFirstFourDegit(1234);
		creditCard.setSecondFourDegit(4567);
		creditCard.setThirdFourDegit(8901);
		creditCard.setLastFourDegit(4512);
		dto.setCreditCard(creditCard);
		
		return "bill-payment-page";
		
	}
	
	@RequestMapping("/process-payment")
	public String processBill(@Valid @ModelAttribute("billInfo") BillDTO dto,BindingResult result) {
		if (result.hasErrors()) {
			return "bill-payment-page";
		}
		return "payment-success-page";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("this is from init binder");
		
		// Here is the spring custome property editor practice::::::
		
		// for date customization
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor=new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Data.class, "date", customDateEditor);
		
		// for amount customization , Register a custom editor for amount field
		NumberFormat numberFormat=new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor= new CustomNumberEditor(BigDecimal.class,numberFormat, true);
		binder.registerCustomEditor(BigDecimal.class,"amount",customNumberEditor);
		
		
		// for currecy field customization, register a custom editor for currecy field
		CurrencyPropertyEditor currencyPropertyEditor=new CurrencyPropertyEditor();
		binder.registerCustomEditor(Currency.class, "currency",currencyPropertyEditor);
		
		
		/*
		// register custom editor for creditcard field
		 
			CreditCardPropertyEditor creditCardPropertyEditor=new CreditCardPropertyEditor();
			binder.registerCustomEditor(CreditCard.class,"creditCard", creditCardPropertyEditor);
		*/
		
		
		/*
			// to register a formatter  by init binder method
			 
			binder.addCustomFormatter(new BillFormatter());
		*/
	}
}

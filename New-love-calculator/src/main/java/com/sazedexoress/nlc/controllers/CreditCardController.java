package com.sazedexoress.nlc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sazedexoress.nlc.api.Amount;
import com.sazedexoress.nlc.api.BillDTO;
import com.sazedexoress.nlc.api.CreditCard;

@Controller
public class CreditCardController {
	@RequestMapping("/showPaymentPage")
	public String showPaymentPage(@ModelAttribute("billInfo") BillDTO dto) {
		CreditCard creditCard=new CreditCard();
		creditCard.setFirstFourDegit("1234");
		creditCard.setSecondFourDegit("4567");
		creditCard.setThirdFourDegit("8901");
		creditCard.setLastFourDegit("4512");
		Amount amount=new Amount();
		amount.setLocalDefination("USD");
		amount.setAmountOfBill(200000.0);
		dto.setAmount(amount);
		dto.setCreditCard(creditCard);
		return "credit-card-page";
	}
	
	@RequestMapping("/process-creditcard")
	public String processCreditcardPayment(@ModelAttribute("billInfo") BillDTO dto) {
		/*
		    Manual procees 
		 */
		
		
		return "payment-successfull";
	}
}

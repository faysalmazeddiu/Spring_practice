package com.sazedexoress.nlc.api;

import java.math.BigDecimal;

public class Amount {
	private double amountOfBill;
	private String localDefination;
	
	public double getAmountOfBill() {
		return amountOfBill;
	}
	public void setAmountOfBill(double amountOfBill) {
		this.amountOfBill = amountOfBill;
	}
	public String getLocalDefination() {
		return localDefination;
	}
	public void setLocalDefination(String localDefination) {
		this.localDefination = localDefination;
	}
	
	@Override
	public String toString() {
		return "Amount [amountOfBill=" + amountOfBill + ", localDefination=" + localDefination + "]";
	}
	
	
	
}

package com.sazedexoress.nlc.api;

public class CreditCard {
	
	private String firstFourDegit;
	private String secondFourDegit;
	private String thirdFourDegit;
	private String lastFourDegit;
	public String getFirstFourDegit() {
		return firstFourDegit;
	}
	public void setFirstFourDegit(String firstFourDegit) {
		this.firstFourDegit = firstFourDegit;
	}
	public String getSecondFourDegit() {
		return secondFourDegit;
	}
	public void setSecondFourDegit(String secondFourDegit) {
		this.secondFourDegit = secondFourDegit;
	}
	public String getThirdFourDegit() {
		return thirdFourDegit;
	}
	public void setThirdFourDegit(String thirdFourDegit) {
		this.thirdFourDegit = thirdFourDegit;
	}
	public String getLastFourDegit() {
		return lastFourDegit;
	}
	public void setLastFourDegit(String lastFourDegit) {
		this.lastFourDegit = lastFourDegit;
	}
	@Override
	public String toString() {
		return "CreditCard [firstFourDegit=" + firstFourDegit + ", secondFourDegit=" + secondFourDegit
				+ ", thirdFourDegit=" + thirdFourDegit + ", lastFourDegit=" + lastFourDegit + "]";
	}
	
	
	

}

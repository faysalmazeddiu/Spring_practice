package com.sazedexpress.blc.api;

public class CreditCard {
	
	private Integer firstFourDegit;
	private Integer secondFourDegit;
	private Integer thirdFourDegit;
	private Integer lastFourDegit;
	
	public Integer getFirstFourDegit() {
		return firstFourDegit;
	}
	public void setFirstFourDegit(Integer firstFourDegit) {
		this.firstFourDegit = firstFourDegit;
	}
	public Integer getSecondFourDegit() {
		return secondFourDegit;
	}
	public void setSecondFourDegit(Integer secondFourDegit) {
		this.secondFourDegit = secondFourDegit;
	}
	public Integer getThirdFourDegit() {
		return thirdFourDegit;
	}
	public void setThirdFourDegit(Integer thirdFourDegit) {
		this.thirdFourDegit = thirdFourDegit;
	}
	public Integer getLastFourDegit() {
		return lastFourDegit;
	}
	public void setLastFourDegit(Integer lastFourDegit) {
		this.lastFourDegit = lastFourDegit;
	}
	
	@Override
	public String toString() {
		return firstFourDegit + "-" + secondFourDegit
				+ "-" + thirdFourDegit + "-" + lastFourDegit;
	}
	
	
	
	
	

}

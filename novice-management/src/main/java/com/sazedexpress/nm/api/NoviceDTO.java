package com.sazedexpress.nm.api;

public class NoviceDTO {
	private int noviceId;
	private String studentNameString;
	private long studentMobile;
	private String countryString;
	
	public String getStudentNameString() {
		return studentNameString;
	}
	public void setStudentNameString(String studentNameString) {
		this.studentNameString = studentNameString;
	}
	public long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public String getCountryString() {
		return countryString;
	}
	public void setCountryString(String countryString) {
		this.countryString = countryString;
	}
	
	
	public int getNoviceId() {
		return noviceId;
	}
	public void setNoviceId(int noviceId) {
		this.noviceId = noviceId;
	}
	@Override
	public String toString() {
		return "NoviceDTO [noviceId=" + noviceId + ", studentNameString=" + studentNameString + ", studentMobile="
				+ studentMobile + ", countryString=" + countryString + "]";
	}
	
	
	
	
	

}

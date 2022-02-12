package com.sazedexoress.nlc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	@NotBlank(message = " * User name can not be blank")
	//@Min(value = 3, message = " * user name should be at least 3 charecter")
	@Size(min = 3, max = 15, message = " * Your name should have minimum 3 - 15 char")
	private String userName;
	
	@NotBlank(message = " * Crash name can not be blank")
	//@Min(value = 3, message = " * user name should be at least 3 charecter")
	@Size(min = 3, max = 15, message = " * Crash name should have minimum 3 - 15 char")
	private String crashName;
	
	@AssertTrue(message = " * You have to agree for using our App")
	private boolean termAndCondition;
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrashName() {
		return crashName;
	}
	public void setCrashName(String crashName) {
		this.crashName = crashName;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crashName=" + crashName + "]";
	}
	

}

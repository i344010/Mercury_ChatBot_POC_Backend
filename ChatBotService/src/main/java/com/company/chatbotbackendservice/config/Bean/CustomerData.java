package com.company.chatbotbackendservice.config.Bean;

public class CustomerData {

	private String userName;
	
	private String phoneNo;
	
	private String timeToCall;
	
	private String emailId;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getTimeToCall() {
		return timeToCall;
	}

	public void setTimeToCall(String timeToCall) {
		this.timeToCall = timeToCall;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}

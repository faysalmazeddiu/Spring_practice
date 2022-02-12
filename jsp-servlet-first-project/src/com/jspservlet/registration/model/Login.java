package com.jspservlet.registration.model;

public class Login {
	private int login_id;
	private int user_id;
	private String username;
	private String password;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", user_id=" + user_id + ", username=" + username + ", password="
				+ password + "]";
	}
	
	

}

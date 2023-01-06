package com.knimbus.model;

public class User1 {
	
	private Long userId;
	private String userName;
	private String email;
	private String password;
	private String vote;
	
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User1 [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", vote=" + vote + "]";
	}
	
}

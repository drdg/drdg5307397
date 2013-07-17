package com.sino.elearning.msg.bean;

public class EFlowUser {
	private Long userId;//用户Id
	private String userName;//用户的登陆名
	private String userNM;//用户姓名
	public EFlowUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EFlowUser(Long userId, String userName, String userNM) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNM = userNM;
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
	public String getUserNM() {
		return userNM;
	}
	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}
	
}

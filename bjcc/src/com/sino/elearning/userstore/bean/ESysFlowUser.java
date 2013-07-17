package com.sino.elearning.userstore.bean;

import java.util.HashSet;
import java.util.Set;

public class ESysFlowUser {

	private Long userId;
	private String userCode;
	private String userName;
	private String userPassword;
	private String userNm;
	private String userNameFull;
	private String userOnline;
	private String note;
	private String status;
	private String auther;
	private String time;
	private String userStatus;
	private String userSex;
	private String userTitle;
	private String userState;
	private String userJid;
	private String phone;
	private String userEmail;
	private String userEmailPsw;
	private String userMode;
	
	private Set abs = new HashSet(0);
	
	
	public Set getAbs() {
		return abs;
	}

	public void setAbs(Set abs) {
		this.abs = abs;
	}

	public ESysFlowUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ESysFlowUser(Long userId, String userCode, String userName,
			String userPassword, String userNm, String userNameFull,
			String userOnline, String note, String status, String auther,
			String time, String userStatus, String userSex, String userTitle,
			String userJid, String phone, String userEmail,
			String userEmailPsw, String userMode) {
		super();
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNm = userNm;
		this.userNameFull = userNameFull;
		this.userOnline = userOnline;
		this.note = note;
		this.status = status;
		this.auther = auther;
		this.time = time;
		this.userStatus = userStatus;
		this.userSex = userSex;
		this.userTitle = userTitle;
		this.userJid = userJid;
		this.phone = phone;
		this.userEmail = userEmail;
		this.userEmailPsw = userEmailPsw;
		this.userMode = userMode;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserNameFull() {
		return userNameFull;
	}
	public void setUserNameFull(String userNameFull) {
		this.userNameFull = userNameFull;
	}
	public String getUserOnline() {
		return userOnline;
	}
	public void setUserOnline(String userOnline) {
		this.userOnline = userOnline;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public String getUserJid() {
		return userJid;
	}
	public void setUserJid(String userJid) {
		this.userJid = userJid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmailPsw() {
		return userEmailPsw;
	}
	public void setUserEmailPsw(String userEmailPsw) {
		this.userEmailPsw = userEmailPsw;
	}
	public String getUserMode() {
		return userMode;
	}
	public void setUserMode(String userMode) {
		this.userMode = userMode;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}
	
}

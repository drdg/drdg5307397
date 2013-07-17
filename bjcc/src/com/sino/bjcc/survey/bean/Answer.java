package com.sino.bjcc.survey.bean;

public class Answer {
	
	public static final int CHECKBOX_QUESTION = 1;  //多项选择题
	
	private long ID;
	private long questionID;
	private long userID;
	private String answer;
	private String other;
	private int checkboxFlag = 0;

	public long getID() {
		return this.ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getQuestionID() {
		return this.questionID;
	}

	public long getUserID() {
		return this.userID;
	}

	public String getAnswer() {
		return this.answer;
	}

	public String getOther() {
		return this.other;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getCheckboxFlag() {
		return checkboxFlag;
	}

	public void setCheckboxFlag(int checkboxFlag) {
		this.checkboxFlag = checkboxFlag;
	}

}

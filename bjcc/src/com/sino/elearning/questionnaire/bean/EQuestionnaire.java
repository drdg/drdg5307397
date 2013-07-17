package com.sino.elearning.questionnaire.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EQuestionnaire entity. @author MyEclipse Persistence Tools
 */

public class EQuestionnaire implements java.io.Serializable {

	// Fields

	private Long questionnaireId;
	private String questionnaireName;
	private Long userid;
	private String userNm;
	private Long deptid;
	private String deptname;
	private String createTime;
	private String status;
	private String expirationTime;
	
	private String testStatus;
	private List<EQuesnaireQuestion> quesnaireQuestions;
	
	//用户问卷ID
	private Long naireUserId;
	//用户问卷状态
	private String naireUserStatus;
	// Constructors
	
	/** default constructor */
	public EQuestionnaire() {
	}
	
	public Long getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnaireName() {
		return this.questionnaireName;
	}

	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public Long getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExpirationTime() {
		return this.expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Long getNaireUserId() {
		return naireUserId;
	}

	public void setNaireUserId(Long naireUserId) {
		this.naireUserId = naireUserId;
	}

	public String getNaireUserStatus() {
		return naireUserStatus;
	}

	public void setNaireUserStatus(String naireUserStatus) {
		this.naireUserStatus = naireUserStatus;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public List<EQuesnaireQuestion> getQuesnaireQuestions() {
		if(null == quesnaireQuestions) {
			quesnaireQuestions = new ArrayList<EQuesnaireQuestion>();
		}
		return quesnaireQuestions;
	}

	public void setQuesnaireQuestions(List<EQuesnaireQuestion> quesnaireQuestions) {
		this.quesnaireQuestions = quesnaireQuestions;
	}
	
	public void addEQuesnaireQuestion(EQuesnaireQuestion quesnaireQuestion) {
		this.getQuesnaireQuestions().add(quesnaireQuestion);
	}
}
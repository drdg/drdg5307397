package com.sino.elearning.studyrecord.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractEEvaluationRecord entity provides the base persistence definition of
 * the EEvaluationRecord entity. @author MyEclipse Persistence Tools
 */

public class EEvaluationRecord implements java.io.Serializable {

	// Fields

	private Long recordId;                    //保存填写试卷记录ID
	private Long testId;					  //试卷
	private String achievement;				  //用户总得分
	private String recordState;				  //填写状态 0:保存（未提交）1:提交
	private Long userId;					  //填写试卷用户ID
	private String userNm;					  //填写试卷用户姓名
	private Long deptId;					  //填写试卷用户所在部门ID
	private String deptName;				  //填写试卷用户所在部门	
	private String time;					  //创建时间
	private List<EEvaluationAnswer> answers;
	private EEvaluationTest test;

	// Constructors

	/** default constructor */
	public EEvaluationRecord() {
	}

	/** minimal constructor */
	public EEvaluationRecord(Long recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public EEvaluationRecord(Long recordId, Long testId,
			String achievement,String recordState, Long userId, 
			String userNm,Long deptId, String deptName, String time,
			List<EEvaluationAnswer> answers,EEvaluationTest test) {
		this.recordId = recordId;
		this.testId = testId;
		this.achievement = achievement;
		this.recordState = recordState;
		this.userId = userId;
		this.userNm = userNm;
		this.deptId = deptId;
		this.deptName = deptName;
		this.time = time;
		this.answers = answers;
		this.test = test;
	}

	// Property accessors

	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getTestId() {
		return this.testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	
	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<EEvaluationAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<EEvaluationAnswer> answers) {
		this.answers = answers;
	}
	
	public void addTestQuestion(EEvaluationAnswer answer){
		if(this.answers == null) {
			this.answers = new ArrayList<EEvaluationAnswer>();
		}
		this.answers.add(answer);
	}
	public EEvaluationTest getTest() {
		return test;
	}

	public void setTest(EEvaluationTest test) {
		this.test = test;
	} 

}
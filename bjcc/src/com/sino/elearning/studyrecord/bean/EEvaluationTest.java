package com.sino.elearning.studyrecord.bean;

import java.util.List;
import java.util.Set;

/**
 * AbstractEEvaluationTest entity provides the base persistence definition of
 * the EEvaluationTest entity. @author MyEclipse Persistence Tools
 */

public class EEvaluationTest implements java.io.Serializable {

	// Fields

	private Long testId;						//试卷ID
	private Long programId;						//节目ID
	private String explain;						//评测说明
	private String state;						//是否已建立了评测试卷 0：无评测试卷 1：有评测试卷
	private Long userId;						//创建人ID
	private String userNm;						//创建人
	private Long deptId;						//创建人部门ID
	private String deptName;					//创建人部门
	private String creatTime;					//创建时间
	private String programName;					//课程资源名称
	private String programType;					//课程资源类别
	private String testState;					//评测问卷状态 0：未启用 1：已启用 2：停用
	private List<EEvaluationTestQuestion> testQuestions;

	// Constructors

	/** default constructor */
	public EEvaluationTest() {
	}

	/** minimal constructor */
	public EEvaluationTest(Long testId, String state,
			String testState) {
		this.testId = testId;
		this.state = state;
		this.testState = testState;
	}

	/** full constructor */
	public EEvaluationTest(Long testId, Long programId,
			String explain, String state, Long userId, String userNm,
			Long deptId, String deptName, String creatTime,
			String programName, String programType, String testState,
			List<EEvaluationTestQuestion> testQuestions) {
		this.testId = testId;
		this.programId = programId;
		this.explain = explain;
		this.state = state;
		this.userId = userId;
		this.userNm = userNm;
		this.deptId = deptId;
		this.deptName = deptName;
		this.creatTime = creatTime;
		this.programName = programName;
		this.programType = programType;
		this.testState = testState;
		this.testQuestions = testQuestions;
	}

	// Property accessors

	public Long getTestId() {
		return this.testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramType() {
		return this.programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getTestState() {
		return this.testState;
	}

	public void setTestState(String testState) {
		this.testState = testState;
	}

	public List<EEvaluationTestQuestion> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(List<EEvaluationTestQuestion> testQuestions) {
		this.testQuestions = testQuestions;
	}

}
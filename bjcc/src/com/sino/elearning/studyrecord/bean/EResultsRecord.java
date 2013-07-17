package com.sino.elearning.studyrecord.bean;

import java.math.BigDecimal;

/**
 * AbstractEResultsRecord entity provides the base persistence definition of the
 * EResultsRecord entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class EResultsRecord implements java.io.Serializable {

	// Fields

	private Long resultsId; 		//成效ID
	private Long programId; 		//视频资源ID
	private String programName;     //资源名称
	private String studyType; 		//学习类型	1:个人学习	2:集体学习
	private String resultsContent; 	//成效内容
	private String state; 		    //状态	0：未审核	1：已审核
	private Long creatUserId; 		//用户ID
	private String userNm; 		    //用户
	private Long deptId; 		    //用户部门ID
	private String deptName; 		//用户部门
	private String creatTime; 		//创建时间
	// Constructors

	/** default constructor */
	public EResultsRecord() {
	}

	/** minimal constructor */
	public EResultsRecord(Long resultsId) {
		this.resultsId = resultsId;
	}

	/** full constructor */
	public EResultsRecord(Long resultsId,Long programId,String programName,
			String studyType, String resultsContent,
			String state, Long creatUserId, String userNm,
			Long deptId, String deptName, String creatTime) {
		this.resultsId = resultsId;
		this.programId = programId;
		this.programName = programName;
		this.studyType = studyType;
		this.resultsContent = resultsContent;
		this.state = state;
		this.creatUserId = creatUserId;
		this.userNm = userNm;
		this.deptId = deptId;
		this.deptName = deptName;
		this.creatTime = creatTime;
	}

	// Property accessors

	public Long getResultsId() {
		return this.resultsId;
	}

	public void setResultsId(Long resultsId) {
		this.resultsId = resultsId;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getStudyType() {
		return this.studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public String getResultsContent() {
		return this.resultsContent;
	}

	public void setResultsContent(String resultsContent) {
		this.resultsContent = resultsContent;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCreatUserId() {
		return this.creatUserId;
	}

	public void setCreatUserId(Long creatUserId) {
		this.creatUserId = creatUserId;
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
}
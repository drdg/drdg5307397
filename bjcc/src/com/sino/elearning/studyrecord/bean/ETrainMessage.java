package com.sino.elearning.studyrecord.bean;

import java.io.Serializable;

/**
 * AbstractETrainMessage entity provides the base persistence definition of the
 * ETrainMessage entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public  class ETrainMessage implements Serializable {

	// Fields

	private Long trainId;                       //培训信息ID
	private String trainTheme;					//培训主题
	private String trainContent;				//培训内容
	private String trainTime;					//培训时间
	private String remarks;						//备注
	private Long userId;					    //创建人ID
	private String usernm;						//创建人
	private Long deptId;					    //创建人部门ID
	private String deptname;					//创建人部门
	private String creatTime;					//创建时间
	private String mark;						//状态  0：已启用   1：已启用   2：已作废
	private String resultState;					//是否填写成效 0:没有填写  1:已经填写
	// Constructors

	/** default constructor */
	public ETrainMessage() {
	}

	/** minimal constructor */
	public ETrainMessage(Long trainId, String trainTheme,
			String trainContent, String trainTime, String mark) {
		this.trainId = trainId;
		this.trainTheme = trainTheme;
		this.trainContent = trainContent;
		this.trainTime = trainTime;
		this.mark = mark;
	}

	/** full constructor */
	public ETrainMessage(Long trainId, String trainTheme,
			String trainContent, String trainTime, String remarks,
			Long userId, String usernm, Long deptId,
			String deptname,String creatTime ,String mark) {
		this.trainId = trainId;
		this.trainTheme = trainTheme;
		this.trainContent = trainContent;
		this.trainTime = trainTime;
		this.remarks = remarks;
		this.userId = userId;
		this.usernm = usernm;
		this.deptId = deptId;
		this.deptname = deptname;
		this.creatTime = creatTime;
		this.mark = mark;
	}
	// Property accessors
	
	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public String getTrainTheme() {
		return trainTheme;
	}

	public void setTrainTheme(String trainTheme) {
		this.trainTheme = trainTheme;
	}

	public String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public String getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(String trainTime) {
		this.trainTime = trainTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getResultState() {
		return resultState;
	}

	public void setResultState(String resultState) {
		this.resultState = resultState;
	}
}
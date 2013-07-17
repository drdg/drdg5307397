package com.sino.elearning.learningneed.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * AbstractEResourceAdvice entity provides the base persistence definition of
 * the EResourceAdvice entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public  class EResourceAdvice implements Serializable {

	// Fields

	private BigDecimal resourceId;//建议ID
	private String resourceClassified;//资源分类
	private String adviceContent;//建议内容
	private String states;//资源建议状态 0:未审批  1:已审批
	private BigDecimal userId;//提出人用户ID
	private String userNm;//提出人用户名
	private BigDecimal deptId;//提出人所在部门ID
	private String deptNm;//提出人所在部门名
	private String creatTime;//提出时间
	private BigDecimal manageUserId;//审批人ID
	private String manageUserNm;//审批人名
	private BigDecimal manageDeptId;//审批人所在部门ID
	private String manageDeptName;//审批人所在部门
	private String audiyTime;//审批时间
	private String title;//标题
	// Constructors

	/** default constructor */
	public EResourceAdvice() {
	}

	/** minimal constructor */
	public EResourceAdvice(BigDecimal resourceId,
			String resourceClassified, String adviceContent, String states) {
		this.resourceId = resourceId;
		this.resourceClassified = resourceClassified;
		this.adviceContent = adviceContent;
		this.states = states;
	}

	/** full constructor */
	public  EResourceAdvice(BigDecimal resourceId,
			String resourceClassified, String adviceContent, String states,
			BigDecimal userId, String userNm, BigDecimal deptId, String deptNm,
			String creatTime, BigDecimal manageUserId, String manageUserNm,
			BigDecimal manageDeptId, String manageDeptName, String audiyTime,
			String title) {
		this.resourceId = resourceId;
		this.resourceClassified = resourceClassified;
		this.adviceContent = adviceContent;
		this.states = states;
		this.userId = userId;
		this.userNm = userNm;
		this.deptId = deptId;
		this.deptNm = deptNm;
		this.creatTime = creatTime;
		this.manageUserId = manageUserId;
		this.manageUserNm = manageUserNm;
		this.manageDeptId = manageDeptId;
		this.manageDeptName = manageDeptName;
		this.audiyTime = audiyTime;
		this.title = title;
	}

	// Property accessors

	public BigDecimal getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(BigDecimal resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceClassified() {
		return this.resourceClassified;
	}

	public void setResourceClassified(String resourceClassified) {
		this.resourceClassified = resourceClassified;
	}

	public String getAdviceContent() {
		return this.adviceContent;
	}

	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}

	public String getStates() {
		return this.states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public BigDecimal getDeptId() {
		return this.deptId;
	}

	public void setDeptId(BigDecimal deptId) {
		this.deptId = deptId;
	}

	public String getDeptNm() {
		return this.deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public BigDecimal getManageUserId() {
		return this.manageUserId;
	}

	public void setManageUserId(BigDecimal manageUserId) {
		this.manageUserId = manageUserId;
	}

	public String getManageUserNm() {
		return this.manageUserNm;
	}

	public void setManageUserNm(String manageUserNm) {
		this.manageUserNm = manageUserNm;
	}

	public BigDecimal getManageDeptId() {
		return this.manageDeptId;
	}

	public void setManageDeptId(BigDecimal manageDeptId) {
		this.manageDeptId = manageDeptId;
	}

	public String getManageDeptName() {
		return this.manageDeptName;
	}

	public void setManageDeptName(String manageDeptName) {
		this.manageDeptName = manageDeptName;
	}

	public String getAudiyTime() {
		return this.audiyTime;
	}

	public void setAudiyTime(String audiyTime) {
		this.audiyTime = audiyTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
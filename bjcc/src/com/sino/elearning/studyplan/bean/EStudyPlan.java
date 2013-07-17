package com.sino.elearning.studyplan.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EStudyPlan entity. @author MyEclipse Persistence Tools
 */

public class EStudyPlan implements java.io.Serializable {

	// Fields

	private Long studyPlanId;
	private String studyTime;
	private Long userId;
	private String userNm;
	private Long deptId;
	private String deptName;
	private String creatTime;
	private Long cnt;
	private Set studyPrograms = new HashSet(0);
	
	public Set tempSet = new HashSet(0);
	// Constructors

	/** default constructor */
	public EStudyPlan() {
	}

	/** minimal constructor */
	public EStudyPlan(Long studyPlanId) {
		this.studyPlanId = studyPlanId;
	}

	/** full constructor */
	public EStudyPlan(Long studyPlanId, String studyTime,
			Long userId, String userNm, Long deptId,
			String deptName, String creatTime, Long cnt,
			Set studyPrograms) {
		this.studyPlanId = studyPlanId;
		this.studyTime = studyTime;
		this.userId = userId;
		this.userNm = userNm;
		this.deptId = deptId;
		this.deptName = deptName;
		this.creatTime = creatTime;
		this.cnt = cnt;
		this.studyPrograms = studyPrograms;
	}

	// Property accessors

	public Long getStudyPlanId() {
		return this.studyPlanId;
	}

	public void setStudyPlanId(Long studyPlanId) {
		this.studyPlanId = studyPlanId;
	}

	public String getStudyTime() {
		return this.studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
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

	public Long getCnt() {
		return this.cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public Set getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(Set studyPrograms) {
		this.studyPrograms = studyPrograms;
	}
}
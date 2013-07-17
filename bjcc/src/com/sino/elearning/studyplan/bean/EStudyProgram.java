package com.sino.elearning.studyplan.bean;

import java.math.BigDecimal;

/**
 * EStudyProgram entity. @author MyEclipse Persistence Tools
 */

public class EStudyProgram implements java.io.Serializable {

	// Fields

	private Long studyProgramId;
	private Long programId;
	private String programName;
	private String programType;
	private String imgUrl;
	
	private String speaker;
	private String path;

	private EStudyPlan EStudyPlan;
	// Constructors

	/** default constructor */
	public EStudyProgram() {
	}

	/** minimal constructor */
	public EStudyProgram(Long studyProgramId) {
		this.studyProgramId = studyProgramId;
	}

	/** full constructor */
	public EStudyProgram(Long studyProgramId, EStudyPlan EStudyPlan,
			Long programId, String programName, String programType, String imgUrl, String speaker, String path) {
		this.studyProgramId = studyProgramId;
		this.EStudyPlan = EStudyPlan;
		this.programId = programId;
		this.programName = programName;
		this.programType = programType;
		this.imgUrl = imgUrl;
		this.speaker = speaker;
		this.path = path;
	}

	// Property accessors

	public Long getStudyProgramId() {
		return this.studyProgramId;
	}

	public void setStudyProgramId(Long studyProgramId) {
		this.studyProgramId = studyProgramId;
	}

	public EStudyPlan getEStudyPlan() {
		return this.EStudyPlan;
	}

	public void setEStudyPlan(EStudyPlan EStudyPlan) {
		this.EStudyPlan = EStudyPlan;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
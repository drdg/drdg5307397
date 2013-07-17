package com.sino.elearning.questionnaire.bean;

import java.math.BigDecimal;

/**
 * EQuestionnaireDept entity. @author MyEclipse Persistence Tools
 */

public class EQuestionnaireDept implements java.io.Serializable {

	// Fields

	private Long id;
	private Long questionnaireId;
	private Long deptId;

	// Constructors

	/** default constructor */
	public EQuestionnaireDept() {
	}

	/** minimal constructor */
	public EQuestionnaireDept(Long id) {
		this.id = id;
	}

	/** full constructor */
	public EQuestionnaireDept(Long id, Long questionnaireId,
			Long deptId) {
		this.id = id;
		this.questionnaireId = questionnaireId;
		this.deptId = deptId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

}
package com.sino.elearning.questionnaire.bean;

import java.math.BigDecimal;

/**
 * EQuesnaireQuesOption entity. @author MyEclipse Persistence Tools
 */

public class EQuesnaireQuesOption implements java.io.Serializable {

	// Fields

	private Long id;
	private EQuesnaireQuestion EQuesnaireQuestion;
	private String content;

	// Constructors

	/** default constructor */
	public EQuesnaireQuesOption() {
	}

	/** minimal constructor */
	public EQuesnaireQuesOption(Long id) {
		this.id = id;
	}

	/** full constructor */
	public EQuesnaireQuesOption(Long id,
			EQuesnaireQuestion EQuesnaireQuestion, String content) {
		this.id = id;
		this.EQuesnaireQuestion = EQuesnaireQuestion;
		this.content = content;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EQuesnaireQuestion getEQuesnaireQuestion() {
		return this.EQuesnaireQuestion;
	}

	public void setEQuesnaireQuestion(EQuesnaireQuestion EQuesnaireQuestion) {
		this.EQuesnaireQuestion = EQuesnaireQuestion;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
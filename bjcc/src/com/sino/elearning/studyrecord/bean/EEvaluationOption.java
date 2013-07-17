package com.sino.elearning.studyrecord.bean;

import java.math.BigDecimal;

/**
 * AbstractEEvaluationOption entity provides the base persistence definition of
 * the EEvaluationOption entity. @author MyEclipse Persistence Tools
 */

public class EEvaluationOption implements java.io.Serializable {

	// Fields

	private Long answerRecOptionId;           //用户选择选项记录ID
	private EEvaluationAnswer answer;		  
	private Long optionId;					  //用户选择问题选项ID
	
	// Constructors

	/** default constructor */
	public EEvaluationOption() {
	}

	/** minimal constructor */
	public EEvaluationOption(Long answerRecOptionId) {
		this.answerRecOptionId = answerRecOptionId;
	}

	/** full constructor */
	public EEvaluationOption(Long answerRecOptionId,
			EEvaluationAnswer answer, Long optionId) {
		this.answerRecOptionId = answerRecOptionId;
		this.answer = answer;
		this.optionId = optionId;
	}

	// Property accessors

	public Long getAnswerRecOptionId() {
		return this.answerRecOptionId;
	}

	public void setAnswerRecOptionId(Long answerRecOptionId) {
		this.answerRecOptionId = answerRecOptionId;
	}

	public EEvaluationAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(EEvaluationAnswer answer) {
		this.answer = answer;
	}

	public Long getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

}
package com.sino.elearning.studyrecord.bean;

import java.math.BigDecimal;

/**
 * AbstractETestQuestionOption entity provides the base persistence definition
 * of the ETestQuestionOption entity. @author MyEclipse Persistence Tools
 */

public class ETestQuestionOption implements
		java.io.Serializable {

	// Fields
	
	private Long optionId;										//选项ID
	private EEvaluationTestQuestion testQuestion;
	private String optionContent;								//选项内容
	private String rightAnswers;							    //是否为正确答案 0：错误答案 1：正确答案
	private String changeState;								    //用户选择状态
	private Long sequence;									   //正确选项 序号
	// Constructors

	/** default constructor */
	public ETestQuestionOption() {
	}

	/** minimal constructor */
	public ETestQuestionOption(Long optionId) {
		this.optionId = optionId;
	}

	/** full constructor */
	public ETestQuestionOption(Long optionId,
			EEvaluationTestQuestion testQuestion, String optionContent,
			String rightAnswers, String changeState, Long sequence) {
		super();
		this.optionId = optionId;
		this.testQuestion = testQuestion;
		this.optionContent = optionContent;
		this.rightAnswers = rightAnswers;
		this.changeState = changeState;
		this.sequence = sequence;
	}
	// Property accessors

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public EEvaluationTestQuestion getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(EEvaluationTestQuestion testQuestion) {
		this.testQuestion = testQuestion;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getRightAnswers() {
		return rightAnswers;
	}

	public void setRightAnswers(String rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public String getChangeState() {
		return changeState;
	}

	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	
}
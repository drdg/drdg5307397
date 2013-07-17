package com.sino.elearning.studyrecord.bean;

import java.util.List;
import java.util.Set;

/**
 * AbstractEEvaluationTestQuestion entity provides the base persistence
 * definition of the EEvaluationTestQuestion entity. @author MyEclipse
 * Persistence Tools
 */

public class EEvaluationTestQuestion implements
		java.io.Serializable {

	// Fields

	private Long questionId;					//试卷问题ID
	private String questionTitle;				//试卷问题题目
	private String questionType;				//试卷问题类型  0：单选题  1：多选题
	
	private EEvaluationTest test;
	
	private List<ETestQuestionOption> options;	

	// Constructors

	/** default constructor */
	public EEvaluationTestQuestion() {
	}

	/** minimal constructor */
	public EEvaluationTestQuestion(Long questionId) {
		this.questionId = questionId;
	}

	/** full constructor */
	public EEvaluationTestQuestion(Long questionId,
			String questionTitle, String questionType, EEvaluationTest test,
			List<ETestQuestionOption> options) {
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionType = questionType;
		this.test = test;
		this.options = options;
	}

	// Property accessors

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return this.questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public EEvaluationTest getTest() {
		return test;
	}

	public void setTest(EEvaluationTest test) {
		this.test = test;
	}

	public List<ETestQuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<ETestQuestionOption> options) {
		this.options = options;
	}
}
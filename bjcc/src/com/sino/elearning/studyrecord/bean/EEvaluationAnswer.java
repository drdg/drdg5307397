package com.sino.elearning.studyrecord.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractEEvaluationAnswer entity provides the base persistence definition of
 * the EEvaluationAnswer entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class EEvaluationAnswer implements java.io.Serializable {

	// Fields

	private Long answerRecordId;    			//填写评测试卷问题记录ID
	private EEvaluationRecord Record; 			
	private Long questionId;					//问题ID
	private String answerState;					//回答是否正确
	private List<EEvaluationOption> options;	

	// Constructors

	/** default constructor */
	public EEvaluationAnswer() {
	}

	/** minimal constructor */
	public EEvaluationAnswer(Long answerRecordId) {
		this.answerRecordId = answerRecordId;
	}

	/** full constructor */
	public EEvaluationAnswer(Long answerRecordId,
			EEvaluationRecord Record, Long questionId,
			String answerState, List<EEvaluationOption> options) {
		this.answerRecordId = answerRecordId;
		this.Record = Record;
		this.questionId = questionId;
		this.answerState = answerState;
		this.options = options;
	}

	// Property accessors

	public Long getAnswerRecordId() {
		return this.answerRecordId;
	}

	public void setAnswerRecordId(Long answerRecordId) {
		this.answerRecordId = answerRecordId;
	}

	public EEvaluationRecord getRecord() {
		return Record;
	}

	public void setRecord(EEvaluationRecord record) {
		Record = record;
	}

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswerState() {
		return this.answerState;
	}

	public void setAnswerState(String answerState) {
		this.answerState = answerState;
	}

	public List<EEvaluationOption> getOptions() {
		return options;
	}

	public void setOptions(List<EEvaluationOption> options) {
		this.options = options;
	}
	public void addOption(EEvaluationOption option){
		if(this.options == null) {
			this.options = new ArrayList<EEvaluationOption>();
		}
		this.options.add(option);
	}
}
package com.sino.elearning.questionnaire.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EQuesnaireQuestion entity. @author MyEclipse Persistence Tools
 */

public class EQuesnaireQuestion implements java.io.Serializable {

	// Fields

	private Long questionId;
	private EQuestionnaire EQuestionnaire;
	private String questionName;
	private String choose;
	private String questionType;
	//简答题答案
	private String content;
	
	private List quesnaireQuesOptions;
	
	/** default constructor */
	public EQuesnaireQuestion() {
	}
	// Property accessors

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public EQuestionnaire getEQuestionnaire() {
		return this.EQuestionnaire;
	}

	public void setEQuestionnaire(EQuestionnaire EQuestionnaire) {
		this.EQuestionnaire = EQuestionnaire;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getChoose() {
		return this.choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List getQuesnaireQuesOptions() {
		if(null == quesnaireQuesOptions) {
			quesnaireQuesOptions = new ArrayList();
		}
		return quesnaireQuesOptions;
	}

	public void setQuesnaireQuesOptions(List quesnaireQuesOptions) {
		this.quesnaireQuesOptions = quesnaireQuesOptions;
	}
	
	public void addQuesnaireQuesOptions(Object o) {
		this.getQuesnaireQuesOptions().add(o);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
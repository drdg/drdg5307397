package com.sino.elearning.questionnaire.bean;

import java.math.BigDecimal;


/**
 * EQuesnaireAnswerAns entity. @author MyEclipse Persistence Tools
 */

public class EQuesnaireAnswerAns  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Long questionId;
     private String content;
     private EQuestionnaireUser questionnaireUser;

    // Constructors

	/** default constructor */
    public EQuesnaireAnswerAns() {
    }

	/** minimal constructor */
    public EQuesnaireAnswerAns(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public EQuesnaireAnswerAns(Long id, Long questionId, String content, EQuestionnaireUser questionnaireUser) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.questionnaireUser = questionnaireUser;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public EQuestionnaireUser getQuestionnaireUser() {
		return questionnaireUser;
	}

	public void setQuestionnaireUser(EQuestionnaireUser questionnaireUser) {
		this.questionnaireUser = questionnaireUser;
	}

}
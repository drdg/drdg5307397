package com.sino.elearning.questionnaire.bean;

import java.math.BigDecimal;


/**
 * EQuesnaireChoiceAns entity. @author MyEclipse Persistence Tools
 */

public class EQuesnaireChoiceAns  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Long questionId;
     private Long optionId;
     private EQuestionnaireUser questionnaireUser;

    // Constructors


	/** default constructor */
    public EQuesnaireChoiceAns() {
    }

	/** minimal constructor */
    public EQuesnaireChoiceAns(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public EQuesnaireChoiceAns(Long id, Long questionId, Long optionId, EQuestionnaireUser questionnaireUser) {
        this.id = id;
        this.questionId = questionId;
        this.optionId = optionId;
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

    public Long getOptionId() {
        return this.optionId;
    }
    
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public EQuestionnaireUser getQuestionnaireUser() {
		return questionnaireUser;
	}

	public void setQuestionnaireUser(EQuestionnaireUser questionnaireUser) {
		this.questionnaireUser = questionnaireUser;
	}
}
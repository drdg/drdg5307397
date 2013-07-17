package com.sino.elearning.questionnaire.bean;

import java.math.BigDecimal;


/**
 * EQuestionnaireUser entity. @author MyEclipse Persistence Tools
 */

public class EQuestionnaireUser  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Long questionnaireId;
     private Long userid;
     private String userNm;
     private Long deptId;
     private String deptName;
     private String time;
     private String status;

    // Constructors

    /** default constructor */
    public EQuestionnaireUser() {
    }
    
    /** full constructor */
    public EQuestionnaireUser(Long id, Long questionnaireId, Long userid, String userNm, Long deptId, String deptName, String time, String status) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.userid = userid;
        this.userNm = userNm;
        this.deptId = deptId;
        this.deptName = deptName;
        this.time = time;
        this.status = status;
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

    public Long getUserid() {
        return this.userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserNm() {
        return this.userNm;
    }
    
    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public Long getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
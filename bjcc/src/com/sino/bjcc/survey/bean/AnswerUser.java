package com.sino.bjcc.survey.bean;

import java.util.Date;

public class AnswerUser {
    private long ID;            //编号
    private long surveyID;      //调查ID
    private String system ;     //操作系统
    private String browser ;    //浏览器
    private String ipAddress;   //IP地址
    private Date creationDate;  //投票时间

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(long surveyID) {
        this.surveyID = surveyID;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}

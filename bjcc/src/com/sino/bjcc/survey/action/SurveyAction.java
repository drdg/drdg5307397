package com.sino.bjcc.survey.action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.survey.bean.Answer;
import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.bean.Survey;
import com.sino.bjcc.survey.service.ISurveyService;

@SuppressWarnings("serial")
public class SurveyAction extends BaseAction {

	private long surveyId = 0;						//IN：问卷ID
	private List<Answer> answerList = null;			//IN：问卷答案列表
	private List<Question> questionList = null;		//OUT：问题列表
	private Survey survey = null;					//OUT：问卷信息
	
	/**
	 * 获取问卷ID
	 */
	public long getSurveyId() {
		return surveyId;
	}
	/**
	 * 设置问卷ID
	 */
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * 获取问卷信息
	 */
	public Survey getSurvey() {
		return survey;
	}
	/**
	 * 设置问卷信息
	 */
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	/**
	 * 获取问卷问题列表
	 */
	public List<Question> getQuestionList() {
		return questionList;
	}
	/**
	 * 设置问卷问题列表
	 */
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	/**
	 * 获取问卷答案列表
	 */
	public List<Answer> getAnswerList() {
		return answerList;
	}
	/**
	 * 设置问卷答案列表
	 */
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	private ISurveyService srveyManager = null;		//问卷Manager
	/**
	 * 获取问卷Manger
	 */
	public ISurveyService getSrveyManager() {
		return srveyManager;
	}
	/**
	 * 设置问卷Manger
	 */
	public void setSrveyManager(ISurveyService srveyManager) {
		this.srveyManager = srveyManager;
	}

	/**
	 * 方法说明：显示在线调查问卷信息
	 */
	public String showSurvey(){
		setSurvey(getSrveyManager().getSurveyInfo(getSurveyId()));
		setQuestionList(getSrveyManager().getQuestionList(getSurveyId()));
		return SUCCESS;
	}
	
	/**
	 * 方法说明：提交问卷答案，写入DB
	 */
	public String completeSurvey(){
		getSrveyManager().submitSurveyAnswer(answerList, surveyId, getClientIp(), getRequest());
		return SUCCESS;
	}
	
}

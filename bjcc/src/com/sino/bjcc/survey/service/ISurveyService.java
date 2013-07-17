package com.sino.bjcc.survey.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sino.bjcc.survey.bean.Answer;
import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.bean.Survey;

public interface ISurveyService {

	/**
	 * 方法说明：获取问卷信息
	 */
	public Survey getSurveyInfo(long surveyId);
	
	/**
	 * 方法说明：获取问卷的问题
	 */
	public List<Question> getQuestionList(long surveyId);
	
	/**
	 * 方法说明：提交问卷答案
	 */
	public void submitSurveyAnswer(List<Answer> answerList, long surveyId, 
			String ip, HttpServletRequest request);
	
}

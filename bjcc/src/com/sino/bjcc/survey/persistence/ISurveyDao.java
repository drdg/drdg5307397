package com.sino.bjcc.survey.persistence;

import java.util.List;

import com.sino.bjcc.survey.bean.Answer;
import com.sino.bjcc.survey.bean.AnswerUser;
import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.bean.Survey;

public interface ISurveyDao {

	/**
	 * 方法说明：获取问卷信息
	 */
	public Survey getSurveyInfo(long surveyId);
	
	/**
	 * 方法说明：获取问卷的问题
	 */
	public List<Question> getQuestionList(long surveyId);
	
	/**
	 * 方法说明：新建问卷回复用户信息
	 */
	public long createAnswerUser(AnswerUser user);
	
	/**
	 * 方法说明：新建问卷回复答案
	 */
	public void createSurveyAnswer(Answer answer);
	
}

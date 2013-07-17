package com.sino.bjcc.survey.persistence.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.survey.bean.Answer;
import com.sino.bjcc.survey.bean.AnswerUser;
import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.bean.Survey;
import com.sino.bjcc.survey.persistence.ISurveyDao;

public class SurveyDaoImpl extends PersistenceBase implements ISurveyDao {

	/**
	 * 方法说明：获取问卷的问题
	 */
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionList(long surveyId) {
		String hql = "From Question where surveyID = :surveyID Order By sortID ASC";
		List<Question> questionList = executeQuery(hql, new SqlParameter("surveyID",surveyId));
		return questionList;
	}

	/**
	 * 方法说明：获取问卷信息
	 */
	public Survey getSurveyInfo(long surveyId) {
		Survey survey = (Survey) get(Survey.class, surveyId);
		return survey;
	}

	/**
	 * 方法说明：新建问卷回复用户信息
	 */
	public long createAnswerUser(AnswerUser user) {
		return Long.parseLong(save(user).toString());
	}

	/**
	 * 方法说明：新建问卷回复答案
	 */
	public void createSurveyAnswer(Answer answer) {
		save(answer);
	}

}

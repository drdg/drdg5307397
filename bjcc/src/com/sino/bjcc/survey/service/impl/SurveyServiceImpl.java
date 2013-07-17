package com.sino.bjcc.survey.service.impl;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.survey.bean.Answer;
import com.sino.bjcc.survey.bean.AnswerUser;
import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.bean.Survey;
import com.sino.bjcc.survey.persistence.ISurveyDao;
import com.sino.bjcc.survey.service.ISurveyService;

public class SurveyServiceImpl implements ISurveyService {
	
	private ISurveyDao surveyDao = null;	//在线调查Dao
	
	/**
	 * 获取调查问卷Dao
	 */
	public ISurveyDao getSurveyDao() {
		return surveyDao;
	}
	/**
	 * 设置调查问卷Dao
	 */
	public void setSurveyDao(ISurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}

	/**
	 * 方法说明：获取问卷信息
	 */
	public Survey getSurveyInfo(long surveyId){
		return getSurveyDao().getSurveyInfo(surveyId);
	}
	
	/**
	 * 方法说明：获取问卷的问题
	 */
	public List<Question> getQuestionList(long surveyId){
		List<Question> questionList = getSurveyDao().getQuestionList(surveyId);
		//为question对象指定其在list中的index
		for (int index = 0; index < questionList.size(); index++) {
			questionList.get(index).setIndex(index);
		}
		return questionList;
	}

	/**
	 * 方法说明：提交问卷答案
	 */
	@Transactional(readOnly=false)
	public void submitSurveyAnswer(List<Answer> answerList, long surveyId,
			String ip, HttpServletRequest request) {
		long userId = createAnswerUser(surveyId, ip, request);
		createSurveyAnswer(userId, answerList);
	}
	
	/**
	 * 方法说明：新建问卷回复用户信息
	 */
	private long createAnswerUser(long surveyId, String ip, HttpServletRequest request){
		AnswerUser user = new AnswerUser();
        user.setSurveyID(surveyId);
        user.setCreationDate(DateTimeUtil.getNow());
        String agent = request.getHeader("User-Agent");
        StringTokenizer st = new StringTokenizer(agent, ";");
        st.nextToken();
        //得到用户的浏览器名
        String userBrowser = st.nextToken();
        //得到用户的操作系统名
        String userOS = st.nextToken();
        userOS = userOS.substring(0, userOS.length() - 1);
        user.setSystem(userBrowser);
        user.setBrowser(userOS);
        user.setIpAddress(ip);
        return getSurveyDao().createAnswerUser(user);
	}
	
	/**
	 * 方法说明：新建问卷回复答案
	 */
	private void createSurveyAnswer(long userId, List<Answer> answerList){
		if(null==answerList || 0==answerList.size()){
			return;
		}
		for (Answer answer : answerList) {
			if(StringUtil.isNullOrEmpty(answer.getAnswer())){
				continue;
			}
			//答案是复选框的情况，把逗号替换为竖线
			if(Answer.CHECKBOX_QUESTION == answer.getCheckboxFlag()){
				answer.setAnswer(answer.getAnswer().replaceAll(" ", "").replaceAll(",", "|"));
			}
			answer.setUserID(userId);
			getSurveyDao().createSurveyAnswer(answer);
		}
	}
	
}

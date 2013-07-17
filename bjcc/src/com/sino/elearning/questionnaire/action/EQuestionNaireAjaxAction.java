package com.sino.elearning.questionnaire.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.questionnaire.bean.EQuesnaireAnswerAns;
import com.sino.elearning.questionnaire.bean.EQuesnaireChoiceAns;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;
import com.sino.elearning.questionnaire.service.IEQuestionNaireService;
import com.sino.system.constant.Constant;
/**
 * 用户需求问卷处理action
 * @author Administrator
 *
 */
public class EQuestionNaireAjaxAction extends BaseAction {
	
	private IEQuestionNaireService questionNaireService;
	
	//返回结果
	private String result;
	//问卷ID
	private Long questionnaireId;
	
	//用户问卷ID
	private Long naireUserId;
	//用户问卷状态
	private String naireUserStatus;
	
	//选择题问题IDS
	private Long[] choAnswerIds;
	//选择题已选选项questionid_optionid组成的字符串,并以","分割
	private String choAnswers;
	//简答题问题ID数组
	private Long[] ansQuestionIds;
	//简答题答案数组
	private String[] ansAnswers;
	
	/**
	 * 进入调查问卷列表页面
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			if( null != questionnaireId ) {
				EQuestionnaireUser questionnaireUser = null;
				if(null == naireUserId) {
					questionnaireUser = new EQuestionnaireUser();
					questionnaireUser.setDeptId(user.getOrgId());
					questionnaireUser.setDeptName(user.getOrgName());
					questionnaireUser.setQuestionnaireId(questionnaireId);
					questionnaireUser.setUserid(user.getUserId());
					questionnaireUser.setUserNm(user.getUserName());
				} else {
					questionnaireUser = questionNaireService.queryQuestionnaireUser(naireUserId);
				}
				questionnaireUser.setStatus(naireUserStatus);
				questionnaireUser.setTime(DateTimeUtil.getNowStr());
				//用户问卷选择题选项列表
				List<EQuesnaireChoiceAns> choice_ans_list = new ArrayList<EQuesnaireChoiceAns>();
				//用户问卷简答题答案列表
				List<EQuesnaireAnswerAns> answer_ans_list = new ArrayList<EQuesnaireAnswerAns>();
				
				String[] choiceAnswers = choAnswers.split(",");
				String[] temp = null;	
				
				if(null!=ansQuestionIds) {
					for(int i = 0; i < ansQuestionIds.length; i++) {
						if(null!=ansAnswers[i] && ansAnswers[i].trim().length() > 0) {
							EQuesnaireAnswerAns answerAns = new EQuesnaireAnswerAns();
							answerAns.setQuestionId( ansQuestionIds[i] );
							answerAns.setContent(ansAnswers[i]);
							answerAns.setQuestionnaireUser(questionnaireUser);
							answer_ans_list.add(answerAns);
						}
					}
				}
				
				if(null!=choiceAnswers) {
					for(int i = 0; i < choiceAnswers.length; i++) {
						temp = choiceAnswers[i].split("_");
						if( null != temp && temp.length == 2) {
							EQuesnaireChoiceAns choiceans = new EQuesnaireChoiceAns();
							choiceans.setQuestionId(Long.valueOf(temp[0]));
							choiceans.setOptionId(Long.valueOf(temp[1]));
							choiceans.setQuestionnaireUser(questionnaireUser);
							choice_ans_list.add(choiceans);
						}
					}
				}
				if(null == naireUserId) {
					questionNaireService.save(questionnaireUser, choice_ans_list, answer_ans_list);
				} else {
					questionNaireService.modify(questionnaireUser, choice_ans_list, answer_ans_list);
				}
				result = "success";
			}
		} catch (Exception e) {
			result = "failed";
			log.error("保存用户问卷及答案失败 save()", e);
			throw e;
		}
		return SUCCESS;
	}

	@JSON(serialize=false)
	public IEQuestionNaireService getQuestionNaireService() {
		return questionNaireService;
	}

	public void setQuestionNaireService(IEQuestionNaireService questionNaireService) {
		this.questionNaireService = questionNaireService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Long[] getAnsQuestionIds() {
		return ansQuestionIds;
	}

	public void setAnsQuestionIds(Long[] ansQuestionIds) {
		this.ansQuestionIds = ansQuestionIds;
	}

	public String getChoAnswers() {
		return choAnswers;
	}

	public void setChoAnswers(String choAnswers) {
		this.choAnswers = choAnswers;
	}

	public String[] getAnsAnswers() {
		return ansAnswers;
	}

	public void setAnsAnswers(String[] ansAnswers) {
		this.ansAnswers = ansAnswers;
	}

	public Long[] getChoAnswerIds() {
		return choAnswerIds;
	}

	public void setChoAnswerIds(Long[] choAnswerIds) {
		this.choAnswerIds = choAnswerIds;
	}

	public Long getNaireUserId() {
		return naireUserId;
	}

	public void setNaireUserId(Long naireUserId) {
		this.naireUserId = naireUserId;
	}

	public String getNaireUserStatus() {
		return naireUserStatus;
	}

	public void setNaireUserStatus(String naireUserStatus) {
		this.naireUserStatus = naireUserStatus;
	}

	private static final Log log = LogFactory.getLog(com.sino.elearning.questionnaire.action.EQuestionNaireAjaxAction.class);
}
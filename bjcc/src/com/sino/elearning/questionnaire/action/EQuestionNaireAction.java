package com.sino.elearning.questionnaire.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.elearning.questionnaire.bean.EQuestionnaire;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;
import com.sino.elearning.questionnaire.service.IEQuestionNaireService;
import com.sino.system.constant.Constant;
/**
 * 用户需求问卷处理action
 * @author Administrator
 *
 */
public class EQuestionNaireAction extends BaseAction {
	
	private IEQuestionNaireService questionNaireService;
	
	private List<EQuestionnaire> questionnaireList;
	
	private Long questionnaireId;
	private EQuestionnaire questionnaire;
	/**
	 * 进入主页面调查问卷列表页面
	 * @return
	 * @throws Exception
	 */
	public String prepareMain() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			questionnaireList = questionNaireService.queryByDeptId(user.getOrgId());
			if(questionnaireList!=null){
				for(int i=0;i<questionnaireList.size();i++){
					List<EQuestionnaireUser> questionnaireUser = questionNaireService.queryByquestionnaireId(questionnaireList.get(i).getQuestionnaireId(), user.getUserId());
					 if(questionnaireUser.size()>0){
						 questionnaireList.get(i).setTestStatus("已答");
					 }else{
						 questionnaireList.get(i).setTestStatus("未答");
					 }
				}
			}
		} catch (Exception e) {
			log.error("查询用户问卷失败 prepareMain()", e);
			throw e;
		}
		return "preparemain";
	}
	
	/**
	 * 进入更多调查问卷页面
	 * @return
	 * @throws Exception
	 */
	public String prepareMore() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return "preparemore";
	}
	
	/**
	 * 进入更多调查问卷列表页面
	 * @return
	 * @throws Exception
	 */
	public String queryMore() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			questionnaireList = questionNaireService.queryByDeptId(super.getPaginationBean(), user.getOrgId());
			if(questionnaireList!=null){
				for(int i=0;i<questionnaireList.size();i++){
					List<EQuestionnaireUser> questionnaireUser = questionNaireService.queryByquestionnaireId(questionnaireList.get(i).getQuestionnaireId(), user.getUserId());
					 if(questionnaireUser.size()>0){
						 questionnaireList.get(i).setTestStatus("已答");
					 }else{
						 questionnaireList.get(i).setTestStatus("未答");
					 }
				}
			}
		} catch (Exception e) {
			log.error("查询用户问卷失败 queryMore()", e);
			throw e;
		}
		return "nairelist";
	}
	
	
	/**
	 * 调查更多问卷也面进行模糊查询
	 * 
	 * */
	public String search() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String title =getRequest().getParameter("title");
		try {
			if(title!=null&&!"".equals(title)){
				getPaginationBean().setCurrentPage(1);	
			}
			questionnaireList = questionNaireService.findByTitle(getPaginationBean(),user.getOrgId(),title);
			if(questionnaireList!=null){
				for(int i=0;i<questionnaireList.size();i++){
					List<EQuestionnaireUser> questionnaireUser = questionNaireService.queryByquestionnaireId(questionnaireList.get(i).getQuestionnaireId(), user.getUserId());
					 if(questionnaireUser.size()>0){
						 questionnaireList.get(i).setTestStatus("已答");
					 }else{
						 questionnaireList.get(i).setTestStatus("未答");
					 }
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "search";
	}
	

	/**
	 * 进入调查问卷页面
	 * @return
	 * @throws Exception
	 */
	public String toNaire() throws Exception {
		
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			questionnaire = questionNaireService.queryById(questionnaireId, user.getUserId());
			
			//已经提交的问卷
			if( "1".equals(questionnaire.getNaireUserStatus()) ) {
				return "nairedetail";
			} else {
				return "tonaire";
			}
		} catch (Exception e) {
			log.error("查询用户问卷失败 toNaire()", e);
			throw e;
		}
		
	}
	
	
	public IEQuestionNaireService getQuestionNaireService() {
		return questionNaireService;
	}

	public void setQuestionNaireService(IEQuestionNaireService questionNaireService) {
		this.questionNaireService = questionNaireService;
	}

	public List<EQuestionnaire> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<EQuestionnaire> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	public EQuestionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(EQuestionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	private static final Log log = LogFactory.getLog(com.sino.elearning.questionnaire.action.EQuestionNaireAction.class);
}
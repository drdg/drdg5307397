package com.sino.elearning.studyplan.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.studyplan.bean.EStudyPlan;
import com.sino.elearning.studyplan.bean.EStudyProgram;
import com.sino.elearning.studyplan.service.IEStudyPlanService;
import com.sino.system.constant.Constant;

public class EStudyPlanAction extends BaseAction {
	
	IEStudyPlanService studyPlanService;
	
	//查询日期
	private String qryDate;
	//学习计划列表
	private List<EStudyPlan> studyPlanList;
	/**
	 * 进入学习计划页面
	 * @return
	 */
	public String prepare() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		
		return "prepareplan";
	}
	
	/**
	 * 学习计划日历控件首部部分
	 * @return
	 */
	public String head() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return "headplan";
	}
	
	/**
	 * 进入选课页面
	 * @return
	 */
	public String selectCourse() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return "selectcourse";
	}
	
	/**
	 * 查询学习计划
	 * @return
	 * @throws Exception
	 */
	public String queryProgram() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		Map params = new HashMap();
		params.put("userId", user.getUserId());
		if(null!=qryDate && qryDate.length()>0) {
			params.put("studyTime", qryDate);
		}
		try {
			studyPlanList = studyPlanService.findByParams(null, params);
		}catch(Exception e) {
			log.error("查询学习计划失败 queryProgram()", e);
			throw e;
		}
		return "queryprogram";
	}
	
	public IEStudyPlanService getStudyPlanService() {
		return studyPlanService;
	}

	public void setStudyPlanService(IEStudyPlanService studyPlanService) {
		this.studyPlanService = studyPlanService;
	}
	
	public String getQryDate() {
		return qryDate;
	}

	public void setQryDate(String qryDate) {
		this.qryDate = qryDate;
	}

	public List<EStudyPlan> getStudyPlanList() {
		return studyPlanList;
	}

	public void setStudyPlanList(List<EStudyPlan> studyPlanList) {
		this.studyPlanList = studyPlanList;
	}

	private static final Log log = LogFactory.getLog(com.sino.elearning.studyplan.action.EStudyPlanAction.class);
}
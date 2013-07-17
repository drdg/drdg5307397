package com.sino.elearning.studyplan.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.studyplan.bean.EStudyPlan;
import com.sino.elearning.studyplan.bean.EStudyProgram;
import com.sino.elearning.studyplan.service.IEStudyPlanService;
import com.sino.system.constant.Constant;

public class EStudyPlanAjaxAction extends BaseAction {
	
	private IEStudyPlanService studyPlanService;
	private List<EStudyPlan> studyPlanList;
	
	//查询标志(main)为查询学习计划，不加载明细)
	private String queryTag;
	//课程ID
	private Long programId;
	//学习计划ID
	private Long studyPlanId;
	//返回保存结果是否成功
	private String result;
	//查询月
	private String qryMon;
	//查询日期
	private String qryDate;
	//学习计划
	private EStudyPlan studyPlan;
	//节目ID
	private String[] programIds;
	//节目名称
	private String[] names;
	//节目图片地址
	private String[] imgurls;
	//节目渠道
	private String[] channels;
	//学习日期
	private String[] dates;
	//主讲人
	private String[] speakers;
	//播放路径
	private String[] paths;
	
	/**
	 * 暂时保存学习计划 临时数据
	 * @return
	 */
	public String saveTempData() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		result = "success";
		HttpSession session = super.getSession();
		session.setAttribute("programIds", programIds);
		session.setAttribute("names", names);
		session.setAttribute("imgurls", imgurls);
		session.setAttribute("channels", channels);
		session.setAttribute("dates", dates);
		session.setAttribute("speakers", speakers);
		session.setAttribute("paths", paths);
		return SUCCESS;
	}
	
	/**
	 * 清空学习计划 临时数据
	 * @return
	 */
	public String clearTempData() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		result = "success";
		HttpSession session = super.getSession();
		session.removeAttribute("programIds");
		session.removeAttribute("names");
		session.removeAttribute("imgurls");
		session.removeAttribute("channels");
		session.removeAttribute("dates");
		session.removeAttribute("speakers");
		session.removeAttribute("paths");
		session.removeAttribute("planlist");
		return SUCCESS;
	}
	
	/**
	 * 保存学习计划
	 * @return
	 */
	public String save2() throws Exception {
		result = "fail";
		boolean isExists = false;
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		StringBuffer sbwhere = new StringBuffer();
		sbwhere.append(" and esp.studyTime in ('").append(qryDate).append("',");
		if(null != programIds && programIds.length>0){
			for(int i = 0; i < dates.length; i++) {
				sbwhere.append("'").append(dates[i]).append("',");
			}
		}
		sbwhere.deleteCharAt(sbwhere.length() - 1).append(") ");
		Map params = new HashMap();
		params.put("userId", user.getUserId());
		try {
			studyPlanList = studyPlanService.findByParams(sbwhere.toString(), params);
			for(EStudyPlan plan :studyPlanList) {
				Set tempSet = new HashSet(0);
				Set studyPrograms = plan.getStudyPrograms();
				
				if(plan.getStudyTime().equals(qryDate)) {
					Object[] objs = studyPrograms.toArray();
					for(int i = 0; i < objs.length; i++) {
						((EStudyProgram)objs[i]).setEStudyPlan(null);
						studyPrograms.remove(objs[i]);
						studyPlanService.delete((EStudyProgram)objs[i]);
					}
				}else {
					for(Object obj: studyPrograms) {
						tempSet.add(obj);
					}
				}
				plan.tempSet = tempSet;
			}
			if(null!=programIds) {
				for ( int i = 0; i < programIds.length; i++ ) {
					isExists = false;
					EStudyProgram program = new EStudyProgram();
					program.setProgramId(Long.valueOf(programIds[i]));
					program.setProgramName(names[i]);
					program.setProgramType(channels[i]);
					program.setImgUrl(imgurls[i]);
					program.setSpeaker(speakers[i]);
					program.setPath(paths[i]);
					for(EStudyPlan plan :studyPlanList) {
						if(plan.getStudyTime().equals(dates[i])) {
							plan.tempSet.add(program);
							program.setEStudyPlan(plan);
							isExists = true;
						}
					}
					if(isExists == false) {
						EStudyPlan plan = new EStudyPlan();
						plan.setStudyTime(dates[i]);
						plan.tempSet.add(program);
						program.setEStudyPlan(plan);
						studyPlanList.add(plan);
					}
				}
			}
			
			for(EStudyPlan plan :studyPlanList) {
				plan.setCnt(Long.valueOf(plan.tempSet.size()));
				plan.setStudyPrograms(plan.tempSet);
				plan.setCreatTime(DateTimeUtil.getNowStr());
				plan.setUserId(user.getUserId());
				plan.setUserNm(user.getUserName());
				plan.setDeptId(user.getOrgId());
				plan.setDeptName(user.getOrgName());
			}
			studyPlanService.save(studyPlanList);
			getSession().setAttribute("planlist", studyPlanList);
			result = "success";
		} catch(Exception e) {
			e.printStackTrace();
			super.writeStringToClient("fail");
			log.error("保存学习计划失败 save()", e);
			throw e;
		}
		return SUCCESS;
	}
	
	public String dataLoad() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		studyPlanList = (List<EStudyPlan>) getSession().getAttribute("planlist");
		return SUCCESS;
	}
	
	/**
	 * 加载学习计划
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String wheresql = null;
		if(null!=qryMon && qryMon.length() > 0) {
			wheresql = " and (esp.studyTime like '%" + qryMon + "%' " +
				" or esp.studyTime like '%" + DateTimeUtil.getBeforeOrAfterMon(qryMon, 1) + "%' " +
				" or esp.studyTime like '%" + DateTimeUtil.getBeforeOrAfterMon(qryMon, -1) + "%') ";
		}
		Map params = new HashMap();
		params.put("userId", user.getUserId());
		if(null!=qryDate && qryDate.length()>0) {
			params.put("studyTime", qryDate);
		}
		studyPlanList = studyPlanService.findByParams(wheresql, params);
		if("main".equals(queryTag)) {
			for(int i = 0; i < studyPlanList.size(); i++) {
				studyPlanList.get(i).setStudyPrograms(null);
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 删除学习计划
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
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
		try{
			List<EStudyPlan> list = studyPlanService.findByParams(null, params);
			studyPlanService.delete(list);
			result = "success";
			if(null != list && list.size() > 0) {
				studyPlanId = list.get(0).getStudyPlanId();
			}
		} catch(Exception e) {
			super.writeStringToClient("fail");
			log.error("删除学习计划失败del()", e);
			throw e;
		}
		return SUCCESS;
	}
	
	/**
	 * 验证课程是否已经加入某天学习计划
	 * @return
	 * @throws Exception
	 */
	public String validateProgram() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try{
			boolean bool = studyPlanService.validateProgram(qryDate, programId, user.getUserId());
			if(bool == true) {
				result = "success";
			} else {
				result = "fail";
			}
		} catch(Exception e) {
			super.writeStringToClient("fail");
			log.error("删除学习计划失败del()", e);
			throw e;
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public IEStudyPlanService getStudyPlanService() {
		return studyPlanService;
	}
	public void setStudyPlanService(IEStudyPlanService studyPlanService) {
		this.studyPlanService = studyPlanService;
	}
	public EStudyPlan getStudyPlan() {
		return studyPlan;
	}
	public void setStudyPlan(EStudyPlan studyPlan) {
		this.studyPlan = studyPlan;
	}
	public String[] getProgramIds() {
		return programIds;
	}
	public void setProgramIds(String[] programIds) {
		this.programIds = programIds;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String[] getImgurls() {
		return imgurls;
	}
	public void setImgurls(String[] imgurls) {
		this.imgurls = imgurls;
	}
	public String[] getChannels() {
		return channels;
	}
	public void setChannels(String[] channels) {
		this.channels = channels;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<EStudyPlan> getStudyPlanList() {
		return studyPlanList;
	}
	public void setStudyPlanList(List<EStudyPlan> studyPlanList) {
		this.studyPlanList = studyPlanList;
	}
	public String getQryMon() {
		return qryMon;
	}
	public void setQryMon(String qryMon) {
		this.qryMon = qryMon;
	}
	public String getQryDate() {
		return qryDate;
	}
	public void setQryDate(String qryDate) {
		this.qryDate = qryDate;
	}
	public Long getStudyPlanId() {
		return studyPlanId;
	}
	public void setStudyPlanId(Long studyPlanId) {
		this.studyPlanId = studyPlanId;
	}
	public String getQueryTag() {
		return queryTag;
	}
	public void setQueryTag(String queryTag) {
		this.queryTag = queryTag;
	}
	public String[] getDates() {
		return dates;
	}
	public void setDates(String[] dates) {
		this.dates = dates;
	}
	public String[] getSpeakers() {
		return speakers;
	}
	public void setSpeakers(String[] speakers) {
		this.speakers = speakers;
	}
	public String[] getPaths() {
		return paths;
	}
	public void setPaths(String[] paths) {
		this.paths = paths;
	}
	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	private static final Log log = LogFactory.getLog(com.sino.elearning.studyplan.action.EStudyPlanAjaxAction.class);
}
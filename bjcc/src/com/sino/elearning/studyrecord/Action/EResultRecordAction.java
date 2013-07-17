package com.sino.elearning.studyrecord.Action;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.bean.EResultsRecord;
import com.sino.elearning.studyrecord.bean.ETrainMessage;
import com.sino.elearning.studyrecord.service.IRecordService;
import com.sino.elearning.studyrecord.service.IResultRecordService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class EResultRecordAction extends BaseAction{
	/**
	 * 跳转 用户学习成效
	 * 
	 * 查看该记录是否创建成效
	 * */
	public String jump() throws Exception{
		String programName = "";
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String ubrId = getRequest().getParameter("ubrId");
		String programId = getRequest().getParameter("programId");
		String studyType = getRequest().getParameter("studyType");
		
		if(studyType.equals("1")){
			userBehavior = recordService.findById(Long.valueOf(ubrId));
			if(userBehavior!=null&&!"".equals(userBehavior)){
				programName = userBehavior.getResourcesName();	
			}
		}else if(studyType.equals("2")){
			trainMessage = recordService.findByTrainId(Long.valueOf(programId));
			if(trainMessage!=null&&!"".equals(trainMessage)){
				programName = trainMessage.getTrainTheme();	
			}
		}
		records=resultService.findByProId(Long.valueOf(programId), studyType,user.getUserId());
		if(records.size()>0){
			getRequest().setAttribute("record",records.get(0));
			if(records.get(0).getState().equals("1")){
				getRequest().setAttribute("resultState", "2");
			}else if(records.get(0).getState().equals("0")){
				getRequest().setAttribute("resultState", "1");
			}
		}else{
			getRequest().setAttribute("resultState", "0");
		}
		getRequest().setAttribute("programId", programId);
		getRequest().setAttribute("studyType", studyType);
		getRequest().setAttribute("programName", programName);
		return "jumpsuccess";
	}
	/**
	 * 保存   用户个人学习记录成效
	 * */
	public void saveUserRecord(){
		PrintWriter writer = null ;
		UserInfo user=getLoginUserInfo();
		String programId = getRequest().getParameter("programId");
		String studyType = getRequest().getParameter("studyType");
		String resultsContent = getRequest().getParameter("resultsContent");
		String programName = getRequest().getParameter("programName");
		String newtime= DateTimeUtil.getNowStr();
		
		record=new EResultsRecord();
		record.setProgramId(Long.valueOf(programId));
		record.setProgramName(programName);
		record.setStudyType(studyType);
		record.setResultsContent(resultsContent);
		record.setState("0");
		record.setCreatUserId(user.getUserId());
		record.setUserNm(user.getUserName());
		record.setCreatTime(newtime);
		if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
			record.setDeptId(user.getOrgId());
		}
		record.setDeptName(user.getOrgName());
		try {
			writer = getResponse().getWriter();
			long res= resultService.saveResult(record);
			writer.write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writer.write("faild");
		}
		writer.flush();
		writer.close();
	}
	public void updateUserRecord(){
		PrintWriter writer = null ;
		UserInfo user=getLoginUserInfo();
		String resultsId = getRequest().getParameter("resultsId");
		String programId = getRequest().getParameter("programId");
		String studyType = getRequest().getParameter("studyType");
		String resultsContent = getRequest().getParameter("resultsContent");
		String  state =getRequest().getParameter("state");
		String programName = getRequest().getParameter("programName");
		String newtime= DateTimeUtil.getNowStr();
		
		record=new EResultsRecord();
		record.setResultsId(Long.valueOf(resultsId));
		record.setProgramId(Long.valueOf(programId));
		record.setProgramName(programName);
		record.setStudyType(studyType);
		record.setResultsContent(resultsContent);
		record.setState(state);
		record.setCreatUserId(user.getUserId());
		record.setUserNm(user.getUserName());
		record.setCreatTime(newtime);
		if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
			record.setDeptId(user.getOrgId());
		}
		record.setDeptName(user.getOrgName());
		try {
			writer = getResponse().getWriter();
			resultService.updateResult(record);
			writer.write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writer.write("faild");
		}
		writer.flush();
		writer.close();
	}
	EResultsRecord record;
	List<EResultsRecord> records;
	IResultRecordService resultService;
	SinoUserBehavior userBehavior;
	ETrainMessage trainMessage;
	IRecordService recordService;
	public EResultsRecord getRecord() {
		return record;
	}
	public void setRecord(EResultsRecord record) {
		this.record = record;
	}
	public List<EResultsRecord> getRecords() {
		return records;
	}
	public void setRecords(List<EResultsRecord> records) {
		this.records = records;
	}
	public IResultRecordService getResultService() {
		return resultService;
	}
	public void setResultService(IResultRecordService resultService) {
		this.resultService = resultService;
	}
	public SinoUserBehavior getUserBehavior() {
		return userBehavior;
	}
	public void setUserBehavior(SinoUserBehavior userBehavior) {
		this.userBehavior = userBehavior;
	}
	public ETrainMessage getTrainMessage() {
		return trainMessage;
	}
	public void setTrainMessage(ETrainMessage trainMessage) {
		this.trainMessage = trainMessage;
	}
	public IRecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}
}

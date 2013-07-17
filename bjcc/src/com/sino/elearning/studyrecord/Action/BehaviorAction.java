package com.sino.elearning.studyrecord.Action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.bean.EAttendee;
import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;
import com.sino.elearning.studyrecord.bean.EResultsRecord;
import com.sino.elearning.studyrecord.bean.ETrainMessage;
import com.sino.elearning.studyrecord.service.IRecordService;
import com.sino.elearning.studyrecord.service.IResultRecordService;
import com.sino.elearning.studyrecord.service.ITestService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class BehaviorAction extends BaseAction{
	/**
	 * 显示用户学习记录
	 * */
	public String record(){
		return "success";
	}
	/**
	 * 个人学习记录查询
	 * */
	public String userexecute() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			userBehaviors =	recordService.findByUserId(getPaginationBean(),user.getUserId());
			for(int i=0;i<userBehaviors.size();i++){
				records=resultService.findByProId(Long.valueOf(userBehaviors.get(i).getResourcesId()), "1",user.getUserId());
				if(records.size()>0){
					userBehaviors.get(i).setResultState("1");
				}else{
					userBehaviors.get(i).setResultState("0");
				}
				tests = testService.findBytest(Long.valueOf(userBehaviors.get(i).getResourcesId()), "1");
				if(tests.size()>0){
					record = testService.findByTestId(tests.get(0).getTestId(),user.getUserId());
					if(record.size()>0){
						userBehaviors.get(i).setTestState("1");
					}else{
						userBehaviors.get(i).setTestState("0");
					}
					
				}else{
					userBehaviors.get(i).setTestState("0");
				}
			}
			System.out.println(userBehaviors.size()+"条数");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usersuccess";
		
	}
	/**
	 * 集体学习记录查询
	 * */
	public String trainexecute() throws Exception{
		trainMessages=new ArrayList<ETrainMessage>();
		UserInfo user=getLoginUserInfo();
		SimpleDateFormat bdf = new SimpleDateFormat("yyyy:MM:dd");  
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			trainMessages = recordService.findByAttendUserId(getPaginationBean(), user.getUserId());
			if(null != trainMessages && trainMessages.size()>0) {
				for(int i=0;i<trainMessages.size();i++){
					ETrainMessage trainMessage = trainMessages.get(i);
					trainMessage.setTrainTime(trainMessage.getTrainTime().substring(0,10));
					records=resultService.findByProId(trainMessage.getTrainId(), "2",user.getUserId());
					if(records.size()>0){
						trainMessage.setResultState("1");
					}else{
						trainMessage.setResultState("0");
					}
				}
				System.out.println(trainMessages.size()+"条数");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "trainsuccess";
		
	}
	/**
	 *根据条件  查询个人学习记录
	 * */
	public String userQuery() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String textfield = getRequest().getParameter("textfield");
		try {
			userBehaviors =	recordService.findByUserText(getPaginationBean(),user.getUserId(),textfield);
			System.out.println(userBehaviors.size()+"条数");
			for(int i=0;i<userBehaviors.size();i++){
				records=resultService.findByProId(Long.valueOf(userBehaviors.get(i).getResourcesId()), "1",user.getUserId());
				if(records.size()>0){
					userBehaviors.get(i).setResultState("1");
				}else{
					userBehaviors.get(i).setResultState("0");
				}
				tests = testService.findBytest(Long.valueOf(userBehaviors.get(i).getResourcesId()), "1");
				if(tests.size()>0){
					record = testService.findByTestId(tests.get(0).getTestId(),user.getUserId());
					if(record.size()>0){
						userBehaviors.get(i).setTestState("1");
					}else{
						userBehaviors.get(i).setTestState("0");
					}
					
				}else{
					userBehaviors.get(i).setTestState("0");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usersuccess";
	}
	/**
	 * 根据条件  查询集体学习记录
	 * */
	public String trainQuery() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String textfield = getRequest().getParameter("textfield");
		try {
			trainMessages = recordService.findByTrainText(getPaginationBean(),user.getUserId(),textfield);
			if(null != trainMessages && trainMessages.size()>0) {
				for(int i=0;i<trainMessages.size();i++){
					ETrainMessage trainMessage =trainMessages.get(i); 
					records=resultService.findByProId(trainMessage.getTrainId(), "2",user.getUserId());
					if(records.size()>0){
						trainMessage.setResultState("1");
					}else{
						trainMessage.setResultState("0");
					}
				}
				System.out.println(trainMessages.size()+"条数");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "trainsuccess";
	}
	
	
	
	
	
	private SinoUserBehavior userBehavior;
	private ETrainMessage trainMessage;
	private List<SinoUserBehavior> userBehaviors;
	private List<ETrainMessage> trainMessages;
	private List<EAttendee> attendees;
	private IRecordService recordService;
	private List<EResultsRecord> records;
	private IResultRecordService resultService;
	List<EEvaluationTest> tests;
	List<EEvaluationRecord> record; 
	ITestService testService;
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
	public List<SinoUserBehavior> getUserBehaviors() {
		return userBehaviors;
	}
	public void setUserBehaviors(List<SinoUserBehavior> userBehaviors) {
		this.userBehaviors = userBehaviors;
	}
	public List<ETrainMessage> getTrainMessages() {
		return trainMessages;
	}
	public List<EAttendee> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<EAttendee> attendees) {
		this.attendees = attendees;
	}
	public void setTrainMessages(List<ETrainMessage> trainMessages) {
		this.trainMessages = trainMessages;
	}
	public IRecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
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
	public List<EEvaluationTest> getTests() {
		return tests;
	}
	public void setTests(List<EEvaluationTest> tests) {
		this.tests = tests;
	}
	public ITestService getTestService() {
		return testService;
	}
	public List<EEvaluationRecord> getRecord() {
		return record;
	}
	public void setRecord(List<EEvaluationRecord> record) {
		this.record = record;
	}
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}
}

package com.sino.elearning.studyrecord.Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.studyrecord.bean.EEvaluationAnswer;
import com.sino.elearning.studyrecord.bean.EEvaluationOption;
import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;
import com.sino.elearning.studyrecord.bean.EEvaluationTestQuestion;
import com.sino.elearning.studyrecord.bean.ETestQuestionOption;
import com.sino.elearning.studyrecord.service.ITestService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class EvaluationAction extends BaseAction{
	/**
	 * 判断学习资源是否存在并填写评测试卷
	 * */
	public void jump() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
		}
		PrintWriter writer = null ;
		String programId =getRequest().getParameter("programId");
		String testState = getRequest().getParameter("testState");
		tests = testService.findBytest(Long.valueOf(programId), testState);
		writer = getResponse().getWriter();
		if(tests.size()>0){
			records = testService.findByTestId(tests.get(0).getTestId(),user.getUserId());
			if(records.size()>0){
				if(records.get(records.size()-1).getRecordState().equals("0")){
					writer.write("successbaocun");
				}else if(records.get(records.size()-1).getRecordState().equals("1")){
					writer.write("successtijiao");
				}
				
			}else{
				writer.write("success");
			}
			
		}else{
			writer.write("fail");
		}
		writer.flush();
		writer.close();
	}
	/**
	 * 根据用户学习记录    查询评测试卷
	 * */
	public String execute() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String programId =getRequest().getParameter("programId");
		String testState = getRequest().getParameter("testState");
		
		tests = testService.findByCondition(Long.valueOf(programId), testState);
		if(tests.size()>0){
			test=tests.get(0);
			getRequest().setAttribute("test",test);
			return "jumpsuccess";   	
		}
		return "jumpfail";
		
	}
	/**
	 * 根据用户学习记录 查看用户已保存的学习评测试卷
	 * */
	public String executeBaocun() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String programId =getRequest().getParameter("programId");
		String testState = getRequest().getParameter("testState");
		tests = testService.findByCondition(Long.valueOf(programId), testState);
		record = testService.findByRecordtestId(tests.get(0).getTestId(), user.getUserId());
		test=record.getTest();
		getRequest().setAttribute("record", record);
		getRequest().setAttribute("test", test);
		return "detailbaocun";
	}
	/**
	 * 根据用户学习记录 查看用户已填写的学习评测试卷
	 * */
	public String executeWrite() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String programId =getRequest().getParameter("programId");
		String testState = getRequest().getParameter("testState");
		tests = testService.findByCondition(Long.valueOf(programId), testState);
		record = testService.findByRecordtestId(tests.get(0).getTestId(), user.getUserId());
		test=record.getTest();
		getRequest().setAttribute("record", record);
		getRequest().setAttribute("test", test);
		return "detailtijiao";
	}
	/**
	 * 保存 用户填写的学习评测试卷
	 * */
	public void baocun() throws Exception{
		PrintWriter writer = null ;
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
		}
		String recordId = getRequest().getParameter("recordId");
		String testId= getRequest().getParameter("testId");
		String Id = getRequest().getParameter("Id");
		String recordState = getRequest().getParameter("recordState");
		String newTime=DateTimeUtil.getNowStr();
		String[] question=Id.split(";");
		String[] Str;
		String[] questionoption;
		answers =new ArrayList<EEvaluationAnswer>();
		for(int i=0;i<question.length;i++){
			Str = question[i].split(":");
			answer=new EEvaluationAnswer();
			answer.setQuestionId(Long.valueOf(Str[0]));
			if(Str.length>1){
				questionoption = Str[1].split("、");
				options =new ArrayList<EEvaluationOption>();
				for(int j=0;j<questionoption.length;j++){
					EEvaluationOption option=new EEvaluationOption();
					option.setOptionId(Long.valueOf(questionoption[j]));
					options.add(option);
				}
				answer.setOptions(options);
				}
			answers.add(answer);
			}
		record=new EEvaluationRecord();
		record.setTestId(Long.valueOf(testId));
		record.setUserId(user.getUserId());
		record.setUserNm(user.getUserName());
		if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
			record.setDeptId(user.getOrgId());
		}
		record.setDeptName(user.getOrgName());  
		record.setTime(newTime);
		record.setAnswers(answers);
		record.setRecordState(recordState);
		if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
			record.setDeptId(user.getOrgId());
		}
		if(recordId!=null&&!"".equals(recordId)){
			testService.delect(Long.valueOf(recordId));
		}
		Long num= testService.save(record);
		System.out.println("成功保存了"+num+"评测试卷");
		writer = getResponse().getWriter();
		if(num>0){
			writer.write("success");
		}else{
			writer.write("fail");
		}
		writer.flush();
		writer.close();
	}
	/**
	 * 提交 用户填写的学习评测试卷
	 * */
	public void save() throws Exception{
		PrintWriter writer = null ;
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
		}
		String recordId = getRequest().getParameter("recordId");
		String testId= getRequest().getParameter("testId");
		String Id = getRequest().getParameter("Id");
		String recordState = getRequest().getParameter("recordState");
		String newTime=DateTimeUtil.getNowStr();
		String[] question=Id.split(";");
		String[] Str;
		String[] selected;
		String[] questionoption;
		Double allnum=0.00;
		Double correctnum = 0.00;
		String achievement ;
		answers =new ArrayList<EEvaluationAnswer>();
		for(int i=0;i<question.length;i++){
			Str = question[i].split(":");
			answer=new EEvaluationAnswer();
			answer.setQuestionId(Long.valueOf(Str[0]));
			questionoption = Str[1].split(",");
			if(questionoption[0].equals(questionoption[1])){
				answer.setAnswerState("1");
				correctnum=correctnum+1;
			}else{
				answer.setAnswerState("0");
			}
			selected = questionoption[0].split("、");
			options =new ArrayList<EEvaluationOption>();
			for(int j=0;j<selected.length;j++){
				EEvaluationOption option=new EEvaluationOption();
				option.setOptionId(Long.valueOf(selected[j]));
				options.add(option);
			}
			answer.setOptions(options);
			allnum=allnum+1;
			answers.add(answer);
		}
		record=new EEvaluationRecord();
		record.setTestId(Long.valueOf(testId));
		record.setUserId(user.getUserId());
		record.setUserNm(user.getUserName());
		if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
			record.setDeptId(user.getOrgId());
		}
		record.setDeptName(user.getOrgName());  
		record.setTime(newTime);
		achievement=String.format("%.2f", (correctnum/allnum)*100.00);
		record.setAchievement(achievement);
		record.setRecordState(recordState);
		record.setAnswers(answers);
		if(recordId!=null&&!"".equals(recordId)){
			testService.delect(Long.valueOf(recordId));
		}
		Long num= testService.save(record);
		System.out.println("成功保存了"+num+"个评测试卷");
		writer = getResponse().getWriter();
		if(num>0){
			writer.write(achievement);
		}else{
			writer.write("fail");
		}
		writer.flush();
		writer.close();
	}
	EEvaluationTest test;
	List<EEvaluationTest> tests;
	EEvaluationTestQuestion question;
	ETestQuestionOption option;
	EEvaluationAnswer answer;
	List<EEvaluationAnswer> answers;
	List<EEvaluationOption> options;
	EEvaluationRecord record;
	List<EEvaluationRecord> records; 
	ITestService testService;
	public EEvaluationTest getTest() {
		return test;
	}
	public void setTest(EEvaluationTest test) {
		this.test = test;
	}
	
	public EEvaluationTestQuestion getQuestion() {
		return question;
	}
	public void setQuestion(EEvaluationTestQuestion question) {
		this.question = question;
	}
	
	public ETestQuestionOption getOption() {
		return option;
	}
	public void setOption(ETestQuestionOption option) {
		this.option = option;
	}
	public List<EEvaluationOption> getOptions() {
		return options;
	}
	public void setOptions(List<EEvaluationOption> options) {
		this.options = options;
	}
	
	public EEvaluationAnswer getAnswer() {
		return answer;
	}
	public void setAnswer(EEvaluationAnswer answer) {
		this.answer = answer;
	}
	public List<EEvaluationAnswer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<EEvaluationAnswer> answers) {
		this.answers = answers;
	}
	public EEvaluationRecord getRecord() {
		return record;
	}
	public void setRecord(EEvaluationRecord record) {
		this.record = record;
	}
	public List<EEvaluationTest> getTests() {
		return tests;
	}
	public void setTests(List<EEvaluationTest> tests) {
		this.tests = tests;
	}
	public List<EEvaluationRecord> getRecords() {
		return records;
	}
	public void setRecords(List<EEvaluationRecord> records) {
		this.records = records;
	}
	public ITestService getTestService() {
		return testService;
	}
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}
}

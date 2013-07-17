package com.sino.elearning.studyrecord.service.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.elearning.studyrecord.Dao.IEvaluationTestDao;
import com.sino.elearning.studyrecord.Dao.ITestQuestionDao;
import com.sino.elearning.studyrecord.Dao.ITestQuestionOPtionDao;
import com.sino.elearning.studyrecord.bean.EEvaluationAnswer;
import com.sino.elearning.studyrecord.bean.EEvaluationOption;
import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;
import com.sino.elearning.studyrecord.bean.EEvaluationTestQuestion;
import com.sino.elearning.studyrecord.bean.ETestQuestionOption;
import com.sino.elearning.studyrecord.service.ITestService;



public class TestServiceImpl implements ITestService{
	/**
	 * 根据条件查询是否存在评测试卷
	 * */
	public List<EEvaluationTest> findBytest(Long programId, String testState)
			throws Exception {
		List<EEvaluationTest> test = null;
		test = testDao.findByCondition(programId, testState);
		return test;
	}
	/**
	   * 根据条件查询评测试卷
	   * @param id
	   * @return
	   */
	public List<EEvaluationTest> findByCondition(Long programId,String testState) throws Exception {
		List<EEvaluationTest> test = null;
		try{
			test = testDao.findByCondition(programId, testState);
			if(test.size()==0){
				return test;
			}
			List<EEvaluationTestQuestion> questions = questionDao.findByTestId(test.get(0).getTestId());
			test.get(0).setTestQuestions(questions);
			for(int i = 0; i < questions.size(); i++) {
				EEvaluationTestQuestion question = questions.get(i);
				List<ETestQuestionOption> options = optionDao.findByQuestionId(question.getQuestionId());
				question.setOptions(options);
			}
		}catch(Exception e){
            throw new Exception((new StringBuilder("根据试卷ID查询失败")).append(test.get(0).getTestId()).toString());
		}
		return test;
	}
	/**
	 * 删除填写保存试卷 根据填写试卷ID
	 * */
	public void  delect(Long recordId){
		try{
			List<EEvaluationAnswer> questions = questionDao.findByRecordId(recordId);
			
			for(int i = 0; i < questions.size(); i++) {
				EEvaluationAnswer question =questions.get(i);
				optionDao.delByAnswerRecordId(question.getAnswerRecordId());
			}
			questionDao.delByRecordId(recordId);
			testDao.delect(recordId);
		}catch(Exception e){
			log.error((new StringBuilder("评测试卷删除失败")).append(recordId).toString(), e);
		}
	};
	/**
	 * 保存用户已填写的评测试卷
	 * */
	public Long save(EEvaluationRecord record) throws Exception{
		Long id = 0L;
		id = testDao.save(record);
		for(int i=0;i<record.getAnswers().size();i++){
			EEvaluationAnswer answer=record.getAnswers().get(i);
			answer.setRecord(record);
			questionDao.save(answer);
			if(answer.getOptions()!=null&&!"".equals(answer.getOptions())){
				for(int j = 0; j < answer.getOptions().size(); j++) {
					EEvaluationOption option = answer.getOptions().get(j);
					option.setAnswer(answer);
					optionDao.save(option);
				}	
			}
			
		}
		return id;
	}
	/**
	 * 根据试卷Id查询已填写评测试卷是否存在
	 * */
	public List<EEvaluationRecord> findByTestId(Long testId,Long UserId) throws Exception {
		// TODO Auto-generated method stub
		List<EEvaluationRecord> records=null;
		records = testDao.findByTestId(testId,UserId);
		return records;
	}
	/**
	 * 查看用户评测试卷答题情况
	 * */
	public EEvaluationRecord findByRecordtestId(Long id,Long userId){
		List<EEvaluationRecord> records=null;
		EEvaluationRecord record = null;
		EEvaluationTest test = null;
		try{
		records = testDao.findByTestId(id,userId);
		record=records.get(0);
		test=testDao.findById(id);
		List<EEvaluationAnswer> answers = questionDao.findByRecordId(record.getRecordId());
		List<EEvaluationTestQuestion> questions = questionDao.findByTestId(id);
		test.setTestQuestions(questions);
		record.setTest(test);
		record.setAnswers(answers);
		for(int i = 0; i < questions.size(); i++) {
		 	EEvaluationTestQuestion question = questions.get(i);
			List<ETestQuestionOption> testoptions = optionDao.findByQuestionId(question.getQuestionId());
			question.setOptions(testoptions);
		}
		for(int i = 0; i<answers.size();i++){
			EEvaluationAnswer answer = answers.get(i);
			List<EEvaluationOption> recordoptions = optionDao.findByAnswer(answer.getAnswerRecordId());
			List<ETestQuestionOption> testoptions = optionDao.findByQuestionId(answer.getQuestionId());
			
			for(int m=0;m<testoptions.size();m++){
				for(int n=0;n<recordoptions.size();n++){
						if(testoptions.get(m).getOptionId().equals(recordoptions.get(n).getOptionId())){
							testoptions.get(m).setChangeState("1");
							break;
						}else{
							testoptions.get(m).setChangeState("0");
						}
					}
				testoptions.get(m).setSequence(Long.valueOf(m+1));
			}
			answer.setOptions(recordoptions);
		}
		
	}catch(Exception e){
		log.error((new StringBuilder("根据试卷ID查询失败")).append(id).toString(), e);
        (new StringBuilder("根据试卷ID查询失败")).append(id).toString();
	}
		return record;
	};
	
	
	IEvaluationTestDao testDao;
	ITestQuestionDao questionDao;
	ITestQuestionOPtionDao optionDao;
	public IEvaluationTestDao getTestDao() {
		return testDao;
	}
	public void setTestDao(IEvaluationTestDao testDao) {
		this.testDao = testDao;
	}
	public ITestQuestionDao getQuestionDao() {
		return questionDao;
	}
	public void setQuestionDao(ITestQuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	public ITestQuestionOPtionDao getOptionDao() {
		return optionDao;
	}
	public void setOptionDao(ITestQuestionOPtionDao optionDao) {
		this.optionDao = optionDao;
	}
	

	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.service.Imp.TestServiceImpl");
	
	
}

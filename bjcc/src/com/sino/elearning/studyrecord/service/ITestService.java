package com.sino.elearning.studyrecord.service;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;

public interface ITestService {
	/**
	 * 根据条件查询是否存在评测试卷
	 * */
	public abstract List<EEvaluationTest> findBytest(Long programId,String testState) throws Exception;
	/**
	   * 根据条件查询评测试卷
	   * @param id
	   * @return
	   */
	public abstract List<EEvaluationTest> findByCondition(Long programId,String testState) throws Exception;
	
	/**
	 * 保存用户已填写的评测试卷
	 * */
	public abstract Long save(EEvaluationRecord record) throws Exception;
	
	/**
	 * 删除填写保存试卷 根据填写试卷ID
	 * */
	public abstract void  delect(Long recordId)throws Exception;
	/**
	 * 根据试卷Id查询已填写课程评测试卷
	 * */
	public abstract List<EEvaluationRecord> findByTestId(Long testId,Long UserId) throws Exception;
	/**
	 * 查看用户评测试卷答题情况
	 * */
	public abstract EEvaluationRecord findByRecordtestId(Long id,Long userId) throws Exception; 
}

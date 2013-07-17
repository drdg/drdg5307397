package com.sino.elearning.studyrecord.Dao;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;

public interface IEvaluationTestDao {
	/**
	 * 根据条件查询课程评测试卷
	 * */
	public abstract List<EEvaluationTest> findByCondition(Long programId,String testState);
	/**
	 * 根据评测试卷Id 查询评测试卷
	 * */
	public abstract EEvaluationTest findById(Long Id);
	/**
	 * 向EEvaluationRecord表中保存已填写的试卷
	 * */
	public abstract Long save(EEvaluationRecord record);
	/**
	 * 根据试卷Id查询 已保存课程评测试卷
	 * */
	//public abstract List<EEvaluationRecord> findBy(Long testId,Long UserId);
	/**
	 * 根据试卷Id查询已填写课程评测试卷
	 * */
	public abstract List<EEvaluationRecord> findByTestId(Long testId,Long UserId);
	/**
	 * 根据填写问卷Id 删除保存问卷
	 * */
	public abstract void delect(Long recordId);
}

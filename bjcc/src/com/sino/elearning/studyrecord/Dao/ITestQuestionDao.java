package com.sino.elearning.studyrecord.Dao;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EEvaluationAnswer;
import com.sino.elearning.studyrecord.bean.EEvaluationTestQuestion;

public interface ITestQuestionDao {
	/**
	   * 查询所有问题 根据问卷模版ID
	   * @return
	   */
	  public abstract List<EEvaluationTestQuestion> findByTestId(Long testId);
	/**
	 * 向EEvaluationAnswer表中保存 问题信息
	 * */
	  public abstract Long save(EEvaluationAnswer answer);
	  /**
	   * 查询所有问题 根据填写问卷ID
	   * @return
	   */
	  public abstract List<EEvaluationAnswer> findByRecordId(Long recordId);
	  /**
	   * 删除所有问题 根据填写问卷ID
	   * @return
	   */
	  public abstract void delByRecordId(final Long recordId);
}

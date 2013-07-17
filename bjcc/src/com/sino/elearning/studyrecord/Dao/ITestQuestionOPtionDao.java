package com.sino.elearning.studyrecord.Dao;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EEvaluationOption;
import com.sino.elearning.studyrecord.bean.ETestQuestionOption;

public interface ITestQuestionOPtionDao {
	 
	  /**
		 * 查询问题选项 根据问题ID
		 * @param id
		 */
	 public abstract List<ETestQuestionOption> findByQuestionId(Long questionId);
	 /**
	  *  向EEvaluationOption表中 保存用户选择的选项信息
	  * */
	 public abstract Long save(EEvaluationOption option);
	 /**
		 * 查询用户选择问题选项 根据答题问题ID
		 * @param idfindByQuestionId
		 */
	public abstract List<EEvaluationOption> findByAnswer(Long QuestionId);
	/**
	 * 删除用户选择问题选项 根据答题问题ID
	 * @param idfindByQuestionId
	 */
	public abstract void delByAnswerRecordId(Long AnswerRecordId);
}

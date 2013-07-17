package com.sino.elearning.studyrecord.service;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EResultsRecord;

public interface IResultRecordService {
	/**
	 * 保存用户的学习成效
	 * */
	public abstract long saveResult(EResultsRecord result) throws Exception;
	/**
	 * 根据资源ID及学习类型  查询用户学习成效
	 * */
	public List<EResultsRecord> findByProId(long id,String studyType,Long userId)throws Exception;
	/**
	 * 修改用户填写的学习成效
	 *
	 **/
	public abstract void updateResult(EResultsRecord result) throws Exception;
}

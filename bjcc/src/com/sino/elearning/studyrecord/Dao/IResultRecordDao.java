package com.sino.elearning.studyrecord.Dao;

import java.util.List;

import com.sino.elearning.studyrecord.bean.EResultsRecord;

public interface IResultRecordDao {
	/**
	 * 根据用户的学习记录填写用户学习成效
	 * */
	public abstract long saveResult(EResultsRecord result);
	/**
	 * 根据资源ID及学习类型  查询用户学习成效
	 * */
	public abstract List<EResultsRecord> findByProId(long id,String studyType,Long userId);
	/**
	 * 修改用户填写成效
	 * */
	public abstract void updateResult(EResultsRecord result);
}

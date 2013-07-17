package com.sino.elearning.studyrecord.Dao;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.bean.EAttendee;
import com.sino.elearning.studyrecord.bean.ETrainMessage;


public interface IRecordDao {
	/**
	 * 查询用户个体学习记录  查询全部个体学习记录
	 * */
	public abstract List<SinoUserBehavior> findAll(PaginationBean page);
	/**
	 * 根据用户Id 查看该用户的全部个体学习记录
	 * */
	public abstract List<SinoUserBehavior> findByUserId(PaginationBean page,long userId);
	/**
	 * 根据用户个体学习记录Id 查看具体个体学习记录
	 * */
	public abstract SinoUserBehavior findById(long id);
	/**
	 * 查询用户集体学习记录  查询全部个体学习记录
	 * */
	public abstract List<ETrainMessage> findTrainAll(PaginationBean page);
	/**
	 * 根据用户Id 查看该用户的全部集体学习记录
	 * */
	public abstract List<ETrainMessage> findByTrainUserId(PaginationBean page,long userId);
	/**
	 * 根据用户个体学习记录Id 查看具体集体学习记录
	 * */
	public abstract ETrainMessage findByTrainId(long id);
	
	/**
	 * 根据用户根据用户名   查看用户集体学习记录ID
	 * */
	public abstract List<EAttendee> findByUserNM(PaginationBean page,String userNM);
	/**
	 * 根据条件查询  个体用户学习记录
	 * */
	public abstract List<SinoUserBehavior> findByUserText(PaginationBean page,long userId,String textfield);
	/**
	 *根据条件查询    用户集体学习记录
	 * */
	public abstract List<ETrainMessage> findByTrainText(PaginationBean page,long userId,String textfield);
	
	/**
	 * 根据参加人用户ID查询集体记录
	 * @param page
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public abstract List<ETrainMessage> findByAttendUserId(PaginationBean page,Long userId) throws Exception;
}

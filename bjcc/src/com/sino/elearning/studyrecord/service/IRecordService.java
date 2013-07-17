package com.sino.elearning.studyrecord.service;

import java.math.BigDecimal;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.bean.EAttendee;
import com.sino.elearning.studyrecord.bean.ETrainMessage;


public interface IRecordService {
	/**
	 * 查询用户学习记录  查询全部学习记录
	 * */
	public abstract List<SinoUserBehavior> findAll(PaginationBean page) throws Exception;
	/**
	 * 根据用户Id 查看该用户的全部学习记录
	 * */
	public abstract List<SinoUserBehavior> findByUserId(PaginationBean page,long userId) throws Exception;
	/**
	 * 根据用户学习记录Id 查看具体学习记录
	 * */
	public abstract SinoUserBehavior findById(long id) throws Exception;
	/**
	 * 查询用户集体学习记录  查询全部集体学习记录
	 * */
	public abstract List<ETrainMessage> findTrainAll(PaginationBean page) throws Exception;
	/**
	 * 根据用户Id 查看该用户的全部集体学习记录
	 * */
	public abstract List<ETrainMessage> findByTrainUserId(PaginationBean page,long userId) throws Exception;
	/**
	 * 根据用户集体学习记录Id 查看具体集体学习记录
	 * */
	public abstract ETrainMessage findByTrainId(long id) throws Exception;
	/**
	 * 根据用户根据用户名   查看用户集体学习记录ID
	 * */
	public abstract List<EAttendee> findByUserNM(PaginationBean page,String userNM) throws Exception;
	/**
	 * 根据条件查询  个体用户学习记录
	 * */
	public abstract List<SinoUserBehavior> findByUserText(PaginationBean page,long userId,String textfield) throws Exception;
	/**
	 *根据条件查询    用户集体学习记录
	 * */
	public abstract List<ETrainMessage> findByTrainText(PaginationBean page,long userId,String textfield) throws Exception;
	
	/**
	 * 根据参加人用户ID查询集体记录
	 * @param page
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ETrainMessage> findByAttendUserId(PaginationBean page,Long userId) throws Exception;
}

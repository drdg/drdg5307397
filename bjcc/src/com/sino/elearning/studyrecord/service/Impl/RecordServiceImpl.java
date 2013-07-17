package com.sino.elearning.studyrecord.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.Dao.IRecordDao;
import com.sino.elearning.studyrecord.bean.EAttendee;
import com.sino.elearning.studyrecord.bean.EEvaluationTestQuestion;
import com.sino.elearning.studyrecord.bean.ETestQuestionOption;
import com.sino.elearning.studyrecord.bean.ETrainMessage;
import com.sino.elearning.studyrecord.service.IRecordService;

public class RecordServiceImpl implements IRecordService{
	/**
	 * 查询所有用户的个体学习记录   
	 * */
	public List<SinoUserBehavior> findAll(PaginationBean page) throws Exception {
		// TODO Auto-generated method stub
		return recordDao.findAll(page);
	}
	/**
	 * 根据学习记录Id 查看用户的个体学习记录情况
	 * 
	 * */
	public SinoUserBehavior findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return recordDao.findById(id);
	}
	/**
	 * 根据用户Id 查询用户 的个体学习记录
	 * */
	public List<SinoUserBehavior> findByUserId(PaginationBean page,long userId)
			throws Exception {
		// TODO Auto-generated method stub
		return recordDao.findByUserId(page,userId);
	}
	/**
	 * 根据用户个体学习记录Id 查看具体集体学习记录
	 * */
	public ETrainMessage findByTrainId(long id)  throws Exception{
		// TODO Auto-generated method stub
		return recordDao.findByTrainId(id);
	}
	/**
	 * 根据用户根据用户名   查看用户集体学习记录ID
	 * */
	public List<EAttendee> findByUserNM(PaginationBean page, String userNM)
			throws Exception {
		List<EAttendee> list=null;
		list = recordDao.findByUserNM(page, userNM);
		if(list.size()==0){
			return list;
		}
		for(int i = 0; i < list.size(); i++) {
			EAttendee attendee = list.get(i);
			ETrainMessage message = recordDao.findByTrainId(attendee.getTrainId());
			if(message.getMark().equals("1")){
				attendee.setTrainMessage(message);
			}
		}
		return list;
	}
	/**
	 * 根据用户Id 查看该用户的全部集体学习记录
	 * */
	public List<ETrainMessage> findByTrainUserId(PaginationBean page,long userId) {
		// TODO Auto-generated method stub
		return recordDao.findByTrainUserId(page,userId);
	}
	/**
	 * 查询用户集体学习记录  查询全部集体学习记录
	 * */
	public List<ETrainMessage> findTrainAll(PaginationBean page) {
		// TODO Auto-generated method stub
		return recordDao.findTrainAll(page);
	}
	/**
	 *根据条件查询    用户集体学习记录
	 * */
	public List<ETrainMessage> findByTrainText(PaginationBean page,
			long userId, String textfield) throws Exception {
		// TODO Auto-generated method stub
		return recordDao.findByTrainText(page, userId, textfield);
	}
	/**
	 * 根据条件查询  个体用户学习记录
	 * */
	public List<SinoUserBehavior> findByUserText(PaginationBean page,
			long userId, String textfield) throws Exception {
		// TODO Auto-generated method stub
		return recordDao.findByUserText(page, userId, textfield);
	}

	/**
	 * 根据参加人用户ID查询集体记录
	 * @param page
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ETrainMessage> findByAttendUserId(PaginationBean page,Long userId) throws Exception {
		List<ETrainMessage> list = null;
		try {
			list = recordDao.findByAttendUserId(page, userId);
		}catch(Exception e) {
			throw e;
		}
		return list;
	}
	
	IRecordDao recordDao;
	public IRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	
}

package com.sino.bjcc.userBehavior.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.userBehavior.dao.IUserBehaviorDao;
import com.sino.bjcc.userBehavior.service.IUserBehaviorService;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;

public class UserBehaviorServiceImpl implements IUserBehaviorService {
	private IUserBehaviorDao userBehaviorDao;

	public IUserBehaviorDao getUserBehaviorDao() {
		return userBehaviorDao;
	}

	public void setUserBehaviorDao(IUserBehaviorDao userBehaviorDao) {
		this.userBehaviorDao = userBehaviorDao;
	}
	
	@Transactional(readOnly=false)
	public void addUserBehavior(SinoUserBehavior sinoUserBehavior) {
		//sinoUserBehavior.set
		userBehaviorDao.addUserBehavior(sinoUserBehavior);
		
	}

	

}

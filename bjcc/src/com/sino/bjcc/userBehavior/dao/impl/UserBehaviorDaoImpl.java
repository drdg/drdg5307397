package com.sino.bjcc.userBehavior.dao.impl;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.userBehavior.dao.IUserBehaviorDao;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;

public class UserBehaviorDaoImpl extends PersistenceBase implements
		IUserBehaviorDao {

	public void addUserBehavior(SinoUserBehavior sinoUserBehavior) {
		this.save(sinoUserBehavior);
		
	}

}

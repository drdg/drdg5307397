package com.sino.bjcc.quxianRank.persistence.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.quxianRank.persistence.IRankDao;
import com.sino.bjcc.tuwenLive.bean.LiveSubject;

public class RankDaoImpl extends PersistenceBase implements IRankDao {

	//获取区县排行List
	public List rankList() {
		String hql="SELECT sfd.deptname FROM SinoFlowDept as sfd, SinoVideoShow as svs where sfd.isarea='5' and svs.type=02 and svs.departmentId=sfd.deptid  order by svs.viewDuration desc ";
		return (List)executeQuery(hql,5);
	}

}

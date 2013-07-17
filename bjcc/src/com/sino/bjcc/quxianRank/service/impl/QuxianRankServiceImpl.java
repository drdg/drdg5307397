package com.sino.bjcc.quxianRank.service.impl;

import java.util.List;

import com.sino.bjcc.quxianRank.bean.SinoFlowDept;
import com.sino.bjcc.quxianRank.persistence.IRankDao;
import com.sino.bjcc.quxianRank.service.IQuxianRankService;


public class QuxianRankServiceImpl implements IQuxianRankService{
	
	//区县排行的Dao
	private IRankDao rankDao=null;

	public IRankDao getRankDao() {
		return rankDao;
	}

	public void setRankDao(IRankDao rankDao) {
		this.rankDao = rankDao;
	}

	//获取区县排行的list
	public List<SinoFlowDept> RankList() {
		
		return rankDao.rankList();
	}
}

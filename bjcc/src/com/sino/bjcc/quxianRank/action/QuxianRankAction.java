package com.sino.bjcc.quxianRank.action;


import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.quxianRank.service.IQuxianRankService;

public class QuxianRankAction extends BaseAction{

	private List list;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	private IQuxianRankService quxianList; 
	
	public IQuxianRankService getQuxianList() {
		return quxianList;
	}
	public void setQuxianList(IQuxianRankService quxianList) {
		this.quxianList = quxianList;
	}
	
	//获取区县排行列表
	public String RankList(){
		list=quxianList.RankList();

		return SUCCESS;
	}
}

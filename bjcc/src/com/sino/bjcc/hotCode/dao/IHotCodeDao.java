package com.sino.bjcc.hotCode.dao;

import java.util.List;

import com.sino.bjcc.hotCode.bean.HotCode;

public interface IHotCodeDao {
	
	/**
	 * 获取全部上线状态长城热词
	 */
	public List<HotCode> getList();
	
}

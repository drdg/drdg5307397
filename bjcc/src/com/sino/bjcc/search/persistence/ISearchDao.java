package com.sino.bjcc.search.persistence;

import java.util.List;

import com.sino.bjcc.search.bean.SKeyCode;
import com.sino.bjcc.search.bean.SKeyDetail;

public interface ISearchDao {

	/**
	 * 方法说明：查找关键词
	 */
	public List<SKeyCode> findSkeyCode(String keyCode);
	
	/**
	 * 方法说明：更新关键词
	 */
	public void updateKeyCode(SKeyCode keyCode);

	/**
	 * 方法说明：新增关键词
	 */
	public long createKeyCode(SKeyCode keyCode);

	/**
	 * 方法说明：新增关键词查找履历
	 */
	public long createKeyDetail(SKeyDetail keyDetail);
	
}

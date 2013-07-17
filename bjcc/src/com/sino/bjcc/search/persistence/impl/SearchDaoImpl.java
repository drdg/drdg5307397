package com.sino.bjcc.search.persistence.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.search.bean.SKeyCode;
import com.sino.bjcc.search.bean.SKeyDetail;
import com.sino.bjcc.search.persistence.ISearchDao;

public class SearchDaoImpl extends PersistenceBase implements ISearchDao {

	/**
	 * 方法说明：查找关键词
	 */
	@SuppressWarnings("unchecked")
	public List<SKeyCode> findSkeyCode(String keyCode) {
		String hql="from SKeyCode s where s.name=:name";
		List<SKeyCode> keyCodeList = executeQuery(hql, new SqlParameter("name",keyCode));
		return keyCodeList;
	}

	/**
	 * 方法说明：新增关键词查找履历
	 */
	public long createKeyDetail(SKeyDetail keyDetail) {
		return Long.parseLong(save(keyDetail).toString());
	}

	/**
	 * 方法说明：新增关键词
	 */
	public long createKeyCode(SKeyCode keyCode) {
		return Long.parseLong(save(keyCode).toString());
	}

	/**
	 * 方法说明：更新关键词
	 */
	public void updateKeyCode(SKeyCode keyCode) {
		update(keyCode);
	}

}

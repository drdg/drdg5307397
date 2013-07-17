package com.sino.bjcc.hotCode.dao.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.hotCode.bean.HotCode;
import com.sino.bjcc.hotCode.dao.IHotCodeDao;

public class HotCodeDao extends PersistenceBase implements IHotCodeDao {

	/**
	 * 方法说明：获取所有热词
	 */
	@SuppressWarnings("unchecked")
	public List<HotCode> getList() {
		String hql="from HotCode hc where hc.status='1'";
		return (List<HotCode>)executeQuery(hql);
	}

}

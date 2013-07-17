package com.sino.bjcc.media.dao.impl;

import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.media.bean.ListBoxItem;
import com.sino.bjcc.media.dao.IListBoxItemDao;

public class ListBoxItemDao extends PersistenceBase implements IListBoxItemDao {

	/**
	 * 方法说明：获取所有条件项目
	 */
	@SuppressWarnings("unchecked")
	public List<ListBoxItem> getList() {
		String hql = "from ListBoxItem ";
		return (List<ListBoxItem>) executeQuery(hql);
	}
	
}

package com.sino.bjcc.media.dao;

import java.util.List;

import com.sino.bjcc.media.bean.ListBoxItem;

public interface IListBoxItemDao {
	/**
	 * 方法说明：获取所有条件项目
	 */
	public List<ListBoxItem> getList();
}

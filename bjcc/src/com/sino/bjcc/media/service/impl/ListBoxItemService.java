package com.sino.bjcc.media.service.impl;

import java.util.List;

import com.sino.bjcc.media.dao.IListBoxItemDao;
import com.sino.bjcc.media.service.IListBoxItemService;

public class ListBoxItemService implements IListBoxItemService {
	private IListBoxItemDao itemDao;		//检索选项DAO
	/**
	 * 设置检索选项DAO
	 */
	public void setItemDao(IListBoxItemDao itemDao) {
		this.itemDao = itemDao;
	}
	/**
	 * 获取检索选项DAO
	 */
	public IListBoxItemDao getItemDao(){
		return this.itemDao;
	}
	
	/**
	 * 方法说明：获取所有条件项目
	 */
	@SuppressWarnings("unchecked")
	public List getList() {
		return getItemDao().getList();
	}
}

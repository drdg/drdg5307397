package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Car;
import com.aps.db.model._Route;

public interface Route{
	
	/**
	 * 增
	 */
	public boolean doInster(_Route route);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(ArrayList<_Route> obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Route> doSelect();
	
	/**
	 * 分页方式查询
	 */

	public ArrayList<_Route> doSelectPage(FenPage fpage);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Route> doSelect(_Route alobj);
	
	
}

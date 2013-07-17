package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Car;

public interface Car{
	
	/**
	 * 增
	 */
	public boolean doInster(ArrayList<_Car> alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(ArrayList<_Car> obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Car> doSelect();
	
	/**
	 * 分页方式查询
	 */

	public ArrayList<_Car> doSelectPage(FenPage fpage);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Car> doSelect(_Car car);
	
	
	
}

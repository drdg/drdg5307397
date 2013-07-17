package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model._Dea;

public interface Dea{
	
	/**
	 * 增
	 */
	public boolean doInster(_Dea alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(ArrayList<_Dea> obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Dea> doSelect();
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Dea> doSelect(ArrayList<_Dea> alobj);
	
}

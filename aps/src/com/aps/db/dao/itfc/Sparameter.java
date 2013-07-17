package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model._Sparameter;

public interface Sparameter{
	
	/**
	 * 增
	 */
	public boolean doInster(_Sparameter alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(ArrayList<_Sparameter> obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Sparameter> doSelect();
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Sparameter> doSelect(ArrayList<_Sparameter> alobj);
	
}

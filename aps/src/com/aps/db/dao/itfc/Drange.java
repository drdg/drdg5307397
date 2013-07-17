package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model.V_Dpoint_Drange;
import com.aps.db.model._Drange;

public interface Drange{
	
	/**
	 * 增
	 */
	public boolean doInster(_Drange alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(_Drange obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<V_Dpoint_Drange> doSelect(FenPage page);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Drange> doSelect(_Drange alobj);
	
}

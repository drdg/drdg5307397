package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.CapacityS;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Capacitys;
import com.aps.db.model._Capacity;

public interface Capacity{
	
	/**
	 * 增
	 */
	public boolean doInster(_Capacity alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(_Capacity obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<V_Capacitys> doSelect(FenPage page);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Capacity> doSelect(_Capacity alobj);
	
	/**
	 * 装载信息到设置运力页面
	 */
	public ArrayList<CapacityS> doGetAllToCap();
}

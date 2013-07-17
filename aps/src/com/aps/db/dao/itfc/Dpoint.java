package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Car;
import com.aps.db.model._Dpoint;

public interface Dpoint{
	
	/**
	 * 增
	 */
	public boolean doInster(_Dpoint alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(ArrayList<_Dpoint> obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Dpoint> doSelect();
	
	/**
	 * 分页方式查询
	 */
	public ArrayList<_Dpoint> doSelectPage(FenPage fpage);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Dpoint> doSelect(ArrayList<_Dpoint> alobj);
	
	/**
	 * 查看详情
	 */
	public ArrayList<V_EmpDetail> doSelectDetail(FenPage fpage);
	
}

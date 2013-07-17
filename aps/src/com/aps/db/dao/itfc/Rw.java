package com.aps.db.dao.itfc;

import java.util.ArrayList;

import com.aps.db.model.FenPage;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;

public interface Rw{
	
	/**
	 * 增
	 */
	public boolean doInster(_Rw alobj);
	
	/**
	 * 删
	 */
	public boolean doDelete(String id);	
	
	/**
	 * 改
	 */
	public boolean doUpdate(_Rw obj);
	
	/**
	 * 查
	 * 无条件，分页方式，全查
	 */
	public ArrayList<_Rw> doSelect(FenPage page);
	
	/**
	 * 查
	 * 有条件，分页方式，全查(根据传进来的参数“组串”，在执行)
	 */
	public ArrayList<_Rw> doSelect(_Rw alobj);
	
	/**
	 * 查询出路线起点信息，装载到配送范围页面
	 */
	public ArrayList<_Route> doSelectPointToRw();
	
}

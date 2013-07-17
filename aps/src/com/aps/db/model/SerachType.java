package com.aps.db.model;

public class SerachType {
	
	/**
	 * true 代表高级搜索
	 * false 代表普通搜索
	 **/
	private boolean stype;

	public boolean isStype() {
		return stype;
	}

	public void setStype(boolean stype) {
		this.stype = stype;
	}
}

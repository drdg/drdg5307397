package com.sino.bjcc.common.db;

public class SqlParameter {

	public SqlParameter(String key,Object obj){
		setParamKey(key);
		setParamVal(obj);
	}

	private String paramKey = null;
	
	private Object paramVal = null;

	public String getParamKey() {
		return paramKey;
	}

	private void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public Object getParamVal() {
		return paramVal;
	}

	private void setParamVal(Object paramVal) {
		this.paramVal = paramVal;
	}
	
}

package com.sino.bjcc.common.dao;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IDateTimeDao {

	public String getDbNowStr();
	
}

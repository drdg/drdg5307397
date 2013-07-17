package com.sino.bjcc.timetable.service;

import java.util.List;

public interface ITimeTableService {
	
	//获取课程表类型文章访问路径
	public List getTimeTable(String date,int schemaId);

}

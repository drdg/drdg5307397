package com.sino.bjcc.timetable.persistence;

import java.util.Date;
import java.util.List;

public interface ITimeTableDao {
	
	//获取课程预告(课程表)类型的文章访问路径
	public List getURL(String date,int schemaId);

}

package com.sino.bjcc.timetable.persistence.impl;
import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.timetable.persistence.ITimeTableDao;

public class TimeTableDaoImpl extends PersistenceBase implements ITimeTableDao{
	
	//获取课程预告(课程表)类型的文章访问路径
	public List getURL(String date,int schemaId) {
		
		String sql="select test.articleid,test.childpath,cc1.path from cms_channel cc1,(select cc.path as childpath,ca.id as articleid,cc.id as childid,cc.parentid as parentid from cms_article ca,cms_channel cc,cms_contentproperty ccp where ca.parentid=cc.id and ccp.schemaid=:schemaid and ccp.articleid=ca.id and  to_char(ccp.datevalue,'YYYY/MM/DD')=:datevalue) test where cc1.id=test.parentid";			
		List pathList =  (List)executeSqlQuery(sql,new SqlParameter("datevalue",date),new SqlParameter("schemaid",schemaId));			
		return pathList;
		
		
	}

}

package com.sino.bjcc.timetable.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.timetable.persistence.ITimeTableDao;
import com.sino.bjcc.timetable.service.ITimeTableService;

public class TimeTableServiceImpl implements ITimeTableService{
	
	
	private ITimeTableDao timeTableDao;//课程表类型的dao

	public ITimeTableDao getTimeTableDao() {
		return timeTableDao;
	}



	public void setTimeTableDao(ITimeTableDao timeTableDao) {
		this.timeTableDao = timeTableDao;
	}



	public List getTimeTable(String date, int schemaId) {
		
		
		List<Object[]> list = timeTableDao.getURL(date, schemaId);
		List<String> listTimeTable = new ArrayList<String>();
		
		if(list.size()!=0){
			String aticleId;
			String path;
			String parentPath;
			
			for(Object[] objs : list ){
				
				aticleId = objs[0].toString();
				path = objs[1].toString();
				parentPath = objs[2].toString();
				
				listTimeTable.add(aticleId);
				listTimeTable.add(path);
				listTimeTable.add(parentPath);
				
				
			}
			
		}else{ }
		return listTimeTable;
	}

}

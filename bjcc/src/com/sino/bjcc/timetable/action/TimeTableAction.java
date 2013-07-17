package com.sino.bjcc.timetable.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.timetable.service.ITimeTableService;


public class TimeTableAction extends BaseAction{
	
	//课程表类型的id
	private static final int SCHEMAID=12;
	
	//课程表的Service
	private ITimeTableService timeTableService;
	
	public void setTimeTableService(ITimeTableService timeTableService) {
		this.timeTableService = timeTableService;
	}
    
	//课程表信息List
	private List timeTableList;
	

	public List getTimeTableList() {
		return timeTableList;
	}


	public void setTimeTableList(List timeTableList) {
		this.timeTableList = timeTableList;
	}
	//文章path、文章id、父栏目path
	private String aticleId;
	private String path;
	private String parentPath;
	
	public String getAticleId() {
		return aticleId;
	}

	public void setAticleId(String aticleId) {
		this.aticleId = aticleId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	//获取课程预告(课程表)类型的文章访问路径
	public String timeTableURL(){//schemaId是扩展字段的id号
		String date = ServletActionContext.getRequest().getParameter("date");
		
		this.timeTableList=timeTableService.getTimeTable(date, SCHEMAID);
		if(timeTableList.size()!=0){
			
			aticleId=(String) timeTableList.get(0);

			path=(String) timeTableList.get(1);

			parentPath = (String)timeTableList.get(2);

			
		}

		return SUCCESS;
		
	}

}

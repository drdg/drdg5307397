package com.sino.bjcc.userBehavior.action;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.userBehavior.service.IUserBehaviorService;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;

public class UserBehaviorAction extends BaseAction implements ServletRequestAware{
	
	HttpServletRequest request;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	private IUserBehaviorService userBehaviorService;

	
	public void setUserBehaviorService(IUserBehaviorService userBehaviorService) {
		this.userBehaviorService = userBehaviorService;
	}

	//private SinoUserBehavior behavior;

	//public SinoUserBehavior getBehavior() {
	//	return behavior;
	//}

	//public void setBehavior(SinoUserBehavior behavior) {
	//	this.behavior = behavior;
	//}

	public String addUserBehavior() throws UnknownHostException, ParseException, UnsupportedEncodingException{
		System.out.println("--------------");
		//request.setCharacterEncoding("utf-8");
		SinoUserBehavior behavior = new SinoUserBehavior();
		long articleID = Long.parseLong(getReqParam("articleID"));
		
		long channelID = Long.parseLong(getReqParam("channelID"));
		
		String ip = getClientIp();
		behavior.setUserIp(ip);//用户访问来源ip地址
		
		if (ip.substring(0, 3).equals("172")) {
			behavior.setNetType(1);//用户使用网络类型
		}else {
			behavior.setNetType(2);
		}
		
		Cookie[] datecookies = request.getCookies();
		Cookie startDateCookie = null;
		for (int i = 0; i < datecookies.length; i++) {
			if (datecookies[i].getName().equals("startDate"+articleID)) {
				startDateCookie = datecookies[i];
			}
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = format.parse(startDateCookie.getValue());
		
		behavior.setVisitStarttime(startDate);//观看视频资源开始时间
		
		 Cookie cookie = new Cookie("startDate"+articleID, null);   
	     cookie.setMaxAge(0);   
	     //cookie.setPath(path);//根据你创建cookie的路径进行填写      
	     HttpServletResponse response = ServletActionContext.getResponse();
	     response.addCookie(cookie);   

		long id = getLoginUserId();
		behavior.setUserId(id);//用户标示
		
		Date endDate = new Date();
		behavior.setVisitEndtime(endDate);//观看视频资源结束时间
		
		behavior.setItemId(channelID);//资源所属栏目ID
		
		String channelTitle = getReqParam("channelName");
		if (channelTitle.substring(channelTitle.length()-3)=="_LM") {
			behavior.setItemType(1);//资源所属栏目类型
			behavior.setResourcesType(2);//用户访问资源类型
		}else if (channelTitle.substring(channelTitle.length()-3)=="_ZB") {
			behavior.setItemType(3);
			behavior.setResourcesType(3);//用户访问资源类型
		}else {
			behavior.setItemType(2);
			behavior.setResourcesType(2);//用户访问资源类型
		}
		int type = Integer.valueOf(getReqParam("type"));
		behavior.setResourcesId(articleID);//用户访问资源标识
		
		String articleName = getReqParam("articleName");
		
		behavior.setResourcesName(articleName);//用户访问资源名称
		behavior.setCreateTime(endDate);//本记录创建时间

		long diff = endDate.getTime()-startDate.getTime();
		int diffmin = (int)diff/(1000*60);
		behavior.setVisitLong(diffmin);
		userBehaviorService.addUserBehavior(behavior);
		
		return SUCCESS;
	}
/*
	public long getUserID(){
		long userID = 0;
		Cookie[] cookies = request.getCookies();
		String result = "";
		for(int i=0;i<cookies.length;i++){ 
			if(cookies[i].getName().equals("bjcc_userid")){
				result = cookies[i].getValue();
	    		break; 
	  		} 
		}
		if (result!="") {
			userID = Long.parseLong(result.split(",")[0]);
			//String userName = result.split(",")[1];
		}
		return userID;
	}
*/
}

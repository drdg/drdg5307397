package com.sino.bjcc.userBehavior.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.userBehavior.service.IUserBehaviorService;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;

public class WriteBehaviorAction extends BaseAction{
	private IUserBehaviorService userBehaviorService;

	public void setUserBehaviorService(IUserBehaviorService userBehaviorService) {
		this.userBehaviorService = userBehaviorService;
	}

	public String writeStartDate() throws Exception {
		int type = Integer.valueOf(getReqParam("type"));
		if(type == 1){
			SinoUserBehavior behavior = new SinoUserBehavior();
			
			long id = getLoginUserId();
			behavior.setUserId(id);//用户标示
			
			String ip = getClientIp();
			behavior.setUserIp(ip);//用户访问来源ip地址
			
			if (ip.substring(0, 3).equals("172")) {
				behavior.setNetType(1);//用户使用网络类型
			}else {
				behavior.setNetType(2);
			}
			
			long channelID = Long.parseLong(getReqParam("channelID"));
			behavior.setItemId(channelID);//资源所属栏目ID
			
			String channelTitle = getReqParam("channelName");
			if (channelTitle.substring(channelTitle.length()-3)=="_LM") {
				behavior.setItemType(1);//资源所属栏目类型
			}else {
				behavior.setItemType(2);
			}
			
			long articleID = Long.parseLong(getReqParam("articleID"));
			behavior.setResourcesId(articleID);//用户访问资源标识
			behavior.setResourcesType(type);//用户访问资源类型
			String articleName = getReqParam("articleName");
			
			behavior.setResourcesName(articleName);//用户访问资源名称
			behavior.setCreateTime(new Date());//本记录创建时间
			userBehaviorService.addUserBehavior(behavior);
		}else {
			long articleID = Long.parseLong(getReqParam("articleID"));
			String name = "startDate"+articleID;
			Date startDate = new Date();
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Cookie myCookie = new Cookie(name,format.format(startDate));
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(myCookie);
		}
		return SUCCESS;
	}

}

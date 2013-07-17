package com.sino.bjcc.common.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LiveOnlineUserListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		removeLiveUser(se.getSession(), 1);	//全国频道
		removeLiveUser(se.getSession(), 2);	//北京频道
		removeLiveUser(se.getSession(), 3);	//专题直播
	}

	/**
	 * 方法说明：session关闭时，移除application中的直播用户信息
	 */
	@SuppressWarnings("unchecked")
	private void removeLiveUser(HttpSession session,int liveType){
		ServletContext application = session.getServletContext();
		if (null == application.getAttribute("live_online_user" + liveType)) {
			return;
		}
		Map<String,Integer> userMap = (Map<String,Integer>)application.getAttribute("live_online_user" + liveType);
		if(userMap.containsKey(session.getId())){
			userMap.remove(session.getId());
		}
	}
	
}

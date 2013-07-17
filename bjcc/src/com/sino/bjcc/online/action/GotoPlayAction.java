package com.sino.bjcc.online.action;

import java.util.HashMap;
import java.util.Map;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.online.bean.LiveConfigBean;
import com.sino.bjcc.online.service.IPlayUserOnlineService;

@SuppressWarnings("serial")
public class GotoPlayAction extends BaseAction {

	/**直播在线用户超过设置的上限数**/
	private final String TOO_MANY_USER = "1";	
	private int siteId = 0;				//in:网站Id
	private String loginUrl = null;		//out:登录页面URL
	private String errorCode = null;    //out:不能播放视频的错误码
	private String needLogin = null;		//out:用户是否已经登录，每次都请求一次单点登录会使同一认证平台压力过大，添加此字段如果已经登录则不再请求单点登录
	
	/**
	 * 获取登录页面URL
	 */
	public String getLoginUrl() {
		return loginUrl;
	}
	/**
	 * 设置登录页面URL
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * 获取网站ID
	 */
	public int getSiteId() {
		return siteId;
	}
	/**
	 * 设置网站ID
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
	/**
	 * 获取不能观看视频的错误码
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * 设置不能观看视频的错误码
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 获取用户是否已经登录
	 */
	public String getNeedLogin() {
		return needLogin;
	}
	/**
	 * 设置用户是否已经登录
	 */
	public void setNeedLogin(String needLogin) {
		this.needLogin = needLogin;
	}

	private IPlayUserOnlineService onlineManager = null;	//视频在线用户Manager
	/**
	 * 获取视频在线用户Manager
	 */
	public IPlayUserOnlineService getOnlineManager() {
		return onlineManager;
	}
	/**
	 * 设置视频在线用户Manager
	 */
	public void setOnlineManager(IPlayUserOnlineService onlineManager) {
		this.onlineManager = onlineManager;
	}
	
	@SuppressWarnings("unchecked")
	public String executeIsLogin() throws Exception{
		if(!isLogin()){
			String windowLink = getReqParam("toUrl");
			setLoginUrl(PropertyUtil.getProperty("bjcc.login.url") + "?toUrl=" + windowLink);
			return "login";
		}
		String liveType = getReqParam("liveType");
		if(null==liveType || "".equals(liveType.trim())){
			//如果是点播的请求跳转到点播页面
			return SUCCESS;
		}
		LiveConfigBean liveConfig = getOnlineManager().getMaxLiveUser(getSiteId());
		if(null == liveConfig){
			return SUCCESS;
		}
		//直播时需要往application中放入直播在线用户sessionid用于标识直播在线用户数
		Object onlineUser = getSession().getServletContext().getAttribute("live_online_user" + liveType);
		if(null == onlineUser){
			onlineUser = new HashMap<String,Integer>();
			getSession().getServletContext().setAttribute("live_online_user" + liveType, onlineUser);
		}
		//直播在线用户数超过设定的上限数时，跳转到指定的URL
		if(liveConfig.getMaxLiveUser()>0 && liveConfig.getMaxLiveUser()<=((Map<String,Integer>)onlineUser).size()){
			setErrorCode(TOO_MANY_USER);
			setLoginUrl(liveConfig.getTransUrl());
			return "login";
		}
		//把当前直播用户记录到application
		((Map<String,Integer>)onlineUser).put(getSession().getId(),0);
		return SUCCESS;
	}
	
	/**
	 * 方法说明：用户是否已经登录，如果已经登录则不再请求单点登录，否则请求单点登录
	 */
	public String executeNeedLogin() throws Exception{
		if(!isLogin()){
			setNeedLogin(TOO_MANY_USER);
		}
		return SUCCESS;
	}
}

package com.sino.bjcc.online.bean;

public class LiveConfigBean {

	private int maxLiveUser = 0;		//直播在线用户最大上限数
	private String transUrl = null;		//超过上限数以后跳转到的URL

	/**
	 * 获取直播在线用户最大上限数
	 */
	public int getMaxLiveUser() {
		return maxLiveUser;
	}
	/**
	 * 设置直播在线用户最大上限数
	 */
	public void setMaxLiveUser(int maxLiveUser) {
		this.maxLiveUser = maxLiveUser;
	}

	/**
	 * 获取超过直播在线用户上限数后跳转的URL
	 */
	public String getTransUrl() {
		return transUrl;
	}
	/**
	 * 设置超过直播在线用户上限数后跳转的URL
	 */
	public void setTransUrl(String transUrl) {
		this.transUrl = transUrl;
	}
	
}

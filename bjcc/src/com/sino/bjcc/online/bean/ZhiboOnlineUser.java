package com.sino.bjcc.online.bean;

import java.util.Date;

public class ZhiboOnlineUser {

	private long id = 0;				//ID
	private String ip = null;			//用户IP
	private long userId = 0;			//用户ID
	private long orgId = 0;				//组织ID	
	private Date startTime = null;		//创建时间
	private Date endTime = null;		//最后修改时间
	private String siteType = null;		//网络来源
	private String liveType = null;		//直播频道
	private String liveTitle = null;	//直播标题
	
	/**
	 * 获取ID
	 */
	public long getId() {
		return id;
	}
	/**
	 * 设置ID
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 获取用户IP地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置用户IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 获取登录用户组织ID
	 */
	public long getOrgId() {
		return orgId;
	}
	/**
	 * 设置登录用户组织ID
	 */
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	
	/**
	 * 获取开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 获取结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 获取网络来源
	 */
	public String getSiteType() {
		return siteType;
	}
	/**
	 * 设置网络来源
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	
	/**
	 * 获取用户ID
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * 设置用户ID
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取直播频道
	 */
	public String getLiveType() {
		return liveType;
	}
	/**
	 * 设置直播频道
	 */
	public void setLiveType(String liveType) {
		this.liveType = liveType;
	}
	
	/**
	 * 获取直播标题
	 */
	public String getLiveTitle() {
		return liveTitle;
	}
	/**
	 * 设置直播标题
	 */
	public void setLiveTitle(String liveTitle) {
		this.liveTitle = liveTitle;
	}
	
}

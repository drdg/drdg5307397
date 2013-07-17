package com.sino.bjcc.online.service;

import com.sino.bjcc.online.bean.LiveConfigBean;

public interface IPlayUserOnlineService {
	
	/**
	 * 方法说明：新建点播在线用户信息
	 */
	public long createDianboUser(String ip, long userId, long programId) throws Exception;
	
	/**
	 * 方法说明：更新点播在线用户信息
	 */
	public void updateDianboUser(long playUserId);
	
	/**
	 * 方法说明：新建直播在线用户信息
	 */
	public long createZhiboUser(String ip, long userId, String liveType, String liveTitle) throws Exception;
	
	/**
	 * 方法说明：更新直播在线用户信息
	 */
	public void updateZhiboUser(long playUserId);
	
	/**
	 * 方法说明：获取直播在线用户上限数
	 */
	public LiveConfigBean getMaxLiveUser(long siteId) throws Exception;
	
}

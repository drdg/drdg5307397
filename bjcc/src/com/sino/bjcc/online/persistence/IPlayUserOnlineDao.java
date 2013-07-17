package com.sino.bjcc.online.persistence;

import java.util.List;

import com.sino.bjcc.online.bean.DianboOnlineUser;
import com.sino.bjcc.online.bean.LiveConfigBean;
import com.sino.bjcc.online.bean.UserOrgBean;
import com.sino.bjcc.online.bean.ZhiboOnlineUser;

public interface IPlayUserOnlineDao {

	/**
	 * 方法说明：检索用户登录名和组织ID
	 */
	public List<UserOrgBean> queryUserAndOrgInfo(long userId);
	
	/**
	 * 方法说明：新建点播在线用户
	 */
	public long createDianboUser(DianboOnlineUser dianboUser);
	
	/**
	 * 方法说明：获取点播在线用户
	 */
	public DianboOnlineUser getDianboUser(long userId);
	
	/**
	 * 方法说明：更新点播在线用户
	 */
	public void updateDianboUser(DianboOnlineUser user);
	
	/**
	 * 方法说明：新建直播在线用户
	 */
	public long createZhiboUser(ZhiboOnlineUser zhiboUser);
	
	/**
	 * 方法说明：获取直播在线用户
	 */
	public ZhiboOnlineUser getZhiboUser(long userId);

	/**
	 * 方法说明：更新直播在线用户
	 */
	public void updateZhiboUser(ZhiboOnlineUser user);
	
	/**
	 * 方法说明：获取互联网直播在线用户上限数
	 */
	public LiveConfigBean getHlwMaxLiveUser(long siteId);
	
	/**
	 * 方法说明：获取政务网直播在线用户上限数
	 */
	public LiveConfigBean getZwwMaxLiveUser(long siteId);
	
}

package com.sino.bjcc.online.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.online.bean.DianboOnlineUser;
import com.sino.bjcc.online.bean.LiveConfigBean;
import com.sino.bjcc.online.bean.UserOrgBean;
import com.sino.bjcc.online.bean.ZhiboOnlineUser;
import com.sino.bjcc.online.persistence.IPlayUserOnlineDao;

public class PlayUserOnlineDaoImpl extends PersistenceBase implements IPlayUserOnlineDao{
	
	/**
	 * 方法说明：检索用户登录名和组织ID
	 */
	@SuppressWarnings("unchecked")
	public List<UserOrgBean> queryUserAndOrgInfo(long userId) {
		
		String sql = "SELECT U.USERNAME as loginName,UD.AREAID as orgId FROM SYS_FLOW_USER U JOIN SYS_FLOW_USER_EXT UD ON U.USERID=UD.USERID WHERE U.USERID=:USERID";
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("loginName");
		fieldList.add("orgId");
		return (List<UserOrgBean>) executeSqlQuery2Bean(sql, UserOrgBean.class, fieldList, new SqlParameter("USERID",userId));
	}

	/**
	 * 方法说明：新建点播在线用户
	 */
	public long createDianboUser(DianboOnlineUser dianboUser){
		return Long.parseLong(save(dianboUser).toString());
	}

	/**
	 * 方法说明：获取点播在线用户
	 */
	public DianboOnlineUser getDianboUser(long userId) {
		return (DianboOnlineUser) get(DianboOnlineUser.class, userId);
	}

	/**
	 * 方法说明：更新点播在线用户
	 */
	public void updateDianboUser(DianboOnlineUser user) {
		update(user);
	}
	
	/**
	 * 方法说明：新建直播在线用户
	 */
	public long createZhiboUser(ZhiboOnlineUser zhiboUser){
		return Long.parseLong(save(zhiboUser).toString());
	}
	
	/**
	 * 方法说明：获取直播在线用户
	 */
	public ZhiboOnlineUser getZhiboUser(long userId) {
		return (ZhiboOnlineUser) get(ZhiboOnlineUser.class, userId);
	}

	/**
	 * 方法说明：更新直播在线用户
	 */
	public void updateZhiboUser(ZhiboOnlineUser user) {
		update(user);
	}
	
	/**
	 * 方法说明：获取互联网直播在线用户上限数
	 */
	public LiveConfigBean getHlwMaxLiveUser(long siteId){
		String sql = "SELECT HLWMAXLIVEUSER as maxLiveUser,HLWTRANSURL AS transUrl FROM CMS_SITE WHERE ID=:ID";
		return getLiveConfigBean(sql, siteId);
	}
	
	/**
	 * 方法说明：获取政务网直播在线用户上限数
	 */
	public LiveConfigBean getZwwMaxLiveUser(long siteId){
		String sql = "SELECT ZWWMAXLIVEUSER as maxLiveUser,ZWWTRANSURL AS transUrl FROM CMS_SITE WHERE ID=:ID";
		return getLiveConfigBean(sql, siteId);
	}
	
	/**
	 * 方法说明：获取直播在线用户上限数及超过上限数跳转的URL
	 */
	private LiveConfigBean getLiveConfigBean(String sql, long siteId){
		//设定取得数据的字段名称
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("maxLiveUser");
		fieldList.add("transUrl");
		//获取配置信息
		List<?> configList = executeSqlQuery2Bean(sql, LiveConfigBean.class, fieldList, new SqlParameter("ID", siteId));
		if(null == configList || 0==configList.size()){
			return null;
		}
		LiveConfigBean config = (LiveConfigBean) (configList.get(0));
		return config;
	}
	
}

package com.sino.bjcc.online.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.online.bean.DianboOnlineUser;
import com.sino.bjcc.online.bean.LiveConfigBean;
import com.sino.bjcc.online.bean.UserOrgBean;
import com.sino.bjcc.online.bean.ZhiboOnlineUser;
import com.sino.bjcc.online.persistence.IPlayUserOnlineDao;
import com.sino.bjcc.online.service.IPlayUserOnlineService;

public class PlayUserOnlineServiceImpl implements IPlayUserOnlineService{

	private IPlayUserOnlineDao onlineDao = null;
	
	/**
	 * 方法说明：获取在线用户dao
	 */
	public IPlayUserOnlineDao getOnlineDao() {
		return onlineDao;
	}
	/**
	 * 方法说明：设置在线用户dao
	 */
	public void setOnlineDao(IPlayUserOnlineDao onlineDao) {
		this.onlineDao = onlineDao;
	}

	/**
	 * 方法说明：新建点播在线用户
	 */
	@Transactional(readOnly=false)
	public long createDianboUser(String ip, long userId, long programId) throws Exception{
		//获取用户信息和区县ID
		List<UserOrgBean> userList = getOnlineDao().queryUserAndOrgInfo(userId);
		if(null==userList || 0==userList.size()){
			return 0;
		}
		long orgId = ((UserOrgBean)userList.get(0)).getOrgId();
		DianboOnlineUser user = new DianboOnlineUser();
		user.setIp(ip);						//用户IP设定
		user.setUserId(userId);				//用户ID设定
		user.setOrgId(orgId);				//区县ID设定
		user.setProgramId(programId);		//节目ID设定
		String siteType = PropertyUtil.getProperty("web.public.sitetype");
		if("zww".equals(siteType)){
			siteType = "1";
		}else{
			siteType = "0";
		}
		user.setSiteType(siteType);			//网络来源设定
		Date now = DateTimeUtil.getNow();
		user.setStartTime(now);				//开始时间设定
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, 10);
		user.setEndTime(cal.getTime());		//结束时间设定
		return getOnlineDao().createDianboUser(user);
	}
	
	/**
	 * 方法说明：更新点播在线用户信息
	 */
	@Transactional(readOnly=false)
	public void updateDianboUser(long playUserId){
		DianboOnlineUser user = getOnlineDao().getDianboUser(playUserId);
		user.setEndTime(DateTimeUtil.getNow());
		getOnlineDao().updateDianboUser(user);
	}
	
	/**
	 * 方法说明：新建直播在线用户信息
	 */
	@Transactional(readOnly=false)
	public long createZhiboUser(String ip, long userId, String liveType, String liveTitle) throws Exception{
		//获取用户信息和区县ID
		List<UserOrgBean> userList = getOnlineDao().queryUserAndOrgInfo(userId);
		if(null==userList || 0==userList.size()){
			return 0;
		}
		long orgId = ((UserOrgBean)userList.get(0)).getOrgId();
		ZhiboOnlineUser onlineUser = new ZhiboOnlineUser();
		onlineUser.setIp(ip);					//用户IP设定
		onlineUser.setUserId(userId);			//用户ID
		onlineUser.setOrgId(orgId);				//组织ID
		onlineUser.setLiveType(liveType);		//直播频道
		onlineUser.setLiveTitle(liveTitle);		//直播标题
		String siteType = PropertyUtil.getProperty("web.public.sitetype");
		if("zww".equals(siteType)){
			siteType = "1";
		}else{
			siteType = "0";
		}
		onlineUser.setSiteType(siteType);		//网络来源设定
		Date now = DateTimeUtil.getNow();
		onlineUser.setStartTime(now);			//开始时间设定
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, 10);
		onlineUser.setEndTime(cal.getTime());	//结束时间设定
		return getOnlineDao().createZhiboUser(onlineUser);
	}
	
	/**
	 * 方法说明：更新直播在线用户信息
	 */
	@Transactional(readOnly=false)
	public void updateZhiboUser(long playUserId){
		ZhiboOnlineUser onlineUser = getOnlineDao().getZhiboUser(playUserId);
		onlineUser.setEndTime(DateTimeUtil.getNow());
		getOnlineDao().updateZhiboUser(onlineUser);
	}
	
	/**
	 * 方法说明：获取直播在线用户上限数
	 */
	public LiveConfigBean getMaxLiveUser(long siteId) throws Exception{
		LiveConfigBean maxLiveUser = null;
		String siteType = PropertyUtil.getProperty("web.public.sitetype");
		if("zww".equalsIgnoreCase(siteType)){
			maxLiveUser = getOnlineDao().getZwwMaxLiveUser(siteId);
		}else{
			maxLiveUser = getOnlineDao().getHlwMaxLiveUser(siteId);
		}
		
		return maxLiveUser;
	}
	
}

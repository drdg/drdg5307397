package com.sino.bjcc.online.action;

import java.util.Map;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.online.service.IPlayUserOnlineService;

public class PlayUserOnlineJsonAction extends BaseAction{

	private static final long serialVersionUID = -2672112519257991401L;

	private IPlayUserOnlineService dianboManager = null;	//在线用户manager
	/**
	 * 点播在线用户Manager
	 */
	public void setDianboManager(IPlayUserOnlineService dianboManager) {
		this.dianboManager = dianboManager;
	}

	private long playUserId = 0;		//点播在线用户ID新建时设定，更新时用
	private long programId = 0;			//点播节目ID

	/**
	 * 获取点播在线用户ID
	 */
	public long getPlayUserId() {
		return playUserId;
	}
	/**
	 * 设置点播在线用户ID
	 */
	public void setPlayUserId(long playUserId) {
		this.playUserId = playUserId;
	}
	
	/**
	 * 获取点播节目ID
	 */
	public long getProgramId() {
		return programId;
	}
	/**
	 * 设置点播节目ID
	 */
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	
	/**
	 * 方法说明：更新点播在线用户
	 */
	public String executeUpdateOrderUser(){
		this.dianboManager.updateDianboUser(getPlayUserId());
		return SUCCESS;
	}
	
	/**
	 * 方法说明：新建点播在线用户
	 */
	public String executeCreateOrderUser() throws Exception{
		long id = this.dianboManager.createDianboUser(getClientIp(), getLoginUserId(), getProgramId());
		setPlayUserId(id);
		return SUCCESS;
	}
	
	/**
	 * 方法说明：新建直播在线用户
	 */
	public String executeCreateLiveUser() throws Exception{
		String liveType = getReqParam("liveType");		//直播频道：1-全国;2-北京;3-专题
		String liveTitle = getReqParam("liveTitle");
		long id = this.dianboManager.createZhiboUser(getClientIp(), getLoginUserId(), liveType, liveTitle);
		setPlayUserId(id);
		return SUCCESS;
	}
	
	/**
	 * 方法说明：更新直播在线用户
	 */
	@SuppressWarnings("unchecked")
	public String executeUpdateLiveUser(){
		String key = "live_online_user" + getReqParam("liveType");
		//获取application中直播在线用户信息
		Object onlineUser = getSession().getServletContext().getAttribute(key);
		if(null != onlineUser){
			//从application中移除当前直播用户信息
			if(((Map<String,Integer>)onlineUser).containsKey(getSession().getId())){
				((Map<String,Integer>)onlineUser).remove(getSession().getId());
			}
		}
		this.dianboManager.updateZhiboUser(getPlayUserId());
		return SUCCESS;
	}
}

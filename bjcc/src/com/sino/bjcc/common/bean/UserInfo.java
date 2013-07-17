package com.sino.bjcc.common.bean;

public class UserInfo {

	private Long userId = null;			//登录用户的ID
	private String userName = null;		//登录用户的名字
	private String loginName = null;	//登录用户的登录名
	private Long orgId = null;				//登录用户所属组织ID
	private String orgName = null;		//登录用户所属组织部门名称
	
	public UserInfo(){}
	
	public UserInfo(long userId, String userName, String loginName, long orgId,
			String orgName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.loginName = loginName;
		this.orgId = orgId;
		this.orgName = orgName;
	}
	/**
	 * 获取登录用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置登录用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取登录用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置登录用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取登录用户登录名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置登录用户登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * 获取登录用户所属组织ID
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置登录用户所属组织ID
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取登录用户所属组织的部门名称
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置登录用户所属组织的部门名称
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}

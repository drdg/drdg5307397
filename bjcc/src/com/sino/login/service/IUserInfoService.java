package com.sino.login.service;

import com.sino.bjcc.common.bean.UserInfo;

/**
 * 验证用户身份service接口
 * @author Administrator
 *
 */
public interface IUserInfoService {
	
	/**
	 * 验证用户登录信息
	 * @param login_name
	 * @param passwd
	 * @param deptid
	 * @return
	 * @throws Exception
	 */
	public UserInfo validataUserinfo(String login_name, String passwd, String deptid) throws Exception;
}
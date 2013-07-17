package com.sino.login.dao;

import com.sino.bjcc.common.bean.UserInfo;

/**
 * 验证用户身份dao接口
 * @author Administrator
 *
 */
public interface IUserInfoDao {
	
	/**
	 * 验证用户登录信息
	 * @param login_name
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	public UserInfo validataUserinfo(String login_name, String passwd, String deptid) throws Exception;
}
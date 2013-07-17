package com.sino.login.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sino.bjcc.common.bean.UserInfo;
import com.sino.login.dao.IUserInfoDao;
import com.sino.login.service.IUserInfoService;
import com.sun.org.apache.bcel.internal.generic.Type;
/**
 * 验证用户身份dao实现类
 * @author Administrator
 *
 */
public class UserInfoServiceImpl implements IUserInfoService {
	
	private IUserInfoDao userInfoDao;

	/**
	 * 验证用户登录信息
	 * @param login_name
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public UserInfo validataUserinfo(final String login_name, final String passwd, final String deptid) throws Exception{
		UserInfo userinfo = null;
		userinfo = userInfoDao.validataUserinfo(login_name, passwd, deptid);
		return userinfo;
	}
	
	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
}
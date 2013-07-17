package com.sino.login.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.xsqlbuilder.XsqlBuilder;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sino.bjcc.common.bean.UserInfo;
import com.sino.login.dao.IUserInfoDao;
/**
 * 验证用户身份dao实现类
 * @author Administrator
 *
 */
public class UserInfoDaoImpl extends HibernateDaoSupport implements IUserInfoDao {
	private final String sql = "SELECT SFU.USERID AS userId, SFU.USERNAME AS loginName, SFU.USER_NM AS userName, SFD.DEPTID AS orgId, SFD.DEPTNAME AS orgName " +
					"FROM SYS_FLOW_USER SFU " +
						"LEFT JOIN  SYS_USER_DPRB SUD ON SFU.USERID = SUD.USERID " +
						"LEFT JOIN SYS_FLOW_DEPT SFD ON SUD.DEPTID = SFD.DEPTID " +
			       "WHERE 1=1 " +
			       " /~ and SFU.USERNAME = '[LOGIN_NAME]' ~/ " +
			       " /~ AND SFU.USER_PASSWORD = '[PASSWD]' ~/ " +
			       " /~ and SUD.DEPTID = '[DEPTID]' ~/ ";
	private final XsqlBuilder xsqlBuilder = new XsqlBuilder();
	
	/**
	 * 验证用户登录信息
	 * @param login_name
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public UserInfo validataUserinfo(final String login_name, final String passwd, final String deptid) throws Exception{
		List<UserInfo> list = null;
		UserInfo userinfo = null;
		list = (List<UserInfo>) getHibernateTemplate().execute(new HibernateCallback() {
			@SuppressWarnings("deprecation")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Map params = new HashMap();
				params.put("LOGIN_NAME", login_name);
				params.put("PASSWD", passwd);
				params.put("DEPTID", deptid);
				
				SQLQuery query = (SQLQuery) session.createSQLQuery(xsqlBuilder.generateSql(sql, params).getXsql());
				
				query.addScalar("userId", Hibernate.LONG);
				query.addScalar("userName", Hibernate.STRING);
				query.addScalar("loginName", Hibernate.STRING);
				query.addScalar("orgId", Hibernate.LONG);
				query.addScalar("orgName", Hibernate.STRING);
				query.setResultTransformer(Transformers.aliasToBean(UserInfo.class));
				return (List<UserInfo>)query.list();
			}
		});
		if(null!=list && list.size() > 0) {
			userinfo = list.get(0);
		}
		return userinfo;
	}
}
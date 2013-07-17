package com.sino.system.constant.dao.impl;

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

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.system.constant.dao.IConstantConfigureDao;
/**
 * 系统常量dao实现类
 * @author Administrator
 *
 */
public class ConstantConfigureDaoImpl extends PersistenceBase implements
		IConstantConfigureDao {
	
	private final String query_constant_sql = "SELECT A.CON_KEY, A.CON_VALUE " +
			"FROM E_SYSTEM_CONSTANT_CONFIGURE A " +
				"WHERE 1 = 1 " +
			" /~ AND A.CON_NET_DIFF = '[CON_NET_DIFF]' ~/ ";
	
	private final XsqlBuilder xsqlBuilder = new XsqlBuilder();
	
	/**
	 * 获取常量配置信息
	 * @param conNetDiff(网络区分 0:互联网 1:政务网)
	 */
	@SuppressWarnings("unchecked")
	public List<Map> getConstants(final String conNetDiff) throws Exception {
		List<Map> list = null;
		list = (List<Map>) getHibernateTemplate().execute(new HibernateCallback() {
			@SuppressWarnings("deprecation")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Map params = new HashMap();
				params.put("CON_NET_DIFF", conNetDiff);
				SQLQuery query = (SQLQuery) session.createSQLQuery(xsqlBuilder.generateSql(query_constant_sql, params).getXsql());
				query.addScalar("CON_KEY", Hibernate.STRING);
				query.addScalar("CON_VALUE", Hibernate.STRING);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				return (List<Map>)query.list();
			}
		});
		return list;
	}
}
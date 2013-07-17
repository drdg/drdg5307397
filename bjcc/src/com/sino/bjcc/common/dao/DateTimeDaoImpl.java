package com.sino.bjcc.common.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.PersistenceBase;

@Transactional
public class DateTimeDaoImpl extends PersistenceBase implements IDateTimeDao {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false)
	public String getDbNowStr() {
		String sql = "SELECT TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS') AS NOW FROM DUAL";
		Session session = super.getHibernateTemplate().getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(sql);
		List<String> date = query.list();
		session.close();
		return date.get(0);
	}

}

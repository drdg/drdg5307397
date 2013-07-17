package com.sino.bjcc.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.common.utility.HibernateTypeUtil;
import com.sino.elearning.basedao.IBaseDao;

@Transactional
public class PersistenceBase extends HibernateDaoSupport implements IBaseDao {

	public static final int QUERY_TYPE_HQL = 0;
	public static final int QUERY_TYPE_SQL = 1;

	/**
	 * 方法说明：新增一个实体对象
	 */
	public Serializable save(Object entity) {
		return getHibernateTemplate().save(entity);
	}

	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	/**
	 * 方法说明：更新一个实体对象
	 */
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 方法说明：删除一个实体对象
	 */
	public void delete(Object entity) throws Exception {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 方法说明：根据ID取得一个实体对象
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 方法说明：根据ID取得一个实体对象
	 */
	public Object get(String entityName, Serializable id) {
		return getHibernateTemplate().get(entityName, id);
	}

	/**
	 * 方法说明：根据ID加载一个实体对象
	 */
	@SuppressWarnings("unchecked")
	public Object load(Class entityClass, Serializable id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 方法说明：根据ID加载一个实体对象
	 */
	public Object load(String entityName, Serializable id) {
		return getHibernateTemplate().load(entityName, id);
	}

	/**
	 * 方法说明：执行Hql查询操作
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(String hql, SqlParameter... hqlParams) {
		Query query = createQuery(QUERY_TYPE_HQL, hql, hqlParams);
		List result = query.list();
		return result;
	}

	/**
	 * 方法说明：执行Hql查询操作，返回指定的记录数 参数说明：hql：要执行的hql语句 maxSize：查询的记录数
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(String hql, int maxSize, SqlParameter... hqlParams) {
		Query query = createQuery(QUERY_TYPE_HQL, hql, hqlParams);
		query.setMaxResults(maxSize);
		List result = query.list();
		return result;
	}

	/**
	 * 方法说明：执行sql查询操作
	 */
	@SuppressWarnings("unchecked")
	public List executeSqlQuery(String sql, SqlParameter... sqlParams) {
		Query query = createQuery(QUERY_TYPE_SQL, sql, sqlParams);
		List result = query.list();
		return result;
	}

	/**
	 * 方法说明：执行sql查询操作返回一个结果
	 */
	public Object executeSqlScalar(String sql, SqlParameter... sqlParams) {
		Query query = createQuery(QUERY_TYPE_SQL, sql, sqlParams);
		Object result = query.uniqueResult();
		return result;
	}
	
	/**
	 * 方法说明：执行sql查询操作，返回指定的记录数 参数说明：hql：要执行的hql语句 maxSize：查询的记录数
	 */
	@SuppressWarnings("unchecked")
	public List executeSqlQuery(String sql, int maxSize,
			SqlParameter... sqlParams) {
		Query query = createQuery(QUERY_TYPE_SQL, sql, sqlParams);
		query.setMaxResults(maxSize);
		List result = query.list();
		return result;
	}

	/**
	 * 方法说明：执行sql查询操作 参数说明：hql：要执行的hql语句
	 */
	@SuppressWarnings("unchecked")
	public List<Map> executeSqlMap(final String sql){
		if (sql == null && "".equals(sql)) {
			return null;
		}
		List<Map> res = null;
		try {
			res = (List<Map>) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = (SQLQuery) session
									.createSQLQuery(sql);
							return query.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP).list();
						}
					});
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
		return res;

	}

	/**
	 * 方法说明：执行更新操作
	 */
	public int executeUpdate(String hql, SqlParameter... hqlParams) {
		Query query = createQuery(QUERY_TYPE_HQL, hql, hqlParams);
		return query.executeUpdate();
	}

	/**
	 * 方法说明：执行sql更新操作
	 */
	public int executeSqlUpdate(String sql, SqlParameter... hqlParams){
		Query query = createQuery(QUERY_TYPE_SQL, sql, hqlParams);
		return query.executeUpdate();
	}
	
	/**
	 * 方法说明：获取总记录数
	 */
	public PaginationBean getRecordCount(PaginationBean page, String hql,
			SqlParameter... hqlParams) {
		long recordCount = 0;
		Query query = createQuery(QUERY_TYPE_HQL, hql, hqlParams);
		recordCount = (Long) query.uniqueResult();
		page.setTotalRecord(recordCount);
		return page;
	}

	/**
	 * 方法说明：获取指定页的记录
	 */
	public List<?> getRecordByPage(PaginationBean page, String hql,
			SqlParameter... hqlParams) {
		Query query = createQuery(QUERY_TYPE_HQL, hql, hqlParams);
		int fromIndex = (page.getCurrentPage() - 1) * page.getPageSize();
		// 设定指定页记录开始的索引
		query.setFirstResult(fromIndex);
		query.setMaxResults(page.getPageSize());
		List<?> list = query.list();
		return list;
	}

	/**
	 * 方法说明：分页查询执行sql查询并把检索结果封装到Bean
	 */
	public List<?> executePageSqlQuery2Bean(PaginationBean page, String sql, Class<?> beanClass,
			List<String> fieldList, SqlParameter... sqlParams) {
		Query query = createSql2BeanQuery(sql, beanClass, fieldList, sqlParams);
		int fromIndex = (page.getCurrentPage() - 1) * page.getPageSize();
		// 设定指定页记录开始的索引
		query.setFirstResult(fromIndex);
		query.setMaxResults(page.getPageSize());
		return query.list();
	}
	
	/**
	 * 方法说明：创建检索结果封装到Bean的query对象
	 */
	@SuppressWarnings("unchecked")
	private Query createSql2BeanQuery(String sql, Class<?> beanClass,
			List<String> fieldList, SqlParameter... sqlParams) {
		Hashtable<String, Class> htField = new Hashtable<String, Class>();
		Field[] fieldsArr = beanClass.getDeclaredFields();
		for (Field field : fieldsArr) {
			htField.put(field.getName(), field.getType());
		}

		sql = trimDoubleBlank(sql);
		SQLQuery sqlQuery = getCurSession().createSQLQuery(sql);
		for (String fieldName : fieldList) {
			if (htField.containsKey(fieldName)) {
				Type type = HibernateTypeUtil.matchHibernateType(htField
						.get(fieldName));
				// 添加要查询字段的标量
				if (null == type) {
					sqlQuery.addScalar(fieldName);
				} else {
					sqlQuery.addScalar(fieldName, type);
				}
			}
		}
		// 设定sql参数
		for (SqlParameter param : sqlParams) {
			sqlQuery.setParameter(param.getParamKey(), param.getParamVal());
		}
		// 转换查询结果
		if (beanClass != null) {
			sqlQuery.setResultTransformer(Transformers.aliasToBean(beanClass));
		}
		return sqlQuery;
	}
	
	/**
	 * 方法说明：执行sql查询并把检索结果封装到Bean
	 */
	public List<?> executeSqlQuery2Bean(String sql, Class<?> beanClass,
			List<String> fieldList, SqlParameter... sqlParams) {
		Query sqlQuery = createSql2BeanQuery(sql, beanClass, fieldList, sqlParams);
		return sqlQuery.list();
	}

	/**
	 * 方法说明：创建query对象，并设定query对象的参数
	 */
	public Query createQuery(int queryType, String hql,
			SqlParameter... hqlParams) {
		Query query;
		hql = trimDoubleBlank(hql);
		if (QUERY_TYPE_SQL == queryType) {
			query = getCurSession().createSQLQuery(hql);
		} else {
			query = getCurSession().createQuery(hql);
		}

		// 设定sql参数
		for (SqlParameter param : hqlParams) {
			query.setParameter(param.getParamKey(), param.getParamVal());
		}
		return query;
	}

	/**
	 * 方法说明：去掉sql语句中多余空格
	 */
	public String trimDoubleBlank(String sql) {
		if (null != sql && !"".equals(sql.trim())) {
			sql = sql.replaceAll("\r\n", " ");
			sql = sql.replaceAll("\n", " ");
			sql = sql.replaceAll("\t", " ");
			while (sql.contains("  ")) {
				sql = sql.replaceAll("  ", " ");
			}
		}
		return sql;
	}

	/**
	 * 方法说明：获取session
	 */
	public Session getCurSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
}
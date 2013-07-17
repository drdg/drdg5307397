package com.sino.elearning.basedao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;

public interface IBaseDao {
	/**
	 * 方法说明：新增一个实体对象
	 */
	public Serializable save(Object entity);
	
	/**
	 * 方法说明：更新一个实体对象
	 */
	public void update(Object entity);
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity);
	
	/**
	 * 方法说明：删除一个实体对象
	 */
	public void delete(Object entity) throws Exception;
	
	/**
	 * 方法说明：根据ID取得一个实体对象
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class entityClass, Serializable id);
	
	/**
	 * 方法说明：根据ID取得一个实体对象
	 */
	public Object get(String entityName, Serializable id);
	
	/**
	 * 方法说明：根据ID加载一个实体对象
	 */
	@SuppressWarnings("unchecked")
	public Object load(Class entityClass, Serializable id);
	
	/**
	 * 方法说明：根据ID加载一个实体对象
	 */
	public Object load(String entityName, Serializable id);
	
	/**
	 * 方法说明：执行Hql查询操作
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(String hql, SqlParameter... hqlParams);
	
	/**
	 * 方法说明：执行Hql查询操作，返回指定的记录数
	 * 参数说明：hql：要执行的hql语句
	 *          maxSize：查询的记录数
	 */
	@SuppressWarnings("unchecked")
	public List executeQuery(String hql, int maxSize, SqlParameter... hqlParams);
	
	/**
	 * 方法说明：执行sql查询操作
	 */
	@SuppressWarnings("unchecked")
	public List executeSqlQuery(String sql, SqlParameter... sqlParams);
	
	/**
	 * 方法说明：执行sql查询操作，返回指定的记录数
	 * 参数说明：hql：要执行的hql语句
	 *          maxSize：查询的记录数
	 */
	@SuppressWarnings("unchecked")
	public List executeSqlQuery(String sql, int maxSize, SqlParameter... sqlParams);
	/**
	 * 方法说明：执行sql查询操作
	 * 参数说明：hql：要执行的hql语句       
	 */
	@SuppressWarnings("unchecked")
	public List<Map> executeSqlMap(final String sql);
	
	/**
	 * 方法说明：执行更新操作
	 */
	public int executeUpdate(String hql, SqlParameter... hqlParams);
	
	/**
	 * 方法说明：获取总记录数
	 */
	public PaginationBean getRecordCount(PaginationBean page,String hql,SqlParameter... hqlParams);
	
	/**
	 * 方法说明：获取指定页的记录
	 */
	public List<?> getRecordByPage(PaginationBean page, String hql,SqlParameter... hqlParams);
	
		/**
	 * 方法说明：执行sql查询并把检索结果封装到Bean
	 */
	@SuppressWarnings("unchecked")
	public List<?> executeSqlQuery2Bean(String sql, Class<?> beanClass,
			List<String> fieldList, SqlParameter... sqlParams);
	
	/**
	 * 方法说明：创建query对象，并设定query对象的参数
	 */
	public Query createQuery(int queryType, String hql, SqlParameter... hqlParams);
	
	/**
	 * 方法说明：去掉sql语句中多余空格
	 */
	public String trimDoubleBlank(String sql);
	
	/**
	 * 方法说明：获取session
	 */
	public Session getCurSession();
}

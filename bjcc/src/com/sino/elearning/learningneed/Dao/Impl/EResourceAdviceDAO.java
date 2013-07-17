package com.sino.elearning.learningneed.Dao.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.learningneed.Dao.IEResourceAdviceDao;
import com.sino.elearning.learningneed.bean.EResourceAdvice;

/**
 * A data access object (DAO) providing persistence and search support for
 * EResourceAdvice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see learningneed.EResourceAdvice
 * @author MyEclipse Persistence Tools
 */

public class EResourceAdviceDAO extends PersistenceBase implements IEResourceAdviceDao{

	public void delete(BigDecimal resourceId) {
		 try
	        {
			 EResourceAdvice persistentInstance = findById(resourceId);
			 getHibernateTemplate().delete(persistentInstance);
	        }
	        catch(RuntimeException re)
	        {
	            log.error("用户学习需求删除失败。", re);
	            throw re;
	        }
		
	}

	@SuppressWarnings("unchecked")
	public List<EResourceAdvice> findAll(PaginationBean page) {
		 try
			{
			 String queryString = "from EResourceAdvice";
			 List<EResourceAdvice> resources=getHibernateTemplate().find(queryString);
			 return resources;
			}
			catch (RuntimeException re)
			{
				log.error("查询学习需求失败。", re);
				throw re;
			}
	}

	public EResourceAdvice findById(final BigDecimal id) {
		 try
			{
			 EResourceAdvice equestion = (EResourceAdvice)getHibernateTemplate().get("com.sino.elearning.learningneed.bean.EResourceAdvice", id);
	        
	        return equestion;
			}
			catch (RuntimeException re)
			{
				log.error("根据需求Id查询学习需求失败。", re);
				throw re;
			}
	}
	/**
	 * 根据查询条件 模糊查询
	 * */
	public  List<EResourceAdvice> findByTitle(PaginationBean page,BigDecimal userId,String title){
		 List<EResourceAdvice> list = null;
		    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
			StringBuffer hql = new StringBuffer();
			hql.append("from EResourceAdvice as eq where 1=1");
			if(userId!=null&&!"".equals(userId)){
				hql.append(" AND eq.userId=:UserId ");
				paramList.add(new SqlParameter("UserId", userId));
			}
			if(title!=null&&!"".equals(title)){
				hql.append(" AND eq.title like :Title ");
				paramList.add(new SqlParameter("Title", "%"+title+"%"));
			}
			hql.append(" order by eq.creatTime desc ");
			String hq=hql.toString();
		    System.out.println(hql);
			String queryString= "select count(*) "+hq;
			page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
			System.out.println(page);
			System.out.println(page.getTotalRecord()+"记录");
			list =(List<EResourceAdvice>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
			return list;
	};
	@SuppressWarnings("unchecked")
	public List<EResourceAdvice> showByUserId(BigDecimal userId) {
	    List<EResourceAdvice> list = null;
	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    	StringBuffer hql = new StringBuffer();
			hql.append("from EResourceAdvice as eq where ");
			if(userId!=null&&!"".equals(userId)){
				hql.append(" eq.userId=:UserId ");
				paramList.add(new SqlParameter("UserId", userId));
			}
			hql.append(" order by eq.creatTime desc ");
			String queryString = hql.toString();
	    	list = super.executeQuery(queryString, 10, paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<EResourceAdvice> findByUserIdAll(PaginationBean page,BigDecimal userId) {
	    List<EResourceAdvice> list = null;
	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		StringBuffer hql = new StringBuffer();
		hql.append("from EResourceAdvice as eq where 1=1");
		if(userId!=null&&!"".equals(userId)){
			hql.append(" AND eq.userId=:UserId order by eq.creatTime desc ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		String hq=hql.toString();
	    System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list =(List<EResourceAdvice>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	public BigDecimal save(EResourceAdvice transientInstance) {
		 BigDecimal message = null; 
		try{
	    	  message= (BigDecimal) getHibernateTemplate().save(transientInstance);
	       }catch(RuntimeException re){
	    	   log.error("添加学习需求失败。", re);
	    	   throw re;
	       }
	       return message;
	}
	/**
	 * 修改个人学习需求
	 * */
	public void update(EResourceAdvice transientInstance) {
		 try
	        {
	            getHibernateTemplate().saveOrUpdate(transientInstance);
	            log.debug("attach successful");
	        }
	        catch(RuntimeException re)
	        {
	            log.error("attach failed", re);
	            throw re;
	        }
	}
	private static final Log log = LogFactory.getLog("com.sino.elearning.learningneed.Dao.Impl.EResourceAdviceDAO");


	
	
	
}
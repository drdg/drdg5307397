package com.sino.elearning.studyrecord.Dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.studyrecord.Dao.IResultRecordDao;
import com.sino.elearning.studyrecord.bean.EResultsRecord;

public class EResultRecordDaoImpl extends PersistenceBase implements IResultRecordDao{
	/**
	 * 为用户添加学习成效
	 * */
	public long saveResult(EResultsRecord result) {
		log.debug("saving EResultsRecord instance");
		   Long message = null;
	       try{
	    	  message= (Long) getHibernateTemplate().save(result);
	    	  log.debug("saving success");
	       }catch(RuntimeException re){
	    	   log.error("saving failed", re);
	    	   throw re;
	       }
	       return message;
	}
	/**
	 * 根据资源ID 以及 用户学习类型   查询用户学习成效
	 * */
	@SuppressWarnings("unchecked")
	public List<EResultsRecord> findByProId(long id, String studyType,Long userId) {
		String queryString = "from EResultsRecord as eq where eq.programId= ? and eq.studyType= ? and eq.creatUserId=? order by eq.creatTime desc";
		List<EResultsRecord> results=null;
	    try{
	    	results = getHibernateTemplate().find(queryString, new Object[]{id,studyType,userId});
	    } catch (RuntimeException re)
	    {
	    	log.error("根据用户Id查询学习需求失败。", re);
	    	throw re;
	    }
		return results;
	}
	public void updateResult(EResultsRecord result) {
	        try
	        {
	            getHibernateTemplate().saveOrUpdate(result);
	            log.debug("attach successful");
	        }
	        catch(RuntimeException re)
	        {
	            log.error("attach failed", re);
	            throw re;
	        }
	}
	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.Dao.Impl.EResultRecordDaoImpl");

	
	
}

package com.sino.elearning.studyrecord.Dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.studyrecord.Dao.ITestQuestionDao;
import com.sino.elearning.studyrecord.bean.EEvaluationAnswer;
import com.sino.elearning.studyrecord.bean.EEvaluationTestQuestion;

public class TestQuestionDaoIpml extends PersistenceBase implements ITestQuestionDao{

	
	@SuppressWarnings("unchecked")
	public List<EEvaluationTestQuestion> findByTestId(Long testId) {
		String queryString = "from EEvaluationTestQuestion as eq where eq.test.testId= ?  order by eq.questionId";
        List<EEvaluationTestQuestion> list = null;
        try{
        	list = getHibernateTemplate().find(queryString, new Object[]{testId});
        	log.debug("find by testId success");
        }
        catch(RuntimeException re)
        {
            log.error("find by by testId failed", re);
            throw re;
        }
        return list;
	}
	/**
	 * 向EEvaluationAnswer表中保存 问题信息
	 * */
	public Long save(EEvaluationAnswer answer) {
		log.debug("saving EEvaluationAnswer instance");
		   Long message = null;
	       try{
	    	  message= (Long) getHibernateTemplate().save(answer);
	    	  log.debug("saving success");
	       }catch(RuntimeException re){
	    	   log.error("saving failed", re);
	    	   throw re;
	       }
	       return message;
	}
	/**
	   * 查询所有问题 根据填写问卷ID
	   * @return
	   */
	@SuppressWarnings("unchecked")
	public List<EEvaluationAnswer> findByRecordId(Long recordId) {
		log.debug("find EEvaluationAnswer by recordId instance");
        String queryString = "from EEvaluationAnswer as eq where eq.Record.recordId= ?  order by eq.answerRecordId";
        List<EEvaluationAnswer> list = null;
        try{
        	list = getHibernateTemplate().find(queryString, new Object[]{recordId});
        	log.debug("find by recordId success");
        }
        catch(RuntimeException re)
        {
            log.error("find by by recordId  failed", re);
            throw re;
        }
        return list;
	}
	/**
	   * 删除所有问题 根据填写问卷ID
	   */
	  public void delByRecordId(final Long recordId){
		  log.debug("delete EEvaluationAnswer by recordId instance");
			try
	        {
	            getHibernateTemplate().execute(new HibernateCallback() {

	                public Object doInHibernate(Session session)
	                {
	                    Query query = session.createQuery("delete from EEvaluationAnswer as eq where eq.Record.recordId=:RECORD_ID");
	                    query.setLong("RECORD_ID", recordId);
	                    return Integer.valueOf(query.executeUpdate());
	                }
	            });
	            log.debug("delete by testId success");
	        }
	        catch(RuntimeException re)
	        {
	            log.error("delete by by testId failed", re);
	            throw re;
	        }

			
	  };
	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.Dao.Impl.TestQuestionDaoIpml");
	
}

package com.sino.elearning.studyrecord.Dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.studyrecord.Dao.IEvaluationTestDao;
import com.sino.elearning.studyrecord.bean.EEvaluationRecord;
import com.sino.elearning.studyrecord.bean.EEvaluationTest;

public class EvaluationTestDaoImpl extends PersistenceBase implements IEvaluationTestDao{
	@SuppressWarnings("unchecked")
	public List<EEvaluationTest> findByCondition(Long programId, String testState) {
		
		String queryString = "from EEvaluationTest as eq where eq.programId= ? and eq.testState= ? ";
		List<EEvaluationTest> tests=null;
	    try{
	    	tests = getHibernateTemplate().find(queryString, new Object[]{programId,testState});
	    } catch (RuntimeException re)
	    {
	    	log.error("根据用户Id查询学习需求失败。", re);
	    	throw re;
	    }
		return tests;
	}
	/**
	 * 根据评测试卷Id 查询评测试卷
	 * */
	public EEvaluationTest findById(Long Id){
		log.debug((new StringBuilder("getting EEvaluationTest instance with id: ")).append(Id).toString());
        try
		{
        	EEvaluationTest questionnaireTemplate = (EEvaluationTest)getHibernateTemplate().get("com.sino.elearning.studyrecord.bean.EEvaluationTest", Id);
        
        return questionnaireTemplate;
		}
		catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 向EEvaluationRecord表中保存已填写的试卷
	 * */
	public Long save(EEvaluationRecord record) {
		log.debug("saving EEvaluationRecord instance");
		   Long message = null;
	       try{
	    	  message= (Long) getHibernateTemplate().save(record);
	    	  log.debug("saving success");
	       }catch(RuntimeException re){
	    	   log.error("saving failed", re);
	    	   throw re;
	       }
	       return message;
	}
	/**
	 * 根据试卷Id查询已填写课程评测试卷
	 * */
	@SuppressWarnings("unchecked")
	public List<EEvaluationRecord> findByTestId(Long testId,Long UserId) {
		String queryString = "from EEvaluationRecord as eq where eq.testId= ? and eq.userId= ? ";
		List<EEvaluationRecord> records=null;
	    try{
	    	records = getHibernateTemplate().find(queryString, new Object[]{testId,UserId});
	    } catch (RuntimeException re)
	    {
	    	log.error("根据用户Id查询学习需求失败。", re);
	    	throw re;
	    }
		return records;
	}
	/**
	 * 根据填写问卷Id 删除保存问卷
	 * */
	public void delect(Long recordId) {
		log.debug("deleting persistentInstance instance");
        try
        {
        	EEvaluationRecord persistentInstance = findByRecordId(Long.valueOf(recordId));
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch(RuntimeException re)
        {
            log.error("delete failed", re);
            throw re;
        }
		
	}
	public EEvaluationRecord findByRecordId(Long recordId){
        try
		{
        	EEvaluationRecord questionnaireTemplate = (EEvaluationRecord)getHibernateTemplate().get("com.sino.elearning.studyrecord.bean.EEvaluationRecord", recordId);
        
        return questionnaireTemplate;
		}
		catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}	
	}
	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.Dao.Impl.EvaluationTestDaoImpl");
	
	
	
}

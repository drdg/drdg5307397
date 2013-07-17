package com.sino.elearning.studyrecord.Dao.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.studyrecord.Dao.ITestQuestionOPtionDao;
import com.sino.elearning.studyrecord.bean.EEvaluationOption;
import com.sino.elearning.studyrecord.bean.ETestQuestionOption;

public class TestQuestionOPtionDaoImpl extends PersistenceBase implements ITestQuestionOPtionDao{

	@SuppressWarnings("unchecked")
	public List<ETestQuestionOption> findByQuestionId(Long questionId) {
		log.debug("find ETestQuestionOption by questionId instance");
        String queryString = "from ETestQuestionOption as eqo where eqo.testQuestion.questionId= ?  order by eqo.optionId";
        List<ETestQuestionOption> list = null;
        try{
        	list = getHibernateTemplate().find(queryString, new Object[]{questionId});
        	log.debug("find by questionid success");
        }
        catch(RuntimeException re)
        {
            log.error("find by by questionid failed", re);
            throw re;
        }
        return list;
	}
	/**
	  *  向EEvaluationOption表中 保存用户选择的选项信息
	  * */
	public Long save(EEvaluationOption option) {
		log.debug("saving EEvaluationOption instance");
		   Long message = null;	
	       try{
	    	  message= (Long) getHibernateTemplate().save(option);
	    	  log.debug("saving success");
	       }catch(RuntimeException re){
	    	   log.error("saving failed", re);
	    	   throw re;
	       }
	       return message;
	}
	 /**
	 * 查询用户选择问题选项 根据答题问题ID
	 * @param idfindByQuestionId
	 */
	@SuppressWarnings("unchecked")
	public List<EEvaluationOption> findByAnswer(Long QuestionId){
		log.debug("find EEvaluationOption by answerRecordId instance");
        String queryString = "from EEvaluationOption as eqo where eqo.answer.answerRecordId= ?  order by eqo.answerRecOptionId";
        List<EEvaluationOption> list = null;
        try{
        	list = getHibernateTemplate().find(queryString, new Object[]{QuestionId});
        	log.debug("find by answerRecordId success");
        }
        catch(RuntimeException re)
        {
            log.error("find by by answerRecordId failed", re);
            throw re;
        }
        return list;
	};
	/**
	 * 删除用户选择问题选项 根据答题问题ID
	 * @param idfindByQuestionId
	 */
	public void delByAnswerRecordId(final Long AnswerRecordId){
		try
        {
            getHibernateTemplate().execute(new HibernateCallback() {

                public Object doInHibernate(Session session)
                {
                    Query query = session.createQuery("delete from  EEvaluationOption as eqo where eqo.answer.answerRecordId=:ANSWER_RECORD_ID");
                    query.setLong("ANSWER_RECORD_ID", AnswerRecordId);
                    return Integer.valueOf(query.executeUpdate());
                }
            });
            log.debug("delete by AnswerRecordId success");
        }
        catch(RuntimeException re)
        {
            log.error("delete by by questionid failed", re);
            throw re;
        }
	};
	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.Dao.Impl.TestQuestionOPtionDaoImpl");
	
}

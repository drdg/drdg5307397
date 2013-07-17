package com.sino.elearning.questionnaire.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.xsqlbuilder.XsqlBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.questionnaire.bean.EQuesnaireQuestion;
import com.sino.elearning.questionnaire.bean.EQuestionnaire;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;
import com.sino.elearning.questionnaire.dao.IEQuestionNaireDao;
/**
 * 用户问卷dao实现类
 * @author Administrator
 *
 */
public class EQuestionNaireDaoImpl extends PersistenceBase implements
		IEQuestionNaireDao {
	
	/**
	 * 根据部门查询用户问卷
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> queryByDeptId(Long deptId) throws Exception {
		final Long dept = null == deptId ? -1L : deptId;
		final String hql = "select eqn from EQuestionnaire as eqn, EQuestionnaireDept eqnd " +
				"where eqn.questionnaireId = eqnd.questionnaireId " +
					"and eqn.status = '1' " +	//已发布
					"and (eqn.expirationTime>= to_char(sysdate,'YYYY-MM-DD') or eqn.expirationTime is null) " +	//有效的
					"and eqnd.deptId=:deptId order by eqn.expirationTime desc ";
		try {
			return executeQuery(hql, 10, new SqlParameter("deptId",deptId));
		} catch (Exception e) {
			log.error("查询用户问卷失败queryByDeptId(Long deptId)");
        	throw e;
		}
	}
	
	/**
	 * 根据部门查询用户问卷
	 * @param page
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> queryByDeptId(PaginationBean page, Long deptId) throws Exception {
		final Long dept = null == deptId ? -1L : deptId;
		final String hql = "from EQuestionnaire as eqn, EQuestionnaireDept eqnd " +
				"where eqn.questionnaireId = eqnd.questionnaireId " +
					"and eqn.status = '1' " +	//已发布
					"and (eqn.expirationTime>= to_char(sysdate,'YYYY-MM-DD') or eqn.expirationTime is null) " +	//有效的
					"and eqnd.deptId=:deptId order by eqn.expirationTime desc ";
		String queryString= "select count(eqn)" + hql;
		try {
			SqlParameter params = new SqlParameter("deptId",deptId);
			page = getRecordCount(page, queryString, params);
			return (List<EQuestionnaire>) getRecordByPage(page, "select eqn " + hql, params);
		} catch (Exception e) {
			log.error("查询用户问卷失败queryByDeptId(Long deptId)");
        	throw e;
		}
	}
	/**
	 * 根据调查问卷名进行模糊查询
	 * @param page
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> findByTitle(PaginationBean page, Long deptId,
			String title) throws Exception {
		List<EQuestionnaire> list = null;
	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		StringBuffer hql = new StringBuffer();
		hql.append("from EQuestionnaire as eqn, EQuestionnaireDept eqnd ");
		hql.append(" where eqn.questionnaireId = eqnd.questionnaireId ");
		hql.append(" and eqn.status = '1'  ");
		hql.append(" and (eqn.expirationTime>= to_char(sysdate,'YYYY-MM-DD') or eqn.expirationTime is null) ");
		if(deptId!=null&&!"".equals(deptId)){
			hql.append(" and eqnd.deptId=:deptId  ");
			paramList.add(new SqlParameter("deptId",deptId));
		}
		if(title!=null&&!"".equals(title)){
			hql.append(" and eqn.questionnaireName like:title ");
			paramList.add(new SqlParameter("title","%"+title+"%"));
		}
		hql.append(" order  by eqn.expirationTime desc  ");
		String hq=hql.toString();
	    System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list =(List<EQuestionnaire>) getRecordByPage(page, "select eqn " +hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	/**
	 * 根据questionnaireId userID 查看用户答卷状态
	 * @param questionnaireId
	 * @param userid
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public List<EQuestionnaireUser> queryByquestionnaireId(Long questionnaireId, Long userid) throws Exception{
		List<EQuestionnaireUser> questionnaireUser=null;
		String naire_user_hql = "from EQuestionnaireUser eqnu where eqnu.questionnaireId = :questionnaireId and eqnu.userid = :userid ";
		try {
			questionnaireUser =(List<EQuestionnaireUser>)super.executeQuery(naire_user_hql, new SqlParameter("questionnaireId", questionnaireId), new SqlParameter("userid", userid));
		return  questionnaireUser;
		} catch (Exception e) {
			log.error("查询用户问卷失败queryByDeptId(Long deptId)");
        	throw e;
		}
	}
	/**
	 * 根据questionnaireId查询问卷
	 * @param questionnaireId
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public EQuestionnaire queryById(Long questionnaireId, Long userid) throws Exception {
		EQuestionnaire result = null;
		String naire_hql = "from EQuestionnaire eqn where eqn.questionnaireId = :questionnaireId";
		
		String naire_user_hql = "from EQuestionnaireUser eqnu where eqnu.questionnaireId = :questionnaireId and eqnu.userid = :userid ";
		
		StringBuffer question_sql_sb = new StringBuffer();
		question_sql_sb.append("select eqnq.question_id as questionId, eqnq.question_name as questionName, eqnq.question_type as questionType, eqnq.choose as choose, eqnaa.content as content ")
			.append("from e_quesnaire_question eqnq left join ")
			.append("	(select question_id, content from  e_quesnaire_answer_ans where 1=1 ")
			.append("		/~ and user_naireid = '[naireuserid]' ~/ ")
			.append("	)eqnaa on eqnq.question_id = eqnaa.question_id ")
			.append(" where 1 = 1 ")
			.append(" /~ and eqnq.questionnaire_id = '[questionnaireId]' ~/ ")
			.append(" order by eqnq.question_id ");
		
		StringBuffer option_sql_sb = new StringBuffer();
		option_sql_sb.append("select eqnqo.id, eqnqo.question_id, eqnqo.content, eqnca.option_id ")
			.append("from e_quesnaire_ques_option eqnqo left join ")
			.append("	(select question_id ,option_id from e_quesnaire_choice_ans where 1=1 ")
			.append(" 		/~ and question_id = '[questionid]' ~/ ")
			.append(" 		/~ and user_naireid = '[naireuserid]' ~/ ")
			.append("	) eqnca on eqnqo.question_id = eqnca.question_id and eqnqo.id = eqnca.option_id ")
			.append(" where 1 = 1 ")
			.append(" /~ and eqnqo.question_id = '[questionid]' ~/ ")
			.append(" order by eqnqo.id ");
		XsqlBuilder xsqlBuilder = new XsqlBuilder();
		Map params = new HashMap();
		try {
			List<EQuestionnaire> list = super.executeQuery(naire_hql, new SqlParameter("questionnaireId", questionnaireId));
			if(list.size() > 0) {
				result = list.get(0);
				List<EQuestionnaireUser> naireuserlist = super.executeQuery(naire_user_hql, new SqlParameter("questionnaireId", questionnaireId), new SqlParameter("userid", userid));
				if(naireuserlist.size() > 0 ) {
					EQuestionnaireUser naireuser = naireuserlist.get(0);
					result.setNaireUserId(naireuser.getId());
					result.setNaireUserStatus(naireuser.getStatus());
				}else{
					result.setNaireUserId(-1L);
				}
				params.clear();
				params.put("naireuserid", result.getNaireUserId());
				params.put("questionnaireId", questionnaireId);
				SQLQuery question_query = (SQLQuery) super.createQuery(QUERY_TYPE_SQL, xsqlBuilder.generateSql(question_sql_sb.toString(), params).getXsql());
				question_query.addScalar("questionId", Hibernate.LONG);
				question_query.addScalar("questionName", Hibernate.STRING);
				question_query.addScalar("questionType", Hibernate.STRING);
				question_query.addScalar("choose", Hibernate.STRING);
				question_query.addScalar("content", Hibernate.STRING);
				question_query.setResultTransformer(Transformers.aliasToBean(EQuesnaireQuestion.class));
				List<EQuesnaireQuestion> questions = question_query.list();
				
				result.setQuesnaireQuestions(questions);
				for(EQuesnaireQuestion question: questions) {
					params.clear();
					params.put("questionid", question.getQuestionId());
					params.put("naireuserid", result.getNaireUserId());
					SQLQuery option_query = (SQLQuery) super.createQuery(QUERY_TYPE_SQL, xsqlBuilder.generateSql(option_sql_sb.toString(), params).getXsql());
					option_query.addScalar("id", Hibernate.LONG);
					option_query.addScalar("question_id", Hibernate.LONG);
					option_query.addScalar("content", Hibernate.STRING);
					option_query.addScalar("option_id", Hibernate.LONG);
					option_query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
					List options = option_query.list();
					question.setQuesnaireQuesOptions(options);
				}
			}
			question_sql_sb = null;
			option_sql_sb = null;
			return result;
		}catch(Exception e) {
			log.error("根据questionnaireId查询问卷失败queryById(Long id)");
			throw e;
		}
	}
	
	/**
	 * 根据ID查询用户问卷
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public EQuestionnaireUser queryQuestionnaireUser(Long id) throws Exception {
		
		EQuestionnaireUser result = null;
		String hql = "from EQuestionnaireUser eqnu where eqnu.id = :id ";
		try {
			List<EQuestionnaireUser> list = super.executeQuery(hql, new SqlParameter("id", id));
			if(list.size() > 0) {
				result = list.get(0);
			}
		}catch(Exception e) {
			log.error("根据id查询问卷失败queryQuestionnaireUser(Long id)");
			throw e;
		}
		return result;
	}
	
	/**
	 * 根据用户问卷ID删除问题
	 * @param id
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public void deleteQuestionByNaireUserId(Long id) throws Exception {
//		String del_ques_hql = "delete EQuesnaireUserQues eqnuq where eqnuq.questionnaireUser.id = :id";
		String del_choice_ans_hql = "delete EQuesnaireChoiceAns eqnca where eqnca.questionnaireUser.id = :id";
		String del_answer_ans_hql = "delete EQuesnaireAnswerAns eqnaa where eqnaa.questionnaireUser.id = :id";
		try {
			super.executeUpdate(del_choice_ans_hql, new SqlParameter("id", id));
			super.executeUpdate(del_answer_ans_hql, new SqlParameter("id", id));
//			super.executeUpdate(del_ques_hql, new SqlParameter("id", id));
		} catch(Exception e) {
			log.error("根据用户问卷ID删除问题失败deleteQuestionByNaireUserId(Long id)");
			throw e;
		}
	}

	private static final Log log = LogFactory.getLog(com.sino.elearning.questionnaire.dao.impl.EQuestionNaireDaoImpl.class);
}
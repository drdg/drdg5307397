package com.sino.elearning.questionnaire.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.elearning.questionnaire.bean.EQuesnaireAnswerAns;
import com.sino.elearning.questionnaire.bean.EQuesnaireChoiceAns;
import com.sino.elearning.questionnaire.bean.EQuestionnaire;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;
import com.sino.elearning.questionnaire.dao.IEQuestionNaireDao;
import com.sino.elearning.questionnaire.service.IEQuestionNaireService;
/**
 * 用户问卷service实现类
 * @author Administrator
 *
 */
public class EQuestionNaireServiceImpl implements IEQuestionNaireService {
	
	private IEQuestionNaireDao questionNaireDao;

	/**
	 * 根据部门查询用户问卷
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> queryByDeptId(Long deptId) throws Exception {
		try {
			return questionNaireDao.queryByDeptId(deptId);
		}catch(Exception e) {
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
		try {
			return questionNaireDao.queryByDeptId(page, deptId);
		} catch(Exception e) {
			log.error("查询用户问卷失败queryByDeptId(PaginationBean page, Long deptId)");
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
		return questionNaireDao.findByTitle(page, deptId, title);
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
		try {
			return questionNaireDao.queryByquestionnaireId(questionnaireId, userid);
		}catch(Exception e) {
			log.error("根据id查询问卷失败queryById(Long id)");
        	throw e;
		}
	}
	/**
	 * 根据id查询问卷
	 * @param id
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public EQuestionnaire queryById(Long id, Long userid) throws Exception {
		try {
			return questionNaireDao.queryById(id, userid);
		}catch(Exception e) {
			log.error("根据id查询问卷失败queryById(Long id)");
        	throw e;
		}
	}
	
	/**
	 * 保存用户问卷及答案
	 * 
	 * @param questionnaireUser
	 * @param question_list
	 * @param choice_ans_list
	 * @param answer_ans_list
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public Serializable save(EQuestionnaireUser questionnaireUser,
			List<EQuesnaireChoiceAns> choice_ans_list,
			List<EQuesnaireAnswerAns> answer_ans_list) throws Exception {
		Serializable result = null;
		try {
			result = questionNaireDao.save(questionnaireUser);
			for(EQuesnaireChoiceAns choiceAns: choice_ans_list) {
				questionNaireDao.save(choiceAns);
			}
			for(EQuesnaireAnswerAns answerAns: answer_ans_list) {
				questionNaireDao.save(answerAns);
			}
		} catch (Exception e) {
			log.error("保存用户问卷及答案失败save");
        	throw e;
		}
		return result;
	}
	
	/**
	 * 修改用户问卷及答案
	 * 
	 * @param questionnaireUser
	 * @param question_list
	 * @param choice_ans_list
	 * @param answer_ans_list
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void modify(EQuestionnaireUser questionnaireUser,
			List<EQuesnaireChoiceAns> choice_ans_list,
			List<EQuesnaireAnswerAns> answer_ans_list) throws Exception {
		try{
			questionNaireDao.update(questionnaireUser);
			questionNaireDao.deleteQuestionByNaireUserId(questionnaireUser.getId());
			for(EQuesnaireChoiceAns choiceAns: choice_ans_list) {
				questionNaireDao.save(choiceAns);
			}
			for(EQuesnaireAnswerAns answerAns: answer_ans_list) {
				questionNaireDao.save(answerAns);
			}
		} catch (Exception e) {
			log.error("更改用户问卷及答案失败modify");
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
		try {
			return questionNaireDao.queryQuestionnaireUser(id);
		} catch (Exception e) {
			log.error("根据ID查询用户问卷失败queryQuestionnaireUser(Long id)");
        	throw e;
		}
	}
	
	public IEQuestionNaireDao getQuestionNaireDao() {
		return questionNaireDao;
	}

	public void setQuestionNaireDao(IEQuestionNaireDao questionNaireDao) {
		this.questionNaireDao = questionNaireDao;
	}
	
	private static final Log log = LogFactory.getLog(com.sino.elearning.questionnaire.service.impl.EQuestionNaireServiceImpl.class);

}
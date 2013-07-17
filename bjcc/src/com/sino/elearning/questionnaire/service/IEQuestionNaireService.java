package com.sino.elearning.questionnaire.service;

import java.io.Serializable;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.questionnaire.bean.EQuesnaireAnswerAns;
import com.sino.elearning.questionnaire.bean.EQuesnaireChoiceAns;
import com.sino.elearning.questionnaire.bean.EQuestionnaire;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;

/**
 * 用户问卷service接口
 * 
 * @author Administrator
 * 
 */
public interface IEQuestionNaireService {

	/**
	 * 根据部门查询用户问卷
	 * 
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> queryByDeptId(Long deptId) throws Exception;

	/**
	 * 根据部门查询用户问卷
	 * @param page
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> queryByDeptId(PaginationBean page, Long deptId) throws Exception;
	
	/**
	 * 根据调查问卷名进行模糊查询
	 * @param page
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaire> findByTitle (PaginationBean page, Long deptId,String title) throws Exception;
	/**
	 * 根据questionnaireId userID 查看用户答卷状态
	 * @param questionnaireId
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<EQuestionnaireUser> queryByquestionnaireId(Long questionnaireId, Long userid) throws Exception;
	/**
	 * 根据id查询问卷
	 * @param id
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public EQuestionnaire queryById(Long id, Long userid) throws Exception;

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
	public Serializable save(EQuestionnaireUser questionnaireUser,
			List<EQuesnaireChoiceAns> choice_ans_list,
			List<EQuesnaireAnswerAns> answer_ans_list) throws Exception;
	
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
	public void modify(EQuestionnaireUser questionnaireUser,
			List<EQuesnaireChoiceAns> choice_ans_list,
			List<EQuesnaireAnswerAns> answer_ans_list) throws Exception;
	
	/**
	 * 根据ID查询用户问卷
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EQuestionnaireUser queryQuestionnaireUser(Long id) throws Exception;
}
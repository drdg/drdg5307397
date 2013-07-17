package com.sino.elearning.questionnaire.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.basedao.IBaseDao;
import com.sino.elearning.questionnaire.bean.EQuestionnaire;
import com.sino.elearning.questionnaire.bean.EQuestionnaireUser;
/**
 * 用户问卷dao接口
 * @author Administrator
 *
 */
public interface IEQuestionNaireDao extends IBaseDao {
	
	/**
	 * 根据部门查询用户问卷
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
	 * 根据questionnaireId查询问卷
	 * @param questionnaireId
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public EQuestionnaire queryById(Long questionnaireId, Long userid) throws Exception;
	
	/**
	 * 根据ID查询用户问卷
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public EQuestionnaireUser queryQuestionnaireUser(Long id) throws Exception;
	
	/**
	 * 根据用户问卷ID删除问题
	 * @param id
	 * @throws Exception
	 */
	public void deleteQuestionByNaireUserId(Long id) throws Exception;
	
}
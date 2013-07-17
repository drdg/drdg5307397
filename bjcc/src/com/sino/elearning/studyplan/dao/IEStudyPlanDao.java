package com.sino.elearning.studyplan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.sino.elearning.basedao.IBaseDao;
import com.sino.elearning.studyplan.bean.EStudyPlan;
/**
 * 学习计划dao接口
 * @author Administrator
 *
 */
public interface IEStudyPlanDao extends IBaseDao {

	/**
	 * 根据参数查询学习计划
	 * @param wheresql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<EStudyPlan> findByParams(String wheresql, Map params) throws Exception;
	
	/**
	 * 验证该课程是否已经加入到某天的学习计划
	 * @param date
	 * @param programId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean validateProgram(String date, Long programId, Long userId) throws Exception;
}
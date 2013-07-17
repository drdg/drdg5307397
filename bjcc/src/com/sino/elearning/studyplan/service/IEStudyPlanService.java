package com.sino.elearning.studyplan.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sino.elearning.studyplan.bean.EStudyPlan;
import com.sino.elearning.studyplan.bean.EStudyProgram;

/**
 * 学习计划管理service接口类
 * @author Administrator
 *
 */
public interface IEStudyPlanService {

	/**
	 * 保存学习计划
	 * @param plan
	 */
	public Serializable save(EStudyPlan plan) throws Exception;
	
	/**
	 * 保存或更新学习计划
	 * @param plan
	 */
	public void saveOrUpdate(EStudyPlan plan) throws Exception;
	
	/**
	 * 保存学习计划
	 * @param plan
	 */
	public void save(List<EStudyPlan> planList) throws Exception;
	
	/**
	 * 根据参数查询学习计划
	 * @param wheresql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<EStudyPlan> findByParams(String wheresql, Map params) throws Exception;
	
	/**
	 * 删除学习计划
	 * @param planList
	 * @throws Exception
	 */
	public void delete(List<EStudyPlan> planList) throws Exception;
	
	/**
	 * @param program
	 * @throws Exception
	 */
	public void delete(EStudyProgram program) throws Exception;
	
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

package com.sino.elearning.studyplan.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.sino.elearning.studyplan.bean.EStudyPlan;
import com.sino.elearning.studyplan.bean.EStudyProgram;
import com.sino.elearning.studyplan.dao.IEStudyPlanDao;
import com.sino.elearning.studyplan.service.IEStudyPlanService;
/**
 * 学习计划管理
 * @author Administrator
 *
 */
public class EStudyPlanServiceImpl implements IEStudyPlanService {
	
	private IEStudyPlanDao studyPlanDao;
	
	/**
	 * 保存学习计划
	 * @param plan
	 */
	@Transactional(readOnly=false)
	public Serializable save(EStudyPlan plan) throws Exception {
		Serializable result = null;
		Map params = new HashMap();
		params.put("userId", plan.getUserId());
		params.put("studyTime", plan.getStudyTime());
		try{
			List<EStudyPlan> list = studyPlanDao.findByParams(null, params);
			if(null!=list && list.size()>0) {
				EStudyPlan obj = list.get(0);
				plan.setStudyPlanId(obj.getStudyPlanId());
				EStudyProgram program;
				for(Object object: obj.getStudyPrograms()) {
					program = (EStudyProgram)object;
					program.setEStudyPlan(null);
					studyPlanDao.delete(program);
				}
				obj.setCnt(plan.getCnt());
				obj.setCreatTime(plan.getCreatTime());
				obj.setDeptId(plan.getDeptId());
				obj.setDeptName(plan.getDeptName());
				obj.setStudyPrograms(plan.getStudyPrograms());
				obj.setStudyTime(plan.getStudyTime());
				obj.setUserId(plan.getUserId());
				obj.setUserNm(plan.getUserNm());
				for(Object object: plan.getStudyPrograms()) {
					program = (EStudyProgram)object;
					program.setEStudyPlan(obj);
				}
				studyPlanDao.update(obj);
			}else{
				result = studyPlanDao.save(plan);
			}
		}catch(Exception e){
			log.error("保存学习计划失败 save()");
			throw e;
		}
		return result;
	}
	
	/**
	 * 保存或更新学习计划
	 * @param plan
	 */
	@Transactional(readOnly=false)
	public void saveOrUpdate(EStudyPlan plan) throws Exception {
		try{
			studyPlanDao.saveOrUpdate(plan);
			studyPlanDao.getCurSession().clear();
		}catch(Exception e){
			log.error("保存学习计划失败 saveOrUpdate()");
			throw e;
		}
	}
	
	/**
	 * 保存学习计划
	 * @param plan
	 */
	@Transactional(readOnly=false)
	public void save(List<EStudyPlan> planList) throws Exception {
		try {
			for(EStudyPlan plan: planList) {
				if(plan.getStudyPrograms().size() == 0) {
					studyPlanDao.delete(plan);
				} else {
					studyPlanDao.saveOrUpdate(plan);
				}
			}
		}catch(Exception e){
			log.error("保存学习计划失败 save()");
			throw e;
		}
	}
	
	/**
	 * 根据参数查询学习计划
	 * @param wheresql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<EStudyPlan> findByParams(String wheresql,Map params) throws Exception{
		List<EStudyPlan> list = null;
		try {
			list = studyPlanDao.findByParams(wheresql, params);
		} catch (Exception e) {
			log.error("查询学习计划失败 findByParams()");
			throw e;
		}
		return list;
	}
	
	/**
	 * 删除学习计划
	 * @param planList
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public void delete(List<EStudyPlan> planList) throws Exception {
		try{
			for(EStudyPlan plan: planList) {
				studyPlanDao.delete(plan);
			}
		} catch (Exception e) {
			log.error("删除学习计划失败 delete()");
			throw e;
		}
	}
	
	/**
	 * 验证该课程是否已经加入到某天的学习计划
	 * @param date
	 * @param programId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public boolean validateProgram(String date, Long programId, Long userId) throws Exception {
		try {
			return studyPlanDao.validateProgram(date, programId, userId);
		}catch (Exception e) {
			log.error("验证该课程是否已经加入到某天的学习计划失败 validateProgram()");
			throw e;
		}
	}
	
	/**
	 * @param program
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public void delete(EStudyProgram program) throws Exception {
		studyPlanDao.delete(program);
	}
	public IEStudyPlanDao getStudyPlanDao() {
		return studyPlanDao;
	}

	public void setStudyPlanDao(IEStudyPlanDao studyPlanDao) {
		this.studyPlanDao = studyPlanDao;
	}
	
	private static final Log log = LogFactory.getLog(com.sino.elearning.studyplan.service.impl.EStudyPlanServiceImpl.class);
}
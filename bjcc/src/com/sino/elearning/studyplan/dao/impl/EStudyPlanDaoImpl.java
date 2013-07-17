package com.sino.elearning.studyplan.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.studyplan.bean.EStudyPlan;
import com.sino.elearning.studyplan.bean.EStudyProgram;
import com.sino.elearning.studyplan.dao.IEStudyPlanDao;
/**
 * 学习计划管理dao接口类
 * @author Administrator
 *
 */
public class EStudyPlanDaoImpl extends PersistenceBase implements
		IEStudyPlanDao {
	
	/**
	 * 根据参数查询学习计划
	 * @param wheresql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<EStudyPlan> findByParams(String wheresql, Map params) throws Exception{
		List<EStudyPlan> list = null;
		StringBuffer hql = new StringBuffer();
        Object values[] = new Object[params.size()];
        int i = 0;
        hql.append("from EStudyPlan as esp where 1=1");
        if(null!=wheresql && wheresql.length()>0) {
        	hql.append(wheresql);
        }
        for(Iterator iterator = params.keySet().iterator(); iterator.hasNext();)
        {
            String key = (String)iterator.next();
            hql.append(" and");
            hql.append(" esp.");
            hql.append(key);
            hql.append("=?");
            values[i] = params.get(key);
            i++;
        }
        
        String qureString = hql.toString();
        
        try {
        	list = getHibernateTemplate().find(qureString, values);
        } catch ( Exception e ) {
        	log.error("查询学习计划失败findByParams(Map params)");
        	throw e;
        }
		return list;
	}
	
	/**
	 * 验证该课程是否已经加入到某天的学习计划
	 * @param date
	 * @param programId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean validateProgram(String date, Long programId, Long userId) throws Exception {
		
		boolean result = true;
		String hql = "from EStudyProgram a join a.EStudyPlan b where a.programId = ? and b.studyTime = ? and b.userId = ? ";
		try {
			List<EStudyProgram> list = getHibernateTemplate().find(hql, new Object[]{programId, date, userId});
			if(list.size() > 0) {
				result = false;
			}else {
				result = true;
			}
		}catch ( Exception e ) {
			e.printStackTrace();
        	log.error("验证该课程是否已经加入到某天的学习计划失败validateProgram");
        	throw e;
        }
		return result;
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.studyplan.dao.impl.EStudyPlanDaoImpl.class);
}
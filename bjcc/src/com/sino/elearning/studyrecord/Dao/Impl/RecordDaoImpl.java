package com.sino.elearning.studyrecord.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.mapping.Array;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.media.bean.Program;
import com.sino.bjcc.videoRank.bean.SinoUserBehavior;
import com.sino.elearning.studyrecord.Dao.IRecordDao;
import com.sino.elearning.studyrecord.bean.EAttendee;
import com.sino.elearning.studyrecord.bean.ETrainMessage;

public class RecordDaoImpl extends PersistenceBase implements IRecordDao{

	@SuppressWarnings("unchecked")
	public List<SinoUserBehavior> findAll(PaginationBean page) {
		try
		{
		 String queryString = "from SinoUserBehavior";
		 List<SinoUserBehavior> resources=getHibernateTemplate().find(queryString);
		 return resources;
		}
		catch (RuntimeException re)
		{
			log.error("查询个人学习需求失败。", re);
			throw re;
		}
	}

	public SinoUserBehavior findById(long id) {
		try
		{
			SinoUserBehavior equestion = (SinoUserBehavior)getHibernateTemplate().get("com.sino.bjcc.videoRank.bean.SinoUserBehavior", id);
        
        return equestion;
		}
		catch (RuntimeException re)
		{
			log.error("根据需求Id查询个人学习需求失败。", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SinoUserBehavior> findByUserId(PaginationBean page,long userId) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<SinoUserBehavior> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from SinoUserBehavior as eq where 1=1");
		if(userId!=0){
			hql.append(" AND eq.userId=:UserId  ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		hql.append(" AND eq.resourcesType = 2 ");
		hql.append(" order by eq.createTime desc");
		String hq=hql.toString();
	    System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page.toString());
		System.out.println(page.getTotalRecord()+"记录");
		list =(List<SinoUserBehavior>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	
	public ETrainMessage findByTrainId(long id) {
		try
		{
			ETrainMessage equestion = (ETrainMessage)getHibernateTemplate().get("com.sino.elearning.studyrecord.bean.ETrainMessage", id);
        
        return equestion;
		}
		catch (RuntimeException re)
		{
			log.error("根据需求Id查询集体学习需求失败。", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<EAttendee> findByUserNM(PaginationBean page, String userNM) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<EAttendee> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from EAttendee as eq where 1=1");
		if(userNM!=null||!"".equals(userNM)){
			hql.append(" AND eq.attendee like :userNM ");
			paramList.add(new SqlParameter("userNM", "%"+userNM+"%"));
		}
		String hq=hql.toString();
		System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list= (List<EAttendee>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<ETrainMessage> findByTrainUserId(PaginationBean page,long userId) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<ETrainMessage> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from ETrainMessage as eq where 1=1");
		if(userId!=0){
			hql.append(" AND eq.userId=:UserId order by eq.creatTime desc ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		String hq=hql.toString();
		System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list= (List<ETrainMessage>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<ETrainMessage> findByTrainText(PaginationBean page,
			long userId, String textfield) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<ETrainMessage> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from ETrainMessage etm, EAttendee eta  where 1=1 ");
		hql.append(" and etm.trainId = eta.trainId and etm.mark = '1' ");
		if(userId!=0){
			hql.append(" AND eta.userid=:UserId ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		if(textfield!=null &&!"".equals(textfield)){
			hql.append(" AND etm.trainTheme like :trainTheme ");
			paramList.add(new SqlParameter("trainTheme", "%"+textfield+"%"));
		}
		hql.append(" order by etm.creatTime desc ");
		String hq=hql.toString();
		System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list= (List<ETrainMessage>) getRecordByPage(page, "select etm "+hq,paramList.toArray(new SqlParameter[]{}));
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<SinoUserBehavior> findByUserText(PaginationBean page, long userId,
			String textfield) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<SinoUserBehavior> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from SinoUserBehavior as eq where 1=1");
		if(userId!=0){
			hql.append(" AND eq.userId=:UserId ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		if(textfield!=null &&!"".equals(textfield)){
			hql.append(" AND eq.resourcesName  like :resourcesName");
			paramList.add(new SqlParameter("resourcesName", "%"+textfield+"%"));
		}
		hql.append(" AND eq.resourcesType = 2 ");
		hql.append(" order by eq.createTime desc ");
		String hq=hql.toString();
	    System.out.println(hql);
		String queryString= "select count(*) "+hq;
		page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
		System.out.println(page);
		System.out.println(page.getTotalRecord()+"记录");
		list =(List<SinoUserBehavior>) getRecordByPage(page, hq,paramList.toArray(new SqlParameter[]{}));
		return list;
		
	}
	@SuppressWarnings("unchecked")
	public List<ETrainMessage> findTrainAll(PaginationBean page) {
		try
		{
		 String queryString = "from ETrainMessage";
		 List<ETrainMessage> resources=getHibernateTemplate().find(queryString);
		 return resources;
		}
		catch (RuntimeException re)
		{
			log.error("查询集体学习需求失败。", re);
			throw re;
		}
	}
	
	/**
	 * 根据参加人用户ID查询集体记录
	 * @param page
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ETrainMessage> findByAttendUserId(PaginationBean page,Long userId) throws Exception {
		
		List<ETrainMessage> list = null;
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		StringBuffer hql = new StringBuffer();
		hql.append("from ETrainMessage as etm, EAttendee eta  where 1=1 ");
		hql.append(" and etm.trainId = eta.trainId and etm.mark = '1' ");
		if(null != userId ){
			hql.append(" AND eta.userid=:UserId order by etm.creatTime desc ");
			paramList.add(new SqlParameter("UserId", userId));
		}
		String hq=hql.toString();
		System.out.println(hql);
		String queryString= "select count(etm) "+hq;
		try {
			page = getRecordCount(page, queryString, paramList.toArray(new SqlParameter[]{}));
			System.out.println(page);
			System.out.println(page.getTotalRecord()+"记录");
			list= (List<ETrainMessage>) getRecordByPage(page, "select etm "+hq,paramList.toArray(new SqlParameter[]{}));
		} catch (RuntimeException re){
			log.error("根据参加人用户ID查询集体记录失败。", re);
			throw re;
		}
		return list;
	}
	
	private static final Log log = LogFactory.getLog("com.sino.elearning.studyrecord.Dao.Impl.RecordDaoImpl");
}

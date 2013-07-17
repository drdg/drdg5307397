package com.sino.elearning.msg.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.ano.SupervisorService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;
import com.sino.elearning.msg.dao.EReceiveMessageDao;

public class EReceiveMessageDaoImpl extends PersistenceBase implements
		EReceiveMessageDao {

	/**
	 * 保存用户接收信息
	 */
	public Long saveReceiveMessage(EReceiveMessage receiveMessage) {
		return Long.parseLong(save(receiveMessage).toString());
	}

	/**
	 * 查询所有的接收信息
	 */
	@SuppressWarnings("unchecked")
	public List<EReceiveMessage> findAllReceiveMessage() {
		List<EReceiveMessage> list = null;
		list = getHibernateTemplate().find("FROM EReceiveMessage");
		return list;
	}

	/**
	 * 查询当前用户接收的信息30
	 */
	@SuppressWarnings("unchecked")
	public List<EReceiveMessage> findAll(PaginationBean page,
			final String receiveName) {
		// List<EReceiveMessage> list = null;
		// list = getHibernateTemplate().find(
		// "FROM EReceiveMessage t where t.receiveName = ? ",
		// new Object[] { receiveName });
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<EReceiveMessage> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from EReceiveMessage as eq where 1=1");
		if (receiveName.length() != 0) {
			hql.append(" AND eq.receiveName=:receiveName ");
			paramList.add(new SqlParameter("receiveName", receiveName));
		}
		hql.append(" AND eq.mesStatus = '0' ");
		hql.append(" ORDER BY receiveMsgId DESC");
		String hq = hql.toString();
		String queryString = "select count(*) " + hq;
		page = getRecordCount(page, queryString, paramList
				.toArray(new SqlParameter[] {}));
		System.out.println(page.getTotalRecord() + "记录");
		list = (List<EReceiveMessage>) getRecordByPage(page, hq, paramList
				.toArray(new SqlParameter[] {}));
		return list;
	}

	/**
	 * 查询接收的信息
	 */
	public EReceiveMessage findById(final long recId) {
		return (EReceiveMessage) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.load(EReceiveMessage.class, recId);
					}
				});
	}
	/**
	 * 逻辑删除收件箱的信息
	 * 
	 * @param id
	 * */
	public void delfoReceiveId(String id){
		EReceiveMessage receiveMessage = findById(Long.valueOf(id));
		receiveMessage.setMesStatus("1");
		getHibernateTemplate().update(receiveMessage);
	};
	/**
	 * 删除收件箱的信息
	 */
	 
	public void delByReceiveId(String receiveId) {
		EReceiveMessage receiveMessage = findById(Long.valueOf(receiveId));
		getHibernateTemplate().delete(receiveMessage);
	}
	/**
	 * 根据id查询群发用户信息
	 * */
	@SuppressWarnings("unchecked")
	public List<EReceiveMessage> findById(Long id,String receiveName){
	    List<EReceiveMessage> list = null;
	    try{
	    	StringBuffer hql = new StringBuffer();
			hql.append("from EReceiveMessage as eq where 1=1");
			if (id!=null&&!"".equals(id)) {
				hql.append(" and eq.websiteMessage.id= ");
				hql.append(id);
			}
			if(receiveName!=null&&!"".equals(receiveName)){
				hql.append(" and eq.receiveName !=  ");
				hql.append(receiveName);
			}
			String hq = hql.toString();
			list = getHibernateTemplate().find(hq);
	    } catch (RuntimeException re)
	    {
	    	log.error("根据用户Id查询学习需求失败。", re);
	    	throw re;
	    }
		return list;
	};
	/**
	 * 查询收件箱中全部未读的信息
	 */
	public List<EReceiveMessage> findAllUnreadMessage(String receiveName, String status) {
		String queryString = "from EReceiveMessage as eq where 1=1 and eq.receiveName=? and eq.status=? and eq.mesStatus='0' ";
	    List<EReceiveMessage> list = null;
	    try{
	    	list = getHibernateTemplate().find(queryString, new Object[]{receiveName,status});
	    } catch (RuntimeException re)
	    {
	    	log.error("根据用户Id查询学习需求失败。", re);
	    	throw re;
	    }
		return list;

	}
	/**
	 * 查询收件箱中未读的信息30
	 */
	 
	public List<EReceiveMessage> findUnreadMessage(PaginationBean page,
			String receiveName, String status) {

		// List<EReceiveMessage> list = null;
		// list = getHibernateTemplate()
		// .find(
		// "FROM EReceiveMessage t where t.receiveName = ? and t.status = ? ",
		// new Object[] { receiveName, status }); 
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<EReceiveMessage> list = null;
		StringBuffer hql = new StringBuffer();
		hql.append("from EReceiveMessage as eq where 1=1");
		if (receiveName.length() != 0) {
			hql.append(" AND eq.receiveName=:receiveName ");
			paramList.add(new SqlParameter("receiveName", receiveName));
		}
		if (status.length() != 0) {
			hql.append(" AND eq.status=:status ");
			paramList.add(new SqlParameter("status", status));
		}
		hql.append(" AND eq.mesStatus = '0' ");
		String hq = hql.toString();
		String queryString = "select count(*) " + hq;
		page = getRecordCount(page, queryString, paramList
				.toArray(new SqlParameter[] {}));
		System.out.println(page.getTotalRecord() + "记录");
		list = (List<EReceiveMessage>) getRecordByPage(page, hq, paramList
				.toArray(new SqlParameter[] {}));
		return list;
	}

	/**
	 * 查询需要回复的信息
	 */
	 
	public EReceiveMessage findReplyMessage(long receiveMsgId,
			String receiveName) {
		EReceiveMessage message = null;
		List<EReceiveMessage> list = null;
		list = getHibernateTemplate()
				.find(
						"FROM EReceiveMessage t where t.receiveMsgId = ? and t.receiveName = ? ",
						new Object[] { receiveMsgId, receiveName });
		if (list.size() > 0) {
			message = list.get(0);
		}
		return message;
	}

	/**
	 * 查询需要转发的信息
	 */
	 
	public EReceiveMessage findTransferMessage(long receiveMsgId,
			String receiveName) {
		EReceiveMessage message = null;
		List<EReceiveMessage> list = null;
		list = getHibernateTemplate()
				.find(
						"FROM EReceiveMessage t where t.receiveMsgId = ? and t.receiveName = ? ",
						new Object[] { receiveMsgId, receiveName });
		if (list.size() > 0) {
			message = list.get(0);
		}
		return message;
	}
	
	/**
	 * 查看收件箱详细信息
	 */
	 
	public EReceiveMessage findDetailMessage(long receiveMsgId,
			String receiveName) {
		EReceiveMessage message = null;
		List<EReceiveMessage> list = null;
		list = getHibernateTemplate()
				.find(
						"FROM EReceiveMessage t where t.receiveMsgId = ? and t.receiveName = ? ",
						new Object[] { receiveMsgId, receiveName });
		if (list.size() > 0) {
			message = list.get(0);
		}
		return message;
	}
	public int updateObject(final String hql, final Object[] params) {
		Integer res = 0;
		try {
			res = (Integer) getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session)throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					if (params != null) {
						for (int i = 0; i < params.length; i++) {
							query.setParameter(i, params[i]);
						}
					}
					return query.executeUpdate();
				}
			});
		}catch (RuntimeException re){
			System.out.println("updateObject EvaluationTest failed:"+hql);
			throw re;
		}
		return res;
	}
	private static final Log log = LogFactory.getLog("com.sino.elearning.msg.dao.impl.EReceiveMessageDaoImpl");
}

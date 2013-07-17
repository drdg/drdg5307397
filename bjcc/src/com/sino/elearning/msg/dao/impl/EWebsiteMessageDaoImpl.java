package com.sino.elearning.msg.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;
import com.sino.elearning.msg.dao.EWebsiteMessageDao;

/**
 * @author WANGNING 2012-11-17
 * 
 */
public class EWebsiteMessageDaoImpl extends PersistenceBase implements
		EWebsiteMessageDao {

	/**
	 * 保存站内信息
	 */
	public Long saveMessage(EWebsiteMessage websiteMessage) {
		return Long.parseLong(save(websiteMessage).toString());
	}

	/**
	 * 查询当前用户发件箱的信息30
	 */
	@SuppressWarnings("all")
	public List<EWebsiteMessage> findAll(PaginationBean page,
			final String sendUsername, final String status) {
		// List<EWebsiteMessage> list = null;
		// list = getHibernateTemplate().find("FROM EWebsiteMessage");
		// list = getHibernateTemplate()
		// .find(
		// "FROM EWebsiteMessage t where t.sendUsername = ? and t.status = ? ",
		// new Object[] { sendUsername, status });
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		List<EWebsiteMessage> list = null;
		List<EReceiveMessage> recrive=null;
		StringBuffer hql = new StringBuffer();
		hql.append("from EWebsiteMessage as eq where 1=1");
		if (sendUsername.length() != 0) {
			hql.append(" AND eq.sendUsername=:sendUsername ");
			paramList.add(new SqlParameter("sendUsername", sendUsername));
		}
		if (status.length() != 0) {
			hql.append(" AND eq.status=:status ");
			paramList.add(new SqlParameter("status", status));
		}
		hql.append(" ORDER BY sendTime DESC ");
		String hq = hql.toString();
		String queryString = "select count(*) " + hq;
		page = getRecordCount(page, queryString, paramList
				.toArray(new SqlParameter[] {}));
		System.out.println(page.getTotalRecord() + "记录");
		list = (List<EWebsiteMessage>) getRecordByPage(page, hq, paramList
				.toArray(new SqlParameter[] {}));
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				recrive = getHibernateTemplate().find(
					"FROM EReceiveMessage t where t.websiteMessage.id = ? ",new Object[] {list.get(i).getId()});
				list.get(i).setListusers(recrive);
			}
		}
		return list;

	}

	/**
	 * 按id进行查询站内信息
	 */
	public EWebsiteMessage findById(long id) {
		return (EWebsiteMessage) getHibernateTemplate().load(
				EWebsiteMessage.class, id);

	}

	/**
	 * 验证用户姓名
	 */
	 
	public List<Map> verifyUserNames(String[] userNames) {
		// TODO Auto-generated method stub
		// select * from sys_flow_user a where a.username in
		// ('admin','test','aaa');
		List paramList = new ArrayList();

		StringBuffer verifySql = new StringBuffer();
		verifySql
				.append("select a.userid, a.username from sys_flow_user a where a.username in (");
		for (int i = 0; i < userNames.length; i++) {
			if (userNames[i].trim().length() > 0) {
				verifySql.append("'");
				verifySql.append(userNames[i]).append("',");
			}
		}
		verifySql.deleteCharAt(verifySql.toString().length() - 1);
		verifySql.append(")");
		final String sqlQuery = verifySql.toString();

		List<Map> list = super.executeSqlMap(sqlQuery.toString());

		return list;
	}

	/**
	 * 逻辑删除发件箱的信息
	 */
	 
	public void delMessageById(String id) {
		EWebsiteMessage websiteMessage = findById(Long.valueOf(id));
		websiteMessage.setStatus("1");
		getHibernateTemplate().update(websiteMessage);
	}
	/**
	 * 删除发件箱的信息
	 * 
	 * @param id
	 */
	public void delByMessageId(String id){
		EWebsiteMessage websiteMessage = findById(Long.valueOf(id));
		getHibernateTemplate().delete(websiteMessage);
	};
	/**
	 * 保存转发信息
	 */
	 
	public Long saveTransferMessage(EWebsiteMessage websiteMessage) {
		return Long.parseLong(save(websiteMessage).toString());
	}

	/**
	 * 保存回复信息
	 */
	 
	public Long saveReplyMessage(EWebsiteMessage websiteMessage) {
		return Long.parseLong(save(websiteMessage).toString());
	}
	/**
	 * 查看发件箱详细信息
	 */
	@SuppressWarnings("unchecked")
	public EWebsiteMessage findDetailWebMessage(long id,
			String sendUsername) {
		EWebsiteMessage message = null;
		List<EWebsiteMessage> list = null;
		List<EReceiveMessage> recrive=null;
		list = getHibernateTemplate()
				.find(
						"FROM EWebsiteMessage t where t.id = ? and t.sendUsername = ? ",
						new Object[] { id, sendUsername });
		recrive = getHibernateTemplate()
					.find(
						"FROM EReceiveMessage t where t.websiteMessage.id = ? ",new Object[] {id});
		if (list.size() > 0) {
			message = list.get(0);
		}
		message.setListusers(recrive);
		return message;
	}
}

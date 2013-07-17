package com.sino.bjcc.leaveMessage.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.leaveMessage.bean.LeaveMessage;
import com.sino.bjcc.leaveMessage.persistence.ILeaveMessageDao;

public class LeaveMessageDaoImpl extends PersistenceBase implements ILeaveMessageDao {

	/**
	 * 方法说明：新建留言
	 */
	public void createLeaveMessage(LeaveMessage leaveMessage) {
		save(leaveMessage);
	}

	/**
	 * 方法说明：获取所有留言
	 */
	@SuppressWarnings("unchecked")
	public List<LeaveMessage> getAllLeaveMessage(PaginationBean pagiBean, long typeId) {
		//查询所有留言的sql
		String hql = "From LeaveMessage Where typeId = :typeId And isAudit=1";
		//查询所有留言所需参数
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlParameter("typeId", typeId));
		SqlParameter[] sqlParam = params.toArray(new SqlParameter[]{});
		
		//查询符合条件的记录数量
		pagiBean = getRecordCount(pagiBean, "Select Count(*) " + hql, sqlParam);
		//查询符合条件的记录
		List<LeaveMessage> msgList = (List<LeaveMessage>) getRecordByPage(pagiBean, hql+" Order By createDate Desc", sqlParam);
		return msgList;
	}

	/**
	 * 方法说明：根据用户ID获取与用户相关的所有留言
	 */
	@SuppressWarnings("unchecked")
	public List<LeaveMessage> getPersonalLeaveMessage(PaginationBean pagiBean, long userId, long typeId) {
		//查询个人留言的sql
		String hql = "From LeaveMessage Where userId = :userId And typeId = :typeId";
		//查询个人留言的sql参数
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlParameter("userId", userId));
		params.add(new SqlParameter("typeId", typeId));
		SqlParameter[] sqlParam = params.toArray(new SqlParameter[]{});
		
		//查询符合条件的记录数量
		pagiBean = getRecordCount(pagiBean, "Select Count(*) " + hql, sqlParam);
		//查询符合条件的记录
		List<LeaveMessage> msgList = (List<LeaveMessage>) getRecordByPage(pagiBean, hql+" Order By createDate Desc", sqlParam);
		return msgList;
	}

}

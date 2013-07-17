package com.sino.bjcc.leaveMessage.persistence;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.leaveMessage.bean.LeaveMessage;

public interface ILeaveMessageDao {

	/**
	 * 方法说明：获取所有留言
	 */
	public List<LeaveMessage> getAllLeaveMessage(PaginationBean pagiBean, long typeId);
	
	/**
	 * 方法说明：根据用户ID获取与用户相关的所有留言
	 */
	public List<LeaveMessage> getPersonalLeaveMessage(PaginationBean pagiBean, long userId, long typeId);
	
	/**
	 * 方法说明：新建留言
	 */
	public void createLeaveMessage(LeaveMessage leaveMessage);
	
}

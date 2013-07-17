package com.sino.bjcc.leaveMessage.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.leaveMessage.bean.LeaveMessage;

public interface ILeaveMessageService {

	/**
	 * 方法说明：新建留言信息
	 */
	public void createLeaveMessage(long typeId,long userId,String userName,String msgContent);
	
	/**
	 * 方法说明：获取所有留言
	 */
	public List<LeaveMessage> getAllLeaveMessage(PaginationBean pagiBean, long typeId);
	
	/**
	 * 方法说明：获取个人留言
	 */
	public List<LeaveMessage> getPersonalLeaveMessage(PaginationBean pagiBean, long typeId, long userId);
	
}

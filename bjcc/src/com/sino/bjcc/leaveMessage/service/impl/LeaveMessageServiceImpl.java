package com.sino.bjcc.leaveMessage.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.leaveMessage.bean.LeaveMessage;
import com.sino.bjcc.leaveMessage.persistence.ILeaveMessageDao;
import com.sino.bjcc.leaveMessage.service.ILeaveMessageService;

public class LeaveMessageServiceImpl implements ILeaveMessageService {

	private ILeaveMessageDao leaveMessageDao = null;	//留言信息Dao
	/**
	 * 获取留言信息Dao
	 */
	public ILeaveMessageDao getLeaveMessageDao() {
		return leaveMessageDao;
	}
	/**
	 * 设置留言信息Dao
	 */
	public void setLeaveMessageDao(ILeaveMessageDao leaveMessageDao) {
		this.leaveMessageDao = leaveMessageDao;
	}

	/**
	 * 方法说明：新建留言信息
	 */
	@Transactional(readOnly=false)
	public void createLeaveMessage(long typeId, long userId, String userName, String msgContent) {
		LeaveMessage message = new LeaveMessage();
		message.setContent(msgContent);
		message.setCreateDate(DateTimeUtil.getNow());
		message.setTypeId(typeId);
		message.setUserId(userId);
		message.setMsgName(userName);
		getLeaveMessageDao().createLeaveMessage(message);
	}

	/**
	 * 方法说明：获取所有留言
	 */
	public List<LeaveMessage> getAllLeaveMessage(PaginationBean pagiBean, long typeId) {
		return getLeaveMessageDao().getAllLeaveMessage(pagiBean, typeId);
	}

	/**
	 * 方法说明：获取个人留言
	 */
	public List<LeaveMessage> getPersonalLeaveMessage(PaginationBean pagiBean, long typeId, long userId) {
		return getLeaveMessageDao().getPersonalLeaveMessage(pagiBean, userId, typeId);
	}

}

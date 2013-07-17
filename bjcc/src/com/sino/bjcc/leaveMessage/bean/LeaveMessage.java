package com.sino.bjcc.leaveMessage.bean;

import java.util.Date;

import com.sino.bjcc.common.utility.DateTimeUtil;

public class LeaveMessage {

	private long id = 0;				//主键ID
	private long userId = 0;			//用户ID
	private String msgName = null;		//留言用户昵称
	private String title = null;		//留言标题
	private String content = null;		//留言内容
	private Date createDate = null;		//留言时间
	private String replyName = null;	//回复人姓名
	private String replyContent = null;	//专家回复
	private int status = 0;				//状态
	private Date replyDate = null;		//更新时间
	private long typeId = 0;			//留言类型ID
	private int isAudit = 0;			//是否审核
	
	/**
	 * 获取留言信息ID
	 */
	public long getId() {
		return id;
	}
	/**
	 * 设置留言信息ID
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 获取留言用户ID
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * 设置留言用户ID
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取留言用户名
	 */
	public String getMsgName() {
		return msgName;
	}
	/**
	 * 设置留言用户名
	 */
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	
	/**
	 * 获取留言标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置留言标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取留言内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置留言标题
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取留言时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置留言时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取指定格式的留言时间
	 */
	public String getCreateDateStr(){
		if(null == getCreateDate()){
			return null;
		}
		return DateTimeUtil.ConvertDate2String(getCreateDate(), DateTimeUtil.FORMAT_YMDHMS);
	}
	
	/**
	 * 获取留言回复人姓名
	 */
	public String getReplyName() {
		return replyName;
	}
	/**
	 * 设置留言回复人姓名
	 */
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	
	/**
	 * 获取留言回复内容
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * 设置留言回复内容
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	/**
	 * 获取留言状态
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 设置留言状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * 获取留言回复时间
	 */
	public Date getReplyDate() {
		return replyDate;
	}
	/**
	 * 设置留言回复时间
	 */
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	/**
	 * 获取指定格式的留言回复时间
	 */
	public String getReplyDateStr(){
		if(null == getReplyDate()){
			return null;
		}
		return DateTimeUtil.ConvertDate2String(getReplyDate(), DateTimeUtil.FORMAT_YMDHMS);
	}
	
	/**
	 * 获取留言类型ID
	 */
	public long getTypeId() {
		return typeId;
	}
	/**
	 * 设置留言类型ID
	 */
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	/**
	 * 获取审核标记
	 */
	public int getIsAudit() {
		return isAudit;
	}
	/**
	 * 设置审核标记
	 */
	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}
	
}

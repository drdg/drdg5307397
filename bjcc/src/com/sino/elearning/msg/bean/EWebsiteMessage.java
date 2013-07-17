package com.sino.elearning.msg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EWebsiteMessage implements Serializable {
	private static final long serialVersionUID = -2365844904700148241L;
	/**
	 * 主键标识
	 */
	private Long id;
	/**
	 * 发信人姓名
	 */
	private String sendUsername;
	/**
	 * 短信标题
	 */
	private String msgTitle;
	/**
	 * 短信内容
	 */
	private String msgContent;
	/**
	 * 发送时间
	 */
	private String sendTime;
	/**
	 * 状态
	 */
	private String status = "0";
	/**
	 * 接收短信人
	 */
	private String receiveusers;
	/**
	 * 接收短信的集合
	 */
	private List<EReceiveMessage> listusers = new ArrayList<EReceiveMessage>();

	public List<EReceiveMessage> getListusers() {
		return listusers;
	}

	public void setListusers(List<EReceiveMessage> listusers) {
		this.listusers = listusers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSendUsername() {
		return sendUsername;
	}

	public void setSendUsername(String sendUsername) {
		this.sendUsername = sendUsername;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceiveusers() {
		return receiveusers;
	}

	public void setReceiveusers(String receiveusers) {
		this.receiveusers = receiveusers;
	}

}

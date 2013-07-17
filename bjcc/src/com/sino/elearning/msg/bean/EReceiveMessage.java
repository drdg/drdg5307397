package com.sino.elearning.msg.bean;

import java.io.Serializable;

/**
 * @author wangning
 * 
 * 2012-11-17
 */
public class EReceiveMessage implements Serializable {

	private static final long serialVersionUID = -1733957522593404885L;
	/**
	 * 接收短信ID
	 */
	private long receiveMsgId;
	/**
	 * 接收人姓名
	 */
	private String receiveName;
	/**
	 * 接收短信状态
	 */
	private String status = "0";
	/**
	 * 接收短信状态
	 */
	private String mesStatus = "0";
	/**
	 * 接收短信
	 */
	private EWebsiteMessage websiteMessage;

	public long getReceiveMsgId() {
		return receiveMsgId;
	}

	public void setReceiveMsgId(long receiveMsgId) {
		this.receiveMsgId = receiveMsgId;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public EWebsiteMessage getWebsiteMessage() {
		return websiteMessage;
	}

	public void setWebsiteMessage(EWebsiteMessage websiteMessage) {
		this.websiteMessage = websiteMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMesStatus() {
		return mesStatus;
	}

	public void setMesStatus(String mesStatus) {
		this.mesStatus = mesStatus;
	}

}
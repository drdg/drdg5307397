package com.sino.bjcc.search.bean;

import java.util.Date;

public class SKeyCode { 
	private long keyId;			//关键词ID
	private String name;		//关键词名称
	private String sync;		//是否同步为长城热词
	private Date createTime;	//创建时间
	private String url;			//url地址
	private long num;			//检索次数
	
	/**
	 * 获取检索次数
	 */
	public long getNum() {
		return num;
	}
	/**
	 * 设置检索次数
	 */
	public void setNum(long num) {
		this.num = num;
	}
	
	/**
	 * 获取关键词指向URL地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置关键词指向URL地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 获取关键词ID
	 */
	public long getKeyId() {
		return keyId;
	}
	/**
	 * 设置关键词ID
	 */
	public void setKeyId(long keyId) {
		this.keyId = keyId;
	}
	
	/**
	 * 获取关键词
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置关键词
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取是否同步为热词的flag
	 */
	public String getSync() {
		return sync;
	}
	/**
	 * 设置是否同步为热词的flag
	 */
	public void setSync(String sync) {
		this.sync = sync;
	}
	
	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}

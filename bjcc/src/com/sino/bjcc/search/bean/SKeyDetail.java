package com.sino.bjcc.search.bean;

import java.util.Date;

public class SKeyDetail {

	private long detailId;		//检索履历ID
	private long keyId;			//关键词ID
	private String name;		//关键词
	private Date searchTime; 	//检索时间
	
	/**
	 * 获取检索履历ID
	 */
	public long getDetailId() {
		return detailId;
	}
	/**
	 * 设置检索履历ID
	 */
	public void setDetailId(long detailId) {
		this.detailId = detailId;
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
	 * 获取检索时间
	 */
	public Date getSearchTime() {
		return searchTime;
	}
	/**
	 * 设置检索时间
	 */
	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}

}

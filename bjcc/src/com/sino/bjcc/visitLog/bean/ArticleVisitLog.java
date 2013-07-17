package com.sino.bjcc.visitLog.bean;

import java.util.Date;

public class ArticleVisitLog {

	private long id = 0 ;			//ID主键
	private long articleId = 0;		//文章ID
	private long siteId = 0;		//站点ID
	private String system = null;	//系统
	private String browser = null;	//浏览器
	private String ipAddress = null;//IP地址
	private Date creationDate = null;//访问时间

	/**
	 * 获取主键
	 */
	public long getId() {
		return id;
	}
	/**
	 * 设置主键
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 获取访问文章ID
	 */
	public long getArticleId() {
		return articleId;
	}
	/**
	 * 设置访问文章ID
	 */
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	/**
	 * 获取访问文章所在站点ID
	 */
	public long getSiteId() {
		return siteId;
	}
	/**
	 * 设置访问文章所在站点ID
	 */
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	/**
	 * 获取用户的系统
	 */
	public String getSystem() {
		return system;
	}
	/**
	 * 设置用户的系统
	 */
	public void setSystem(String system) {
		this.system = system;
	}
	
	/**
	 * 获取用户的浏览器名称及版本
	 */
	public String getBrowser() {
		return browser;
	}
	/**
	 * 设置用户的浏览器名称及版本
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	/**
	 * 获取用户的IP
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * 设置用户的IP
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * 获取用户访问时间
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * 设置用户访问时间
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}

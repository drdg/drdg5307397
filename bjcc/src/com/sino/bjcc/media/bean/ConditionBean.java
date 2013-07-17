package com.sino.bjcc.media.bean;

public class ConditionBean { 
	
	private String date;			//时间
	private String form;			//媒体类型
	private String source;			//征集来源
	private String audien;			//学习对象
	private String tag;				//标签
	private String keyWord;			//关键字
	private String sourceOrg;		//提供单位
	
	/**
	 * 获取时间
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置时间
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * 获取媒体类型
	 */
	public String getForm() {
		return form;
	}
	/**
	 * 设置媒体类型
	 */
	public void setForm(String form) {
		this.form = form;
	}
	
	/**
	 * 获取征集来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置征集来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * 获取学习对象
	 */
	public String getAudien() {
		return audien;
	}
	/**
	 * 设置学习对象
	 */
	public void setAudien(String audien) {
		this.audien = audien;
	}
	
	/**
	 * 获取检索关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 设置检索关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	/**
	 * 获取提供单位
	 */
	public String getSourceOrg() {
		return sourceOrg;
	}
	/**
	 * 设置提供单位
	 */
	public void setSourceOrg(String sourceOrg) {
		this.sourceOrg = sourceOrg;
	}
	
	/**
	 * 获取标签
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置标签
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}

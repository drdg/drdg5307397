package com.sino.bjcc.search.bean;

public class SearchConditionBean {

	private int timeRange = 0;			//时间段
	private String keyWord = null;		//关键字
	private String sortField = null;	//排序字段
	private String sortType = null;		//排序类型
	
	/**
	 * 获取检索时间段
	 */
	public int getTimeRange() {
		return timeRange;
	}
	/**
	 * 设置检索时间段
	 */
	public void setTimeRange(int timeRange) {
		this.timeRange = timeRange;
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
		if(null!=keyWord){
			keyWord = keyWord.trim();
		}
		this.keyWord = keyWord;
	}
	
	/**
	 * 获取排序字段
	 */
	public String getSortField() {
		return sortField;
	}
	/**
	 * 设置排序字段
	 */
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	
	/**
	 * 获取排序类型
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * 设置排序类型
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
}

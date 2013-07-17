package com.sino.bjcc.common.bean;

public class SearchFileBean {
	private String modifyDate = null;		//最后更新时间
	private String title = null;			//标题
	private String content = null;			//内容
	private String path = null;				//路径
	
	/**
	 * 获取最后更新时间
	 */
	public String getModifyDate() {
		return modifyDate;
	}
	/**
	 * 设置最后更新时间
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	/**
	 * 获取标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取文件路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置文件路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}

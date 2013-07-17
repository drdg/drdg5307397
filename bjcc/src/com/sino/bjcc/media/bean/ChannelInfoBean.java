package com.sino.bjcc.media.bean;

public class ChannelInfoBean {

	private String id = null;		//cms_channel栏目ID
	private String code = null;		//sino_channel视频频道ID
	private String parentId = null;	//父栏目ID
	private String path = null;		//发布路径
	
	/**
	 * 获取网站栏目ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置网站栏目ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取视频频道ID
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置视频频道ID
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 获取父栏目ID
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置父栏目ID
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取发布路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置发布路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}

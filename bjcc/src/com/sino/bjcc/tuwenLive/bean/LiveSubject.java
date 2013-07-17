package com.sino.bjcc.tuwenLive.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 	功能描述： 	图文直播管理-主题Bean对象<br/>
 */
public class LiveSubject {

	private long subjectId= 0;				//主题ID
	private String title = null;			//主题名称
	private String description = null;		//主题简介
	private Date publishDate = null;		//发布日期
	private String publishUrl = null;		//发布URL
	private String state = null;			//状态
	private Date createDate = null;			//创建时间
	private Date updateDate = null;			//最后修改时间
	private String delFlag = null;			//删除flag
	
	private List<LiveContent> contentList = new ArrayList<LiveContent>();  //内容列表
	private List<LivePicture> pictureList = new ArrayList<LivePicture>();  //图片列表
	
	/**
	 * 获取主题IDs
	 */
	public long getSubjectId() {
		return subjectId;
	}
	/**
	 * 设置主题ID
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	/**
	 * 获取主题名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置主题名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取主题介绍
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置主题介绍
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取发布日期
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置发布日期
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * 获取发布URL
	 */
	public String getPublishUrl() {
		return publishUrl;
	}
	/**
	 * 设置发布URL
	 */
	public void setPublishUrl(String publishUrl) {
		this.publishUrl = publishUrl;
	}
	
	/**
	 * 获取主题状态（是否发布）
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置主题状态（是否发布）
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * 获取创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取最后更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置最后更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 获取删除FLAG
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置删除FLAG
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	/**
	 * 获取内容列表
	 */
	public List<LiveContent> getContentList() {
		return contentList;
	}
	/**
	 * 设置内容列表
	 */
	public void setContentList(List<LiveContent> contentList) {
		this.contentList = contentList;
	}
	
	/**
	 * 获取图片列表
	 */
	public List<LivePicture> getPictureList() {
		return pictureList;
	}
	/**
	 * 设置图片列表
	 */
	public void setPictureList(List<LivePicture> pictureList) {
		this.pictureList = pictureList;
	}
	
}

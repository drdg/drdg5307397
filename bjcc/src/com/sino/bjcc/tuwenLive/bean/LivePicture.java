package com.sino.bjcc.tuwenLive.bean;

import java.util.Date;

public class LivePicture {
	
	private long pictureId= 0;				//内容ID
	private long subjectId = 0;				//所属主题ID
	private String url = null;				//内容信息
	private String title = null;			//图片名称
	private String description = null;      //图片说明
	private String spokeTime = null;		//上传时间
	private Date createDate = null;			//创建时间
	private Date updateDate = null;			//最后修改时间
	private String delFlag = null;			//删除flag
	
	/**
	 * 获取图片ID
	 */
	public long getPictureId() {
		return pictureId;
	}
	/**
	 * 设置图片ID
	 */
	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}
	
	/**
	 * 获取图片URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置图片URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 获取图片名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置图片名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取图片说明
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置图片说明
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取图片上传时间
	 */
	public String getSpokeTime() {
		return spokeTime;
	}
	/**
	 * 设定图片上传时间
	 */
	public void setSpokeTime(String spokeTime) {
		this.spokeTime = spokeTime;
	}
	
	/**
	 * 获取所属主题ID
	 */
	public long getSubjectId() {
		return subjectId;
	}
	/**
	 * 设定所属主题ID
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
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
	
}

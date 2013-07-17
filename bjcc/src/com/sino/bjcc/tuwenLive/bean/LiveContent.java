package com.sino.bjcc.tuwenLive.bean;

import java.util.Date;

/**
 * 	功能描述： 	图文直播管理-内容Bean对象<br/>
 */
public class LiveContent {

	private long contentId= 0;				//内容ID
	private long subjectId = 0;				//所属主题ID
	private String spokesman = null;		//发言人---姓名、单位
	private String content = null;			//内容信息
	private String spokeTime = null;			//发言时间
	private Date createDate = null;			//创建时间
	private Date updateDate = null;			//最后修改时间
	private String delFlag = null;			//删除flag
	
	/**
	 * 获取内容ID
	 */
	public long getContentId() {
		return contentId;
	}
	/**
	 * 设置内容ID
	 */
	public void setContentId(long contentId) {
		this.contentId = contentId;
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
	 * 获取发言人
	 */
	public String getSpokesman() {
		return spokesman;
	}
	/**
	 * 设定发言人
	 */
	public void setSpokesman(String spokesman) {
		this.spokesman = spokesman;
	}
	
	/**
	 * 获取内容信息
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置内容信息
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取发言时间
	 */
	public String getSpokeTime() {
		return spokeTime;
	}
	/**
	 * 设定发言时间
	 */
	public void setSpokeTime(String spokeTime) {
		this.spokeTime = spokeTime;
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

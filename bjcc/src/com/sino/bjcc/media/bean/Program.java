package com.sino.bjcc.media.bean;

import java.util.Date;

public class Program {
	
	private long id;//节目ID 
	private String name;//节目的名称 
	private String ename;//节目的英文名称 
	private String orgCode;//组织编码 
	private String channel;//节目的分类编码
	private String provider;//提供商 
	private String timeLength;//时长 
	private String speaker;//演讲人 
	private String cast;//人员 
	private String role;//角色 
	private String releaseDate;//发布日期 
	private long num;//剧集数量 
	private Date createDate;//创建时间 
	private Date updateDate;//修改时间 
	private String summary;//视频介绍 
	private long sourceOrg;//来源机构 
	private long audiences;//学习对象
	private long form;//视频形式 
	private long source;//征集来源 
	private long county;//区县 0 中心 1、2、3... 区县ID
	private String middle_image;
	private String tags;//标签
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public long getSourceOrg() {
		return sourceOrg;
	}
	public void setSourceOrg(long sourceOrg) {
		this.sourceOrg = sourceOrg;
	}
	public long getAudiences() {
		return audiences;
	}
	public void setAudiences(long audiences) {
		this.audiences = audiences;
	}
	public long getForm() {
		return form;
	}
	public void setForm(long form) {
		this.form = form;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public long getCounty() {
		return county;
	}
	public void setCounty(long county) {
		this.county = county;
	}
	public String getMiddle_image() {
		return middle_image;
	}
	public void setMiddle_image(String middleImage) {
		middle_image = middleImage;
	}
	private ListBoxItem item;
	public ListBoxItem getItem() {
		return item;
	}
	public void setItem(ListBoxItem item) {
		this.item = item;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}

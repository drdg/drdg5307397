package com.sino.bjcc.media.bean;

import java.util.Date;

public class ComBean {
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
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public long getAddUserId() {
		return addUserId;
	}
	public void setAddUserId(long addUserId) {
		this.addUserId = addUserId;
	}
	public long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSourceOrg() {
		return sourceOrg;
	}
	public void setSourceOrg(String sourceOrg) {
		this.sourceOrg = sourceOrg;
	}
	public String getAudiences() {
		return audiences;
	}
	public void setAudiences(String audiences) {
		this.audiences = audiences;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getCounty() {
		return county;
	}
	public void setCounty(long county) {
		this.county = county;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
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
	private String statu;//状态
	private String createDate;//创建时间 
	private Date updateDate;//修改时间 
	private long addUserId;//添加该记录的用户ID 
	private long updateUserId;//修改记录的用户ID 
	private String summary;//视频介绍 
	private String sourceOrg;//来源机构 
	private String audiences;//学习对象
	private String form;//视频形式 
	private String source;//征集来源 
	private long county;//区县 0 中心 1、2、3... 区县ID
	private String tag;//标签
	private String vchannel;
	private String vname;
	private String play_url;
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getVId() {
		return vId;
	}
	public void setVId(long vId) {
		this.vId = vId;
	}
	private long vId;
	private String middle_image;//标签
	public String getMiddle_image() {
		return middle_image;
	}
	public void setMiddle_image(String middleImage) {
		middle_image = middleImage;
	}
	public String getVchannel() {
		return vchannel;
	}
	public void setVchannel(String vchannel) {
		this.vchannel = vchannel;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getPlay_url() {
		return play_url;
	}
	public void setPlay_url(String playUrl) {
		play_url = playUrl;
	}
}

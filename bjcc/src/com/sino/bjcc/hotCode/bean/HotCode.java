package com.sino.bjcc.hotCode.bean;

import java.util.Date;

public class HotCode {

	
	private long hotId;
	private String name;
	private String type;
	private String url;
	private String status;
	private Date createTime;
	private String desc;
	private long kId;
	
	public long getkId() {
		return kId;
	}
	public void setkId(long kId) {
		this.kId = kId;
	}
	public long getHotId() {
		return hotId;
	}
	public void setHotId(long hotId) {
		this.hotId = hotId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	}


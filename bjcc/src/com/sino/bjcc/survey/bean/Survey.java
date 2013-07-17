package com.sino.bjcc.survey.bean;

import java.util.Date;

public class Survey {
	private long id = 0;
	private String name = null;
	private long siteID;
	private String description;
	private Date startDate;
	private Date endDate;
	private int status;
	private int answerCount;
	private int ipCount = 1;
	private Date creationDate;
	private String owner;
	private long typeId = 0;

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

	public long getSiteID() {
		return this.siteID;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public int getIpCount() {
		return this.ipCount;
	}

	public int getStatus() {
		return this.status;
	}

	public String getOwner() {
		return this.owner;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public int getAnswerCount() {
		return this.answerCount;
	}

	public void setSiteID(long siteID) {
		this.siteID = siteID;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setIpCount(int ipCount) {
		this.ipCount = ipCount;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
}
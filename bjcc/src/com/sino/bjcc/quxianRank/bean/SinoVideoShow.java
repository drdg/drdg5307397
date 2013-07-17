package com.sino.bjcc.quxianRank.bean;

import java.util.Date;

/**
 * SinoVideoShow entity. @author MyEclipse Persistence Tools
 */
public class SinoVideoShow {

	private String videoId;
	private String departmentId;
	private String organizationId;
	private String decisionId;
	private Date stattime;
	private Date statdate;
	private Double viewDuration;
	private Long stationNum;
	private Long uploadNum;
	private Long clickNum;
	private String type;
	private Date creatdate;
	private String studyTerrace;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getDecisionId() {
		return decisionId;
	}
	public void setDecisionId(String decisionId) {
		this.decisionId = decisionId;
	}
	public Date getStattime() {
		return stattime;
	}
	public void setStattime(Date stattime) {
		this.stattime = stattime;
	}
	public Date getStatdate() {
		return statdate;
	}
	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}
	public Double getViewDuration() {
		return viewDuration;
	}
	public void setViewDuration(Double viewDuration) {
		this.viewDuration = viewDuration;
	}
	public Long getStationNum() {
		return stationNum;
	}
	public void setStationNum(Long stationNum) {
		this.stationNum = stationNum;
	}
	public Long getUploadNum() {
		return uploadNum;
	}
	public void setUploadNum(Long uploadNum) {
		this.uploadNum = uploadNum;
	}
	public Long getClickNum() {
		return clickNum;
	}
	public void setClickNum(Long clickNum) {
		this.clickNum = clickNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	public String getStudyTerrace() {
		return studyTerrace;
	}
	public void setStudyTerrace(String studyTerrace) {
		this.studyTerrace = studyTerrace;
	}
	
	

}

package com.sino.bjcc.videoRank.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 在这里我修改了一种字段类型 int 改成  Integer
 * 
 * */
/**
 * AbstractSinoUserBehavior entity provides the base persistence definition of
 * the SinoUserBehavior entity. @author MyEclipse Persistence Tools
 */

public class SinoUserBehavior {

	// Fields

	private Long ubrId;               //此表主键，标识
	private Long userId;              //用户标识
	private String userIp;                  //用户访问来源IP地址
	private Integer netType;				//用户使用网络类型（1：政务网，2：互联网）
	private Long itemId;				//资源所属栏目ID
	private Integer itemType;			//资源所属栏目类型（1：栏目，2：专题）
	private Long resourcesId;			//用户访问资源标识
	private Integer resourcesType;		//用户访问资源类型（1：图文，2：视频）
	private String resourcesName;			//用户访问资源名称
	private Date visitStarttime;			//用户观看视频资源开始时间
	private Date visitEndtime;				//用户观看视频资源结束时间
	private Integer visitLong;			//用户观看视频资源时长
	private Date createTime;				//本记录创建时间
	private String testState;				//评测试卷状态 0：没有填写评测试卷  1：已经填写评测问卷
	private String resultState;				//是否填写成效 0:没有填写  1:已经填写
	public Long getUbrId() {
		return ubrId;
	}
	public void setUbrId(Long ubrId) {
		this.ubrId = ubrId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Integer getNetType() {
		return netType;
	}
	public void setNetType(Integer netType) {
		this.netType = netType;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public Long getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(Long resourcesId) {
		this.resourcesId = resourcesId;
	}
	public Integer getResourcesType() {
		return resourcesType;
	}
	public void setResourcesType(Integer resourcesType) {
		this.resourcesType = resourcesType;
	}
	public String getResourcesName() {
		return resourcesName;
	}
	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}
	public Date getVisitStarttime() {
		return visitStarttime;
	}
	public void setVisitStarttime(Date visitStarttime) {
		this.visitStarttime = visitStarttime;
	}
	public Date getVisitEndtime() {
		return visitEndtime;
	}
	public void setVisitEndtime(Date visitEndtime) {
		this.visitEndtime = visitEndtime;
	}
	public Integer getVisitLong() {
		return visitLong;
	}
	public void setVisitLong(Integer visitLong) {
		this.visitLong = visitLong;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTestState() {
		return testState;
	}
	public void setTestState(String testState) {
		this.testState = testState;
	}
	public String getResultState() {
		return resultState;
	}
	public void setResultState(String resultState) {
		this.resultState = resultState;
	}
}
package com.sino.bjcc.timetable.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * AbstractCmsContentproperty entity provides the base persistence definition of
 * the CmsContentproperty entity. @author MyEclipse Persistence Tools
 */

public class CmsContentproperty {

	// Fields

	private BigDecimal id;
	private BigDecimal articleid;
	private BigDecimal schemaid;
	private BigDecimal doublevalue;
	private String stringvalue;
	private BigDecimal longvalue;
	private BigDecimal intvalue;
	private Date datevalue;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getArticleid() {
		return articleid;
	}
	public void setArticleid(BigDecimal articleid) {
		this.articleid = articleid;
	}
	public BigDecimal getSchemaid() {
		return schemaid;
	}
	public void setSchemaid(BigDecimal schemaid) {
		this.schemaid = schemaid;
	}
	public BigDecimal getDoublevalue() {
		return doublevalue;
	}
	public void setDoublevalue(BigDecimal doublevalue) {
		this.doublevalue = doublevalue;
	}
	public String getStringvalue() {
		return stringvalue;
	}
	public void setStringvalue(String stringvalue) {
		this.stringvalue = stringvalue;
	}
	public BigDecimal getLongvalue() {
		return longvalue;
	}
	public void setLongvalue(BigDecimal longvalue) {
		this.longvalue = longvalue;
	}
	public BigDecimal getIntvalue() {
		return intvalue;
	}
	public void setIntvalue(BigDecimal intvalue) {
		this.intvalue = intvalue;
	}
	public Date getDatevalue() {
		return datevalue;
	}
	public void setDatevalue(Date datevalue) {
		this.datevalue = datevalue;
	}

	
}
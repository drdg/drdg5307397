package com.sino.bjcc.timetable.bean;

import java.math.BigDecimal;
import java.util.Date;


/**
 * AbstractCmsArticle entity provides the base persistence definition of the
 * CmsArticle entity. @author MyEclipse Persistence Tools
 */

public class CmsArticle {

	// Fields

	private BigDecimal id;
	private BigDecimal parentid;
	private BigDecimal siteid;
	private BigDecimal sortid;
	private String name;
	private String vicetitle;
	private String keyword;
	private String source;
	private String summary;
	private String url;
	private String publishurl;
	private BigDecimal viewcount;
	private BigDecimal wordcount;
	private Integer grade;
	private String content;
	private String version;
	private Integer type;
	private Integer status;
	private Integer pubflag;
	private Date creationdate;
	private Date modifieddate;
	private Date publishdate;
	private String owner;
	private String author;
	private BigDecimal price;
	private String query1;
	private String query2;
	private Integer lockedflag;
	private String lockedby;
	private BigDecimal workflowstatus;
	private BigDecimal srccontentid;
	private BigDecimal istip;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getParentid() {
		return parentid;
	}
	public void setParentid(BigDecimal parentid) {
		this.parentid = parentid;
	}
	public BigDecimal getSiteid() {
		return siteid;
	}
	public void setSiteid(BigDecimal siteid) {
		this.siteid = siteid;
	}
	public BigDecimal getSortid() {
		return sortid;
	}
	public void setSortid(BigDecimal sortid) {
		this.sortid = sortid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVicetitle() {
		return vicetitle;
	}
	public void setVicetitle(String vicetitle) {
		this.vicetitle = vicetitle;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPublishurl() {
		return publishurl;
	}
	public void setPublishurl(String publishurl) {
		this.publishurl = publishurl;
	}
	public BigDecimal getViewcount() {
		return viewcount;
	}
	public void setViewcount(BigDecimal viewcount) {
		this.viewcount = viewcount;
	}
	public BigDecimal getWordcount() {
		return wordcount;
	}
	public void setWordcount(BigDecimal wordcount) {
		this.wordcount = wordcount;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPubflag() {
		return pubflag;
	}
	public void setPubflag(Integer pubflag) {
		this.pubflag = pubflag;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getQuery1() {
		return query1;
	}
	public void setQuery1(String query1) {
		this.query1 = query1;
	}
	public String getQuery2() {
		return query2;
	}
	public void setQuery2(String query2) {
		this.query2 = query2;
	}
	public Integer getLockedflag() {
		return lockedflag;
	}
	public void setLockedflag(Integer lockedflag) {
		this.lockedflag = lockedflag;
	}
	public String getLockedby() {
		return lockedby;
	}
	public void setLockedby(String lockedby) {
		this.lockedby = lockedby;
	}
	public BigDecimal getWorkflowstatus() {
		return workflowstatus;
	}
	public void setWorkflowstatus(BigDecimal workflowstatus) {
		this.workflowstatus = workflowstatus;
	}
	public BigDecimal getSrccontentid() {
		return srccontentid;
	}
	public void setSrccontentid(BigDecimal srccontentid) {
		this.srccontentid = srccontentid;
	}
	public BigDecimal getIstip() {
		return istip;
	}
	public void setIstip(BigDecimal istip) {
		this.istip = istip;
	}
	

	

}
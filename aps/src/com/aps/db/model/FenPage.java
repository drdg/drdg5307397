package com.aps.db.model;

/**
 * 分页类
 * @author 付政委
 *
 */
public class FenPage extends SerachType{
	
	private String pageS;			//获取数据能分出多少页
	private String pageCount;		//数据库数据总条数
	private String pageNow;			//当前第几页
	private String pageSize;		//每页大小多少条数据
	private String pageNum;			//每页显示几个页1、2、3、4、5例如这样五页
	
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getPageNow() {
		return pageNow;
	}
	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageS() {
		return pageS;
	}
	public void setPageS(String pageS) {
		this.pageS = pageS;
	}
	
}

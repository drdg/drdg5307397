package com.sino.bjcc.common.bean;

public class PaginationBean  {

	/**当前页 */
	private int currentPage = 1;
	
	/**每页记录数 */
	private int pageSize = 5;
	
	/**总页数 */
	private int totalPage = 0;

	/**总记录数*/
	private long totalRecord = 0;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		
		if(0 != getPageSize()){
			int pageNo = (int) (getTotalRecord()/getPageSize());
			int mod = (int) (getTotalRecord()%getPageSize());
			this.totalPage = mod>0 ? pageNo+1 : pageNo;
		}
		
		return totalPage;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}

package com.sino.bjcc.search.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.SearchFileBean;
import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.search.bean.SearchConditionBean;
import com.sino.bjcc.search.service.ISearchService;

@SuppressWarnings("serial")
public class SearchAction extends BaseAction {

	private ISearchService searchManager = null;	//检索Manager
	/**
	 * 获取检索Manager
	 */
	public ISearchService getSearchManager() {
		return searchManager;
	}
	/**
	 * 设置检索Manager
	 */
	public void setSearchManager(ISearchService searchManager) {
		this.searchManager = searchManager;
	}

	private List<SearchFileBean> fileList = null;	//OUT检索出的文件
	private SearchConditionBean condiBean = null;	//IN检索条件
	private String keyWord = null;					//IN关键字
	private long times = 0;							//检索使用时间
	
	/**
	 * 获取检索到的文件信息
	 */
	public List<SearchFileBean> getFileList() {
		return fileList;
	}
	/**
	 * 设置检索到的文件信息
	 */
	public void setFileList(List<SearchFileBean> fileList) {
		this.fileList = fileList;
	}

	/**
	 * 获取检索条件
	 */
	public SearchConditionBean getCondiBean() {
		if(null==this.condiBean){
			this.condiBean = new SearchConditionBean();
		}
		return condiBean;
	}
	/**
	 * 设置检索条件
	 */
	public void setCondiBean(SearchConditionBean condiBean) {
		this.condiBean = condiBean;
	}
	
	/**
	 * 获取检索关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 设置检索关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * 获取检索使用时间
	 */
	public long getTimes() {
		return times;
	}
	/**
	 * 设置检索使用时间
	 */
	public void setTimes(long times) {
		this.times = times;
	}

	/**
	 * 方法说明：检索文件
	 */
	public String searchFiles() throws UnsupportedEncodingException{
		Date start = new Date();
		if(!StringUtil.isNullOrEmpty(getKeyWord())){
			getCondiBean().setKeyWord(URLDecoder.decode(getKeyWord(),"utf-8"));
		}
		//查询相关文件
		setFileList(getSearchManager().search(getCondiBean(), getPaginationBean()));
		Date end = new Date();
		setTimes(end.getTime()-start.getTime());
		//新增或更新关键词
		getSearchManager().insertOrUpdateSkey(getCondiBean().getKeyWord());
		return SUCCESS;
	}
	
}

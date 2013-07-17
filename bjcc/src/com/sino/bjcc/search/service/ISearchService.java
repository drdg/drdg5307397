package com.sino.bjcc.search.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.bean.SearchFileBean;
import com.sino.bjcc.search.bean.SearchConditionBean;

public interface ISearchService {

	/**
	 * 方法说明：根据关键字检索出相关页面
	 */
	public List<SearchFileBean> search(SearchConditionBean condiBean, PaginationBean page);
	
	/**
	 * 方法说明：新增或更新关键词
	 */
	public int insertOrUpdateSkey(String key);
	
}

package com.sino.bjcc.search.service.impl;

import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.bean.SearchFileBean;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.common.utility.lucene.LuceneUtil;
import com.sino.bjcc.search.bean.SKeyCode;
import com.sino.bjcc.search.bean.SKeyDetail;
import com.sino.bjcc.search.bean.SearchConditionBean;
import com.sino.bjcc.search.persistence.ISearchDao;
import com.sino.bjcc.search.service.ISearchService;

public class SearchServiceImpl implements ISearchService {
	/**未同步**/
	private final String UN_SYNC = "0";
	
	private ISearchDao searchDao = null;	//检索Dao
	/**
	 * 获取检索Dao
	 */
	public ISearchDao getSearchDao() {
		return searchDao;
	}
	/**
	 * 设置检索Dao
	 */
	public void setSearchDao(ISearchDao searchDao) {
		this.searchDao = searchDao;
	}


	/**
	 * 方法说明：根据关键字检索出相关页面
	 */
	public List<SearchFileBean> search(SearchConditionBean condiBean, PaginationBean page){
		List<SearchFileBean> fileList = null;
		try{
			LuceneUtil util = new LuceneUtil();
			util.setDateRangeFilter(condiBean.getTimeRange());
			fileList = util.searchIndexFileResult(condiBean.getKeyWord(), page);
			String path = null;
			for(SearchFileBean file : fileList){
				path = file.getPath().replace(PropertyUtil.getProperty("lucene.search.dir"), PropertyUtil.getProperty("bjcc.portal.url"));
				path = path.replace("\\", "/");
				file.setPath(path);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return fileList;
	}
	
	/**
	 * 方法说明：新增或更新关键词
	 */
	public int insertOrUpdateSkey(String key){
		long keyId = 0; 
		Date createTime = DateTimeUtil.getNow();
		List<SKeyCode> list= getSearchDao().findSkeyCode(key);
		if(list.size()>0){
			//如果关键词已经存在，更新关键词信息
			SKeyCode sKey = list.get(0);
			//获取关键词ID
			keyId = sKey.getKeyId();
			sKey.setNum(sKey.getNum()+1);
			getSearchDao().updateKeyCode(sKey);
		}else{
			//如果不存在关键词则新增关键词信息
			SKeyCode sKey = new SKeyCode();
			sKey.setCreateTime(createTime);
			sKey.setName(key);
			sKey.setSync(UN_SYNC);  
			sKey.setNum(1);
			keyId = getSearchDao().createKeyCode(sKey);
		}
		//新增关键词检索履历
		SKeyDetail kDetail=new SKeyDetail();
		kDetail.setKeyId(keyId);
		kDetail.setName(key);
		kDetail.setSearchTime(createTime);
		getSearchDao().createKeyDetail(kDetail);
		return 1;
	}
	
}

package com.sino.bjcc.media.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.media.bean.ComBean;
import com.sino.bjcc.media.bean.ConditionBean;
import com.sino.bjcc.media.bean.ListBoxItem;

public interface IProgramService {
	
	/**
	 * 方法说明：获取视频信息
	 */
	public List<ComBean> getList(PaginationBean page, String channel, ConditionBean condiBean, List<ListBoxItem> itemList) throws Exception;

	/**
	 * 方法说明：获取栏目信息
	 */
	public String getChannel(String channel);
	
}

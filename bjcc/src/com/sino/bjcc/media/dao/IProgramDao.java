package com.sino.bjcc.media.dao;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.media.bean.ChannelInfoBean;

public interface IProgramDao {
	
	/**
	 * 方法说明：获取频道信息
	 */
	public ChannelInfoBean getChannelInfo(String channel);
	
	/**
	 * 方法说明：获取所有频道信息
	 */
	public List<ChannelInfoBean> getChannelList();
	
	/**
	 * 方法说明：获取视频信息
	 */
	@SuppressWarnings("unchecked")
	public List getList(PaginationBean pagiBean,String channel,String date,long sourceOrg,long source,long form,long audien,String tag,String search);
	
}

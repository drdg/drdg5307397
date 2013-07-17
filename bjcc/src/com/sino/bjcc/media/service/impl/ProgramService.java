package com.sino.bjcc.media.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.media.bean.ChannelInfoBean;
import com.sino.bjcc.media.bean.ComBean;
import com.sino.bjcc.media.bean.ConditionBean;
import com.sino.bjcc.media.bean.ListBoxItem;
import com.sino.bjcc.media.dao.IProgramDao;
import com.sino.bjcc.media.service.IProgramService;

public class ProgramService implements IProgramService {
	
	private IProgramDao programDao;		//视频Dao

	/**
	 * 设置视频Dao
	 */
	public void setProgramDao(IProgramDao programDao) {
		this.programDao = programDao;
	}
	/**
	 * 获取视频Dao
	 */
	public IProgramDao getProgramDao() {
		return programDao;
	}

	/**
	 * 方法说明：获取视频信息
	 */
	@SuppressWarnings("unchecked")
	public List<ComBean> getList(PaginationBean page, String channel, ConditionBean condiBean, List<ListBoxItem> itemList) throws Exception {
		long sourceOrg = 0, source = 0, form = 0, audien = 0;
		//提供单位ID
		if (!StringUtil.isNullOrEmpty(condiBean.getSourceOrg())) {
			sourceOrg = Long.parseLong(condiBean.getSourceOrg());
		}
		//征集来源ID
		if (!StringUtil.isNullOrEmpty(condiBean.getSource())) {
			source = Long.parseLong(condiBean.getSource());
		}
		//媒体类型ID
		if (!StringUtil.isNullOrEmpty(condiBean.getForm())) {
			form = Long.parseLong(condiBean.getForm());
		}
		//学习对象ID
		if (!StringUtil.isNullOrEmpty(condiBean.getAudien())) {
			audien = Long.parseLong(condiBean.getAudien());
		}
		//根据条件获取视频信息
		List programList = programDao.getList(page, channel, condiBean
				.getDate(), sourceOrg, source, form, audien,
				condiBean.getTag(), condiBean.getKeyWord());
		//把视频相关标签信息放入hashtable
		Hashtable<Long, ListBoxItem> itemTable = compItemList(itemList);
		//查询频道信息
		List<ChannelInfoBean> channelList = getProgramDao().getChannelList();
		Hashtable<String, ChannelInfoBean> sinoChannel = compSinoChannel(channelList);
		Hashtable<String, ChannelInfoBean> cmsChannel = compCmsChannel(channelList);
		
		return compResultList(programList, itemTable, sinoChannel, cmsChannel);
	}

	/**
	 * 方法说明：把检索条件item放入Hashtable
	 */
	private Hashtable<Long,ListBoxItem> compItemList(List<ListBoxItem> itemList){
		Hashtable<Long,ListBoxItem> htItems = new Hashtable<Long,ListBoxItem>();
		for(ListBoxItem item : itemList){
			htItems.put(item.getId(), item);
		}
		return htItems;
	}
	
	/**
	 * 方法说明：把视频频道信息并放入Hashtable
	 */
	private Hashtable<String, ChannelInfoBean> compSinoChannel(List<ChannelInfoBean> channelList){
		Hashtable<String, ChannelInfoBean> channelTable = new Hashtable<String, ChannelInfoBean>();
		//把频道信息放入hashtable，key为sino_channel的id，value为channelInfo
		for(ChannelInfoBean channel : channelList){
			if(StringUtil.isNullOrEmpty(channel.getCode())){
				continue;
			}
			channelTable.put(channel.getCode(), channel);
		}
		return channelTable;
	}

	/**
	 * 方法说明：把网站栏目信息并放入Hashtable
	 */
	private Hashtable<String, ChannelInfoBean> compCmsChannel(List<ChannelInfoBean> channelList){
		Hashtable<String, ChannelInfoBean> channelTable = new Hashtable<String, ChannelInfoBean>();
		//把频道信息放入hashtable，key为cms_channel的id，value为channelInfo
		for(ChannelInfoBean channel : channelList){
			channelTable.put(channel.getId(), channel);
		}
		return channelTable;
 	}
	
	/**
	 * 方法说明：封装检索结果，页面显示用
	 */
	@SuppressWarnings("unchecked")
	private List<ComBean> compResultList(List programList, Hashtable<Long,ListBoxItem> itemTable, 
			Hashtable<String, ChannelInfoBean> sinoChannel, Hashtable<String, ChannelInfoBean> cmsChannel) throws Exception{
		List<ComBean> comList = new ArrayList<ComBean>();
		String publishUrl = PropertyUtil.getProperty("bjcc.portal.url");
		for (int i = 0; i < programList.size(); i++) {
			Object[] obj = (Object[]) programList.get(i);
			ComBean comBean = new ComBean();
			//播放地址
			comBean.setPlay_url(StringUtil.convert2String(obj[0]));
			String vid = null==obj[1] ? "0" : String.valueOf(obj[1]);
			comBean.setVId(Long.parseLong(vid));
			//名称
			comBean.setName(StringUtil.convert2String(obj[2]));
			//图片
			comBean.setMiddle_image(StringUtil.convert2String(obj[3]));
			//描述
			String summary = StringUtil.convert2String(obj[4]);
			if (summary.length() > 60) {
				summary = summary.substring(0, 59) + " ... ...";
			} 
			comBean.setSummary(summary);
			//时间
			if (obj[5] != null) {
				comBean.setCreateDate(DateTimeUtil.ConvertDate2String((Date) obj[5], DateTimeUtil.FORMAT_YMDHMS));
			}
			//提供单位
			if(null!=obj[6] && null!=itemTable.get(Long.parseLong(obj[6].toString()))){
				comBean.setProvider(itemTable.get(Long.parseLong(obj[6].toString())).getValue());
			}
			//人员
			comBean.setCast(StringUtil.convert2String(obj[7]));
			//时长
			comBean.setTimeLength(StringUtil.convert2String(obj[8]));
			//演讲人
			comBean.setSpeaker(StringUtil.convert2String(obj[9]));
			//媒体类型
			if(null!=obj[10] && null!=itemTable.get(Long.parseLong(obj[10].toString()))){
				comBean.setForm(itemTable.get(Long.parseLong(obj[10].toString())).getValue());
			}
			if(null != obj[11]) {
				comBean.setChannel(obj[11].toString());
			}
			//拼接连接路径
			if( obj[11]!=null){
				String publishPath = getPublishPath(obj[11].toString(), sinoChannel, cmsChannel);
				comBean.setPath(publishUrl + publishPath + obj[12].toString() + ".html");
			}
			comList.add(comBean);
		}
		return comList;
	}

	/**
	 * 方法说明：获取视频发布路径
	 */
	private String 	getPublishPath(String ids, Hashtable<String,ChannelInfoBean> sinoChannel, Hashtable<String,ChannelInfoBean> cmsChannel){
		if(StringUtil.isNullOrEmpty(ids)){
			return null;
		}
		//分割id字符串，字符串格式为“,id1,id2,”，取最后一个ID作为视频的ID
		String[] idArr = ids.split(",");
		String key = idArr[idArr.length-1];
		//如果视频频道没有指定id的频道返回空
		if (!sinoChannel.containsKey(key)) {
			return null;
		}
		//声明视频发布路径的对象
		StringBuffer sbPath = new StringBuffer();
		ChannelInfoBean channel = sinoChannel.get(key);
		List<String> pathList = new ArrayList<String>();
		pathList.add("/");
		pathList.add(channel.getPath());
		//当栏目还有父栏目时，从cms栏目中取出父栏目的发布路径，直到顶级栏目
		while(!StringUtil.isNullOrEmpty(channel.getParentId())){
			if(!cmsChannel.containsKey(channel.getParentId())){
				break;
			}
			channel = cmsChannel.get(channel.getParentId());
			pathList.add("/");
			pathList.add(channel.getPath());
		}
		int size = pathList.size();
		//有父栏目时要去掉首页的发布路径
		if(size > 2){
			pathList.remove(size-1);
			pathList.remove(size-2);
		}
		for(int index = pathList.size()-1; index>=0; index--){
			sbPath.append(pathList.get(index));
		}
		return sbPath.toString();
	}
	
	/**
	 * 方法说明：获取栏目信息
	 */
	public String getChannel(String channelId) {
		//如果栏目id为空返回null
		if(StringUtil.isNullOrEmpty(channelId)){
			return null;
		}
		ChannelInfoBean channel = getProgramDao().getChannelInfo(channelId);
		//根据ID查询不到频道时返回null
		if(null == channel){
			return null;
		}
		List<String> idList = new ArrayList<String>();
		idList.add(channel.getCode());
		//查询父栏目信息
		while(!StringUtil.isNullOrEmpty(channel.getParentId())){
			channel = getProgramDao().getChannelInfo(channel.getParentId());
			//取不到栏目或栏目对应的视频id为空时跳出循环
			if(null==channel || StringUtil.isNullOrEmpty(channel.getCode())){
				break;
			}
			idList.add(channel.getCode());
		}
		StringBuffer sbChannel = new StringBuffer();
		sbChannel.append(",");
		for(int index=idList.size()-1; index>=0; index--){
			sbChannel.append(idList.get(index));
			sbChannel.append(",");
		}
		
		return sbChannel.toString();
	}
	
}

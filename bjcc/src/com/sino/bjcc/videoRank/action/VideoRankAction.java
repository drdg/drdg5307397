package com.sino.bjcc.videoRank.action;

import java.util.Iterator;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.videoRank.service.IVideoRankService;

public class VideoRankAction extends BaseAction{
	

	//表示资源类型的标识:2为视频
	private static final int RESOURCESTYPE = 2;
	
	//视频资源名称
	private String resourcesName;
	public String getResourcesName() {
		return resourcesName;
	}
	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}
	//视频资源id
	private String resourcesId;
	public String getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}
	
	//月份排行的视频List
	private List listMonth;
	//季度排行的视频List
	private List listSeason;
	//年份排行的视频List
	private List listYear;
	
	public List getListMonth() {
		return listMonth;
	}
	public void setListMonth(List listMonth) {
		this.listMonth = listMonth;
	}
	public List getListSeason() {
		return listSeason;
	}
	public void setListSeason(List listSeason) {
		this.listSeason = listSeason;
	}
	public List getListYear() {
		return listYear;
	}
	public void setListYear(List listYear) {
		this.listYear = listYear;
	}
	
	//排行的Service
	private IVideoRankService videoRankService;
	
	public IVideoRankService getVideoRankService() {
		return videoRankService;
	}
	public void setVideoRankService(IVideoRankService videoRankService) {
		this.videoRankService = videoRankService;
	}
	
	//获取视频月排行列表
	public String videoRankList() {
		//视频点播月排行List
		listMonth = videoRankService.MonthRank(RESOURCESTYPE);
		//视频点播季排行List
		listSeason = videoRankService.SeasonRank(RESOURCESTYPE);
		//视频点播年排行List
		listYear = videoRankService.YearRank(RESOURCESTYPE);
		

		
 

		
		return SUCCESS;
	}
	

}

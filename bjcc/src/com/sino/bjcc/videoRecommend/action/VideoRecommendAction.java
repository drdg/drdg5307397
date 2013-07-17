package com.sino.bjcc.videoRecommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.videoRecommend.service.IVideoRecommendService;

public class VideoRecommendAction extends BaseAction{

	private IVideoRecommendService newVideoManager;
	

	public IVideoRecommendService getNewVideoManager() {
		return newVideoManager;
	}

	public void setNewVideoManager(IVideoRecommendService newVideoManager) {
		this.newVideoManager = newVideoManager;
	}
	private List videoList;
	
	public List getVideoList() {
		return videoList;
	}

	public void setVideoList(List videoList) {
		this.videoList = videoList;
	}
    //获取视频信息及播放地址
	public String palyUrl(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		int num = Integer.valueOf(request.getParameter("num"));
		videoList = newVideoManager.playUrl(num);
		
		return SUCCESS;
	}
	
}

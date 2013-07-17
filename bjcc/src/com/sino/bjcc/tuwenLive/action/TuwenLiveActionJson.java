package com.sino.bjcc.tuwenLive.action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.tuwenLive.bean.LiveContent;
import com.sino.bjcc.tuwenLive.bean.LivePicture;
import com.sino.bjcc.tuwenLive.bean.LiveSubject;
import com.sino.bjcc.tuwenLive.service.ITuwenLiveService;

@SuppressWarnings("serial")
public class TuwenLiveActionJson extends BaseAction{

	private long liveId = 0;						//直播ID
	private List<LiveContent> contentList = null;	//图文直播-文字列表
	private List<LivePicture> pictureList = null;	//图文直播-图片列表
	
	/**
	 * 获取直播ID
	 */
	public long getLiveId() {
		return liveId;
	}
	/**
	 * 设置直播ID
	 */
	public void setLiveId(long liveId) {
		this.liveId = liveId;
	}
	
	/**
	 * 获取文字列表
	 */
	public List<LiveContent> getContentList() {
		return contentList;
	}
	/**
	 * 设置文字列表
	 */
	public void setContentList(List<LiveContent> contentList) {
		this.contentList = contentList;
	}

	/**
	 * 获取图片列表
	 */
	public List<LivePicture> getPictureList() {
		return pictureList;
	}
	/**
	 * 设置图片列表
	 */
	public void setPictureList(List<LivePicture> pictureList) {
		this.pictureList = pictureList;
	}

	private ITuwenLiveService liveManager = null;	//图文直播service对象
	
	/**
	 * 设置图文直播service对象
	 */
	public void setLiveManager(ITuwenLiveService liveManager) {
		this.liveManager = liveManager;
	}
	
	public String executeJson() throws Exception{
		LiveSubject subject = this.liveManager.getLiveSubject(getLiveId());
		setContentList(subject.getContentList());
		setPictureList(subject.getPictureList());
		for (LiveContent content : this.getContentList()) {
			String cont = content.getContent().replaceAll("<", "&lt;");
			cont = cont.replaceAll(">", "&gt;");
			cont = cont.replaceAll("\r\n", "<br/>");
			content.setContent(cont);
		}
		return SUCCESS;
	}
	
}

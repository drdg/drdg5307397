package com.sino.bjcc.tuwenLive.action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.tuwenLive.bean.LiveContent;
import com.sino.bjcc.tuwenLive.bean.LiveSubject;
import com.sino.bjcc.tuwenLive.service.ITuwenLiveService;

@SuppressWarnings("serial")
public class TuwenLiveAction extends BaseAction {

	private long liveId = 0;					//直播ID
	private LiveSubject liveSubject = null;		//直播主题
	
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
	 * 获取直播主题
	 */
	public LiveSubject getLiveSubject() {
		return liveSubject;
	}
	/**
	 * 设置直播主题
	 */
	public void setLiveSubject(LiveSubject liveSubject) {
		this.liveSubject = liveSubject;
	}

	private List<LiveSubject> subjectList = null;
	
	public List<LiveSubject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<LiveSubject> subjectList) {
		this.subjectList = subjectList;
	}

	private ITuwenLiveService liveManager = null;	//图文直播service对象
	
	/**
	 * 获取图文直播service对象
	 */
	public ITuwenLiveService getLiveManager() {
		return liveManager;
	}
	/**
	 * 设置图文直播service对象
	 */
	public void setLiveManager(ITuwenLiveService liveManager) {
		this.liveManager = liveManager;
	}

	public String getAllLive(){
		
		this.subjectList = getLiveManager().getAllLive();
		
		return SUCCESS;
	}
	
	public String detailLive() throws Exception{
		this.setLiveSubject(getLiveManager().getLiveSubject(getLiveId()));
		for (LiveContent content : this.getLiveSubject().getContentList()) {
			String cont = content.getContent().replaceAll("<", "&lt;");
			cont = cont.replaceAll(">", "&gt;");
			cont = cont.replaceAll("\r\n", "<br/>");
			content.setContent(cont);
		}
		return SUCCESS;
	}
	
}

package com.sino.bjcc.visitLog.action;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.visitLog.service.IVisitLogService;

@SuppressWarnings("serial")
public class VisitLogAction extends BaseAction {

	private long articleId = 0;		//访问文章ID
	private long channelId = 0;		//访问栏目ID

	/**
	 * 获取访问文章ID
	 */
	public long getArticleId() {
		return articleId;
	}
	/**
	 * 设置访问文章ID
	 */
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	/**
	 * 获取访问栏目ID
	 */
	public long getChannelId() {
		return channelId;
	}
	/**
	 * 设置访问栏目ID
	 */
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	
	private IVisitLogService visitLogManager = null;	//访问日志Manager

	/**
	 * 获取访问日志Manager
	 */
	public IVisitLogService getVisitLogManager() {
		return visitLogManager;
	}
	/**
	 * 设置访问日志Manager
	 */
	public void setVisitLogManager(IVisitLogService visitLogManager) {
		this.visitLogManager = visitLogManager;
	}
	
	/**
	 * 方法说明：访问文章时，记录文章访问日志
	 */
	public String visitArticle(){
		getVisitLogManager().writeArticleVisitLog(getRequest(), getArticleId());
		return SUCCESS;
	}
	
	/**
	 * 方法说明：访问栏目时，记录栏目访问日志
	 */
	public String visitChannel(){
		getVisitLogManager().writeChannelVisitLog(getRequest(), getChannelId());
		return SUCCESS;
	}
	
	/**
	 * 方法说明：获取文章访问次数
	 */
	public String articleVisitCount(){
		int visitCount = getVisitLogManager().articleVisitCount(Long.parseLong(getReqParam("articleID")));
		this.getRequest().setAttribute("visitCont", visitCount);
		return SUCCESS;
	}
}

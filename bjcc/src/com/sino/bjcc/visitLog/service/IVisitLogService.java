package com.sino.bjcc.visitLog.service;

import javax.servlet.http.HttpServletRequest;

public interface IVisitLogService {

	/**
	 * 方法说明：记录文章访问日志
	 */
	public void writeArticleVisitLog(HttpServletRequest request, long articleId);
	
	/**
	 * 方法说明：记录栏目访问日志
	 */
	public void writeChannelVisitLog(HttpServletRequest request, long channelId);
	
	/**
	 * 获取文章访问次数
	 */
	public int articleVisitCount(long artucleID);
	
}

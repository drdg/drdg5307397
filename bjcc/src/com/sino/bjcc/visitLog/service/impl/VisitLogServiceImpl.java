package com.sino.bjcc.visitLog.service.impl;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.bjcc.visitLog.bean.ArticleVisitLog;
import com.sino.bjcc.visitLog.bean.ChannelVisitLog;
import com.sino.bjcc.visitLog.persistence.IVisitLogDao;
import com.sino.bjcc.visitLog.service.IVisitLogService;

public class VisitLogServiceImpl implements IVisitLogService {

	private IVisitLogDao visitLogDao = null;		//访问日志DAO
	/**
	 * 获取访问日志DAO
	 */
	public IVisitLogDao getVisitLogDao() {
		return visitLogDao;
	}
	/**
	 * 设置访问日志DAO
	 */
	public void setVisitLogDao(IVisitLogDao visitLogDao) {
		this.visitLogDao = visitLogDao;
	}

	/**
	 * 方法说明：记录文章访问日志
	 */
	@Transactional(readOnly=false)
	public void writeArticleVisitLog(HttpServletRequest request, long articleId) {
		//根据文章ID获取所在站点ID
		long siteId = getVisitLogDao().getArticleSiteId(articleId);
		ArticleVisitLog visitLog = new ArticleVisitLog();
		visitLog.setArticleId(articleId);
		visitLog.setSiteId(siteId);
		visitLog.setCreationDate(DateTimeUtil.getNow());
	    String ip = request.getRemoteAddr();
	    visitLog.setIpAddress(ip);
	    String agent = request.getHeader("User-Agent");
	    String userBrowser = "IE 8";
	    String userOS = " Win xp";
	    try{
		    StringTokenizer st = new StringTokenizer(agent,";");
		    st.nextToken();
		    //得到用户的浏览器名
		    userBrowser = st.nextToken();
		    //得到用户的操作系统名
		    userOS = st.nextToken();
		    userOS = userOS.substring(0, userOS.length()-1);
	    }catch(Exception ex){
	    	//发生异常不做任何处理，浏览器默认IE8系统默认XP
	    }
	    visitLog.setSystem(userOS);
	    visitLog.setBrowser(userBrowser);
	    //新建文章访问日志
	    getVisitLogDao().createArticleVisitLog(visitLog);
	    //更新文章访问次数
	    getVisitLogDao().updateArticle(articleId);
	}

	/**
	 * 方法说明：记录栏目访问日志
	 */
	@Transactional(readOnly=false)
	public void writeChannelVisitLog(HttpServletRequest request, long channelId) {
		//根据文章ID获取所在站点ID
		long siteId = getVisitLogDao().getChannelSiteId(channelId);
		ChannelVisitLog visitLog = new ChannelVisitLog();
		visitLog.setChannelId(channelId);
		visitLog.setSiteId(siteId);
		visitLog.setCreationDate(DateTimeUtil.getNow());
	    String ip = request.getRemoteAddr();
	    visitLog.setIpAddress(ip);
	    String agent = request.getHeader("User-Agent");
	    String userBrowser = "IE 8";
	    String userOS = " Win xp";
	    try{
		    StringTokenizer st = new StringTokenizer(agent,";");
		    st.nextToken();
		    //得到用户的浏览器名
		    userBrowser = st.nextToken();
		    //得到用户的操作系统名
		    userOS = st.nextToken();
		    userOS = userOS.substring(0, userOS.length()-1);
	    }catch(Exception ex){
	    	//发生异常不做任何处理，浏览器默认IE8系统默认XP
	    }
	    visitLog.setSystem(userOS);
	    visitLog.setBrowser(userBrowser);
	    //新建栏目访问日志
	    getVisitLogDao().createChannelVisitLog(visitLog);
	}

	/*
	 * 获取文章访问次数
	 */
	public int articleVisitCount(long articleID){
		int visitCount = getVisitLogDao().getArticleCount(articleID);
		return visitCount;
	}
}

package com.sino.bjcc.visitLog.persistence;

import com.sino.bjcc.visitLog.bean.ArticleVisitLog;
import com.sino.bjcc.visitLog.bean.ChannelVisitLog;

public interface IVisitLogDao {

	/**
	 * 方法说明：获取访问文章所在站点ID
	 */
	public long getArticleSiteId(long articleId);
	
	/**
	 * 方法说明：创建文章访问记录
	 */
	public void createArticleVisitLog(ArticleVisitLog articleVisitLog);
	
	/**
	 * 方法说明：更新文章访问次数
	 */
	public void updateArticle(long articleId);
	
	/**
	 * 方法说明：获取栏目所在站点ID
	 */
	public long getChannelSiteId(long channelId);

	/**
	 * 方法说明：创建栏目访问记录
	 */
	public void createChannelVisitLog(ChannelVisitLog channelVisitLog);
	
	/**
	 * 方法说明：获取文章访问次数
	 */
	public int getArticleCount(long articleID);
	
}

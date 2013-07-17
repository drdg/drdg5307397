package com.sino.bjcc.visitLog.persistence.impl;

import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.db.SqlParameter;
import com.sino.bjcc.visitLog.bean.ArticleVisitLog;
import com.sino.bjcc.visitLog.bean.ChannelVisitLog;
import com.sino.bjcc.visitLog.persistence.IVisitLogDao;

public class VisitLogDaoImpl extends PersistenceBase implements IVisitLogDao {

	/**
	 * 方法说明：获取访问文章所在站点ID
	 */
	public long getArticleSiteId(long articleId) {
		String sql = "SELECT SITEID FROM CMS_ARTICLE WHERE ID = :ID";
		Object id = executeSqlScalar(sql, new SqlParameter("ID", articleId));
		return Long.parseLong(id.toString());
	}
	
	/**
	 * 方法说明：创建文章访问记录
	 */
	public void createArticleVisitLog(ArticleVisitLog articleVisitLog) {
		save(articleVisitLog);
	}
	
	/**
	 * 方法说明：更新文章访问次数
	 */
	public void updateArticle(long articleId) {
		String sql = "UPDATE CMS_ARTICLE SET VIEWCOUNT = VIEWCOUNT+1 WHERE ID = :ID";
		executeSqlUpdate(sql, new SqlParameter("ID", articleId));
	}

	/**
	 * 方法说明：获取栏目所在站点ID
	 */
	public long getChannelSiteId(long channelId) {
		String sql = "SELECT SITEID FROM CMS_CHANNEL WHERE ID = :ID";
		Object id = executeSqlScalar(sql, new SqlParameter("ID", channelId));
		return Long.parseLong(id.toString());
	}
	
	/**
	 * 方法说明：创建栏目访问记录
	 */
	public void createChannelVisitLog(ChannelVisitLog channelVisitLog) {
		save(channelVisitLog);
	}
	
	/**
	 * 方法说明：获取文章访问次数
	 */
	public int getArticleCount(long articleID){
		
		String sql = "SELECT VIEWCOUNT FROM CMS_ARTICLE WHERE ID = :ID";
		Object viewCount = executeSqlScalar(sql, new SqlParameter("ID", articleID));
		return Integer.parseInt(viewCount.toString());
		
	}

}

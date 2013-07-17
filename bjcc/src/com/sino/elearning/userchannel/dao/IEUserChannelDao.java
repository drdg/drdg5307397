package com.sino.elearning.userchannel.dao;

import java.util.List;
import java.util.Map;

import com.sino.bjcc.timetable.bean.CmsArticle;
import com.sino.bjcc.timetable.bean.CmsChannel;
import com.sino.elearning.basedao.IBaseDao;
/**
 * 用户专题dao接口
 * @author Administrator
 *
 */
public interface IEUserChannelDao extends IBaseDao {
	/**
	 * 根据参数查询专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findCmsChannelByParams(Map params) throws Exception;
	
	/**
	 * 根据参数查询用户专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findUserChannelByParams(Map params) throws Exception;
	
	/**
	 * 根据用户ID删除用户专题
	 * @param userId
	 * @throws Exception
	 */
	public void deleteByUserId(Long userId) throws Exception;
	
	/**
	 * 根据hql语句查询文章列表前10条
	 * @param channelids
	 * @return
	 * @throws Exception
	 */
	public List<CmsArticle> queryCmsArticleByHql(String channelids) throws Exception;
}
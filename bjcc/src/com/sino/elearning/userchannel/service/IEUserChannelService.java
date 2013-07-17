package com.sino.elearning.userchannel.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.timetable.bean.CmsArticle;
import com.sino.bjcc.timetable.bean.CmsChannel;
import com.sino.elearning.userchannel.bean.EUserChannel;

/**
 * 用户专题service接口类
 * @author Administrator
 *
 */
public interface IEUserChannelService {

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
	 * 保存用户学习专题
	 * @param list
	 * @param userId
	 * @throws Exception
	 */
	public void save(List<EUserChannel> list, Long userId) throws Exception;
	
	/**
	 * 根据hql语句查询文章列表
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<CmsArticle> queryCmsArticleByHql(String hql) throws Exception;
}
package com.sino.elearning.userchannel.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.timetable.bean.CmsArticle;
import com.sino.bjcc.timetable.bean.CmsChannel;
import com.sino.elearning.userchannel.bean.EUserChannel;
import com.sino.elearning.userchannel.dao.IEUserChannelDao;
import com.sino.elearning.userchannel.service.IEUserChannelService;
/**
 * 用户专题service实现类
 * @author Administrator
 *
 */
public class EUserChannelServiceImpl implements IEUserChannelService {
	
	private IEUserChannelDao userChannelDao;
	
	/**
	 * 根据参数查询专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findCmsChannelByParams(Map params) throws Exception {
		List<CmsChannel> list = null;
		try {
			list = userChannelDao.findCmsChannelByParams(params);
		} catch (Exception e) {
			log.error("查询专题失败 findCmsChannelByParams()");
			throw e;
		}
		return list;
	}
	
	/**
	 * 根据参数查询用户专题
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CmsChannel> findUserChannelByParams(Map params) throws Exception {
		List<CmsChannel> list = null;
		try {
			list = userChannelDao.findUserChannelByParams(params);
		} catch (Exception e) {
			log.error("查询用户专题失败 findUserChannelByParams()");
			throw e;
		}
		return list;
	}
	
	/**
	 * 保存用户学习专题
	 * @param list
	 * @param userId
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public void save(List<EUserChannel> list, Long userId) throws Exception {
		try{
			userChannelDao.deleteByUserId(userId);
			if(null!=list && list.size()>0) {
				for(EUserChannel userChannel: list) {
					userChannelDao.save(userChannel);
				}
			}
		} catch (Exception e) {
			log.error("保存用户学习专题失败 save()");
			throw e;
		}
	}
	
	/**
	 * 根据hql语句查询文章列表
	 * @param channelids
	 * @return
	 * @throws Exception
	 */
	public List<CmsArticle> queryCmsArticleByHql(String channelids) throws Exception {
		List<CmsArticle> articles = null;
		try{
			articles = userChannelDao.queryCmsArticleByHql(channelids);
		}catch(Exception e) {
			log.error("查询文章失败 queryCmsArticleByHql()");
			throw e;
		}
		return articles;
	}
	
	public IEUserChannelDao getUserChannelDao() {
		return userChannelDao;
	}

	public void setUserChannelDao(IEUserChannelDao userChannelDao) {
		this.userChannelDao = userChannelDao;
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.userchannel.service.impl.EUserChannelServiceImpl.class);
}
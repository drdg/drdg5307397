package com.sino.elearning.userchannel.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.timetable.bean.CmsArticle;
import com.sino.bjcc.timetable.bean.CmsChannel;
import com.sino.elearning.userchannel.service.IEUserChannelService;
import com.sino.system.constant.Constant;
/**
 * 用户专题
 * @author Administrator
 *
 */
public class EUserChannelAction extends BaseAction {
	
	private IEUserChannelService userChannelService;
	
	private String userChannelIds;
	
	private List<CmsArticle> articles;
	
	private List<CmsChannel> allCmsChannels;
	private List<CmsChannel> userChannels;
	private List<CmsChannel> notUserChannels;
	
	public String prepare() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try{
			Map params = new HashMap();
			params.put("cc.type", 0);
			params.put("euc.userId", user.getUserId());
			userChannels = userChannelService.findUserChannelByParams(params);
			Map params2 = new HashMap();
			params2.put("type", 0);
			allCmsChannels = userChannelService.findCmsChannelByParams(params2);
			if(userChannels.size() == 0) {
				userChannels = allCmsChannels;
			}
			String channelids = getChannel(userChannels);
			articles = userChannelService.queryCmsArticleByHql(channelids);
			calculatArticleUrl();
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error("加载文章出错", e);
			throw e;
		}
		return "prepareuserchannel";
	}
	
	public String prepareMod() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		Map params = new HashMap();
		params.put("type", 0);
		Map params2 = new HashMap();
		params2.put("cc.type", 0);
		params2.put("euc.userId", user.getUserId());
		try {
			allCmsChannels = userChannelService.findCmsChannelByParams(params);
			userChannels = userChannelService.findUserChannelByParams(params2);
			compareList();
		}catch(Exception e) {
			log.error("查询专题失败prepareMod()", e);
			throw e;
		}
		return "preparemoduserchannel";
	}

	public String getChannel(List<CmsChannel> channelList) {
		StringBuffer sb = new StringBuffer();
		for(CmsChannel channel: channelList) {
			sb.append(channel.getId()).append(",");
		}
		return sb.deleteCharAt(sb.length() - 1 ).toString();
	}
	
	/**
	 * 计算文章的发布地址
	 */
	public void calculatArticleUrl() {
		for(CmsArticle article :articles) {
			StringBuffer sb = new StringBuffer();
			sb.append("/").append(article.getId()).append(".html");
			 CmsChannel channel = getCmsChannelByChannelId(article.getParentid());
			 while (null!=channel && channel.getParentid()!=null) {
				 sb.insert(0, channel.getPath()).insert(0, "/");
				 channel = getCmsChannelByChannelId(channel.getParentid());
			 }
			 sb.insert(0, Constant.ARTICLE_PREFIX_URL);
			 article.setPublishurl(sb.toString());
		}
	}
	
	/**
	 * 根据channelid找出CmsChannel
	 * @param channelid
	 * @return
	 */
	public CmsChannel getCmsChannelByChannelId (BigDecimal channelid) {
		CmsChannel result = null;
		for(CmsChannel channel: allCmsChannels) {
			 if(channel.getId().equals(channelid)) {
				 result = channel;
				 break;
			 }
		 }
		return result;
	}
	
	/**
	 * 通过比较找出用户没有添加的专题
	 */
	public void compareList() {
		if(null == allCmsChannels || null == userChannels) {
			return;
		}
		for(int i = 0; i < allCmsChannels.size(); i++) {
			boolean isExists = false;
			CmsChannel chan1 = allCmsChannels.get(i);
			for(int j = 0; j < userChannels.size(); j++) {
				CmsChannel chan2 = userChannels.get(j);
				if(chan1.getId().equals(chan2.getId())) {
					isExists = true;
					break;
				}
			}
			if(isExists == false) {
				getNotUserChannels().add(chan1);
			}
		}
	}
	
	public IEUserChannelService getUserChannelService() {
		return userChannelService;
	}

	public void setUserChannelService(IEUserChannelService userChannelService) {
		this.userChannelService = userChannelService;
	}

	public List<CmsChannel> getAllCmsChannels() {
		return allCmsChannels;
	}

	public void setAllCmsChannels(List<CmsChannel> allCmsChannels) {
		this.allCmsChannels = allCmsChannels;
	}
	
	public List<CmsChannel> getUserChannels() {
		return userChannels;
	}

	public void setUserChannels(List<CmsChannel> userChannels) {
		this.userChannels = userChannels;
	}

	public List<CmsChannel> getNotUserChannels() {
		if(notUserChannels == null) {
			notUserChannels = new ArrayList<CmsChannel>();
		}
		return notUserChannels;
	}

	public void setNotUserChannels(List<CmsChannel> notUserChannels) {
		this.notUserChannels = notUserChannels;
	}
	
	public String getUserChannelIds() {
		return userChannelIds;
	}

	public void setUserChannelIds(String userChannelIds) {
		this.userChannelIds = userChannelIds;
	}
	
	public List<CmsArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<CmsArticle> articles) {
		this.articles = articles;
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.userchannel.action.EUserChannelAction.class);
}
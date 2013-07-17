package com.sino.elearning.userchannel.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.elearning.userchannel.bean.EUserChannel;
import com.sino.elearning.userchannel.service.IEUserChannelService;
import com.sino.system.constant.Constant;
/**
 * 用户专题
 * @author Administrator
 *
 */
public class EUserChannelAjaxAction extends BaseAction {
	
	private IEUserChannelService userChannelService;
	
	private String result;
	
	private String userChannels;
	
	public String save() throws Exception {
		result = "fail";
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			List<EUserChannel> userChannelsList = null;
			if( null != userChannels && userChannels.length() > 0 ) {
				userChannelsList = new ArrayList<EUserChannel>();
				String[] channelids = userChannels.split(",");
				for(String channelid: channelids){
					EUserChannel userChannel = new EUserChannel();
					userChannel.setUserId(user.getUserId());
					userChannel.setChannelId(Long.valueOf(channelid));
					userChannelsList.add(userChannel);
				}
			}
			userChannelService.save(userChannelsList, user.getUserId());
			result = "success";
		} catch (Exception e) {
			super.writeStringToClient("fail");
			log.error("保存用户学习专题失败 save()", e);
			throw e;
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public IEUserChannelService getUserChannelService() {
		return userChannelService;
	}

	public void setUserChannelService(IEUserChannelService userChannelService) {
		this.userChannelService = userChannelService;
	}

	public String getUserChannels() {
		return userChannels;
	}

	public void setUserChannels(String userChannels) {
		this.userChannels = userChannels;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.userchannel.action.EUserChannelAjaxAction.class);
}
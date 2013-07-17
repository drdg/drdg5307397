package com.sino.elearning.PersonalInfo.Action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.service.EWebsiteMessageService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class PersonalInfoAction extends BaseAction{
	private EWebsiteMessageService websiteMessageService;
	private List<EReceiveMessage> receiveMessages;
	public String excuse() throws Exception{
		String num;
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		receiveMessages = websiteMessageService.findAllUnreadMessage(username, "0");
		num=String.valueOf(receiveMessages.size());
		getRequest().setAttribute("num",num);
		return "success";
	}
	public EWebsiteMessageService getWebsiteMessageService() {
		return websiteMessageService;
	}
	public void setWebsiteMessageService(
			EWebsiteMessageService websiteMessageService) {
		this.websiteMessageService = websiteMessageService;
	}
	public List<EReceiveMessage> getReceiveMessages() {
		return receiveMessages;
	}
	public void setReceiveMessages(List<EReceiveMessage> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}
}

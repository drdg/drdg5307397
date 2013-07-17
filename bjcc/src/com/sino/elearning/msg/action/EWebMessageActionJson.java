package com.sino.elearning.msg.action;

import org.apache.struts2.json.annotations.JSON;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.elearning.msg.service.EWebsiteMessageService;
import com.sino.system.constant.Constant;

public class EWebMessageActionJson extends BaseAction {
	private String receiveusers;
	private EWebsiteMessageService websiteMessageService;
	private String notExistsUsers;

	public String executeJson() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String[] userNames = receiveusers.split(";");

		notExistsUsers = websiteMessageService.verifyUserNames(userNames);
		// System.out.println(notExistsUsers);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public EWebsiteMessageService getWebsiteMessageService() {
		return websiteMessageService;
	}

	public void setWebsiteMessageService(
			EWebsiteMessageService websiteMessageService) {
		this.websiteMessageService = websiteMessageService;
	}

	public String getReceiveusers() {
		return receiveusers;
	}

	public void setReceiveusers(String receiveusers) {
		this.receiveusers = receiveusers;
	}

	public String getNotExistsUsers() {
		return notExistsUsers;
	}

	public void setNotExistsUsers(String notExistsUsers) {
		this.notExistsUsers = notExistsUsers;
	}
}

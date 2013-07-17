package com.sino.elearning.userstore.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.sino.bjcc.common.BaseAction;
import com.sino.elearning.userstore.bean.EUserStore;
import com.sino.elearning.userstore.service.IEUserStoreService;

public class EUserStoreAjaxAction extends BaseAction{

	private IEUserStoreService userStoreService;
	
	private EUserStore userStore;
	private String verifyMessages;
	private Long userId;
	private Long programId;
	/**
	 * 验证用户收藏
	 * @return
	 */
	public String verifyId(){
		
		try {
			if(!userStoreService.verifyUserStoreId(userId, programId)){
				verifyMessages = "用户收藏重复不可以保存！";
			}
		} catch (Exception e) {
			log.error("验证用户搜藏失败");
		}
		return SUCCESS;
		
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.userstore.action.EUserStoreAjaxAction.class);

	public EUserStore getUserStore() {
		return userStore;
	}

	public void setUserStore(EUserStore userStore) {
		this.userStore = userStore;
	}

	public String getVerifyMessages() {
		return verifyMessages;
	}

	public void setVerifyMessages(String verifyMessages) {
		this.verifyMessages = verifyMessages;
	}
	@JSON(serialize = false)
	public IEUserStoreService getUserStoreService() {
		return userStoreService;
	}

	public void setUserStoreService(IEUserStoreService userStoreService) {
		this.userStoreService = userStoreService;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
}

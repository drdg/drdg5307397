package com.sino.elearning.msg.action;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;
import com.sino.elearning.msg.service.EWebsiteMessageService;
import com.sino.system.constant.Constant;

/**
 * 站内短信管理action处理类
 * 
 * @author WANGNING
 * 
 */
public class EWebsiteMessageAction extends BaseAction {
	private EWebsiteMessage websiteMessage;
	private EReceiveMessage receiveMessage;
	private EWebsiteMessageService websiteMessageService;
	private List<EWebsiteMessage> sendMessage;
	private List<EReceiveMessage> receiveMessages;

	private Long id;
	private String ids;
	private String rids;
	private Long receiveMsgId;

	/**
	 * 站内短信页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addForward() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return SUCCESS;
	}

	/**
	 * 当前用户发件箱的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendForward() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		sendMessage = websiteMessageService.findAll(getPaginationBean(),
				username, "0");
		return SUCCESS;
	}

	/**
	 * 当前用户收件箱信息30
	 * 
	 * @return
	 * @throws Exception
	 */
	public String receiveForward() throws Exception {
		
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		receiveMessages = websiteMessageService.findAll(getPaginationBean(),
				username);
		getRequest().setAttribute("showState", "0");
		return SUCCESS;
	}

	/**
	 * 当前用户收件箱未读信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String unreadMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		receiveMessages = websiteMessageService.findUnreadMessage(
				getPaginationBean(), username, "0");
		getRequest().setAttribute("showState", "1");
		return SUCCESS;
	}

	/**
	 * 写信初始化页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String writeForward() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return SUCCESS;
	}

	/**
	 * 回复信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String replyMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		receiveMessage = websiteMessageService.findReplyMessage(receiveMsgId,
				username);
		return SUCCESS;
	}

	/**
	 * 保存回复信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveReplyMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String[] strs = websiteMessage.getReceiveusers().replaceAll("；", ";")
				.split(";");
		List<EReceiveMessage> list = new ArrayList<EReceiveMessage>();
		for (String str : strs) {
			EReceiveMessage rece = new EReceiveMessage();
			rece.setReceiveName(str);
			list.add(rece);
		}
		if(websiteMessage.getMsgTitle().indexOf("回复：")!=0){
			websiteMessage.setMsgTitle("回复："+websiteMessage.getMsgTitle());
		}
		websiteMessage.setListusers(list);
		websiteMessage.setSendUsername(getLoginUserInfo().getLoginName());
		Long retValue = websiteMessageService.saveReplyMessage(websiteMessage);
		if (null == retValue) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	/**
	 * 转发信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String transferMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		receiveMessage = websiteMessageService.findTransferMessage(
				receiveMsgId, username);
		return SUCCESS;
	}

	/**
	 * 保存转发信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveTransferMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String[] strs = websiteMessage.getReceiveusers().replaceAll("；", ";")
				.split(";");
		List<EReceiveMessage> list = new ArrayList<EReceiveMessage>();
		for (String str : strs) {
			EReceiveMessage rece = new EReceiveMessage();
			rece.setReceiveName(str);
			list.add(rece);
		}
		if(websiteMessage.getMsgTitle().indexOf("转发：")!=0){
			websiteMessage.setMsgTitle("转发："+websiteMessage.getMsgTitle());
		}
		websiteMessage.setListusers(list);
		websiteMessage.setSendUsername(getLoginUserInfo().getLoginName());
		Long retValue = websiteMessageService
				.saveTransferMessage(websiteMessage);
		if (null == retValue) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	/**
	 * 查询发件箱的详细信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detailWebMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		websiteMessage = websiteMessageService.findDetailWebMessage(id,
				username);
		return SUCCESS;
	}
	/**
	 * 查询收件箱的详细信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String detailMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String username = user.getLoginName();
		Object params[] = new Object[1];
		params[0] = Long.valueOf(receiveMsgId);
		String hql = "update EReceiveMessage t set t.status = '1' where t.receiveMsgId = ?";
		websiteMessageService.updateObject(hql, params);
		receiveMessage = websiteMessageService.findDetailMessage(receiveMsgId,
				username);
		return SUCCESS;
	}

	/**
	 * 保存站内信息
	 * @return
	 * @throws Exception
	 */
	public String saveMessage() throws Exception {
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String[] strs = websiteMessage.getReceiveusers().replaceAll("；", ";")
				.split(";");
		List<EReceiveMessage> list = new ArrayList<EReceiveMessage>();
		for (String str : strs) {
			EReceiveMessage rece = new EReceiveMessage();
			rece.setReceiveName(str);
			list.add(rece);
		}
		websiteMessage.setListusers(list);
		websiteMessage.setSendUsername(getLoginUserInfo().getLoginName());
		Long retValue = websiteMessageService.save(websiteMessage);
		if (null == retValue) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 删除一条发件箱信息
	 * 
	 * @param websiteMessage
	 */
	public String delMessageById() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		Boolean state = true;
		receiveMessages = websiteMessageService .findById(id,null);
		for(int i=0;i<receiveMessages.size();i++){
			if(receiveMessages.get(i).getMesStatus().equals("0")){
				state = false;
			}
		}
		if(state){
			websiteMessageService.delByMessageId(id);
		}else{
			websiteMessageService.delMessageById(id);	
		}
		
		return SUCCESS;
	}

	/**
	 * 批量删除发件箱信息
	 * 
	 * @return
	 */
	public String delMessageByIds() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		websiteMessageService.delMessageByIds(ids);
		return SUCCESS;
	}

	/**
	 * 删除一条收件箱的信息
	 * 
	 * @return
	 */
	public String delByReceiveId() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		receiveMessage = websiteMessageService.findDetailMessage(receiveMsgId,
				user.getLoginName());
		if(receiveMessage.getWebsiteMessage().getStatus().equals("0")){
			websiteMessageService.delfoReceiveId(receiveMsgId.toString());
		}else if(receiveMessage.getWebsiteMessage().getStatus().equals("1")){
			Boolean state=true;
			receiveMessages = websiteMessageService .findById(receiveMessage.getWebsiteMessage().getId(),user.getLoginName());
			for(int i=0;i<receiveMessages.size();i++){
				if(receiveMessages.get(i).getMesStatus().equals("0")){
					state=false;
				}
			}
			if(state){
				websiteMessageService.delByReceiveId(receiveMsgId);	
			}else{
				websiteMessageService.delfoReceiveId(receiveMsgId.toString());
			}
		}
		return SUCCESS;
	}

	/**
	 * 批量删除收件箱的信息
	 * 
	 * @return
	 */
	public String delByReceiveIds() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		websiteMessageService.delByReceiveIds(rids,user.getLoginName());
		return SUCCESS;
	}

	public EWebsiteMessage getWebsiteMessage() {
		return websiteMessage;
	}

	public void setWebsiteMessage(EWebsiteMessage websiteMessage) {
		this.websiteMessage = websiteMessage;
	}

	public EReceiveMessage getReceiveMessage() {
		return receiveMessage;
	}

	public void setReceiveMessage(EReceiveMessage receiveMessage) {
		this.receiveMessage = receiveMessage;
	}

	public EWebsiteMessageService getWebsiteMessageService() {
		return websiteMessageService;
	}

	public void setWebsiteMessageService(
			EWebsiteMessageService websiteMessageService) {
		this.websiteMessageService = websiteMessageService;
	}

	public List<EWebsiteMessage> getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(List<EWebsiteMessage> sendMessage) {
		this.sendMessage = sendMessage;
	}

	public List<EReceiveMessage> getReceiveMessages() {
		return receiveMessages;
	}

	public void setReceiveMessages(List<EReceiveMessage> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getRids() {
		return rids;
	}

	public void setRids(String rids) {
		this.rids = rids;
	}

	public Long getReceiveMsgId() {
		return receiveMsgId;
	}

	public void setReceiveMsgId(Long receiveMsgId) {
		this.receiveMsgId = receiveMsgId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

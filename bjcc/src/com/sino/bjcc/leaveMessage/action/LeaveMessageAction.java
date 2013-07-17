package com.sino.bjcc.leaveMessage.action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.leaveMessage.bean.LeaveMessage;
import com.sino.bjcc.leaveMessage.service.ILeaveMessageService;

@SuppressWarnings("serial")
public class LeaveMessageAction extends BaseAction{

	/**未登录**/
	private final String ERROR_NOT_LOGIN = "1";
	/**验证码错误**/
	private final String ERROR_VALICODE = "2";
	/**未发生错误，成功提交**/
	private final String ERROR_NOT_HAPP = "-1"; 
	
	private long typeId = 0;				//IN:留言类型ID
	private String messageContent = null;	//IN:留言内容
	private String valCode = null;			//IN:验证码
	private int showTabInx = 0;				//IN:显示的tab的序号
	private String errorCode = null;					//OUT:错误CODE
	private List<LeaveMessage> allMessage = null;		//OUT:所有留言信息
	private List<LeaveMessage> myMessage = null;		//OUT：用户留言信息
	private PaginationBean allPage = null;				//OUT:全部留言分页信息
	private PaginationBean myPage = null;				//OUT：我的留言分页信息
	private int curPage = 1;
	private int myCurPage = 1;

	/**
	 * 获取留言类型ID
	 */
	public long getTypeId() {
		return typeId;
	}
	/**
	 * 设置留言类型ID
	 */
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	/**
	 * 获取留言内容
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 设置留言内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	/**
	 * 获取用户输入验证码
	 */
	public String getValCode() {
		return valCode;
	}
	/**
	 * 设置用户输入验证码
	 */
	public void setValCode(String valCode) {
		this.valCode = valCode;
	}
	
	/**
	 * 获取错误信息码
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * 设置错误信息码
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * 获取显示的tab下标
	 */
	public int getShowTabInx() {
		return showTabInx;
	}
	/**
	 * 设置显示的tab下标
	 */
	public void setShowTabInx(int showTabInx) {
		this.showTabInx = showTabInx;
	}
	
	/**
	 * 获取所有留言信息
	 */
	public List<LeaveMessage> getAllMessage() {
		return allMessage;
	}
	/**
	 * 设置所有留言信息
	 */
	public void setAllMessage(List<LeaveMessage> allMessage) {
		this.allMessage = allMessage;
	}

	/**
	 * 获取个人留言信息
	 */
	public List<LeaveMessage> getMyMessage() {
		return myMessage;
	}
	/**
	 * 设置个人留言信息
	 */
	public void setMyMessage(List<LeaveMessage> myMessage) {
		this.myMessage = myMessage;
	}
	
	/**
	 * 获取全部留言分页信息
	 */
	public PaginationBean getAllPage() {
		if(null == this.allPage){
			this.allPage = new PaginationBean();
			this.allPage.setPageSize(6);
		}
		return allPage;
	}
	/**
	 * 设置全部留言分页信息
	 */
	public void setAllPage(PaginationBean allPage) {
		this.allPage = allPage;
	}
	
	/**
	 * 获取我的留言分页信息
	 */
	public PaginationBean getMyPage() {
		if(null == this.myPage){
			this.myPage = new PaginationBean();
			this.myPage.setPageSize(6);
		}
		return myPage;
	}
	/**
	 * 设置我的留言分页信息
	 */
	public void setMyPage(PaginationBean myPage) {
		this.myPage = myPage;
	}

	/**
	 * 获取全部留言的页号
	 */
	public int getCurPage() {
		return curPage;
	}
	/**
	 * 设置全部留言的页号
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	/**
	 * 获取我的留言的页号
	 */
	public int getMyCurPage() {
		return myCurPage;
	}
	/**
	 * 设置我的留言的页号
	 */
	public void setMyCurPage(int myCurPage) {
		this.myCurPage = myCurPage;
	}

	private ILeaveMessageService messageManager = null;
	/**
	 * 获取留言信息Manager
	 */
	public ILeaveMessageService getMessageManager() {
		return messageManager;
	}
	/**
	 * 设置留言信息Manager
	 */
	public void setMessageManager(ILeaveMessageService messageManager) {
		this.messageManager = messageManager;
	}
	
	/**
	 * 方法说明：获取留言信息列表
	 */
	public String queryLeaveMessage(){
		//获取全部留言的分页信息
		PaginationBean pagiBean = getAllPage();
		String curPage = getReqParam("curPage");
		if(null!=curPage && !"".equals(curPage.trim())){
			pagiBean.setCurrentPage(Integer.parseInt(curPage));
		}
		//获取全部留言
		setAllMessage(getMessageManager().getAllLeaveMessage(pagiBean, getTypeId()));
		
		//获取我的留言的分页信息
		PaginationBean myPage = getMyPage();
		String myCurPage = getReqParam("myCurPage");
		if(null!=myCurPage && !"".equals(myCurPage.trim())){
			myPage.setCurrentPage(Integer.parseInt(myCurPage));
		}
		long userId = 0;
		if(isLogin()){
			userId = getLoginUserInfo().getUserId();
		}
		//获取我的留言信息
		setMyMessage(getMessageManager().getPersonalLeaveMessage(myPage, typeId, userId));
		return SUCCESS;
	}
	
	/**
	 * 方法说明：新建留言
	 */
	public String createLeaveMessage(){
		//没有登录
		if(!isLogin()){
			setErrorCode(ERROR_NOT_LOGIN);
			return INPUT;
		}
		//输入验证码不正确
		if(null==getValCode()||!(getValCode().toLowerCase()).equals(getSession().getAttribute("validateCode"))){
			setErrorCode(ERROR_VALICODE);
			return INPUT;
		}
		getMessageManager().createLeaveMessage(getTypeId(), 
				getLoginUserInfo().getUserId(),
				getLoginUserInfo().getLoginName(), getMessageContent());
		setErrorCode(ERROR_NOT_HAPP);
		return SUCCESS;
	}
	
}

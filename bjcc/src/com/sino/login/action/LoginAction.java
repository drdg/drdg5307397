package com.sino.login.action;

import java.io.IOException;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.login.service.IUserInfoService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	
	private final String SESSION_KEY_FOR_USER = Constant.SESSION_KEY_FOR_USER;
	
	private IUserInfoService userInfoService;
	/**
	 * 登入个人中心
	 * @return
	 */
	public String loginPersonCenter() throws Exception{
		String result = "personCenterLoginSucc";
		if(super.isLogin() == false) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return result;
	}
	
	/**
	 * 登出个人中心
	 */
	public void logoutPersonCenter() {
		if(super.isLogin() == true) {
			super.getSession().removeAttribute(SESSION_KEY_FOR_USER);
			super.getSession().invalidate();
		}
	}
	/**
	 * 返回登录界面
	 */
	public void prepareLoginPersonCenter() throws Exception{
		try {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回登录界面
	 */
	public String indexPersonCenter() throws Exception{
		String result = "personCenterIndex";
		if(super.isLogin() == false) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return result;
	}
	
	/**
	 * 方法说明：字符串是否为空
	 */
	public String userLogin() throws Exception{
		if(isLogin()) {
			//如果已经登录，直接返回
			return SUCCESS;
		}
		String userName = getReqParam("userName");
		String passwd = getReqParam("password");
		if(isNullOrEmpty(userName) || isNullOrEmpty(passwd)){
			//用户名或密码为空，直接返回
			return SUCCESS;
		}
		String deptid = getReqParam("currDeptId");
		if (!isNullOrEmpty(deptid) && deptid.equals("-1")) {
			deptid = null;
		}
		//查询DB用户信息
		UserInfo userinfo = userInfoService.validataUserinfo(userName, passwd, deptid);
		if (null == userinfo) {
			return SUCCESS;
		}
		//把用户信息放入session
		getSession().setAttribute(SESSION_KEY_FOR_USER, userinfo);
		return SUCCESS;
	}
	
	/**
	 * 方法说明：字符串是否为空
	 */
	private boolean isNullOrEmpty(String text){
		if(null == text){
			return true;
		}
		if("".equals(text.trim())){
			return true;
		}
		return false;
	}
	
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
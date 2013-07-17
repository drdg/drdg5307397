package com.sino.bjcc.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.LogUtil;
import com.sino.system.constant.Constant;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 4624081355837651164L;

	private final String UNKNOWN_IP = "unknown"; // 不是正确IP的返回值
	protected final String SESSION_KEY_FOR_USER = Constant.SESSION_KEY_FOR_USER; // session中登录用户信息的key

	protected final String INPUT = "input";
	protected final String SUCCESS = "success";

	private LogUtil logger = null;

	/**
	 * 获取LogUtil用于记录日志
	 */
	protected LogUtil getLogger(Object obj) {
		if (null == this.logger) {
			logger = LogUtil.createInstance(obj);
		}
		return this.logger;
	}

	private PaginationBean paginationBean = null;

	/**
	 * 获取分页信息Bean
	 */
	public PaginationBean getPaginationBean() {
		if (null == this.paginationBean) {
			this.paginationBean = new PaginationBean();
		}
		return paginationBean;
	}

	/**
	 * 设置分页信息Bean
	 */
	public void setPaginationBean(PaginationBean paginationBean) {
		this.paginationBean = paginationBean;
	}

	/**
	 * 获取request对象
	 */
	public HttpServletRequest getRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
	}

	/**
	 * 获取session对象
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * 获取Response对象
	 */
	public HttpServletResponse getResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
	}
	
	/**
	 * 方法说明：获取请求参数
	 */
	public String getReqParam(String paramKey) {
		return getRequest().getParameter(paramKey);
	}

	/**
	 * 方法说明：获取客户端IP
	 */
	protected String getClientIp() {
		HttpServletRequest request = getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (!isRealIp(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (!isRealIp(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (!isRealIp(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.contains(",")) {
			ip = ip.split(",")[0];
		}
		return ip;
	}
	/**
	 * 方法说明：判断是否真正的IP
	 */
	private boolean isRealIp(String ip) {
		if (null == ip || 0 == ip.length() || UNKNOWN_IP.equalsIgnoreCase(ip)) {
			return false;
		}
		return true;
	}

	/**
	 * 方法说明：获取登录用户的ID
	 */
	protected long getLoginUserId() {
		return getLoginUserInfo().getUserId();
	}

	/**
	 * 判断用户是否登录
	 */
	protected boolean isLogin() {
		if (null == getRequest().getSession()
				.getAttribute(SESSION_KEY_FOR_USER)) {
			return false;
		}
		UserInfo user = (UserInfo) getRequest().getSession().getAttribute(
				SESSION_KEY_FOR_USER);
		if (null == user.getLoginName() || "".equals(user.getLoginName())) {
			return false;
		}
		return true;
	}
	
	private UserInfo userInfo = null;
	/**
	 * 获取当前登录用户的用户信息，可能返回空
	 */
	public UserInfo getLoginUserInfo(){
		if(null != userInfo){
			return userInfo;
		}
		if (null != getRequest().getSession().getAttribute(SESSION_KEY_FOR_USER)) {
			this.userInfo = (UserInfo) getRequest().getSession().getAttribute(SESSION_KEY_FOR_USER);
		}
		return this.userInfo;
	}
	
	public void writeStringToClient(String str) throws Exception {
		PrintWriter writer = getResponse().getWriter();
		writer.write(str);
		writer.flush();
		writer.close();
	}
}
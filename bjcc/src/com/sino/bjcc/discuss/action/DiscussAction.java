package com.sino.bjcc.discuss.action;

import java.util.Date;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.discuss.bean.Discuss;
import com.sino.bjcc.discuss.service.IDiscussService;

@SuppressWarnings("serial")
public class DiscussAction extends BaseAction {
	private boolean loginFlag = true;		//登录标记
	private String loginUrl = null;			//登录URL
	/**
	 * 获取登录标记
	 */
	public boolean getLoginFlag() {
		return loginFlag;
	}
	/**
	 * 设置登录标记
	 */
	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	/**
	 * 获取登录页面URL
	 */
	public String getLoginUrl() {
		return loginUrl;
	}
	/**
	 * 设置登录页面URL
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	private String content;					//IN: 内容
	private List<Discuss> list = null;		//OUT:评论列表
	private long total;						//OUT:评论数量
	private long articleID;					//IN:文章ID
	private String score;					//OUT:平均分
	private String logInfo;					//OUT：
	private long siteId;					//IN:站点ID
	private int type;						//IN：评论类型
	private String success;					//out:成功标记
	private int grade;						//评分
	
	/**
	 * 获取成功标记
	 */
	public String getSuccess() {
		return success;
	}
	/**
	 * 设置成功标记
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * 获取评论类型
	 */
	public int getType() {
		return type;
	}
	/**
	 * 设置评论类型
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 获取站点ID
	 */
	public long getSiteId() {
		return siteId;
	}
	/**
	 * 设置站点ID
	 */
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	/**
	 * 获取登录信息
	 */
	public String getLogInfo() {
		return logInfo;
	}
	/**
	 * 设置登录信息
	 */
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 获取平均分
	 */
	public String getScore() {
		return score;
	}
	/**
	 * 设置平均分
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * 获取文章ID
	 */
	public long getArticleID() {
		return articleID;
	}
	/**
	 * 设置文章ID
	 */
	public void setArticleID(long articleID) {
		this.articleID = articleID;
	}

	/**
	 * 获取评论总数
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * 设置评论总数
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 获取评论列表
	 */
	public List<Discuss> getList() {
		return list;
	}
	/**
	 * 设置评论列表
	 */
	public void setList(List<Discuss> list) {
		this.list = list;
	}

	/**
	 * 获取评论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取评分
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * 设置评分
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	private IDiscussService discussService;			//评论Manager
	/**
	 * 设置评论Manager
	 */
	public void setDiscussService(IDiscussService discussService) {
		this.discussService = discussService;
	}

	/**
	 * 方法说明：查询评论
	 */
	@SuppressWarnings("unchecked")
	public String discuss() throws Exception {
		list = discussService.getDiscuss(getPaginationBean(), getArticleID() ,type);
		total = getPaginationBean().getTotalRecord();
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.#");
		score = df.format(discussService.getAvg(getArticleID(),type));
		return SUCCESS;
	}

	/**
	 * 方法说明：新建评论
	 */
	public String createDiscuss() throws Exception {
		if (!isLogin()) {
			setLoginUrl(PropertyUtil.getProperty("bjcc.login.url"));
			setLoginFlag(false);
			return "login";
		}
		Discuss dis = new Discuss();
		dis.setDiscussUserID(getLoginUserId());
		dis.setContent(content);
		dis.setDiscussUser(getLoginUserInfo().getLoginName());
		dis.setArticleID(articleID);
		dis.setCreationDate(new Date());
		dis.setGrade(grade);
		dis.setIpAddress(getRequest().getRemoteAddr());
		dis.setSiteID(siteId);
		dis.setStatus(0);
		dis.setType(type);
		discussService.addDiscuss(dis);
		success = "1";
		return SUCCESS;
	}
	
}

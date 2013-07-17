package com.sino.bjcc.media.action;

import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.media.bean.ComBean;
import com.sino.bjcc.media.bean.ConditionBean;
import com.sino.bjcc.media.bean.ListBoxItem;
import com.sino.bjcc.media.service.IListBoxItemService;
import com.sino.bjcc.media.service.IProgramService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class ProgramAction extends BaseAction {

	private IProgramService programService;		//视频Manager
	private IListBoxItemService itemService;	//检索条件Manager

	/**
	 * 获取视频Manager
	 */
	public IProgramService getProgramService() {
		return programService;
	}
	/**
	 * 设置视频Manager
	 */
	public void setProgramService(IProgramService programService) {
		this.programService = programService;
	}
	/**
	 * 获取检索条件Manager
	 */
	public IListBoxItemService getItemService() {
		return itemService;
	}
	/**
	 * 设置检索条件Manager
	 */
	public void setItemService(IListBoxItemService itemService) {
		this.itemService = itemService;
	}
	
	private List<ListBoxItem> itemList;								//OUT:检索条件选项
	private List<ComBean> comList = new ArrayList<ComBean>();		//OUT:检索结果
	private ConditionBean condiBean = null;							//IN：检索条件
	private String showFlag = null;									//IN:检索条件显示标记
	
	/**
	 * 获取检索条件选项列表
	 */
	public List<ListBoxItem> getItemList() {
		return itemList;
	}
	/**
	 * 设置检索条件选项列表
	 */
	public void setItemList(List<ListBoxItem> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 获取检索结果列表
	 */
	public List<ComBean> getComList() {
		return comList;
	}
	/**
	 * 设置检索结果列表
	 */
	public void setComList(List<ComBean> comList) {
		this.comList = comList;
	}

	/**
	 * 获取检索条件
	 */
	public ConditionBean getCondiBean() {
		if(null == condiBean){
			condiBean = new ConditionBean();
		}
		if(null != condiBean.getKeyWord()){
			condiBean.setKeyWord(condiBean.getKeyWord().trim());
		}
		return condiBean;
	}
	/**
	 * 设置检索条件
	 */
	public void setCondiBean(ConditionBean condiBean) {
		this.condiBean = condiBean;
	}
	/**
	 * 获取检索条件显示标记
	 */
	public String getShowFlag() {
		return showFlag;
	}
	/**
	 * 设置检索条件显示标记
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
	// 查询中信 等于1为“个人中心”查询选课，其它情况为
	private String selectTag;
	//个人中心选课时用
	private String slectDate; 
	/**
	 * 获取检索标记
	 */
	public String getSelectTag() {
		return selectTag;
	}
	/**
	 * 设置检索标记
	 */
	public void setSelectTag(String selectTag) {
		this.selectTag = selectTag;
	}
	
	public String getSlectDate() {
		return slectDate;
	}
	public void setSlectDate(String slectDate) {
		this.slectDate = slectDate;
	}

	private String channel;// 频道
	/**
	 * 获取频道
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 设置频道
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * 方法说明：获取点播课件信息
	 */
	@SuppressWarnings("unchecked")
	public String getCon() throws Exception {
		String result = "program";
		if ("1".equals(selectTag)) {
			result = "slectCourseList";
			if (super.isLogin() == false) {
				super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
				return null;
			}
		}
		this.itemList = itemService.getList();
		String channel = getProgramService().getChannel(getChannel());
		this.comList = getProgramService().getList(getPaginationBean(), channel, getCondiBean(), getItemList());
		return result;
	}

}

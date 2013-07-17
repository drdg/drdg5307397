package com.sino.bjcc.hotCode.action;

import java.util.List;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.hotCode.bean.HotCode;
import com.sino.bjcc.hotCode.service.IHotCodeService;

@SuppressWarnings("serial")
public class HotCodeAction extends BaseAction {
	private List<HotCode> hotCodeList = null;	//OUT:热词列表
	/**
	 * 获取热词列表
	 */
	public List<HotCode> getHotCodeList() {
		return hotCodeList;
	}
	/**
	 * 设置热词列表
	 */
	public void setHotCodeList(List<HotCode> hotCodeList) {
		this.hotCodeList = hotCodeList;
	}

	private IHotCodeService hotCodeService;		//热词Manager
	/**
	 * 设置热词Manager
	 */
	public void setHotCodeService(IHotCodeService hotCodeService) {
		this.hotCodeService = hotCodeService;
	}
	/**
	 * 获取热词Manager
	 */
	public IHotCodeService getHotCodeService() {
		return hotCodeService;
	}
	
	/**
	 * 方法说明：获取所有热词
	 */
	public String getList() throws Exception { 
		setHotCodeList(getHotCodeService().getList()); 
		return "list";
	}
}

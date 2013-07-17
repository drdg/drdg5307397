package com.sino.bjcc.hotCode.service.impl;

import java.net.URLEncoder;
import java.util.List;

import com.sino.bjcc.common.utility.PropertyUtil;
import com.sino.bjcc.hotCode.bean.HotCode;
import com.sino.bjcc.hotCode.dao.IHotCodeDao;
import com.sino.bjcc.hotCode.service.IHotCodeService;

public class HotCodeService implements IHotCodeService {
	/***类型为用户热词***/
	private final String HOT_CODE_USER = "1";
	
	private IHotCodeDao hotCodeDao;		//热词Dao
	/**
	 * 设置热词Dao
	 */
	public void setHotCodeDao(IHotCodeDao hotCodeDao) {
		this.hotCodeDao = hotCodeDao;
	}
	/**
	 * 获取热词Dao
	 */
	public IHotCodeDao getHotCodeDao() {
		return hotCodeDao;
	}

	/**
	 * 方法说明：获取所有热词
	 */
	public List<HotCode> getList() throws Exception {
		//获取所有Dao
		List<HotCode> codeList = getHotCodeDao().getList();
		//为用户热词设定超链接
		for(HotCode code : codeList){
			if(HOT_CODE_USER.equals(code.getType())){
				String url = PropertyUtil.getProperty("bjcc.search.url") + URLEncoder.encode(code.getName(),"UTF-8");
				code.setUrl(url);
			}
		}
		return codeList;
	}
}

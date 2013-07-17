package com.sino.bjcc.hotCode.service;

import java.util.List;
import com.sino.bjcc.hotCode.bean.HotCode;

public interface IHotCodeService {
	/**
	 * 获取全部上线状态长城热词
	 */
	public List<HotCode> getList() throws Exception;
}

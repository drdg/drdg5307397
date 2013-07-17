package com.sino.system.constant.dao;

import java.util.List;
import java.util.Map;

import com.sino.elearning.basedao.IBaseDao;
/**
 * 系统常量dao接口
 * @author Administrator
 *
 */
public interface IConstantConfigureDao extends IBaseDao {
	
	/**
	 * 获取常量配置信息
	 * @param conNetDiff(网络区分 0:互联网 1:政务网)
	 */
	public List<Map> getConstants(String conNetDiff) throws Exception;
}
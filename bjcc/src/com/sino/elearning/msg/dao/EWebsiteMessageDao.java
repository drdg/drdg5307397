package com.sino.elearning.msg.dao;

import java.util.List;
import java.util.Map;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.basedao.IBaseDao;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;

/**
 * 站内短信管理dao接口类
 * 
 * @author WANGNING 2012-11-17
 * 
 */
public interface EWebsiteMessageDao extends IBaseDao {

	/**
	 * 保存站内信息
	 * 
	 * @param eWebsiteMessage
	 */
	public Long saveMessage(EWebsiteMessage eWebsiteMessage);

	/**
	 * 按id进行查询站内信息
	 * 
	 * @param id
	 * @return
	 */
	public EWebsiteMessage findById(long id);

	/**
	 * 查询当前用户的发件箱信息30
	 * 
	 * @return
	 */
	public List<EWebsiteMessage> findAll(PaginationBean page,
			String sendUsername, String status);

	/**
	 * 验证用户姓名
	 * 
	 * @param userNames
	 * @return
	 */
	public List<Map> verifyUserNames(String[] userNames);

	/**
	 * 逻辑删除发件箱的信息
	 * 
	 * @param id
	 */
	public void delMessageById(String id);
	
	/**
	 * 删除发件箱的信息
	 * 
	 * @param id
	 */
	public void delByMessageId(String id);

	/**
	 * 保存转发信息
	 * 
	 * @param eWebsiteMessage
	 * @return
	 */
	public Long saveTransferMessage(EWebsiteMessage websiteMessage);

	/**
	 * 保存回复信息
	 * 
	 * @param websiteMessage
	 * @return
	 */
	public Long saveReplyMessage(EWebsiteMessage websiteMessage);
	/**
	 * 查看发件箱详细信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EWebsiteMessage findDetailWebMessage(long receiveMsgId,
			String sendUsername);
}
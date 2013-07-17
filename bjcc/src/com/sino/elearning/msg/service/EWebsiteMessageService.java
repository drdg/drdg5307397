package com.sino.elearning.msg.service;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;

public interface EWebsiteMessageService {

	/**
	 * 保存站内信息
	 * 
	 * @param eWebsiteMessage
	 */
	public Long save(EWebsiteMessage websiteMessage);

	/**
	 * 按id进行查询站内信息
	 * 
	 * @param id
	 * @return
	 */
	public EWebsiteMessage findById(long id);

	/**
	 * 查询当前用户发件箱的信息30
	 * 
	 * @return
	 */
	public List<EWebsiteMessage> findAll(PaginationBean page,
			String sendUsername, String status);

	/**
	 * 查询当前用户接收的信息30
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAll(PaginationBean page, String receiveName);

	/**
	 * 查询收件箱的信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAllReceiveMessage();

	/**
	 * 验证用户姓名
	 * 
	 * @param userNames
	 * @return
	 */
	public String verifyUserNames(String[] userNames);

	/**
	 * 逻辑删除一条发件箱信息
	 * 
	 * @param id
	 */
	public void delMessageById(long id);

	/**
	 * 删除发件箱的信息
	 * 
	 * @param id
	 */
	public void delByMessageId(long id);
	
	/**
	 * 逻辑批量删除发件箱的信息
	 * 
	 * @param ids
	 */
	public void delMessageByIds(String ids);
	
	/**
	 * 逻辑删除收件箱的信息
	 * 
	 * @param id
	 * */
	public void delfoReceiveId(String id);
	
	/**
	 * 删除一条收件箱的信息
	 * 
	 * @param id
	 * @return
	 */
	public void delByReceiveId(Long id);

	/**
	 * 批量删除收件箱的信息
	 * 
	 * @param rids
	 * @return
	 */
	public void delByReceiveIds(String rids,String username);
	/**
	 * 根据id查询群发用户信息
	 * */
	public List<EReceiveMessage> findById(Long id,String receiveName);
	/**
	 * 查询收件箱中全部未读的信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAllUnreadMessage(String receiveName, String status);
	/**
	 * 查询收件箱中未读的信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findUnreadMessage(PaginationBean page,
			String receiveName, String status);

	/**
	 * 查询需要回复的信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EReceiveMessage findReplyMessage(long receiveMsgId,
			String receiveName);

	/**
	 * 保存回复信息
	 * 
	 * @param websiteMessage
	 * @return
	 */
	public Long saveReplyMessage(EWebsiteMessage websiteMessage);

	/**
	 * 查询需要转发的信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EReceiveMessage findTransferMessage(long receiveMsgId,
			String receiveName);

	/**
	 * 保存转发信息
	 * 
	 * @param eWebsiteMessage
	 * @return
	 */
	public Long saveTransferMessage(EWebsiteMessage websiteMessage);
	/**
	 * 查看发件箱详细信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EWebsiteMessage findDetailWebMessage(long id,
			String receiveName);
	/**
	 * 查看收件箱详细信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EReceiveMessage findDetailMessage(long receiveMsgId,
			String sendUsername);
	  /**
	 * 更新对象根据hql params[]
	 * @param hql
	 * @param params
	 * @return
	 */
	public abstract int updateObject(final String hql, final Object params[]) throws Exception;
}

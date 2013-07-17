package com.sino.elearning.msg.dao;

import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.basedao.IBaseDao;
import com.sino.elearning.msg.bean.EReceiveMessage;

/**
 * 接收短信dao接口类
 * 
 * @author Administrator
 * 
 */
public interface EReceiveMessageDao extends IBaseDao {
	/**
	 * 保存用户接收信息
	 * 
	 * @param eReceive
	 */
	public Long saveReceiveMessage(EReceiveMessage receiveMessage);

	/**
	 * 查询接收的信息
	 * 
	 * @param recId
	 * @return
	 */
	public EReceiveMessage findById(long recId);

	/**
	 * 查询收件箱的信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAllReceiveMessage();
	/**
	 * 查询当前用户接收的信息 30
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAll(PaginationBean page, String receiveName);
	/**
	 * 逻辑删除收件箱的信息
	 * 
	 * @param id
	 * */
	public void delfoReceiveId(String id);
	/**
	 * 删除收件箱的信息
	 * 
	 * @param id
	 */
	public void delByReceiveId(String id);
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
	 * 查询收件箱中未读的信息30
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findUnreadMessage(PaginationBean page,
			String receiveName, String status);

	/**
	 * 查询需要回复的信息
	 * 
	 * @param recId
	 * @return
	 */
	public EReceiveMessage findReplyMessage(long receiveMsgId,
			String receiveName);

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
	 * 查看收件箱详细信息
	 * 
	 * @param receiveMsgId
	 * @param receiveName
	 * @return
	 */
	public EReceiveMessage findDetailMessage(long id,
			String receiveName);
	/**
	   * 更新对象根据hql params[]
	   * @param hql
	   * @param params
	   * @return
	   */
	  public int updateObject(String hql, Object params[]);
}

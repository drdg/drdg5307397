package com.sino.elearning.msg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.msg.bean.EReceiveMessage;
import com.sino.elearning.msg.bean.EWebsiteMessage;
import com.sino.elearning.msg.dao.EReceiveMessageDao;
import com.sino.elearning.msg.dao.EWebsiteMessageDao;
import com.sino.elearning.msg.service.EWebsiteMessageService;

public class EWebsiteMessageServiceImpl implements EWebsiteMessageService {
	private EWebsiteMessageDao websiteMessageDao;
	private EReceiveMessageDao receiveMessageDao;

	/**
	 * 保存站内信息
	 */
	@Transactional(readOnly = false)
	public Long save(EWebsiteMessage websiteMessage) {
		Long result = 0L;
		websiteMessage.setSendTime(DateTimeUtil.getNowStr());
		websiteMessage.setStatus("0");
		websiteMessageDao.saveMessage(websiteMessage);
		for (EReceiveMessage rece : websiteMessage.getListusers()) {
			rece.setWebsiteMessage(websiteMessage);
			receiveMessageDao.save(rece);
		}
		return result;
	}

	/**
	 * 查询当前用户发件箱的信息30
	 */
	public List<EWebsiteMessage> findAll(PaginationBean page,
			String sendUsername, String status) {
		return websiteMessageDao.findAll(page, sendUsername, status);
	}

	/**
	 * 查询当前用户收件箱的信息30
	 */
	 
	public List<EReceiveMessage> findAll(PaginationBean page, String receiveName) {
		return receiveMessageDao.findAll(page, receiveName);
	}
	/**
	 * 查询收件箱中全部未读的信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAllUnreadMessage(String receiveName, String status){
		return receiveMessageDao.findAllUnreadMessage(receiveName, status);
	};
	/**
	 * 查询收件箱中未读的信息30
	 */
	 
	public List<EReceiveMessage> findUnreadMessage(PaginationBean page,
			String receiveName, String status) {
		return receiveMessageDao.findUnreadMessage(page, receiveName, status);
	}

	/**
	 * 查询所有的接收信息
	 * 
	 * @return
	 */
	public List<EReceiveMessage> findAllReceiveMessage() {
		return receiveMessageDao.findAllReceiveMessage();
	}

	/**
	 * 按id进行查询站内信息
	 */
	public EWebsiteMessage findById(long id) {
		return websiteMessageDao.findById(id);
	}

	/**
	 * 验证用户姓名
	 */
	 
	public String verifyUserNames(String[] userNames) {

		List<Map> list = websiteMessageDao.verifyUserNames(userNames);
		// 在数据库中不存在的用户名
		StringBuffer notExistNames = new StringBuffer();
		for (int u = 0; u < userNames.length; u++) {
			boolean isexists = false;
			for (Map map : list) {
				String username = map.get("USERNAME").toString();
				if (username.equals(userNames[u])) {
					isexists = true;
				}
			}
			if (isexists == false) {
				notExistNames.append(userNames[u]).append(";");
			}
		}
		return notExistNames.toString();
	}

	/**
	 * 逻辑删除一条发件箱的信息
	 */
	 
	public void delMessageById(long id) {
		websiteMessageDao.delMessageById(((Long) id).toString());
	}
	
	/**
	 * 删除发件箱的信息
	 * 
	 * @param id
	 */
	public void delByMessageId(long id){
		List<EReceiveMessage> receiveMessages;
		receiveMessages = findById(id,null);
		for(int i=0;i<receiveMessages.size();i++){
			delByReceiveId(receiveMessages.get(i).getReceiveMsgId());
		}
		websiteMessageDao.delByMessageId(String.valueOf(id));
	};
	
	/**
	 * 批量删除发件箱的信息
	 */
	 
	public void delMessageByIds(String ids) {
		String[] str = ids.split(",");
		for (String id : str) {
			Boolean state = true;
			List<EReceiveMessage> receiveMessages = findById(Long.valueOf(id),null);
			if(receiveMessages.size()>0){
				for(int i=0;i<receiveMessages.size();i++){
					if(receiveMessages.get(i).getMesStatus().equals("0")){
						state = false;
					}
				}
				if(state){
					delByMessageId(Long.valueOf(id));
				}else{
					delMessageById(Long.valueOf(id));	
				}
			}else{
				delByMessageId(Long.valueOf(id));
			}
			
		}
	}
	/**
	 * 逻辑删除收件箱的信息
	 * 
	 * @param id
	 * */
	public void delfoReceiveId(String id){
		receiveMessageDao.delfoReceiveId(id);
	};
	/**
	 * 删除一条收件箱的信息
	 */
	 
	public void delByReceiveId(Long id) {
		receiveMessageDao.delByReceiveId(((Long) id).toString());
	}

	/**
	 * 批量删除发件箱的信息
	 */
	 
	public void delByReceiveIds(String rids,String username) {
		String[] str = rids.split(",");
		for (String id : str) {
			EReceiveMessage	receiveMessage =  findDetailMessage(Long.valueOf(id),username);
			if(receiveMessage.getWebsiteMessage().getStatus().equals("0")){
				delfoReceiveId(id);
			}else if(receiveMessage.getWebsiteMessage().getStatus().equals("1")){
				Boolean state=true;
				List<EReceiveMessage> receiveMessages = findById(receiveMessage.getWebsiteMessage().getId(),username);
				if(receiveMessages.size()>0){
					for(int i=0;i<receiveMessages.size();i++){
						if(receiveMessages.get(i).getMesStatus().equals("0")){
							state=false;
						}
					}
					if(state){
						delByReceiveId(Long.valueOf(id));	
					}else{
						delfoReceiveId(id);
					}
				}else{
					delByReceiveId(Long.valueOf(id));
				}
				
			}
		}
	}
	/**
	 * 根据id查询群发用户信息
	 * */
	public List<EReceiveMessage> findById(Long id,String receiveName){
		return receiveMessageDao.findById(id, receiveName);
	};
	/**
	 * 查询需要回复的信息
	 */
	 
	public EReceiveMessage findReplyMessage(long receiveMsgId,
			String receiveName) {
		return receiveMessageDao.findReplyMessage(receiveMsgId, receiveName);
	}

	/**
	 * 保存回复的信息
	 */
	 
	public Long saveReplyMessage(EWebsiteMessage websiteMessage) {
		Long result = 0L;
		websiteMessage.setSendTime(DateTimeUtil.getNowStr());
		websiteMessage.setStatus("0");
		websiteMessageDao.saveReplyMessage(websiteMessage);
		for (EReceiveMessage rece : websiteMessage.getListusers()) {
			rece.setWebsiteMessage(websiteMessage);
			receiveMessageDao.save(rece);
		}
		return result;
	}
	
	/**
	 * 查询需要转发的信息
	 */
	 
	public EReceiveMessage findTransferMessage(long receiveMsgId,
			String receiveName) {
		return receiveMessageDao.findTransferMessage(receiveMsgId, receiveName);
	}

	/**
	 * 保存转发信息
	 */
	 
	public Long saveTransferMessage(EWebsiteMessage websiteMessage) {
		Long result = 0L;
		websiteMessage.setSendTime(DateTimeUtil.getNowStr());
		websiteMessage.setStatus("0");
		websiteMessageDao.saveTransferMessage(websiteMessage);
		for (EReceiveMessage rece : websiteMessage.getListusers()) {
			rece.setWebsiteMessage(websiteMessage);
			receiveMessageDao.save(rece);
		}
		return result;
	}
	/**
	 * 查看发件箱详细信息
	 */
	 
	public EWebsiteMessage findDetailWebMessage(long id,
			String sendUsername) {
		return websiteMessageDao.findDetailWebMessage(id, sendUsername);
	}
	/**
	 * 查看收件箱详细信息
	 */
	 
	public EReceiveMessage findDetailMessage(long receiveMsgId,
			String receiveName) {
		return receiveMessageDao.findDetailMessage(receiveMsgId, receiveName);
	}
	 /**
	 * 更新对象根据hql params[]
	 * @param hql
	 * @param params
	 * @return
	 */
	public int updateObject(String hql, Object[] params) throws Exception {
		// TODO Auto-generated method stub
		return receiveMessageDao.updateObject(hql, params);
	}
	
	
	public EReceiveMessageDao getReceiveMessageDao() {
		return receiveMessageDao;
	}

	public void setReceiveMessageDao(EReceiveMessageDao receiveMessageDao) {
		this.receiveMessageDao = receiveMessageDao;
	}

	public EWebsiteMessageDao getWebsiteMessageDao() {
		return websiteMessageDao;
	}

	public void setWebsiteMessageDao(EWebsiteMessageDao websiteMessageDao) {
		this.websiteMessageDao = websiteMessageDao;
	}


}

package com.sino.elearning.userstore.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.elearning.userstore.bean.EUserStore;
import com.sino.elearning.userstore.dao.IEUserStoreDao;
import com.sino.elearning.userstore.service.IEUserStoreService;

/**
 * 用户收藏service实现
 * @author 付政委 2013年1月25日
 */
public class EUserStoreServiceImpl implements IEUserStoreService {

	private IEUserStoreDao userStoreDao;

	/**
	 * 初始化查询十条用户存储的数据
	 */
	public List<EUserStore> queryCmsArticleByHql() throws Exception {
		List<EUserStore> list = null;
		try {
			list = userStoreDao.queryCmsArticleByHql();
		} catch (Exception e) {
			log.error("查询用户存储失败queryCmsArticleByHql()");
			throw e;
		}
		return list;
	}

	/**
	 * 保存用户收藏
	 */
	public long addUserStoreByHql(EUserStore userStore) throws Exception {
		Long message = null;
		try {
			message = userStoreDao.addUserStoreByHql(userStore);
			log.debug("add userStore ok!service");
		} catch (Exception e) {
			log.error("保存用户收藏失败");
			throw e;
		}
		return message;
	}

	/**
	 * 删除用户收藏
	 */
	public void deleteUserStoreById(Long userStoreId) throws Exception {
		try {
			userStoreDao.deleteUserStoreById(userStoreId);
		} catch (Exception e) {
			log.error("删除用户收藏失败");
			throw e;
		}
	}

	/**
	 * 根据id获得用户详情
	 */
	public EUserStore detailUserStoreById(Long userStoreId) throws Exception {
		EUserStore userStore = null;
		try {
			userStore = (EUserStore) userStoreDao
					.queryUserStoreById(userStoreId);
		} catch (Exception e) {
			log.error("根据id获得用户详情失败");
			throw e;
		}
		return userStore;
	}

	/**
	 * 修改用户收藏
	 */
	public void modifyUserStore(EUserStore userStore) throws Exception {
		try {
			userStoreDao.modifyUserStore(userStore);
		} catch (Exception e) {
			log.error("修改用户收藏失败");
			throw e;
		}
	}

	/**
	 * 验证用户收藏ID是否重复
	 */
	public boolean verifyUserStoreId(Long userId, Long programId)
			throws Exception {
		boolean bool = false;
		try {
			bool = userStoreDao.verifyUserStoreId(userId, programId);
		} catch (Exception e) {
			log.error("验证用户信息是否重复失败");
			throw e;
		}
		return bool;
	}

	Log log = LogFactory
			.getLog(com.sino.elearning.userstore.service.impl.EUserStoreServiceImpl.class);

	public IEUserStoreDao getUserStoreDao() {
		return userStoreDao;
	}

	public void setUserStoreDao(IEUserStoreDao userStoreDao) {
		this.userStoreDao = userStoreDao;
	}

}

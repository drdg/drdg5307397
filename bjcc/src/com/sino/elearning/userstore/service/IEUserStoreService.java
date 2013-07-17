package com.sino.elearning.userstore.service;

import java.util.List;

import com.sino.elearning.userstore.bean.EUserStore;


/**
 * 用户收藏service接口
 * @author 付政委
 * 2013年1月25日
 */
public interface IEUserStoreService {

	/**
	 * 初始化数据返回十条数据库信息
	 * @return
	 * @throws Exception
	 */
	public List<EUserStore> queryCmsArticleByHql() throws Exception;
	
	/**
	 * 保存用户收藏
	 * @return
	 * @throws Exception
	 */
	public long addUserStoreByHql(EUserStore userStore) throws Exception;
	
	/**
	 * 删除用户收藏
	 * @param userStoreId
	 * @throws Exception
	 */
	public void deleteUserStoreById(Long userStoreId) throws Exception;
	
	/**
	 * 根据id获得该用户详情
	 * @param userStoreId
	 * @throws Exception
	 */
	public EUserStore detailUserStoreById(Long userStoreId) throws Exception;
	
	/**
	 * 修改用户收藏信息
	 * @param userStore
	 * @throws Exception
	 */
	public void modifyUserStore(EUserStore userStore) throws Exception;
	
	/**
	 * 验证用户收藏ID是否重复
	 * @param userId
	 * @param programId
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUserStoreId(Long userId,Long programId) throws Exception;
}

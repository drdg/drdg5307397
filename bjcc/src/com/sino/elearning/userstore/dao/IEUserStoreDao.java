package com.sino.elearning.userstore.dao;

import java.util.List;

import com.sino.elearning.basedao.IBaseDao;
import com.sino.elearning.userstore.bean.EUserStore;

/**
 * 用户学习收藏DAO接口
 * @author 付政委
 * 2013年1月25日 
 */
public interface IEUserStoreDao extends IBaseDao{

	/**
	 * 初始化返回前十条数据
	 * @return
	 * @throws Exception
	 */
	public List<EUserStore> queryCmsArticleByHql() throws Exception;
	
	/**
	 * 添加用户收藏信息
	 * @param userStore
	 * @return
	 * @throws Exception
	 */
	public long addUserStoreByHql(EUserStore userStore) throws Exception;
	
	/**
	 * 根据id删除用户收藏信息
	 * @param userStoreId
	 * @throws Exception
	 */
	public void deleteUserStoreById(Long userStoreId) throws Exception;
	
	/**
	 * 根据id获得详情
	 * @param userStoreId
	 * @return
	 * @throws Exception
	 */
	public EUserStore queryUserStoreById(Long userStoreId) throws Exception;
	
	/**
	 * 修改用户存储
	 * @param userStore
	 * @throws Exception
	 */
	public void modifyUserStore(EUserStore userStore) throws Exception;
	
	/**
	 * 验证用户存储的ID是否重复
	 * @param userId
	 * @param programId
	 * @throws Exception
	 */
	public boolean verifyUserStoreId(Long userId,Long programId) throws Exception;
}

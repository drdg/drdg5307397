package com.sino.elearning.userstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sino.bjcc.common.PersistenceBase;
import com.sino.elearning.userstore.bean.ESinoProgram;
import com.sino.elearning.userstore.bean.EUserStore;
import com.sino.elearning.userstore.dao.IEUserStoreDao;

public class EUserStoreDaoImpl extends PersistenceBase implements
		IEUserStoreDao {

	/**
	 * 初始化返回十条数据
	 */
	@SuppressWarnings("unchecked")
	public List<EUserStore> queryCmsArticleByHql() throws Exception {

		List<EUserStore> articles = null;
		try {
			articles = super.executeQuery("from EUserStore",5);
		} catch (Exception e) {
			log.error("查询用户收藏失败queryCmsArticleByHql()");
			throw e;
		}
		return articles;
	}

	/**
	 * 保存用户收藏
	 */
	public long addUserStoreByHql(EUserStore userStore) throws Exception {
		Long message = null;
		try {
			message = (Long) super.getHibernateTemplate().save(userStore);
			log.debug("add UserStore ok!");
		} catch (Exception e) {
			log.error("保存用户收藏失败addUserStoreByHql(EUserStore userStore)");
			throw e;
		}
		return message;
	}

	/**
	 * 删除用户收藏
	 */
	public void deleteUserStoreById(final Long userStoreId) throws Exception {

		try {
			EUserStore eus = new EUserStore();
			eus.setId(userStoreId);
			super.delete(eus);
		} catch (Exception e) {
			log.error("删除用户收藏失败userStoreId = " + userStoreId);
			throw e;
		}

	}
	
	/**
	 * 根据id查询详情
	 */
	public EUserStore queryUserStoreById(Long userStoreId) throws Exception {
		EUserStore userStore = null;
		try {
			userStore = (EUserStore) getHibernateTemplate().get("com.sino.elearning.userstore.bean.EUserStore", userStoreId);
		} catch (Exception e) {
			log.error("根据id查询详情失败");
			throw e;
		}
		
		return userStore;
	}
	
	/**
	 * 修改用户收藏
	 */
	public void modifyUserStore(EUserStore userStore) throws Exception {
		try {
			super.update(userStore);
		} catch (Exception e) {
			log.error("修改用户收藏失败");
			throw e;
		}
	}
	
	/**
	 * 验证用户收藏ID是否重复（两个ID都重复的时候为重复）
	 */
	public boolean verifyUserStoreId(Long userId, Long programId) throws Exception {
		
		try {
			
			Query query = super.getCurSession().createQuery("from EUserStore eus where eus.userId=:USERID and eus.programId =:PROGRAMID");
			query.setLong("USERID", userId);
			query.setLong("PROGRAMID", programId);
			if(query.list().size() > 0){
				return false;
			}else{
				return true;
			}
			
		} catch (Exception e) {
			log.error("验证用户存储ID是否重复失败");
			return false;
		}
		
	}
	
	
	Log log = LogFactory
			.getLog(com.sino.elearning.userstore.dao.impl.EUserStoreDaoImpl.class);
}

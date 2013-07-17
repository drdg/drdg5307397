package com.sino.elearning.userstore.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sino.bjcc.common.BaseAction;
import com.sino.elearning.userstore.bean.EUserStore;
import com.sino.elearning.userstore.service.IEUserStoreService;
/**
 * 用户收藏action
 * @author 付政委
 * 2013年1月25日
 */
public class EUserStoreAction extends BaseAction {

	private IEUserStoreService userStoreService;
	
	private List<EUserStore> articles;
	private EUserStore userStore;
	private Long userStoreId;
	
	
	/**
	 * 初始化查询十条数据
	 * @return
	 * @throws Exception
	 */
	public String prepare() throws Exception{
		
		try {
			articles = userStoreService.queryCmsArticleByHql();
		} catch (Exception e) {
			log.error("初始化查询十条数据失败prepare()");
			throw e;
		}
		
		return "prepareuserstore";
	}
	
	
	/**
	 * 保存用户收藏
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		try {
			userStoreService.addUserStoreByHql(userStore);
		} catch (Exception e) {
			log.error("保存用户收藏失败");
			throw e;
		}
		return prepare();
	}
	
	/**
	 * 删除用户收藏通过id
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		try {
			userStoreService.deleteUserStoreById(userStoreId);
		} catch (Exception e) {
			log.error("删除用户收藏失败");
			throw e;
		}
		
		return prepare();
	}
	
	/**
	 * 通过id查询详情
	 * @return
	 * @throws Exception 
	 */
	public String detail() throws Exception{
		
		try {
			userStore = (EUserStore) userStoreService.detailUserStoreById(userStoreId);
		} catch (Exception e) {
			log.error("通过id查询详情失败");
			throw e;
		}
		return "updateuserstore";
		
	}
	
	/**
	 * 修改用户收藏
	 * @return
	 * @throws Exception 
	 */
	public String modify() throws Exception{
		
		try {
			userStoreService.modifyUserStore(userStore);
		} catch (Exception e) {
			log.error("修改用户收藏失败");
			throw e;
		}
		return prepare();
	}
	
	Log log = LogFactory.getLog(com.sino.elearning.userstore.action.EUserStoreAction.class);

	public IEUserStoreService getUserStoreService() {
		return userStoreService;
	}

	public void setUserStoreService(IEUserStoreService userStoreService) {
		this.userStoreService = userStoreService;
	}

	public List<EUserStore> getArticles() {
		return articles;
	}

	public void setArticles(List<EUserStore> articles) {
		this.articles = articles;
	}


	public EUserStore getUserStore() {
		return userStore;
	}


	public void setUserStore(EUserStore userStore) {
		this.userStore = userStore;
	}


	public Long getUserStoreId() {
		return userStoreId;
	}


	public void setUserStoreId(Long userStoreId) {
		this.userStoreId = userStoreId;
	}
}

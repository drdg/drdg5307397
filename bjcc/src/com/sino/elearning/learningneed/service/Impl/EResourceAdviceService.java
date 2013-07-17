package com.sino.elearning.learningneed.service.Impl;


import java.math.BigDecimal;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.learningneed.Dao.IEResourceAdviceDao;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.learningneed.service.IEResourceAdviceService;

public class EResourceAdviceService implements IEResourceAdviceService{
	/**
	 * 删除个人学习需求
	 * */
	public void delete(BigDecimal resourceId) {
		// TODO Auto-generated method stub
		resourceDao.delete(resourceId);
	}
	/**
	 * 查看全部的个人学习需求
	 * */
	public List<EResourceAdvice> findAll(PaginationBean page) throws Exception {
		// TODO Auto-generated method stub
		return resourceDao.findAll(page);
	}
	/**
	 * 根据ID 查看个人学习需求
	 * */
	public EResourceAdvice findById(BigDecimal id) throws Exception {
		// TODO Auto-generated method stub
		return resourceDao.findById(id);
	}
	/**
	 * 根据查询条件 模糊查询
	 * */
	public  List<EResourceAdvice> findByTitle(PaginationBean page,BigDecimal userId,String title){
		return resourceDao.findByTitle(page, userId, title);
	};
	/**
	 * 前台展示，根据用户Id查询用户学习需求
	 * */
	public List<EResourceAdvice> showByUserId(BigDecimal userId) throws Exception {
		// TODO Auto-generated method stub
		return resourceDao.showByUserId(userId);
	}
	/**
	 * 根据用户ID 查看个人学习需求
	 * */
	public List<EResourceAdvice> findByUserIdAll(PaginationBean page,BigDecimal userId) throws Exception {
		// TODO Auto-generated method stub
		return resourceDao.findByUserIdAll(page,userId);
	}
	/**
	 * 添加个人学习需求
	 * */
	public BigDecimal save(EResourceAdvice transientInstance) throws Exception {
		return resourceDao.save(transientInstance);
	}
	/**
	 * 修改个人学习需求
	 * */
	public void update(EResourceAdvice transientInstance) throws Exception {
		// TODO Auto-generated method stub
		resourceDao.update(transientInstance);
	}
	IEResourceAdviceDao resourceDao;
	public IEResourceAdviceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(IEResourceAdviceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
}

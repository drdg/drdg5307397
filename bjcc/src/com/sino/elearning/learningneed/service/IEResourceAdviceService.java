package com.sino.elearning.learningneed.service;

import java.math.BigDecimal;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.learningneed.bean.EResourceAdvice;

public interface IEResourceAdviceService {
	/**
	 * 添加个人学习需求
	 * */
	public abstract BigDecimal save(EResourceAdvice transientInstance) throws Exception;
	/**
	 * 删除个人学习需求
	 * */
	public abstract void delete(BigDecimal resourceId) throws Exception;
	/**
	 * 根据ID 查看个人学习需求
	 * */
	public abstract EResourceAdvice findById(BigDecimal id) throws Exception;
	/**
	 * 根据查询条件 模糊查询
	 * */
	public abstract List<EResourceAdvice> findByTitle(PaginationBean page,BigDecimal userId,String title) throws Exception;
	/**
	 * 根据用户ID 查看个人学习需求
	 * */
	public abstract List<EResourceAdvice> showByUserId(BigDecimal userId) throws Exception;
	/**
	 * 根据用户ID 查看个人学习需求
	 * */
	public abstract List<EResourceAdvice> findByUserIdAll(PaginationBean page,BigDecimal userId) throws Exception;
	/**
	 * 查看全部的个人学习需求
	 * */
	@SuppressWarnings("unchecked")
	public abstract List<EResourceAdvice> findAll(PaginationBean page) throws Exception;
	/**
	 * 修改个人学习需求
	 * */
	public abstract void update(EResourceAdvice transientInstance) throws Exception;
}

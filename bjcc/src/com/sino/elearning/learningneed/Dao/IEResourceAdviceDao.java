package com.sino.elearning.learningneed.Dao;

import java.math.BigDecimal;
import java.util.List;

import com.sino.bjcc.common.bean.PaginationBean;
import com.sino.elearning.learningneed.bean.EResourceAdvice;

public interface IEResourceAdviceDao {
	/**
	 * 添加个人学习需求
	 * */
	public abstract BigDecimal save(EResourceAdvice transientInstance);
	/**
	 * 删除个人学习需求
	 * */
	public abstract void delete(BigDecimal resourceId);
	/**
	 * 根据ID 查看个人学习需求
	 * */
	public abstract EResourceAdvice findById(BigDecimal id);
	/**
	 * 根据查询条件 模糊查询
	 * */
	public abstract List<EResourceAdvice> findByTitle(PaginationBean page,BigDecimal userId,String title);
	/**
	 * 根据用户ID 查看个人学习需求
	 * */
	public abstract List<EResourceAdvice> showByUserId(BigDecimal userId);
	/**
	 * 根据用户ID 查看个人学习需求
	 * */
	public abstract List<EResourceAdvice> findByUserIdAll(PaginationBean page,BigDecimal userId);
	/**
	 * 查看全部的个人学习需求
	 * */
	@SuppressWarnings("unchecked")
	public abstract List<EResourceAdvice> findAll(PaginationBean page);
	/**
	 * 修改个人学习需求
	 * */
	public abstract void update(EResourceAdvice transientInstance);
}

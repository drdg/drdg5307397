package com.sino.elearning.learningneed.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sino.bjcc.common.BaseAction;
import com.sino.bjcc.common.PersistenceBase;
import com.sino.bjcc.common.bean.UserInfo;
import com.sino.bjcc.common.utility.DateTimeUtil;
import com.sino.elearning.learningneed.bean.EResourceAdvice;
import com.sino.elearning.learningneed.service.IEResourceAdviceService;
import com.sino.system.constant.Constant;

@SuppressWarnings("serial")
public class EResourceAdviceAction extends BaseAction{
	EResourceAdvice resource;
	IEResourceAdviceService resourceService;
	List<EResourceAdvice> resources;
	/**
	 * 查看用户添加的所有学习需求
	 * */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			resources = resourceService.showByUserId(new BigDecimal(user.getUserId()));
			System.out.println(resources.size()+"条件查询");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String jump() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		return "jump";
	}
	/**
	 * 根据分页 查看用户添加的所有学习需求
	 * */
	public String executeAll() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		try {
			getPaginationBean().setPageSize(20);	
			resources = resourceService.findByUserIdAll(getPaginationBean(),new BigDecimal(user.getUserId()));
			System.out.println(resources.size()+"条件查询");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "findall";
	}
	/**
	 * 添加个人需求预处理界面
	 * */
	public String addNeeds() throws Exception{
		UserInfo user=getLoginUserInfo();
		resource=new EResourceAdvice();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
				resource.setUserId(new BigDecimal(user.getUserId()));
				resource.setUserNm(user.getUserName());
				if(user.getOrgId()!=null&&!"".equals(user.getOrgId())){
					resource.setDeptId(new BigDecimal(user.getOrgId()));
				}
				resource.setDeptNm(user.getOrgName());
		return "addneeds";
	}
	/**
	 * 保存用户学习需求
	 * */
	public String save() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String title= getRequest().getParameter("title");
		String resourceClassified = getRequest().getParameter("resourceClassified");
		String adviceContent = getRequest().getParameter("adviceContent");
		String userId= getRequest().getParameter("userId");
		String userNm= getRequest().getParameter("userNm");
		String deptId= getRequest().getParameter("deptId");	
		String deptName= getRequest().getParameter("deptName");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newtime=sdf.format(new Date());
		System.out.println("当前时间："+newtime);
		resource=new EResourceAdvice();
		resource.setTitle(title);
		resource.setResourceClassified(resourceClassified);
		resource.setAdviceContent(adviceContent);
		resource.setUserId(new BigDecimal(userId));
		resource.setStates("0");
		resource.setUserNm(userNm);
		if(deptId!=null&&!"".equals(deptId)){
			resource.setDeptId(new BigDecimal(deptId));
		}
		resource.setDeptNm(deptName);
		resource.setCreatTime(newtime);
		try {
			BigDecimal res= resourceService.save(resource);
			if(res!=null){
				return "savesuccess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "savefail";
		
	}
	/**
	 * 删除用户学习需求
	 * */
	public String delNeeds() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String resourceId= getRequest().getParameter("resourceId");
		if(resourceId==null||"".equals(resourceId)){
			return "delsuccess";
		}
		try {
			resourceService.delete(new BigDecimal(resourceId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "delsuccess";
		
	}
	/**
	 * 删除用户学习需求
	 * */
	public String delOneNeeds() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String resourceId= getRequest().getParameter("resourceId");
		if(resourceId==null||"".equals(resourceId)){
			return "delsuccess";
		}
		try {
			resourceService.delete(new BigDecimal(resourceId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "delonesuccess";
		
	}
	/**
	 * ajax 保存用户学习需求
	 * */
	public void ajaxsave(){
		PrintWriter writer = null ;
		String title= getRequest().getParameter("title");
		String resourceClassified = getRequest().getParameter("resourceClassified");
		String adviceContent = getRequest().getParameter("adviceContent");
		String userId= getRequest().getParameter("userId");
		String userNm= getRequest().getParameter("userNm");
		String deptId= getRequest().getParameter("deptId");
		String deptName= getRequest().getParameter("deptName");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newtime=sdf.format(new Date());
		
		resource=new EResourceAdvice();
		resource.setTitle(title);
		resource.setResourceClassified(resourceClassified);
		resource.setAdviceContent(adviceContent);
		resource.setUserId(new BigDecimal(userId));
		resource.setStates("0");
		resource.setUserNm(userNm);
		if(deptId!=null&&!"".equals(deptId)){
			resource.setDeptId(new BigDecimal(deptId));
		}
		resource.setDeptNm(deptName);
		resource.setCreatTime(newtime);
		try {
				writer = getResponse().getWriter();
				BigDecimal res= resourceService.save(resource);
				writer.write("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writer.write("faild");
			}
			writer.flush();
			writer.close();
	}
	/**
	 * 修改用户学习需求
	 * */
	public void update(){
		PrintWriter writer = null ;
		String title= getRequest().getParameter("title");
		String resourceClassified = getRequest().getParameter("resourceClassified");
		String adviceContent = getRequest().getParameter("adviceContent");
		String userId= getRequest().getParameter("userId");
		String userNm= getRequest().getParameter("userNm");
		String deptId= getRequest().getParameter("deptId");
		String deptName= getRequest().getParameter("deptName");
		String states = getRequest().getParameter("states");
		String resourceId = getRequest().getParameter("resourceId");
		resource=new EResourceAdvice();
		resource.setResourceId(new BigDecimal(resourceId));
		resource.setTitle(title);
		resource.setResourceClassified(resourceClassified);
		resource.setAdviceContent(adviceContent);
		resource.setUserId(new BigDecimal(userId));
		resource.setStates(states);
		resource.setUserNm(userNm);
		if(deptId!=null&&!"".equals(deptId)){
			resource.setDeptId(new BigDecimal(deptId));
		}
		resource.setDeptNm(deptName);
		resource.setCreatTime(DateTimeUtil.getNowStr());
		try {
				writer = getResponse().getWriter();
				resourceService.update(resource);
				writer.write("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writer.write("faild");
			}
			writer.flush();
			writer.close();
	}
	/**
	 * 根据条件 模糊查询 用户需求
	 * */
	public String search() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String title =getRequest().getParameter("title");
		try {
			if(title!=null&&!"".equals(title)){
				getPaginationBean().setCurrentPage(1);	
			}
			resources = resourceService.findByTitle(getPaginationBean(),new BigDecimal(user.getUserId()),title);
			System.out.println(resources.size()+"条件查询");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "findall";
	}
	/**
	 * 查看用户学习需求明细
	 * */
	public String datilNeeds() throws Exception{
		UserInfo user=getLoginUserInfo();
		if(user == null) {
			super.getResponse().sendRedirect(Constant.NO_LOGIN_URL);
			return null;
		}
		String resourceId =getRequest().getParameter("resourceId");
		try {
			resource = resourceService.findById(new BigDecimal(resourceId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "datilsuccess";
		
	}
	
	public EResourceAdvice getResource() {
		return resource;
	}
	public void setResource(EResourceAdvice resource) {
		this.resource = resource;
	}
	public IEResourceAdviceService getResourceService() {
		return resourceService;
	}
	public void setResourceService(IEResourceAdviceService resourceService) {
		this.resourceService = resourceService;
	}
	public List<EResourceAdvice> getResources() {
		return resources;
	}
	public void setResources(List<EResourceAdvice> resources) {
		this.resources = resources;
	}
	
}

package com.sino.system.constant.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.WebApplicationContext;

import com.sino.system.constant.Constant;
import com.sino.system.constant.dao.IConstantConfigureDao;

/**
 * 常量配置工具类
 * @author Administrator
 */
public class ConstantUtil {
	
	private static WebApplicationContext applicationContext;

	private static IConstantConfigureDao constantConfigureDao;
//	网络区分 0:互联网 1:政务网
	private static final String conNetDiff = "0";
	
	private static Map constants = new HashMap();
	
	public static void initConstants() {
		try {
			List<Map> list = getConstants(conNetDiff);
			constants.clear();
			for(Map map : list) {
				constants.put(map.get("CON_KEY"), map.get("CON_VALUE"));
			}
//			session用户信息key
			if(null != constants.get("SESSION_KEY_FOR_USER")) {
				Constant.SESSION_KEY_FOR_USER = constants.get("SESSION_KEY_FOR_USER").toString();
			}
//			视频图片 url
			if(null != constants.get("PROGRAM_IMG_URL")) {
				Constant.PROGRAM_IMG_URL = constants.get("PROGRAM_IMG_URL").toString();
			}
//			首页首部的链接
			if(null != constants.get("HEAD_URL")) {
				Constant.HEAD_URL = constants.get("HEAD_URL").toString();
			}
//			首页底部的链接
			if(null != constants.get("BOTTOM_URL")) {
				Constant.BOTTOM_URL = constants.get("BOTTOM_URL").toString();
			}
//			发布静态文章url前缀
			if(null != constants.get("ARTICLE_PREFIX_URL")) {
				Constant.ARTICLE_PREFIX_URL = constants.get("ARTICLE_PREFIX_URL").toString();
			}
//			未登录用户返回地址
			if(null != constants.get("NO_LOGIN_URL")) {
				Constant.NO_LOGIN_URL = constants.get("NO_LOGIN_URL").toString();
			}
//			村官在线论坛url
			if(null != constants.get("SNS_FORUM_LOGIN_URL")) {
				Constant.SNS_FORUM_LOGIN_URL = constants.get("SNS_FORUM_LOGIN_URL").toString();
			}
//			村官在线论坛主题相关链接url
			if(null != constants.get("SNS_FORUM_THEME_CNT_URL")) {
				Constant.SNS_FORUM_THEME_CNT_URL = constants.get("SNS_FORUM_THEME_CNT_URL").toString();
			}
//			红色港湾论坛url
			if(null != constants.get("RB_FORUM_LOGIN_URL")) {
				Constant.RB_FORUM_LOGIN_URL = constants.get("RB_FORUM_LOGIN_URL").toString();
			}
//			红色港湾论坛主题相关请求url
			if(null != constants.get("RB_FORUM_THEME_CNT_URL")) {
				Constant.RB_FORUM_THEME_CNT_URL = constants.get("RB_FORUM_THEME_CNT_URL").toString();
			}
//			双学双比双提高论坛url
			if(null != constants.get("JSPRUN_FORUM_LOGIN_URL")) {
				Constant.JSPRUN_FORUM_LOGIN_URL = constants.get("JSPRUN_FORUM_LOGIN_URL").toString();
			}
//			双学双比双提高论坛主题相关请求url
			if(null != constants.get("JSPRUN_FORUM_THEME_CNT_URL")) {
				Constant.JSPRUN_FORUM_THEME_CNT_URL = constants.get("JSPRUN_FORUM_THEME_CNT_URL").toString();
			}
//			个人信息修改链接url
			if(null != constants.get("MODIFY_PERSON_MESSAGE")) {
				Constant.MODIFY_PERSON_MESSAGE = constants.get("MODIFY_PERSON_MESSAGE").toString();
			}
		} catch(Exception e) {
			System.err.println("初始化常量配置发生异常：");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取常量配置信息
	 * @param conNetDiff(网络区分 0:互联网 1:政务网)
	 */
	public static List<Map> getConstants(String conNetDiff) throws Exception{
		List<Map> list = null;
		try {
			list = constantConfigureDao.getConstants(conNetDiff);
		} catch (Exception e) {
			System.err.println("获取常量配置信息发生异常：");
		}
		return list;
	}
	
	/**
	 * 初始化applicationContext
	 * @param webApplicationContext
	 */
	public static void initWebApplicationContext(
			WebApplicationContext webApplicationContext) {
		applicationContext = webApplicationContext;
		initDao();
		initConstants();
	}
	
	/**
	 * 初始化constantConfigureDao
	 */
	public static void initDao() {
		constantConfigureDao = (IConstantConfigureDao) applicationContext.getBean("constantConfigureDao");
	}
}
package com.sino.bjcc.common.utility;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

	private static Map<Object, Object> propertyMap = null;
	/**
	 * 方法说明：读取globalResource.properties文件，把其配置添加到propertyMap
	 */
	private static Map<Object, Object> readGlobalProperties() throws Exception{
		Map<Object, Object> map = new HashMap<Object, Object>();
		Properties property = new Properties();
		//读取globalResource.properties文件
		InputStream fileStream = PropertyUtil.class.getResourceAsStream("/globalResource.properties");
		property.load(fileStream);
		//关闭数据流
		fileStream.close();
		map.putAll(property);
		return map;
	}
	
	/**
	 * 方法说明：获取globalResource.properties配置中的值
	 */
	public static String getProperty(String key) throws Exception{
		//propertymap为空时读取一次properties文件
		if(null == propertyMap){
			propertyMap = readGlobalProperties();
		}
		//判断property配置项中是否有指定的配置
		if(!propertyMap.containsKey(key)){
			LogUtil.createInstance(PropertyUtil.class.toString()).error("文件globalResource.properties中没有指定的key：" + key);
			return "";
		}
		
		return propertyMap.get(key).toString();
	}
	
}

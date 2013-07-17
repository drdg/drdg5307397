package com.sino.bjcc.common.utility;

import org.apache.log4j.Logger;

public class LogUtil {

	private Logger logger = null;
	
	private LogUtil(String className){
		logger = Logger.getLogger(className);
	}
	
	public static LogUtil createInstance(Object obj){
		return createInstance(obj.getClass().toString());
	}

	public static LogUtil createInstance(String className){
		return new LogUtil(className);
	}
	
	public void info(String message){
		this.logger.info(message);
	}
	
	public void debug(String message){
		this.logger.debug(message);
	}
	
	public void warn(String message){
		this.logger.warn(message);
	}
	
	public void error(String message){
		this.logger.error(message);
	}
	
	public void error(String message,Exception ex){
		this.logger.error(message,ex);
	}
	
}

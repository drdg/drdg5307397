package com.aps.log.imp;

import java.util.Date;
import com.aps.log.ILog;
 

/**
 * 用户日志
 * @author Administrator
 *
 */
public class UserLog implements ILog {

	private static WriteFile wFile = new WriteFile();
	private static StringBuffer sb = new StringBuffer();
	private static String R = "\r\n";
	private static UserLog ulog = new UserLog();
	
	//单例模式
	public static UserLog getUserLogSingleton(){
		if(null != ulog){
			return ulog;
		}else{
			return new UserLog();
		}
	}
	
	//禁止用户实例化
	private UserLog(){}
	
	/**
	 * 保存日志
	 */
	public void doSaveLog(String str) {
		sb.append(R)
		  .append(new Date())
		  .append(R)
		  .append(str)
		  .append(R)
		  .append("---------------");
		sb.trimToSize();
		wFile.doWF(sb.toString());
		sb.delete(0, sb.toString().length());
	}

	
	
}

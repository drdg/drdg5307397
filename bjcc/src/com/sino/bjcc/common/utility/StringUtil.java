package com.sino.bjcc.common.utility;

import java.util.StringTokenizer;

public class StringUtil {

	/**
	 * 方法说明：根据自定的字符分割字符串
	 */
	public static String[] split(String text, String splitChar){
		if(isNullOrEmpty(text)){
			return new String[0];
		}
	    StringTokenizer stringtokenizer = new StringTokenizer(text, splitChar);
	    int i = stringtokenizer.countTokens();
	    String[] as = new String[i];
	    for (int j = 0; j < i; j++) {
	      as[j] = stringtokenizer.nextToken();
	    }
	    return as;
	}
	
	/**
	 * 方法说明：替换字符串中指定的字符
	 */
	public static String replace(String text, String oldChar, String newChar){
		if(isNullOrEmpty(text)){
			return "";
		}
		return text.replaceAll(oldChar, newChar);
	}
	
	/**
	 * 方法说明：判断字符串是否为空
	 */
	public static boolean isNullOrEmpty(String text){
		if(null == text){
			return true;
		}
		if("".equals(text.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * 方法说明：把Object转换为字符串
	 */
	public static String convert2String(Object obj){
		if(null == obj){
			obj = "";
		}
		return String.valueOf(obj);
	}
	
}

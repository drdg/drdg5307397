/**
 * 代码组合
 */
package com.dhls.factory.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeCombination {
	
	private static int key = 0;
	private static String keyName = "";
	private static boolean judgeMent = false;
	
	private String codeAdd = "";
	
	//实例化写入文档的方法
	SaveCodeToFile saveCodeToFile = new SaveCodeToFile();
	
	public CodeCombination(){
	//	cacheCodeMap = new CacheCodeMap(); 
	}
	
	//组合代码
	public void doCodeCom(String strLine){
		
		if("startCode".equals(strLine)){
			codeAdd += "\r\n";
		}else if("endCode".equals(strLine)){
			//如果没有获取到文件名，那么使用默认文件名
			if("".equals(keyName)){
				key ++;
				keyName = "系统默认名："+key;
			}
			judgeMent = false;//回复初始化
			
//			System.out.println(codeAdd);
//			System.out.println(keyName);
			
			
			//写如文件操作
			if(!"".equals(codeAdd)){
				saveCodeToFile.setJavaFileName(keyName);
				saveCodeToFile.WriteJava(codeAdd);
			}
			
			
			codeAdd = "";
			keyName = "";
			
		}else if(0 < codeAdd.length()){
			
			if(!"".equals(strLine)){
				codeAdd += strLine+"\r\n";
			}
			//找文件名，当找到文件名以后将停止找
			if(!judgeMent){
				getFileName(strLine);
			}
		}
		
	}
	//获取文件名函数
	public void getFileName(String strLine){
		Matcher matcher = Pattern.compile("public class ([a-zA-Z]+)").matcher(strLine);
		if(matcher.find()){
			judgeMent = true;//找到 了
			keyName = matcher.group(1);//获取文件名
		}
	}
	
}

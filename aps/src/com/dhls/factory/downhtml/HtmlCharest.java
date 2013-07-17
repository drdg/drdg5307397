package com.dhls.factory.downhtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlCharest {
	
	/**
	 * 根据地址获得编码格式
	 * @param htmlUrl
	 * @return
	 * @throws IOException
	 */
	public String getHtmlCharest(String htmlUrl) throws IOException{
		
		URL name=new URL(htmlUrl);   
		URLConnection conn=name.openConnection();
		conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
		InputStream input=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(input);
		BufferedReader buffer =new BufferedReader(isr);
		String inputLine,pd="gbk";
		int number = 0;
		while((inputLine=buffer.readLine())!=null&&pd.equals("gbk")&&number<5){
			pd = Regex(inputLine);
			number++;
		}
		buffer.close();
		//返回编码格式
		return pd;
	}
	//获取编码
	private static String Regex(String inputLine){
		String Regex = "<meta{1}.*(charset=){1}[a-zA-Z0-9-\"]*\"\\s?/?>";
		String RegexCharset = "charset=.+[0-9a-zA-Z]{1}";
		Matcher mc = Pattern.compile(Regex).matcher(inputLine);
		String charset; 
		if(mc.find()){
			charset = mc.group();
			Matcher mcCharset = Pattern.compile(RegexCharset).matcher(charset);
			if(mcCharset.find()){
				return mcCharset.group().replaceAll("charset=\"?","");
			}
		}
		return "gbk";
	}
	//用正则对url验证
    private static boolean doValidation(String url){
    	
		return true;
    }
}

package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.aps.db.conn.OracleConn;

public class T {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws ParseException, ScriptException {
		// TODO Auto-generated method stub
		/*Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.parse("1989-01-30"));
		System.out.println(dateFormat.format(dateFormat.parse("1989-01-30")));
		*/
		
		/*
		
		//正则匹配
		String str = "车牌号：京P 23001、型号：大车、购车负责人：江风、";
			   str = "车牌号：京P 23001、体积：800、";
		String regex = "([\u4E00-\u9FA5]{2,5})[：](.*?)、";
		Matcher mc = Pattern.compile(regex).matcher(str);
		
		System.out.println(str.matches(regex));
		
		while(mc.find()){
			System.out.println(mc.group(1)+":"+mc.group(2));
		}
		*/
		/*
		try {
			Connection conn = OracleConn.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from aps_emp");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		String str = "1-6*8+1*36+8";
		System.out.println(1-6*8+1*36+8);
		*/
		
//		ArrayList<String> al = new ArrayList<String>();
//		System.out.println(al);
		
		/*
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
		String exp = "a+b";
		scriptEngine.put("a", 4);
		scriptEngine.put("b", 15);
		Object result = scriptEngine.eval(exp);
		System.out.println(exp + "=" + result); 
		*/
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
		String exp = "2*6-(6+5)";
		Object result = scriptEngine.eval(exp);
		System.out.println(exp + "=" + result); 
	}

}

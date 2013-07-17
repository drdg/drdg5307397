package com.aps.log.factory;

public class MyBean {

	static String obj = null;
	
	public MyBean(String obj){
		this.obj = obj;
	}
	
	static{
		Object obean = null;
		
		try {
			obean = Class.forName(obj).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

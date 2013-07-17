package com.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.aps.log.imp.UserLog;


public class Tuserlog {

	@Test
	public void saveLog(){
		UserLog.getUserLogSingleton().doSaveLog("≤‚ ‘");
		System.out.println("»’÷æ–¥ÕÍ");
	}
	
	@Test
	public void time(){
		File file = new File("F:\\UserLog\\mm");
		if(!file.canWrite()){
			file.mkdirs();
		}
		System.out.println(file.canWrite());
	}
	
	
}

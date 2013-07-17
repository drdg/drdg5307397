package com.aps.log.imp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class WriteFile {

	private FileWriter fileWriter;
	private BufferedWriter bw;
	
	
	public WriteFile(){
		
		Properties props = new Properties();
		
		try {
			props.load(UserLog.class.getClassLoader().getResourceAsStream("aps.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			File file = new File(props.getProperty("SAVELOGURL"));
			if(!file.canWrite()){
				file.mkdirs();
			}
			fileWriter = new FileWriter(new File(props.getProperty("SAVELOGURL")+getFileName()+".txt"),true);
			bw = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//写文件方法
	public void doWF(String str){
		try {
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得文件名
	 */
	public String getFileName(){
		String fileName = "";
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	fileName = formater.format(new Date());
        } catch (Exception e) {
            // log.error(e);
        }
		return fileName;
	}
}

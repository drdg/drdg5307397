package com.dhls.factory.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SaveCodeToFile {

	//定义文件名
	private String strJavaFileName = "";
	
	public void setJavaFileName(String strJavaFileName){
		this.strJavaFileName = "C:\\Documents and Settings\\Administrator\\桌面\\"+strJavaFileName+".java";
	}

	public void WriteJava(String strLine) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( new File(strJavaFileName),true),"UTF-8"));
			bw.write(strLine+"\r\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

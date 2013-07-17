package com.aps.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConn {
	

	private static Connection conn;
	private static String OJDO = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String USER = "drdg";
	private static String PASSWORD = "zxcvbnm";
	
	static{
		try {
			Class.forName(OJDO);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			System.out.println("连接成功... ...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}
	
	public static void CloseConn(){
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

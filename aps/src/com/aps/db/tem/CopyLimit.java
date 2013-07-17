package com.aps.db.tem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aps.db.conn.OracleConn;

public class CopyLimit {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	/**
	 * 定义分页信息
	 * pageSize 每页5条记录
	 * pageNum 每页5个小分页项
	 * */
	public final static String pageSize = "5";
	public final static String pageNum = "5";
	
	/********************************
	 * 模仿limit
	 * @param table 表名
	 * @param odby  以谁排序、建议id
	 * @param start 从数字几开始 1代表第一条数据
	 * @param sum   取出多少数据
	 * @throws SQLException 
	 ********************************/
	public ResultSet doLimit(String table,String odby,String start,String sum) throws SQLException{
		/*这样保证table能被下面用*/
		this.table = table;
		setTable(table);
		String sql = 	"select a.* from "+table+" a where rowid in (" +
						"select rd from (" +
						"select rownum rm,rd from (" +
						"select rowid rd from "+table+" order by "+odby+") where rownum <= ?+?) where rm > ?)";
		/*获得连接*/
		conn = OracleConn.getConn();
		ps = conn.prepareStatement(sql);
		
		//起始位置
		start = String.valueOf((Integer.parseInt(start) - 1) * Integer.valueOf(pageSize));
		//赋值
		ps.setString(1, start);
		ps.setString(2, sum);
		ps.setString(3, start);
		return ps.executeQuery();
	}
	/**
	 * 视图里面不能用rowid所以单写出来一个rownum分页
	 * @param table
	 * @param start
	 * @param sum
	 * @return
	 * @throws SQLException
	 */
	public ResultSet doVLimit(String table,String odby,String start,String sum) throws SQLException{
		/*这样保证table能被下面用*/
		this.table = table;
		setTable(table);
		String sql = 	"select v.* from (" +
						"select rownum rm,v.* from "+table+" v " +
						"where rownum <= ?+? order by "+odby+") v where rm > ?";
		/*获得连接*/
		conn = OracleConn.getConn();
		ps = conn.prepareStatement(sql);
		
		//起始位置
		start = String.valueOf((Integer.parseInt(start) - 1) * Integer.valueOf(pageSize));
		//赋值
		ps.setString(1, start);
		ps.setString(2, sum);
		ps.setString(3, start);
		return ps.executeQuery();
	}
	/**
	 * 获得总数据条数
	 * @return
	 * @throws SQLException
	 */
	public String doCount() throws SQLException{
		String count = "";
		conn = OracleConn.getConn();
		ps = conn.prepareStatement("select count(*) from "+getTable());
		rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getString(1);
		}
		
		return count;
	}
	/**********************
	 * 获取到能分出来多少页
	 * @throws SQLException 
	 **********************
	 */
	public String doPageS() throws SQLException{
		String pages = doCount();
		double pc = Double.parseDouble(pages)/5.0;
		if(pc*10%10 > 0){
			pc = (int)pc+1;
		}
		pages = String.valueOf((int)pc);
		return pages;
	}
}

package com.aps.db.dao.itfc.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aps.db.conn.OracleConn;
import com.aps.db.model.V_PdLogin;
import com.aps.db.tem.GetSelectQurey;

/*前面带v的表示是 数据库里面的视图*/
public class V_PdLoginDAO extends GetSelectQurey{
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 根据传参验证登录
	 * @throws SQLException 
	 * */
	public V_PdLogin doLogin(V_PdLogin vl) throws SQLException{
		
		V_PdLogin vlx = new V_PdLogin();
		/*初始给一个值*/
		vlx.setDpid("0");
		
		/*要执行的sql语句*/
		String sql = "select DPID,DPNAME,EID,ENAME,AUNO,AUDESC from pdlogin where ename = ? and eid = ?";
		
		/*调用父类模板*/
		ps = super.getPs(sql);
		/*设置父类值*/
		ps.setString(1, vl.getEname());
		ps.setString(2, vl.getEid());
		/*执行*/
		rs = ps.executeQuery();
		
		while(rs.next()){
			vlx.setDpid(rs.getString("dpid"));			//配送点id
			vlx.setDpname(rs.getString("dpname"));		//配送点名称
			vlx.setEid(rs.getString("eid"));			//员工编号 
			vlx.setEname(rs.getString("ename"));		//员工名称
			vlx.setAuno(rs.getString("auno"));			//权限编号
			vlx.setAudesc(rs.getString("audesc"));		//权限描述
		}
		
		return vlx;
	}
	
}

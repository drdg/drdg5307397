package com.aps.db.model;

public class V_PdLogin extends FenPage{
	
	/*
	 * SQL> create view pdlogin as select b.dpid,b.dpname,e.eid,e.ename,c.auno,c.audesc from aps_dea a,aps_dpoint b,aps_authority c,aps_emp e where a.fk_dpid = b.dpid and a.fk_eid = e.eid and a.fk_auid = c.auid;
	 * */
	
	private String dpid; 		//配送点id
	private String dpname;		//配送点名称（也包括总公司）	
	private String eid;			//员工id
	private String ename;		//员工名称
	private String auno;		//权限编号
	private String audesc;		//权限描述
	
	public String getDpid() {
		return dpid;
	}
	public void setDpid(String dpid) {
		this.dpid = dpid;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAuno() {
		return auno;
	}
	public void setAuno(String auno) {
		this.auno = auno;
	}
	public String getAudesc() {
		return audesc;
	}
	public void setAudesc(String audesc) {
		this.audesc = audesc;
	}
	
	
}

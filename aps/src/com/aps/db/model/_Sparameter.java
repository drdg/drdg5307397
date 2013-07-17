package com.aps.db.model;

public class _Sparameter {
	/*2
	 *系统参数管理表 aps_sparameter system parameter
	SQL> create table aps_sparameter(
	  2  spid number(10) primary key,
	  3  spinto number(3) not null,
	  4  spof number(3) not null,
	  5  spdeletetime number(3) not null,
	  6  spfirstkg number(5) not null,
	  7  spfirstvo number(5) not null);
	 
	 */
	private String spid;		//系统表id
	private String spinto;		//分成比例设置
	private String spof;		//设置保价费比例
	private String spdeletetime;//设置系统自动删除天数
	private String spfirstkg;	//首公斤设置
	private String spfirstvo;	//首体重设置
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getSpinto() {
		return spinto;
	}
	public void setSpinto(String spinto) {
		this.spinto = spinto;
	}
	public String getSpof() {
		return spof;
	}
	public void setSpof(String spof) {
		this.spof = spof;
	}
	public String getSpdeletetime() {
		return spdeletetime;
	}
	public void setSpdeletetime(String spdeletetime) {
		this.spdeletetime = spdeletetime;
	}
	public String getSpfirstkg() {
		return spfirstkg;
	}
	public void setSpfirstkg(String spfirstkg) {
		this.spfirstkg = spfirstkg;
	}
	public String getSpfirstvo() {
		return spfirstvo;
	}
	public void setSpfirstvo(String spfirstvo) {
		this.spfirstvo = spfirstvo;
	}
}

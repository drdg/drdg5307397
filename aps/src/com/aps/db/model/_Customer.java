package com.aps.db.model;

public class _Customer extends FenPage{
	/*1
	 *客户管理表 aps_customer
	 *SQL> create table aps_customer(
	  2  ctid number(10) primary key,
	  3  cnickname varchar2(20) not null,
	  4  cname varchar2(20) not null,
	  5  csex varchar2(2) default '男' check (csex in ('男','女')),
	  6  cpwd varchar2(15) not null,
	  7  ctel number(11) not null,
	  8  cemail varchar2(20),
	  9  cbirthday date,
	 10  caddress varchar2(30));
	 */

	private String ctid;		//用户id
	private String cnickname;	//用户昵称
	private String cname;		//用户姓名
	private String csex;		//用户性别
	private String cpwd;		//用户密码
	private String ctel;		//用户电话
	private String cemail;		//用户邮箱
	private String cbirthday;	//用户生日
	private String caddress;	//用户所在地
	public String getCtid() {
		return ctid;
	}
	public void setCtid(String ctid) {
		this.ctid = ctid;
	}
	public String getCnickname() {
		return cnickname;
	}
	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCbirthday() {
		return cbirthday;
	}
	public void setCbirthday(String cbirthday) {
		this.cbirthday = cbirthday;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
}

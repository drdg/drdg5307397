package com.aps.db.model;
/**
 * 员工表
 * @author Administrator
 *
 */
public class _Emp extends FenPage{
	/*4
	 *员工表 aps_emp emp
	SQL> create table aps_emp(
	  2  eid number(10) primary key,
	  3  ename varchar2(20) not null,
	  4  esex varchar2(2) default '男' check (esex in ('男','女')),
	  5  eage number(3),
	  6  ebirthday date,
	  7  epa varchar2(4) default '党员' check (epa in('团员','党员','无党人士')),
	  8  eaddress varchar2(100) not null,
	  9  ephone number(11) not null,
	 10  eemail varchar2(20),
	 11  epost varchar2(10),
	 12  edept varchar2(10),
	 13  edindate date,
	 14  esal number(6),
	 15  estate varchar2(10),
	 16  enote varchar2(200));
	 */

	private String eid;			//员工id
	private String ename;		//员工姓名
	private String esex;		//员工性别
	private String eage;		//员工年龄
	private String ebirthday;	//员工生日
	private String epa;			//政治面貌
	private String eaddress;	//地址
	private String ephone;		//手机号
	private String eemail;		//email
	private String epost;		//职位
	private String edept;		//部门
	private String eindate;		//入职时间
	private String esal;		//薪水
	private String estate;		//状态
	private String enote;		//备注
	
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
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getEbirthday() {
		return ebirthday;
	}
	public void setEbirthday(String ebirthday) {
		this.ebirthday = ebirthday;
	}
	public String getEpa() {
		return epa;
	}
	public void setEpa(String epa) {
		this.epa = epa;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
	public String getEindate() {
		return eindate;
	}
	public void setEindate(String eindate) {
		this.eindate = eindate;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public String getEstate() {
		return estate;
	}
	public void setEstate(String estate) {
		this.estate = estate;
	}
	public String getEnote() {
		return enote;
	}
	public void setEnote(String enote) {
		this.enote = enote;
	}
}

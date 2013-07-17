package com.aps.db.model;

/**
 * 权限表持久化
 * @author Administrator
 *
 */
public class _Authority{
	/*3
	 *权限表 aps_authority authority
	SQL> create table aps_authority(
	  2  auid number(10) primary key,
	  3  auno number(10) unique,
	  4  audesc varchar2(20) not null);
	 */
	private String auid;		//权限id
	private String auno;		//权限编号
	private String audesc;		//权限描述
	public String getAuid() {
		return auid;
	}
	public void setAuid(String auid) {
		this.auid = auid;
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

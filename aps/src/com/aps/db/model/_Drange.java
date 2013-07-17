package com.aps.db.model;
/**
 * 配送范围终点外键
 * @author Administrator
 *
 */
public class _Drange {
	/*7
	 *配送范围终点外键 aps_drange drange
	SQL> create table aps_drange(
	  2  drid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  drend varchar(30) not null,
	  5  drfkg number(10) not null,
	  6  drokg number(10) not null);
	 */

	private String  drid;		//配送范围id
	private String  fk_dpid;		//配送范围起点
	private String  drend;		//配送范围终点
	private String  drfkg;		//首公斤价格
	private String  drokg;		//次公斤价格
	public String getDrid() {
		return drid;
	}
	public void setDrid(String drid) {
		this.drid = drid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getDrend() {
		return drend;
	}
	public void setDrend(String drend) {
		this.drend = drend;
	}
	public String getDrfkg() {
		return drfkg;
	}
	public void setDrfkg(String drfkg) {
		this.drfkg = drfkg;
	}
	public String getDrokg() {
		return drokg;
	}
	public void setDrokg(String drokg) {
		this.drokg = drokg;
	}
}

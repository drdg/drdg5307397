package com.aps.db.model;
/**
 * 配送点员工权限外键表
 * @author Administrator
 *
 */
public class _Dea {
	/*6
	 *配送点外键表 aps_dea dea
	SQL> create table aps_dea(
	  2  deaid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  fk_eid number(10) references aps_emp(eid),
	  5  fk_auid number(10) references aps_authority(auid));
	 */

	private String deaid;		//配送员工权限综合表id
	private String fk_dpid;	//配送点外键
	private String fk_eid;		//员工外键
	private String fk_auid;	//权限外键
	public String getDeaid() {
		return deaid;
	}
	public void setDeaid(String deaid) {
		this.deaid = deaid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getFk_eid() {
		return fk_eid;
	}
	public void setFk_eid(String fkEid) {
		fk_eid = fkEid;
	}
	public String getFk_auid() {
		return fk_auid;
	}
	public void setFk_auid(String fkAuid) {
		fk_auid = fkAuid;
	}
}

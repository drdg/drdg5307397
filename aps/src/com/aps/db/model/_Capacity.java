package com.aps.db.model;
/**
 * 运力表持久化
 * @author Administrator
 *
 */
public class _Capacity {
	/*11
	 *运力表 aps_capacity capacity
	SQL> create table aps_capacity(
	  2  capid number(10) primary key,
	  3  fk_dpid number(10) references aps_dpoint(dpid),
	  4  fk_rtid number(10) references aps_route(rtid),
	  5  fk_cid number(10) references aps_car(cid),
	  6  fk_eid number(10) references aps_emp(eid),
	  7  capstate varchar2(20));
	 */

	private String capid; 		//运力表id
	private String fk_dpid;		//配送点外键aps_dpoint
	private String fk_rtid;		//路线外键aps_route
	private String fk_cid;		//车辆外键aps_car
	private String fk_eid;		//员工（司机）外aps_emp
	private String capstate;	//状态
	public String getCapid() {
		return capid;
	}
	public void setCapid(String capid) {
		this.capid = capid;
	}
	public String getFk_dpid() {
		return fk_dpid;
	}
	public void setFk_dpid(String fkDpid) {
		fk_dpid = fkDpid;
	}
	public String getFk_rtid() {
		return fk_rtid;
	}
	public void setFk_rtid(String fkRtid) {
		fk_rtid = fkRtid;
	}
	public String getFk_cid() {
		return fk_cid;
	}
	public void setFk_cid(String fkCid) {
		fk_cid = fkCid;
	}
	public String getFk_eid() {
		return fk_eid;
	}
	public void setFk_eid(String fkEid) {
		fk_eid = fkEid;
	}
	public String getCapstate() {
		return capstate;
	}
	public void setCapstate(String capstate) {
		this.capstate = capstate;
	}
}

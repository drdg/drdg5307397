package com.aps.db.model;
/**
 * 交接单
 * @author Administrator
 *
 */
public class _Eir extends FenPage{
	/*13
	 *交接单aps_eir eir
	SQL> create table aps_eir(
	  2  eirid number(10) primary key,
	  3  fk_capid number(10) references aps_capacity(capid),
	  4  fk_olid number(10) references aps_olist(olid));
	 */

	private String eirid;		//交接单id
	private String fk_capid;	//运力表外键
	private String fk_olid;	//订单表外键
	public String getEirid() {
		return eirid;
	}
	public void setEirid(String eirid) {
		this.eirid = eirid;
	}
	public String getFk_capid() {
		return fk_capid;
	}
	public void setFk_capid(String fkCapid) {
		fk_capid = fkCapid;
	}
	public String getFk_olid() {
		return fk_olid;
	}
	public void setFk_olid(String fkOlid) {
		fk_olid = fkOlid;
	}

}

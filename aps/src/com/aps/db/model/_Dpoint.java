package com.aps.db.model;
/**
 * 配送点表持久化
 * @author Administrator
 *
 */
public class _Dpoint extends FenPage{
	/*5
	 *配送点表 aps_dpoint  distribution point
	SQL> create table aps_dpoint(
	  2  dpid number(10) primary key,
	  3  dppro varchar2(100),
	  4  dpaddress varchar2(100),
	  5  dptel number(11) not null,
	  6  dpemail varchar2(30),
	  7  dpnote varchar2(200));
	  SQL> alter table aps_dpoint add dpname varchar2(40) not null;
	 */

	private String dpid;		//配送点id
	private String dppro;		//省份
	private String dpaddress;	//地址
	private String dptel;		//电话
	private String dpemail;		//邮箱
	private String dpnote;		//备注
	private String dpname;		//配送点名
	public String getDpid() {
		return dpid;
	}
	public void setDpid(String dpid) {
		this.dpid = dpid;
	}
	public String getDppro() {
		return dppro;
	}
	public void setDppro(String dppro) {
		this.dppro = dppro;
	}
	public String getDpaddress() {
		return dpaddress;
	}
	public void setDpaddress(String dpaddress) {
		this.dpaddress = dpaddress;
	}
	public String getDptel() {
		return dptel;
	}
	public void setDptel(String dptel) {
		this.dptel = dptel;
	}
	public String getDpemail() {
		return dpemail;
	}
	public void setDpemail(String dpemail) {
		this.dpemail = dpemail;
	}
	public String getDpnote() {
		return dpnote;
	}
	public void setDpnote(String dpnote) {
		this.dpnote = dpnote;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
}

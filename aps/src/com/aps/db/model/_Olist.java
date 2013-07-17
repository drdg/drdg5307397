package com.aps.db.model;
/**
 * 订单
 * @author Administrator
 *
 */
public class _Olist extends FenPage{
	/*12
	 *订单表 aps_olist order list
	SQL> create or replace table aps_olist(
  2  olid number(10) primary key,
  3   olno number(20) unique not null,
  4  olname varchar2(20) not null,
  5  olsendtel number(11) not null,
  6  olsendaddress varchar2(100) not null,
  7  olsendcode number(6) not null,
  8  olsendemail varchar2(50) not null,
  9  olinname varchar2(20) not null,
 10  olintel number(11) not null,
 11  olinaddress varchar2(100) not null,
 12  olincode number(6) not null,
 13  olgoodsname varchar2(50) not null,
 14  olgoodstype varchar2(20) not null,
 15  olgoodsnum number(5) not null,
 16  olgoodsweight number(5,2) not null,
 17  olgoodsaddress varchar2(100) not null,
 18  oldate date not null,
 19  olingoodsadd varchar2(100) not null,
 20  olins number(10),
 21  olsnotice varchar2(2) default '是' check (olsnotice in('是','否')),
 22  olpays varchar2(10) not null,
 23  olnote varchar2(200));
	 */

	private String olid;		//订单id
	private String olno;		//订单编号
	private String olname;		//发货人姓名
	private String olsendtel;	//发货人电话
	private String olsendaddress;	//发货人地址
	private String olsendcode;	//发货人邮编
	private String olsendemail;	//发货人邮箱
	private String olinname;	//收货人姓名
	private String olintel;	//收货人电话
	private String olinaddress;	//收货人地址
	private String olincode;	//收货人邮编
	private String olgoodsname;	//货物名称
	private String olgoodstype;	//货物类型
	private String olgoodsnum;	//货物个数
	private String olgoodsweight;	//货物重量
	private String olgoodsaddress;	//配送站点
	private String oldate;		//下单时间（系统给时间）
	private String olingoodsadd;	//收获站点
	private String olins;		//保险价值
	private String olsnotice;	//短信通知
	private String olpays;		//付款方式
	private String olnote;		//备注信息
	public String getOlid() {
		return olid;
	}
	public void setOlid(String olid) {
		this.olid = olid;
	}
	public String getOlno() {
		return olno;
	}
	public void setOlno(String olno) {
		this.olno = olno;
	}
	public String getOlname() {
		return olname;
	}
	public void setOlname(String olname) {
		this.olname = olname;
	}
	public String getOlsendtel() {
		return olsendtel;
	}
	public void setOlsendtel(String olsendtel) {
		this.olsendtel = olsendtel;
	}
	public String getOlsendaddress() {
		return olsendaddress;
	}
	public void setOlsendaddress(String olsendaddress) {
		this.olsendaddress = olsendaddress;
	}
	public String getOlsendcode() {
		return olsendcode;
	}
	public void setOlsendcode(String olsendcode) {
		this.olsendcode = olsendcode;
	}
	public String getOlsendemail() {
		return olsendemail;
	}
	public void setOlsendemail(String olsendemail) {
		this.olsendemail = olsendemail;
	}
	public String getOlinname() {
		return olinname;
	}
	public void setOlinname(String olinname) {
		this.olinname = olinname;
	}
	public String getOlintel() {
		return olintel;
	}
	public void setOlintel(String olintel) {
		this.olintel = olintel;
	}
	public String getOlinaddress() {
		return olinaddress;
	}
	public void setOlinaddress(String olinaddress) {
		this.olinaddress = olinaddress;
	}
	public String getOlincode() {
		return olincode;
	}
	public void setOlincode(String olincode) {
		this.olincode = olincode;
	}
	public String getOlgoodsname() {
		return olgoodsname;
	}
	public void setOlgoodsname(String olgoodsname) {
		this.olgoodsname = olgoodsname;
	}
	public String getOlgoodstype() {
		return olgoodstype;
	}
	public void setOlgoodstype(String olgoodstype) {
		this.olgoodstype = olgoodstype;
	}
	public String getOlgoodsnum() {
		return olgoodsnum;
	}
	public void setOlgoodsnum(String olgoodsnum) {
		this.olgoodsnum = olgoodsnum;
	}
	public String getOlgoodsweight() {
		return olgoodsweight;
	}
	public void setOlgoodsweight(String olgoodsweight) {
		this.olgoodsweight = olgoodsweight;
	}
	public String getOlgoodsaddress() {
		return olgoodsaddress;
	}
	public void setOlgoodsaddress(String olgoodsaddress) {
		this.olgoodsaddress = olgoodsaddress;
	}
	public String getOldate() {
		return oldate;
	}
	public void setOldate(String oldate) {
		this.oldate = oldate;
	}
	public String getOlingoodsadd() {
		return olingoodsadd;
	}
	public void setOlingoodsadd(String olingoodsadd) {
		this.olingoodsadd = olingoodsadd;
	}
	public String getOlins() {
		return olins;
	}
	public void setOlins(String olins) {
		this.olins = olins;
	}
	public String getOlsnotice() {
		return olsnotice;
	}
	public void setOlsnotice(String olsnotice) {
		this.olsnotice = olsnotice;
	}
	public String getOlpays() {
		return olpays;
	}
	public void setOlpays(String olpays) {
		this.olpays = olpays;
	}
	public String getOlnote() {
		return olnote;
	}
	public void setOlnote(String olnote) {
		this.olnote = olnote;
	}
}

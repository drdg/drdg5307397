package com.aps.db.model;
/**
 * 车辆管理持久化类
 * @author Administrator
 * 继承分页类
 */
public class _Car extends FenPage{
	/*10
	 *车辆管理 aps_car car
	 
	SQL> create table aps_car(
	  2  cid number(10) primary key,
	  3  cbrand varchar2(20) not null,
	  4  cmodel varchar2(20),
	  5  corigin varchar2(50),
	  6  cproduce date,
	  7  cbuy date,
	  8  cpripal varchar2(10) not null,
	  9  cvolume number(10) not null,
	 10  capac number(10) not null);
	 */
	private String cid;			//车辆id
	private String cbrand;		//车牌号
	private String cmodel;		//型号
	private String corigin;		//产地
	private String cproduce;	//出厂时间
	private String cbuy;		//购车时间
	private String cpripal;		//购车负责人
	private String cvolume;		//体积	
	private String capac;		//容量
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCbrand() {
		return cbrand;
	}
	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}
	public String getCmodel() {
		return cmodel;
	}
	public void setCmodel(String cmodel) {
		this.cmodel = cmodel;
	}
	public String getCorigin() {
		return corigin;
	}
	public void setCorigin(String corigin) {
		this.corigin = corigin;
	}
	public String getCproduce() {
		return cproduce;
	}
	public void setCproduce(String cproduce) {
		this.cproduce = cproduce;
	}
	public String getCbuy() {
		return cbuy;
	}
	public void setCbuy(String cbuy) {
		this.cbuy = cbuy;
	}
	public String getCpripal() {
		return cpripal;
	}
	public void setCpripal(String cpripal) {
		this.cpripal = cpripal;
	}
	public String getCvolume() {
		return cvolume;
	}
	public void setCvolume(String cvolume) {
		this.cvolume = cvolume;
	}
	public String getCapac() {
		return capac;
	}
	public void setCapac(String capac) {
		this.capac = capac;
	}
}

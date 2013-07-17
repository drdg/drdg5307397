package com.aps.db.model;
/**
 * 交接单详情视图
 * @author Administrator
 *
 */
public class V_Eirs extends FenPage{

	//配送点表部分字段
	private String dpid;
	private String dppro;
	private String dpaddress;
	private String dptel;
	private String dpemail;
	private String dpnote;
	private String dpname;
	//路线表部分字段
	private String rtid;
	private String rtname;
	private String rtspoint;
	private String rtpefpkg;
	private String rtpeopkg;
	private String rtpefpvo;
	private String rtpeopvo;
	//车辆表部分字段
	private String cid;
	private String cbrand;
	private String cmodel;
	private String corigin;
	private String cproduce;
	private String cbuy;
	private String cpripal;
	private String cvolume;
	private String capac;
	//员工表部分字段
	private String eid;
	private String ename;
	private String esex;
	private String eage;
	private String ebirthday;
	private String epa;
	private String eaddress;
	private String ephone;
	private String eemail;
	private String epost;
	private String edept;
	private String edindate;
	private String esal;
	private String estate;
	private String enote;
	//运力表id
	private String capid;
	//订单表部分字段
	private String olid;
	private String olno;
	private String olname;
	private String olsendtel;
	private String olsendaddress;
	private String olsendcode;
	private String olsendemail;
	private String olinname;
	private String oliname;
	private String olintel;
	private String olinaddress;
	private String olincode;
	private String olgoodsname;
	private String olgoodstype;
	private String olgoodsum;
	private String olgoodsweight;
	private String olgoodsaddress;
	private String oldate;
	private String olingoodsadd;
	private String olins;
	private String olsnotice;
	private String olpays;
	private String olnote;
	//交接单表id
	private String eirid;
	
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
	public String getRtid() {
		return rtid;
	}
	public void setRtid(String rtid) {
		this.rtid = rtid;
	}
	public String getRtname() {
		return rtname;
	}
	public void setRtname(String rtname) {
		this.rtname = rtname;
	}
	public String getRtspoint() {
		return rtspoint;
	}
	public void setRtspoint(String rtspoint) {
		this.rtspoint = rtspoint;
	}
	public String getRtpefpkg() {
		return rtpefpkg;
	}
	public void setRtpefpkg(String rtpefpkg) {
		this.rtpefpkg = rtpefpkg;
	}
	public String getRtpeopkg() {
		return rtpeopkg;
	}
	public void setRtpeopkg(String rtpeopkg) {
		this.rtpeopkg = rtpeopkg;
	}
	public String getRtpefpvo() {
		return rtpefpvo;
	}
	public void setRtpefpvo(String rtpefpvo) {
		this.rtpefpvo = rtpefpvo;
	}
	public String getRtpeopvo() {
		return rtpeopvo;
	}
	public void setRtpeopvo(String rtpeopvo) {
		this.rtpeopvo = rtpeopvo;
	}
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
	public String getEdindate() {
		return edindate;
	}
	public void setEdindate(String edindate) {
		this.edindate = edindate;
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
	public String getCapid() {
		return capid;
	}
	public void setCapid(String capid) {
		this.capid = capid;
	}
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
	public String getOliname() {
		return oliname;
	}
	public void setOliname(String oliname) {
		this.oliname = oliname;
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
	public String getOlgoodsum() {
		return olgoodsum;
	}
	public void setOlgoodsum(String olgoodsum) {
		this.olgoodsum = olgoodsum;
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
	public String getEirid() {
		return eirid;
	}
	public void setEirid(String eirid) {
		this.eirid = eirid;
	}
	
}

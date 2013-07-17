package com.sino.elearning.userstore.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sino.bjcc.tuwenLive.bean.LiveContent;
import com.sino.bjcc.tuwenLive.bean.LivePicture;

/**
 * 存储stroe  
 * 表e_user_store
 * @author fzw
 * @version 
 */
public class EUserStore implements Serializable {

	private Long id;
	private String time;
	private String pubilshurl;
	
	private ESinoProgram sinoProgram;
	private ESysFlowUser sysFlowUser;
	
	public EUserStore() {
		super();
	}
	
	public EUserStore(Long id, ESinoProgram sinoProgram,
			ESysFlowUser sysFlowUser) {
		super();
		this.id = id;
		this.sinoProgram = sinoProgram;
		this.sysFlowUser = sysFlowUser;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ESinoProgram getSinoProgram() {
		return sinoProgram;
	}
	public void setSinoProgram(ESinoProgram sinoProgram) {
		this.sinoProgram = sinoProgram;
	}
	public ESysFlowUser getSysFlowUser() {
		return sysFlowUser;
	}
	public void setSysFlowUser(ESysFlowUser sysFlowUser) {
		this.sysFlowUser = sysFlowUser;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPubilshurl() {
		return pubilshurl;
	}

	public void setPubilshurl(String pubilshurl) {
		this.pubilshurl = pubilshurl;
	}
}

package com.sino.system.constant.bean;

/**
 * 系统常量配置
 * @author Administrator
 *
 */
public class ConstantConfigure implements java.io.Serializable {
//	系统常量配置ID
	private Long conId;
//	系统常量配置 KEY 键
	private String conKey;
//	系统常量配置 VALUE 值
	private String conValue;
//	系统常量配置 功能描述
	private String conExplain;
//	系统常量配置 网络区分 0:互联网 1:政务网
	private String conNetDiff;
	
	public ConstantConfigure() {
		super();
	}

	public ConstantConfigure(Long conId, String conKey, String conValue,
			String conExplain, String conNetDiff) {
		super();
		this.conId = conId;
		this.conKey = conKey;
		this.conValue = conValue;
		this.conExplain = conExplain;
		this.conNetDiff = conNetDiff;
	}

	public Long getConId() {
		return conId;
	}

	public void setConId(Long conId) {
		this.conId = conId;
	}

	public String getConKey() {
		return conKey;
	}

	public void setConKey(String conKey) {
		this.conKey = conKey;
	}

	public String getConValue() {
		return conValue;
	}

	public void setConValue(String conValue) {
		this.conValue = conValue;
	}

	public String getConExplain() {
		return conExplain;
	}

	public void setConExplain(String conExplain) {
		this.conExplain = conExplain;
	}

	public String getConNetDiff() {
		return conNetDiff;
	}

	public void setConNetDiff(String conNetDiff) {
		this.conNetDiff = conNetDiff;
	}
}
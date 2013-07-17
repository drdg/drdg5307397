package com.sino.bjcc.media.bean;

public class ListBoxItem {
	private long id;			//选项ID
	private long conditionId;	//条件列表ID
	private String value;		//显示值
	private String displayIndex;//显示顺序
	private String code;		//CODE

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getConditionId() {
		return conditionId;
	}

	public void setConditionId(long conditionId) {
		this.conditionId = conditionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayIndex() {
		return displayIndex;
	}

	public void setDisplayIndex(String displayIndex) {
		this.displayIndex = displayIndex;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

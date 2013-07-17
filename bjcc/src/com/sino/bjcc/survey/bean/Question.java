package com.sino.bjcc.survey.bean;

import com.sino.bjcc.survey.util.HtmlUtil;

public class Question {
	private long ID = 0;
	private String name = null;
	private long surveyID;
	private long sortID;
	private int type;
	private int required;
	private int hasOther;
	private int columns;
	private String helpText;
	private String options;
	private String subTitles;
	private int index = 0;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSortID() {
		return this.sortID;
	}

	public long getSurveyID() {
		return this.surveyID;
	}

	public int getType() {
		return this.type;
	}

	public String getSubTitles() {
		return this.subTitles;
	}

	public int getRequired() {
		return this.required;
	}

	public String getOptions() {
		return this.options;
	}

	public String getHelpText() {
		return this.helpText;
	}

	public int getHasOther() {
		return this.hasOther;
	}

	public int getColumns() {
		return this.columns;
	}

	public void setSortID(long sortID) {
		this.sortID = sortID;
	}

	public void setSurveyID(long surveyID) {
		this.surveyID = surveyID;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setSubTitles(String subTitles) {
		this.subTitles = subTitles;
	}

	public void setRequired(int required) {
		this.required = required;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public void setHasOther(int hasOther) {
		this.hasOther = hasOther;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getQuestionHtml(){
		return HtmlUtil.getHtmlStr(this.getIndex(), this);
	}

}
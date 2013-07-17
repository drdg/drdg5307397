package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.survey.bean.Question;

public abstract class HtmlDomConvertor {

	public static int TYPE_RADIO = 0;		//单项选择
	public static int TYPE_CHECKBOX = 1;	//多项选择
	public static int TYPE_TEXT = 2;		//单行文本
	public static int TYPE_TEXTAREA = 3;	//多行文本
	public static int TYPE_SELECT = 4;		//下拉选项
	public static int TYPE_ARRAY = 5;		//矩阵单选
	public static int TYPE_ARRAYMULTI = 6;	//矩阵多选
	public static int TYPE_SORT = 7;		//排序题
	
	private HtmlDomConvertor domConvertor = null;

	public HtmlDomConvertor getDomConvertor() {
		return domConvertor;
	}

	public void setDomConvertor(HtmlDomConvertor domConvertor) {
		this.domConvertor = domConvertor;
	}
	
	/**
	 * 方法说明：返回dom对象的html代码
	 */
	public abstract String convertHtml(int index, Question question);
	
	/**
	 * 方法说明：获取dom对象的名称
	 */
	protected String getDomName(int index, boolean isOther){
		StringBuffer domName = new StringBuffer(); 
		domName.append("answerList[");
		domName.append(index);
		domName.append("].");
		if(isOther){
			domName.append("other");
		}else{
			domName.append("answer");
		}
		return domName.toString();
	}
	
}

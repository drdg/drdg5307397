package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.survey.bean.Question;

public class TextConvertor extends HtmlDomConvertor{

	/**
	 * 方法说明：生成文本框格式的html代码
	 */
	public String convertHtml(int index, Question question) {
		if(TYPE_TEXT==question.getType()){
			return "<input type=text class=qtext name=" + getDomName(index, false) + ">";
		}
		if(null!=getDomConvertor()){
			return getDomConvertor().convertHtml(index, question);
		}
		return null;
	}

}

package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.survey.bean.Question;

public class TextAreaConvertor extends HtmlDomConvertor {

	/**
	 * 方法说明：生成文本域格式的html代码
	 */
	public String convertHtml(int index, Question question) {
		if(TYPE_TEXTAREA==question.getType()){
			return "<textarea class=qarea name=" + getDomName(index, false) + "></textarea>";
		}
		if(null!=getDomConvertor()){
			return getDomConvertor().convertHtml(index,question);
		}
		return null;
	}

}

package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.survey.bean.Question;

public class SelectConvertor extends HtmlDomConvertor{

	public String convertHtml(int index, Question question) {
		if(TYPE_SELECT==question.getType()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("<select class=qsel name=").append(getDomName(index, false)).append(">");
			String[] optionArray = StringUtil.split(question.getOptions(), "||");
			buffer.append("<option value=>").append("---请选择---").append("</option>\n");
			for (int i = 0; i < optionArray.length; i++) {
				buffer.append("<option value=").append(i).append(">").append(optionArray[i]).append("</option>\n");
			}
			buffer.append("</select>\n");
			return buffer.toString();
		}
		if (null != getDomConvertor()) {
			return getDomConvertor().convertHtml(index, question);
		}
		return null;
	}

}

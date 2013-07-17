package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.survey.bean.Question;

public class RectSingleConvertor extends HtmlDomConvertor {

	@Override
	public String convertHtml(int index, Question question) {
		if (TYPE_ARRAY == question.getType()) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<table cellpadding=0 cellspacing=0 border=0>\n");
            String[] optionArray = StringUtil.split(question.getOptions(), "||");
            String[] titleArray = StringUtil.split(question.getSubTitles(), "||");
            for (int i = 0; i < titleArray.length; i++) {
                buffer.append("<tr>");
                buffer.append("<td>").append(titleArray[i]).append("</td>");
                for (int j = 0; j < optionArray.length; j++) {
                    buffer.append("<td><input type=radio name=").append(getDomName(index, false)).append(" value=").append(j).append("></td>");
                    buffer.append("<td colspan=2><label>").append(optionArray[j]).append("</label>&nbsp;</td>");
                }
                buffer.append("</tr>");
            }
            buffer.append("</table>\n");
			return buffer.toString();
		}
		if (null != getDomConvertor()) {
			return getDomConvertor().convertHtml(index, question);
		}
		return null;
	}

}

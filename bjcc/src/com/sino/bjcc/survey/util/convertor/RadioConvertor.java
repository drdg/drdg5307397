package com.sino.bjcc.survey.util.convertor;

import com.sino.bjcc.common.utility.StringUtil;
import com.sino.bjcc.survey.bean.Question;

public class RadioConvertor extends HtmlDomConvertor {

	/**
	 * 方法说明：生成radio格式的html代码
	 */
	public String convertHtml(int index, Question question) {
		if (TYPE_RADIO == question.getType()) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<table cellpadding=0 cellspacing=0 border=0>\n");
			String[] optionArray = StringUtil.split(question.getOptions(), "||");
			int columns = question.getColumns();
			for (int i = 0; i < optionArray.length; i++) {
				if (i % columns == 0)
				{
					buffer.append("<tr>");
				}
				buffer.append("<td><input type=radio class=qradio name=").append(getDomName(index, false)).append(" value=").append(i).append(">");
				buffer.append("<label class=qlbl>").append(optionArray[i]).append("</label>&nbsp;</td>\n");
				if (i % columns == columns - 1) {
					buffer.append("</tr>\n");
				}
			}
			if(!buffer.toString().endsWith("</tr>\n")){
				buffer.append("</tr>\n");
			}
			if (question.getHasOther() == 1) {
				buffer.append("<tr>\n");
				int colspan = columns;
				buffer.append("<td colspan=").append(colspan).append("><input type=radio class=qradio name=").append(getDomName(index, false)).append(" value=T").append(">");
				buffer.append("<label class=qlbl>其他，请输入</label><input type=text disabled=disabled maxlength=255 class=qstext name=").append(getDomName(index, true)).append(" size=10></td>\n");
				buffer.append("</tr>\n");
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

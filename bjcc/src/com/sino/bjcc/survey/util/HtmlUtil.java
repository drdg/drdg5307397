package com.sino.bjcc.survey.util;

import com.sino.bjcc.survey.bean.Question;
import com.sino.bjcc.survey.util.convertor.CheckboxConvertor;
import com.sino.bjcc.survey.util.convertor.HtmlDomConvertor;
import com.sino.bjcc.survey.util.convertor.RadioConvertor;
import com.sino.bjcc.survey.util.convertor.RectMutiConvertor;
import com.sino.bjcc.survey.util.convertor.RectSingleConvertor;
import com.sino.bjcc.survey.util.convertor.SelectConvertor;
import com.sino.bjcc.survey.util.convertor.TextAreaConvertor;
import com.sino.bjcc.survey.util.convertor.TextConvertor;

public class HtmlUtil {

	public static String getHtmlStr(int index, Question question){
		HtmlDomConvertor text = new TextConvertor();
		HtmlDomConvertor textArea = new TextAreaConvertor();
		HtmlDomConvertor radio = new RadioConvertor();
		HtmlDomConvertor checkbox = new CheckboxConvertor();
		HtmlDomConvertor select = new SelectConvertor();
		HtmlDomConvertor rectSingle = new RectSingleConvertor();
		HtmlDomConvertor rectMuti = new RectMutiConvertor();
		text.setDomConvertor(textArea);
		textArea.setDomConvertor(select);
		select.setDomConvertor(radio);
		radio.setDomConvertor(checkbox);
		checkbox.setDomConvertor(rectSingle);
		rectSingle.setDomConvertor(rectMuti);
		return text.convertHtml(index, question);
	}
	
}

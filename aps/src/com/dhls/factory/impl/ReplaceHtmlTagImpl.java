package com.dhls.factory.impl;

import com.dhls.factory.RegexGetCode;

public class ReplaceHtmlTagImpl implements RegexGetCode {

	
	/**
	 * °Ñhtml±êÇ©Ìæ»»µ½
	 */
	@Override
	public String getCode(String strLine) {
		// TODO Auto-generated method stub
		
		
		return strLine.replaceAll("<pre>", "startCode")
					  .replaceAll("</pre>", "endCode")
					  .replaceAll("<.+?>|" +
					  		      "<!--|"  +
					  		      "-->|"   +
					  		      "http://www.CodeHighlighter.com/|" +
					  		      "Code highlighting produced by Actipro CodeHighlighter \\(freeware\\)", "")
		              .replaceAll("&quot;", "\"")
		              .replaceAll("&lt;", "<")
		              .replaceAll("&gt;", ">");
	}

}

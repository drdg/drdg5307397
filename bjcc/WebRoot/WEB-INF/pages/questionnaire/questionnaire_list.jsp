<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js" charset="GB2312"></script>
<script language="javascript" type="text/javascript">
function huida(questionnaireId) {
	window.open("${pageContext.request.contextPath }/toNaireQuestionNaireAction.action?questionnaireId="+questionnaireId+"&rand="+Math.random());
	return false;
}

function gengduo() {
	window.open("${pageContext.request.contextPath }/prepareMoreQuestionNaireAction.action");
	return false;
}
</script>
<style type="text/css">
	body{ background-image:none; }
</style>

</head>

<body>


<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1">
				 <tr>
				  <td width="117" height="29" align="left" class="list_left_tit">学习问卷调查</td>
				  <td width="147" align="right" background="${pageContext.request.contextPath }/images/news2_bg.gif">
				  	<a href="#" onclick="return gengduo();" style="margin-right:10px;">更多&nbsp;<img src="${pageContext.request.contextPath }/images/tj_jh (2).png"/></a>  </td>
				 </tr>
				 <tr>
				  <td colspan="2" style="border-top:1px solid #D6D6D6;">
				   <div class="news_list_1" style="height: 280px;">
					<ul>
						<s:iterator value="questionnaireList" var="questionnaire">
							<li><a href="#" onclick="return huida('<s:property value="#questionnaire.questionnaireId"/>');" class="huida">[回答]</a> <a href="#" onclick="return huida('<s:property value="#questionnaire.questionnaireId"/>');"><s:property value="#questionnaire.questionnaireName"/></a></li>
						</s:iterator>
					</ul>
				   </div>
				  </td>
				 </tr>
				</table>
</body>
</html>

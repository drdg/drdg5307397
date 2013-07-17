<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String title = request.getParameter("title");
String startTime = request.getParameter("startTime");
String endTime = request.getParameter("endTime");
String Type = request.getParameter("Type");
if(startTime == null){
	startTime ="";
}
if(endTime == null){
	endTime ="";
}
if(title==null){
	title="";
};
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/date/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
function huida(questionnaireId) {
	window.open("${pageContext.request.contextPath }/toNaireQuestionNaireAction.action?questionnaireId="+questionnaireId+"&rand="+Math.random());
	return false;
}

function gengduo() {
	window.open("${pageContext.request.contextPath }/prepareMoreQuestionNaireAction.action");
	return false;
}
function search(){
 	var title = $("#title").val();
 	$("form:first").attr("action","<%=request.getContextPath()%>/searchQuestionNaireAction.action?title="+title);
	$("form:first").submit();
}
</script>
</head>
<style type="text/css">
	body{ background-image:none; }
</style>
<body>
<form action="${pageContext.request.contextPath }/queryMoreQuestionNaireAction.action">
<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="news">
   	<tr>
		<td align="center" class="news_title">调查问卷</td>
		<td align="right" style="padding-right: 35px;" background="${pageContext.request.contextPath }/images/news2_bg.gif"></td>
	</tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 5px;" >
            	<tr>
                	<td>问卷名称：
                    	<input type="text" name="title" id="title" style=" width:200px;" value="<%=	title%>" onkeydown= "if(event.keyCode==13)search();"/>
                    </td>
                  	<td>&nbsp;时间:
							<input class="Wdate" size="11" id="startTime" name="startTime" value="<%=startTime%>" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
								&nbsp;至&nbsp;
							<input class="Wdate" size="11" id="endTime" name="endTime" value="<%=endTime%>" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
					</td>
					<td>&nbsp;状态
							<select id="Type" name="Type">
								<option value="">请选择</option>
								<option value="0">已答</option>
								<option value="1">未答</option>
							</select>
						</td>
                	<td width="100" align="center" valign="middle">
                		<a id = "search" href="#"><img src="${pageContext.request.contextPath }/images/cx.jpg" border="0" onclick="return search();"/></a>
                	</td>
           		</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1" style=" margin-bottom:8px;">
	<tr>
		<td colspan="2" style="border-top:1px solid #D6D6D6;">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" style="background:#f3f3f3;font-size:14px;height:27px;">
				<tr>
					<th width="75%" style="text-align: left;padding-left: 30px" >名称</th>
					<th width="10%">状态</th>
					<th width="15%">操作</th>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="border-top:1px solid #D6D6D6;">
			<div class="news2_list">
				<ul class="list">
					<s:iterator value="questionnaireList" id="questionnaire">
						<li>
							<span class="NewsTitle"><a href="#" onclick="return huida('<s:property value="#questionnaire.questionnaireId"/>');" class="NewsTitle"><s:property value="#questionnaire.questionnaireName"/></a></span>
							<span class="NewsDate"></span>
							<span class="NewsType"><a href="#">[<s:property value="#questionnaire.testStatus"/>]</a></span>
							<span class="NewsDel"><a href="#" onclick="return huida('<s:property value="#questionnaire.questionnaireId"/>');" style="float:right; margin-left:20px;">[回答]</a></span> 
						</li>
					</s:iterator>
				</ul>
			</div>
		</td>
	</tr>
	<tr>
    	<td height="25" align="center" bgcolor="#FFFFFF">
    		<strong>
       			<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
       		</strong>
       	</td>
	</tr>
</table>
</form>
</body>
</html>
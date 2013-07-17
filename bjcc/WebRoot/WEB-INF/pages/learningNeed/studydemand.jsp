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
<title>用户个人学习需求</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js" charset="GB2312"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript">
	function add(){
	parent.showTipsWindown(600, 474,"${pageContext.request.contextPath }/addNeedsLearning.action");
	return false;
}
function ListAll(){
	window.open("<%=request.getContextPath()%>/jumpLearning.action");
	//window.parent.location.href='<%=request.getContextPath()%>/executeAllLearning.action';
	//$("form:first").attr("action","<%=request.getContextPath()%>/executeAllLearning.action");
	//$("form:first").submit();	
 }
 function datil(id){
	parent.showTipsWindown(600, 474,"${pageContext.request.contextPath }/datilNeedsLearning.action?resourceId="+id);
	return false; 	
 }
 function refre(){
 	$("form:first").attr("action","${pageContext.request.contextPath }/executeLearning.action");
	$("form:first").submit();
 }
</script>
<style type="text/css">
	body{ background-image:none; }
</style>

</head>

<body>

<form action="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1">
				 <tr>
				  <td width="116" height="29" align="left" class="list_left_tit">学习需求</td>
				  <td width="148" align="right" background="${pageContext.request.contextPath }/images/news2_bg.gif">
				  		<a href="#" onclick="return add();" style="margin-right:10px;">添加&nbsp;<img src="${pageContext.request.contextPath }/images/tj_jh (1).png" /></a>
				  		<a href="#" onclick="return ListAll();" style="margin-right:10px;">更多&nbsp;<img src="${pageContext.request.contextPath }/images/tj_jh (2).png"/></a>
				  </td>
				 </tr>
				 <tr>
				  <td colspan="2" style="border-top:1px solid #D6D6D6;">
				   <div class="news_list_1" style="height: 275px;">
					<ul>
						<s:iterator value="resources"  var="resource">
							<li> 
								<SPAN style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 180px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;">
								<a href="#" onclick="return datil(<s:property value="#resource.resourceId"/>);"><s:property value="#resource.title"/></a>
								</SPAN>
								<a href="#" onclick="return datil(<s:property value="#resource.resourceId"/>);" style="float:right;">
									 <s:if test="%{#resource.states==1}">
										已审核
									 </s:if>
									 <s:if test="%{#resource.states==0}">
										未审核
									 </s:if>
								</a>
							</li>
						</s:iterator>
					</ul>
				   </div>
				  </td>
				 </tr>
				</table>
	</form>
</body>
</html>

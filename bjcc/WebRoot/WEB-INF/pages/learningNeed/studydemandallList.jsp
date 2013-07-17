<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>需求列表</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/jquery-webox.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-webox.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.blockUI.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/date/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript">
function add(){
	parent.showTipsWindown(600, 474,"${pageContext.request.contextPath }/addNeedsLearning.action");
}
 function del(id){
	$("form:first").attr("action","<%=request.getContextPath()%>/delOneNeedsLearning.action?resourceId="+id);
	$("form:first").submit();
 }
 function search(){
 	var title = $("#title").val();
 	$("form:first").attr("action","<%=request.getContextPath()%>/searchLearning.action?title="+title);
	$("form:first").submit();
 }
  function datil(id){
  parent.showTipsWindown(600, 474,"${pageContext.request.contextPath }/datilNeedsLearning.action?resourceId="+id); 	
 }
  function refre(){
 	$("form:first").attr("action","${pageContext.request.contextPath }/executeAllLearning.action");
	$("form:first").submit();
 }
</script>
</head>
<style>
body{ background-image:none; }
</style>
<body>
<form action="">
<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="news">
   	<tr>
		<td align="center" class="news_title">学习需求</td>
		<td align="right" style="padding-right: 15px;" background="${pageContext.request.contextPath }/images/news2_bg.gif">
			<a href="#" onclick="add();" style="text-decoration: none" >添加需求</a> 
	   </td>
	</tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 5px;" >
            	<tr>
                	<td>名称：
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
								<option value="0">已审核</option>
								<option value="1">未审核</option>
							</select>
						</td>
                	<td width="100" align="center" valign="middle">
                		<a id = "search" href="#"><img src="${pageContext.request.contextPath }/images/cx.jpg" border="0" onclick="return search();"/></a>
                	</td>
           		</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1" style=" margin-bottom:8px;">
	<tr>
		<td colspan="2" >
			<table width="100%" border="0" cellpadding="0" cellspacing="0" style="background:#f3f3f3;font-size:14px;height:27px;">
				<tr>
					<th width="50%" style="text-align: left;padding-left: 30px" >名称</th>
					<th width="25">发布时间</th>
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
					<s:iterator value="resources" var="resource">
         				<li>
         					<span class="NewsTitle"><a href="#" onclick="return datil(<s:property value="#resource.resourceId"/>);" style="text-decoration: none"><s:property value="#resource.title"/></a></span>
         					<span class='NewsDate'><s:property value="#resource.creatTime"/></span>
         					<span class="NewsType"><a href="#">[
								<s:if test="%{#resource.states==1}">
									已审核
				 				</s:if>
				 				<s:if test="%{#resource.states==0}">
									未审核
				 				</s:if>
							]</a></span>
							<span class="NewsDel"><a href="#" style="float:right; margin-left:20px; text-decoration: none;" onClick="return del(<s:property value="#resource.resourceId"/>);">[删除]</a></span>
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
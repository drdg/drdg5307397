<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>
   <title>±¨´íÒ³Ãæ</title>
<style type="text/css">
	*{
		margin:0px;
	}

	.mainDiv{
		width:700px;
		height:400px; 
		background-color:#CCCCCC;
		margin:0 auto;
		margin-top:100px;
	}

</style>

</head>

<body>
<div class="mainDiv">
	<div style="font-size:300px;">404</div>
	<div style="float:right;font-size:36px;margin-top:-20px;">I think you know!<hr/>
	<a href="<%=basePath %>login.jsp" style="font-size:12px;position:absolute;margin-top:10px;" target="_parent">·µ»ØµÇÂ¼</a>
	</div>
</div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<link type="text/css"
			href="${pageContext.request.contextPath }/css/study.css"
			rel="stylesheet" />
		<link type="text/css"
			href="${pageContext.request.contextPath }/css/style2.css"
			rel="stylesheet" />
<style type="text/css">
body {
	background-color: white;
	background-image: none;
	margin-top: 0px;
	text-align: center;
	font-size: 12px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}
</style>
	</head>
	<body>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="15%" align="center" class="xxjh_data"> 
					<a href="#" onclick="return parent.xuanke();"><img src="${pageContext.request.contextPath }/images/xg_btt.png" style="margin:0 10px 0 10px;" /></a><a href="#"><img src="${pageContext.request.contextPath }/images/xk_b.gif" /></a>
					</td>
					<td width="65%" align="center" valign="middle" class="xxjh_data">
						<a href="#" class="jh_date" onclick="return parent.prevmon();">&lt;&lt;</a>
							<span id="year"></span>年<span id="mon"></span>月
						<a href="#" class="jh_date" onclick="return parent.nextmon();">&gt;&gt;</a>
					</td>
					<td width="20%"class="tit_dqwz"></td>
				</tr>
			</table>
	</body>
</html>
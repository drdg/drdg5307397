<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<title>权限表</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/authority/css/au_add.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/authority/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/authority/js/au_add.js"></script>
</head>

<body>

	<div class="mainDiv">
	<form action="<%=basePath %>Corporation?type=13&key=1&pageNow=1" method="post">
		<table border="1">
			<tr><th colspan="2"><font color="#FF0000">权限注册</font></th></tr>
			<tr>
				<td width="70px;">权限编号</td>
				<td><input type="text" id="auno" name="auno" maxlength="8"/></td>
			</tr>
			<tr>
				<td>权限描述</td>
				<td><input type="text" id="audesc" name="audesc" maxlength="10"/></td>
			</tr>
			<tr>
				<td colspan="2" style="border:0px;">
				<input type="submit" value="" id="ausub" onclick="return pdsub()"/></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>

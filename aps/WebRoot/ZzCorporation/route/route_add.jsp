<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
<title>增加车辆</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/route/css/route_add.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/route/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/route/js/router_add.js"></script>
</head>

<body>
	<div class="mainDivadd">
		<form action="<%=basePath %>Corporation?type=2&key=1" method="post">
		<table border="1">
			<tr>
				<td colspan="2" align="center">增加路线</td>
			</tr>
			<tr>
				<td width="90px;">路线名称</td>
				<td><input type="text" id="rtname" name="rtname" maxlength="10"/></td>
			</tr>
			<tr>
				<td>路线始发点</td>
				<td><input type="text" id="rtspoint" name="rtspoint" maxlength="15"/></td>
			</tr>
			<tr>
				<td>首公斤重量</td>
				<td><input type="text" id="rpefpkg" name="rtpefpkg" maxlength="10"/>公斤</td>
			</tr>
			<tr>
				<td>次公斤重量</td>
				<td><input type="text" id="rpeopkg" name="rtpeopkg" maxlength="10"/>公斤</td>
			</tr>
			<tr>
				<td>首体积大小</td>
				<td><input type="text" id="repefpvo" name="rtpefpvo" maxlength="10"/>立方米</td>
			</tr>
			<tr>
				<td>次体积大小</td>
				<td><input type="text" id="repovo" name="rtpeopvo" maxlength="10"/>立方米</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="" id="sub" onclick="return pdsub()"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>

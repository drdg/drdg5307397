<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>爱配送后台登录页面</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/login/css/login.css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/login/js/jquery-1.4.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/login/js/login.js"></script>
</head>
<body>
	<div class="mainDiv">
		<div class="leftDiv">
			<ul>
				<li style="font-size:150px;color:#FF0000;font-family:'华文行楷';">爱</li>
				<li>配</li>
				<li>送</li>
				<li>系</li>
				<li>统</li>
				<li>登</li>
				<li>录</li>
			</ul>
		</div>
		
		<div class="rightDiv">
		
		<form action="#" method="post" target="_parent">
			<table>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="vname" id="cname" maxlength="10" style="background:transparent;border:1px #00FF00 dashed;color:#FFFF00;width:150px;"/></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;码</td>
					<td><input type="password" name="vid" maxlength="15" id="cpwd" style="background:transparent;border:1px #00FF00 dashed;color:#FFFF00;width:150px;"/></td>
				</tr>
				<tr>
					<td>登录项</td>
					<td>
						<label><input type="radio" name="cr" value="../../Corporation?type=0" checked="checked" />总公司</label>
						<label><input type="radio" name="cr" value="../../Corporation?type=0"/>分公司</label>
					</td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="登录" id="sub" onclick="return doLogin()" style="background:transparent;background-color:#000000;color:#FF0000;border:1px #FF0000 solid;width:50px;height:25px;"/>
						<input type="reset" value="重置" style="background:transparent;background-color:#000000;color:#FF0000;border:1px #FF0000 solid;width:50px;height:25px;"/>
					</td>
				</tr>
			<tr>
			<td colspan="2" align="left">
			<span id="getPwd" style="cursor: pointer;font-size: 12px;color: gray;">把密码发到我邮箱</span></td></tr>
			</table>
				
				
			</form>
		
		</div>
	</div>
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>go to login page</title>
		<script type="text/javascript">
			//跳转到登录页面
			window.onload = function() {
				var flag = '<s:property value="errorCode"/>';
				if('1'==flag){
					alert("对不起，当前直播频道在线用户已达上限，请稍后再试！");
				}
				document.getElementById("login").click();
			}
		</script>
	</head>
	<body>
		<a href="<s:property value="loginUrl"/>" target="_top" id="login" style="display: none;"></a>
	</body>
</html>
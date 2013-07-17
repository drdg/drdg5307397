 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>play...</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ssoLogin.js"></script>
	<script language="javascript" type="text/javascript">
		$(function(){
			var flag = '<s:property value="needLogin"/>';
			if('1'==flag){
				ssoLogin(function(){submitForm();});
			}else{
				submitForm();
			}
		});	
		//提交表单
		function submitForm(){
			var url = window.location.href;
			url=url.replace('goto','to');
			$("#subForm").attr("action", url);
			$("#subForm").submit();
		}
	</script>
  </head>
  	<form id="subForm" method="post">
  		<input name="toUrl" type="hidden" value="<%=request.getHeader("REFERER") %>"/>
  	</form>
  <body>
  </body>
</html>

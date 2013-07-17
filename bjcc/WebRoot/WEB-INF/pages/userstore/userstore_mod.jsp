<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userstore_mod.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head> 
  
  <body>
    <form action="${pageContext.request.contextPath }/modifyUserStoreAction.action" method="post">
    	<table border="1">
    		<tr>
    			<td>ID</td>
    			<td><input type="text" name="userStore.id" disabled="disabled" value="<s:property value="userStore.id"/>"/></td>
    			<td>USER_ID</td>
    			<td><input type="text" name="userStore.programId" value="<s:property value="userStore.programId"/>"/></td>
    			<td>PROGRAM_ID</td>
    			<td><input type="text" name="userStore.userId" value="<s:property value="userStore.userId"/>"/></td>
    			<td colspan="2">
    				<input type="submit" value="±£´æ¸ü¸Ä">
    			</td>
    		</tr>
    	</table>
    </form>
    
    <s:debug></s:debug>
  </body>
</html>

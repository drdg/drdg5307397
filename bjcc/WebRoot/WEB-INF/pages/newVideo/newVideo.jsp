<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>推荐视频</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
	<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%int i = 0; %>
  
  <s:iterator var="month" value="videoList">
    <%if(i<2){ %>
     <% if(i==0){ 
         out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr>");  
        }
     %>
	  <td height="88" align="center"><a href='http://192.168.6.31/bjzcw/wskt/kjdb/<s:property value="#month[4]"/><s:property value="#month[0]"/>.html' target="_blank" title="<s:property value="#month[2]"/>"><img src='http://web1.bjcc.gov.cn/<s:property value="#month[1]"/>' width="100" height="70" /></a></td>
	 <% if(i==1){ 
         out.println("</tr></table><div class='news_list1'><ul>");  
        }
     %>
	<%}else {%>
      <li class="list-177"><a href='http://192.168.6.31/bjzcw/wskt/kjdb/<s:property value="#month[4]"/><s:property value="#month[0]"/>.html' target="_blank" title="<s:property value="#month[2]"/>"><s:property value="#month[2]"/></a></li>
    <%} %>
     <% i++; %>
</s:iterator>
  <% out.println("</ul></div>");%>
  </body>
</html>

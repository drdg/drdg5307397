<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'writeBehavior.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
	
  </head>
  <script type="text/javascript">
  
		  var articleID = getQueryString("articleID");
		  var articleName = getQueryString("articleName");
		  var channelID = getQueryString("channelID");
		  var channelName = getQueryString("channelName");
		  var type = getQueryString("type");
		  
  		function getQueryString(name) {    
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");    
				var r = window.location.search.substr(1).match(reg);    
				if (r != null) {
					return unescape(r[2]);
				} 
				return null;   
		 }

  </script>
  <script type="text/javascript" src="/bjcc/js/onunload.js"></script>
  <body>
  </body>
  
</html>
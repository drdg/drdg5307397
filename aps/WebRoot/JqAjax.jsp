<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title>¶¯Ì¬Êý¾Ý</title>
<script type="text/javascript" src="<%=basePath %>ZzCorporation/capacity/js/jquery-1.4.2.js"></script>
<script type="text/javascript">

	$(function(){

		getStock();
		    
	});

	function getStock(){

		var time = new Date();
		var url = "http://localhost:8088/aps/asynchronous?"+time.getTime();
		 $.get(url,null,function(date){
			 	$("#ajaxHtml").empty();
				$("#ajaxHtml").append(date);
         })

         setInterval("getStock()",60000);
	}

	

</script>
  </head>
  
  <body style="background-color: maroon;">
    <div id="ajaxHtml" style="float: left;color: white;width: 100%;margin-top: 10px;">
    
    </div>
  </body>
</html>

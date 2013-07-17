<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sino.bjcc.common.bean.UserInfo"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserInfo user = (UserInfo)request.getSession().getAttribute("loginUserInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style_dxx.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个性化学习_收件箱</title>
<script type="text/javascript">
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
 var url = "";
 if(n==0){
 	url = '${pageContext.request.contextPath }/receiveForward.action';
 	tli[0].className="hover";
 	tli[1].className="";
 	tli[2].className="";
 }else if(n==1){
 	url = '${pageContext.request.contextPath }/sendForward.action';
 	tli[1].className="hover";
 	tli[0].className="";
 	tli[2].className="";
 }else if(n==2){
 	url = '${pageContext.request.contextPath }/writeForward.action';
 	tli[2].className="hover";
 	tli[0].className="";
 	tli[1].className="";
 }
 document.location.href = url;
<%-- $.ajax({--%>
<%--   		url:url,--%>
<%--     	type:"post",--%>
<%--     	dataType:"html",--%>
<%--     	success:function(data){--%>
<%--   			$("#main1").html(data);--%>
<%--   		},--%>
<%--   		error:function(){--%>
<%--        	alert("请求失败");--%>
<%--     	}--%>
<%--	});--%>
 }
 $(function(){
 setTab(1,0);
 });

function closewin() {
			parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
		}

</script>
<style>
body{ background-image:none; }
</style>
</head>
<body>
<div class="dxxk">
<div class="dxxkl">

	<div class="dxxqh"  id="menu1">
					<ul>
						<li><a href="#" class="hover" onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#"  onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#"  onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
					
	</div>
	<div class="dxxsjx" id="main1">
	</div>

</div>

</div>

</body>
</html>

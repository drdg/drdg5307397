<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>用户个人学习需求</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/jquery-webox.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/program.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-webox.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.blockUI.js"></script>

<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript">
/*
*弹出本页指定ID的内容于窗口
*id 指定的元素的id
*title:	window弹出窗的标题
*width:	窗口的宽,height:窗口的高
*/
//弹出层调用
function loadperson() {
	$.ajax({
   		url:addUrlRandomParam("${pageContext.request.contextPath }/excusePersonal.action"),
   		async:false,
     	type:"post",
     	dataType:"html",
     	success:function(data){
   			$("#personmsg").html(data);
   		},
   		error:function(){
        	alert("请求失败");
     	}
	});
}
$(function(){
loadperson();
});
function showTipsWindown(width,height,url){
	
	$.webox({
		height:height,
		width:width,
		bgvisibel:true,
		title:'iframe弹出层调用',
		iframe:addUrlRandomParam(url)
	});
	
}
function closeiframe(){
	$('.webox').css({display:'none'});
	$('.background').css({display:'none'});
}
</script>
</head>

<style>
body{ background-image:none; }
</style>

<body>
<form action="<%=request.getContextPath()%>/executeAllLearning.action" method="post" name="xuqiu" id="xuqiu">
<div class="contant">
	<!--head--> 
	<div style="margin:auto; overflow:hidden;">
		<iframe src="<%=Constant.HEAD_URL %>" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
		</div>
  
  <!--head--> 
	<!--ct1--> 
		 <div class="study_tt">
			<div class="two_title_2">个 人 空 间</div>
		 </div>	
		 
	 <div class="study_ct">
			 <div class="study_ct_left"> 
				<div id="personmsg" style="z-index:-1;">
				</div>
				</div>
	<div class="study_ct_right">
		<div class="xxjh">
				<iframe id="xuqiu" name="xuqiu" src="${pageContext.request.contextPath }/executeAllLearning.action" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="470" border="0"> </iframe>
		</div>
	</div>

	
	<!--ct1--> 
</div>

<map name="Map" id="Map"><area shape="rect" coords="606,12,704,39" href="#" /></map>
</div>
<iframe src="<%=Constant.BOTTOM_URL %>" width="100%" height="100%" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
</form>
</body>
</html>

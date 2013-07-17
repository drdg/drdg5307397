<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/jquery-webox.css" rel="stylesheet" />

<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-webox.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.blockUI.js"></script>
<script language="javascript" type="text/javascript">
//window.onbeforeunload = function (event) { 
   // if ((window.event.screenX - window.screenLeft) > (document.documentElement.scrollWidth - 20) && window.event.clientY < 0 || window.event.altKey) { 
    //	 alert("退出");
    //    event = event || window.event; 
   //     event.returnValue = "是否退出?"; 
  //  }else{
  //      alert("刷新");
   // }
//}

$(function(){
	//查找子iframe的元素
	//$('#zhuanti').contents().find('#isread-text').click();
	//调用子iframe的js
	//window.frames["zhuanti"].popTips();
});
function showTipsWindown(width,height,url){
	$.webox({
		height:height,
		width:width,
		bgvisibel:true,
		title:'iframe弹出层调用',
		iframe:addUrlRandomParam(url)
	});
	
	/**
	$.webox({
		height:280,
		width:600,
		bgvisibel:true,
		title:'内嵌弹出层调用',
		html:"aaaaaaaaa"
	});  

	$.ajax({
   		url:addUrlRandomParam(url),
   		async:false,
   		data:data,
     	type:"post",
     	dataType:"html",
     	success:function(data){
   			$("#"+id).html(data);
   			$.webox({
   				height:height,
   				width:width,
   				bgvisibel:true,
   				html:data
   			});
   		},
   		error:function(){
        	alert("请求失败");
     	}
	});
	tipsWindown(title,"id:"+id,width,height,"true","","true",id);
	*/
}

function closeiframe(){
	$('.webox').css({display:'none'});
	$('.background').css({display:'none'});
}

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
</script>
<style>
body{ background-image:none; }
</style>
</head>

<body>
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
			 	
				
				<div id="personmsg" style="z-index:-1; height:265px; margin-bottom:8px;"  class="news1">
				</div>
				<div style=" z-index:-1;">
				<iframe id="xuqiu" name="xuqiu" src="${pageContext.request.contextPath }/executeLearning.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="338" border="0"> </iframe>
				</div>
				
				<div style="z-index:-1;">
				<iframe src="${pageContext.request.contextPath }/prepareMainQuestionNaireAction.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="346" border="0"> </iframe>
				</div>
                <div style="z-index:-1;">
                  <iframe src="${pageContext.request.contextPath }/elearning/leftpicture.jsp" name="leftframe" frameborder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe2" width="100%" height="173" border="0"> </iframe>
                </div>
				
			 </div>
			 
			 <div class="study_ct_right">
			 	<div class="xxjh">
						 <iframe src="${pageContext.request.contextPath }/elearning/studyresource.jsp" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="213" border="0"> </iframe>
				</div>
				<div class="xxjh" style="margin-top:8px;">
				  <iframe src="${pageContext.request.contextPath }/elearning/studycourse.jsp" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="305" border="0"> </iframe>
				</div>
				<div class="xxjh" style="margin-top:8px;">
				<iframe name="xxjl" id="xxjl" src="${pageContext.request.contextPath }/elearning/studyrecord.jsp"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="417" border="0"> </iframe>
				</div>
				<div class="xxjh" style="margin-top:8px;">
				<iframe id = "zhuanti"  src="${pageContext.request.contextPath}/prepareUserChannelAction"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="185" border="0"> </iframe>
				</div>
			 </div>
		 </div>
	<!--ct1--> 
	</div>
	<iframe src="<%=Constant.BOTTOM_URL %>" width="100%" height="100%" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</script>
<style>
body{ background-image:none; }
</style>
</head>

<body>
	<div class="contant">
	
		<!--head--> 
		<div style="margin:auto; overflow:hidden;">
		<iframe src="${pageContext.request.contextPath }/elearning/head_login.jsp" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
		</div>
		
		<!--head--> 
		
	<!--ct1--> 
	
		 <div class="study_tt">
			<div class="two_title_2">个 人 空 间</div>
		 </div>	
		 
		 <div class="study_ct">
			 <div class="study_ct_left">
			 	
				
				<div style="z-index:-1;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1" style=" margin-bottom:8px;">
					 <tr>
					  <td width="101" height="29" align="center" class="right_tit">用户登录</td>
					  <td width="126" align="right" background="${pageContext.request.contextPath }/images/news2_bg.gif">&nbsp;</td>
					 </tr>
					 <tr>
					   <td colspan="2" style="border-top:1px solid #D6D6D6;">
						   <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size:14px;">
							 <tr>
							   <td width="45%" rowspan="4" align="center" valign="middle"><img class="img_kuang" src="${pageContext.request.contextPath }/images/img_tx.gif" width="88" height="99" /></td>
							   <td height="28" align="left" valign="middle" class="hyn_td"><img src="${pageContext.request.contextPath }/images/jf_sun.gif" width="18" height="18" /> 欢迎您</td>
							 </tr>
							 <tr>
							   <td height="28" align="left" valign="middle"><a href="#">test_124</a></td>
							 </tr>
							 <tr>
							   <td height="28" align="left" valign="middle"><img src="${pageContext.request.contextPath }/images/dian03.gif" width="12" height="12" /> 短消息 <span  class="pinglunshu_r">124</span></td>
							 </tr>
							 <tr>
							   <td height="28" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/study_zlxg.gif" width="92" height="22" border="0" /></a></td>
							 </tr>
							 <tr>
							   <td colspan="2" align="center" valign="middle" style=" background-image:url(${pageContext.request.contextPath }/images/hengxian.gif); background-repeat:repeat-x;">&nbsp;</td>
						     </tr>
							 <tr>
							   <td  height="30" colspan="2" align="left" valign="bottom" >
							   <a href="#" onmouseover="zttc('aa', 'show');" onmouseout="zttc('aa', 'hide');">
							   <img src="${pageContext.request.contextPath }/images/cgzx_bt.gif" width="229" height="29" border="0" />
							   </a>
							    <div style="position:relative; ">
								<div class="ycc" id="aa" onmouseover="zttc('aa', 'show');" onmouseout="zttc('aa', 'hide');">
								
									<ul>
									
										<li>主题数：19300</li>
										<li>回帖数：355634</li>
										<li>置顶数：4910</li>
										<li>有图主题数：19300</li>
										<li>精华数：4300</li>
									</ul>
								
								</div>
								</div>
							   </td>
							   
						     </tr>
							 <tr>
							   <td  height="30" colspan="2" align="left" valign="bottom" >
							   <a href="#" onmouseover="zttc('aa1', 'show');" onmouseout="zttc('aa1', 'hide');">
							   <img src="${pageContext.request.contextPath }/images/hsgw_bt.gif" width="229" height="29" border="0" /></a>
							   <div style="position:relative; ">
								<div class="ycc" id="aa1" onmouseover="zttc('aa1', 'show');" onmouseout="zttc('aa1', 'hide');">
								
									<ul>
									
										<li>主题数：66666</li>
										<li>回帖数：7777</li>
										<li>置顶数：88</li>
										<li>有图主题数：19300</li>
										<li>精华数：4300</li>
									</ul>
								
								</div>
								</div>
							   </td>
						     </tr>
							 <tr>
							   <td  height="30" colspan="2" align="left" valign="bottom"  >
							   <a href="#" onmouseover="zttc('aa2', 'show');" onmouseout="zttc('aa2', 'hide');">
							   <img src="${pageContext.request.contextPath }/images/sxsb_bt.gif" width="229" height="29" border="0" /></a>
							   <div style="position:relative; ">
								<div class="ycc" id="aa2" onmouseover="zttc('aa2', 'show');" onmouseout="zttc('aa2', 'hide');">
								
									<ul>
									
										<li>主题数：1111</li>
										<li>回帖数：2222</li>
										<li>置顶数：333</li>
										<li>有图主题数：19300</li>
										<li>精华数：4300</li>
									</ul>
								
								</div>
								</div>
							   </td>
						     </tr>
					     </table>
					   </td>
					 </tr>
				</table>
				</div>
				
				<div style=" z-index:-1;">
				<iframe id="xuqiu" name="xuqiu" src="${pageContext.request.contextPath }/executeLearning.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="310" border="0"> </iframe>
				</div>
				
				<div style="z-index:-1;">
				<iframe src="${pageContext.request.contextPath }/elearning/questionnaire.jsp" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="310" border="0"> </iframe>
				</div>
				
			 </div>
			 
			 <div class="study_ct_right">
			 	<div class="xxjh">
					
						 <iframe src="${pageContext.request.contextPath }/elearning/studyplans.jsp"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="270" border="0"> </iframe>
						
				</div>
				
				
				<div class="xxjh" style="margin-top:8px;">
				
				  <iframe src="${pageContext.request.contextPath }/recordBehavior.action"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="266" border="0"> </iframe>
				
				</div>
			
				
				<div class="xxjh" style="margin-top:8px;">
				
				<iframe src="${pageContext.request.contextPath }/elearning/resource.jsp"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="166" border="0"> </iframe>
				
				</div>
				
				
				<div class="xxjh" style="margin-top:8px;">
				
				<iframe id = "zhuanti"  src="${pageContext.request.contextPath }/elearning/specialstudy.jsp"	name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="150" border="0"> </iframe>
				</div>
				
			 
			 </div>
		 </div>
		 
	<!--ct1--> 
	
	</div>
	
	<div class="copyright">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height:24px;">
		  <tr>
			<td height="26" align="center" valign="middle" background="${pageContext.request.contextPath }/images/bottom_bg.gif" style="color:#fff;"><a href="#" class="nav_word">关于我们</a> | <a href="#" class="nav_word">网站地图</a> | <a href="#" class="nav_word">设为首页</a> | <a href="#" class="nav_word">加入收藏</a> | <a href="#" class="nav_word">联系我们</a> | <a href="#" class="nav_word">免责声明</a></td>
		  </tr>
		  <tr>
			<td height="120" align="center" valign="middle">主办：北京市农村党员干部现代远程教育工作领导协调小组办公室<br />
			  技术支持：北京市农林科学院农业科技信息研究所<br />
			  北京长城网：<a href="../lxwm/20100726/16702.html" target="_blank">http://www.bjcc.gov.cn</a><br />
		    备案/许可证编号为：京ICP备09056845号</td>
		  </tr>
	  </table>
	</div>
</body>
</html>

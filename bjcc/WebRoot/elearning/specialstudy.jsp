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
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/tipswindown.js"></script>
<script language="javascript" type="text/javascript">
/*
*弹出本页指定ID的内容于窗口
*id 指定的元素的id
*title:	window弹出窗的标题
*width:	窗口的宽,height:窗口的高
*/
//弹出层调用
function popTips(){
	parent.showTipsWindown(600, 493,"${pageContext.request.contextPath }/elearning/special_add.jsp");
}

$(document).ready(function(){
	$("#isread-text").click(popTips);
});
</script>
</head>

<style>
body{ background-image:none; }
</style>

<body>

				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news"  style=" background-image:url(${pageContext.request.contextPath }/images/news2_bg.gif); background-repeat:repeat-x;">
					   <tr>
						<td width="112" align="center" class="news_title"> 专题学习</td>
						<td width="517" align="center" valign="middle" class="xxjh_data">&nbsp;</td>
					    <td width="94" align="center" valign="middle" class="tit_dqwz">
						<a href="#"><img src="${pageContext.request.contextPath }/images/tjzt_bt.gif" width="81" height="17" border="0" id="isread-text" /></a> 
						</td>
				       </tr>
				  </table>
				  
				  <div class="ztxx_ct" >
				   	<ul>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理学者谏言社会管理学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
						<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" /> <a href="#">学者谏言社会管理：构建小政府大建设社会制度</a></li>
					</ul>
				  
				  </div>
</body>
</html>

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
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js" charset="GB2312"></script>
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
	parent.showTipsWindown(600, 540,"${pageContext.request.contextPath }/elearning/demand_add.jsp");
}
</script>
</head>

<style>

body{ background-image:none; }
</style>

<body>


<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1" style=" margin-bottom:8px;">
				 <tr>
				  <td width="116" height="29" align="left" class="list_left_tit">个人学习需求</td>
				  <td width="148" align="right" background="${pageContext.request.contextPath }/images/news2_bg.gif">
				  <a href="#" onclick="popTips();">添加</a> 
				  <a href="#">删除</a>  
				  </td>
				 </tr>
				 
				 <tr>
				  <td colspan="2" style="border-top:1px solid #D6D6D6;">
				   <div class="news_list_1">
					<ul>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					 <li><a href="#">大学生村干部在创大学生村干部在创先争优大学生村干部在创先争优先争优</a></li>
					</ul>
				   </div>
				  </td>
				 </tr>
				 
</table>
</body>
</html>

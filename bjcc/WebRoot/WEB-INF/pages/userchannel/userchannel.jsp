<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	parent.showTipsWindown(600, 493,"${pageContext.request.contextPath }/prepareModUserChannelAction.action");
	return false;
}

function refreshpage() {
	$("#form1").submit();
	return false;
}

$(document).ready(function(){
	$("#isread-text").click(popTips);
	return false;
});
</script>
</head>

<style >
body{ background-image:none;}
</style>

<body>
<form id = "form1" action="${pageContext.request.contextPath }/prepareUserChannelAction" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
					   <tr>
						<td width="112" align="center" class="news_title"> 专题学习</td>
						<td width="170" align="left" valign="middle" class="xxjh_data"><a href="#"><img src="${pageContext.request.contextPath }/images/tjzt_bt.png" id="isread-text""/></a></td>
					    <td width="420" align="center" valin="middle" class="tit_dqwz">
							<div class="gxh_tab" id="menu5" style="width:430px;" >
							<ul>
								<li><a href="#" class="hover"  onmousemove="setTab(5,0)">时政要闻</a></li>
								<li><a href="#" onmousemove="setTab(5,1)">农村党建</a></li>
                                <li><a href="#" onmousemove="setTab(5,2)">时政要闻</a></li>
                                <li><a href="#" onmousemove="setTab(5,3)">农村党建</a></li>
                                <li><a href="#" onmousemove="setTab(5,4)">时政要闻</a></li>
							</ul>
							</div>
						</td>
				       </tr>
				  </table>
             <div class="zyxc_qh" id="main5">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" >
   			 <tr>
     			<td>
				  <div class="ztxx_ct" >
				   	<ul>
				   		<s:iterator value="articles" id="article"> 
							<li><img src="${pageContext.request.contextPath }/images/li_dian.gif" />&nbsp;&nbsp;<a href="<s:property value="#article.publishurl"/>" target="_blank"><s:property value="#article.name"/>  </a></li>
						</s:iterator>
					</ul>
				  </div>
                 <div class="zytj_more"><a href="#">更多&nbsp;<img src="${pageContext.request.contextPath }/images/gs_xb.gif" /></a></div>
                  </td>
   				 </tr>
 			 </table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="display: none;">
				<tr>
					<td>
						暂无内容
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="display: none;">
				<tr>
					<td>
						暂无内111容
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="display: none;">
				<tr>
					<td>
						暂无内容
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				style="display: none;">
				<tr>
					<td>
						暂无内111容
					</td>
				</tr>
			</table>

		</div>			
</form>
</body>
</html>

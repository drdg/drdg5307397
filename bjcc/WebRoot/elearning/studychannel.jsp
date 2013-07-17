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
</head>

<style>

body{ background-image:none; }
</style>

<body>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
					   <tr>
						<td width="112" align="center" class="news_title"> 专题学习</td>
						<td width="170" align="left" valign="middle" class="xxjh_data"><a href="#"><img src="${pageContext.request.contextPath }/images/tjzt_bt.png" /></a></td>
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
             <table width="100%" border="0" cellspacing="0" cellpadding="0" style="display: none;">
			<iframe id = "zhuanti"  src="${pageContext.request.contextPath}/prepareUserChannelAction"	name="leftframe" frameBorder="0"scrolling="no" marginwidth="0"marginheight="0" 
					id="leftframe" width="100%" height="100%" border="0"> </iframe>
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

</body>
</html>

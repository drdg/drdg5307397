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
						<td width="112" align="center" class="news_title"> 资源推荐</td>
						<td width="327" align="center" valign="middle" class="xxjh_data">&nbsp;</td>
					    <td width="284" align="center" valign="middle" class="tit_dqwz">
							<div class="zytj_tab" id="menu2">
							<ul>
								<li><a href="#" class="hover"  onmousemove="setTab(2,0)">猜你喜欢</a></li>
								<li><a href="#" onmousemove="setTab(2,1)">大家都看</a></li>
								<li><a href="#" onmousemove="setTab(2,2)">热点推荐</a></li>
							</ul>
							</div>
						</td>
				       </tr>
				  </table>
				  
				  <div class="zytj_ct" id="main2">
				    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td>
						<div class="zytj_img">
							<ul>
							  <li><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a><br /><a href="#">社区情缘</a></li>
							  <li><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a><br /><a href="#">用平凡唱响生命之歌</a></li>
							  <li><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a><br /><a href="#">社区情缘</a></li>
							  <li><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a><br /><a href="#">wowow</a></li>
							  <li><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a><br /><a href="#">用平凡唱响生命之歌用平凡唱响生命之歌用平凡唱响生命之歌用平凡唱响生命之歌</a></li>
							</ul>
						</div>
						</td>
                      </tr>
                    </table>
				    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none;">
					  <tr>
						<td>暂无内容</td>
					  </tr>
					</table>
					
					
					 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none;">
					  <tr>
						<td>暂无内111容</td>
					  </tr>
					</table>
					
					
					
				  
				  
				  </div>

</body>
</html>

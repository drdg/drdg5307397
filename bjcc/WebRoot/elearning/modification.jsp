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

<body>
<div class="contant">
  <!--head-->
  <div style="margin:auto; overflow:hidden;">
    <iframe src="${pageContext.request.contextPath }/elearning/head.jsp" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
  </div>
  <!--head-->
  <!--ct1-->
  <div class="study_tt">
    <div class="two_title_2">个人资料修改</div>
  </div>
  <div class="zlxg_ct">
  
  	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style=" margin-top:10px;">
	  <tr>
		<td width="15%" align="left" valign="top">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
          <tr>
            <td width="15%" align="center" valign="middle"><img class="img_kuang" src="${pageContext.request.contextPath }/images/img_tx.gif" width="88" height="99" /></td>
          </tr>
          <tr>
            <td width="15%" height="30" align="center" valign="middle"><a href="#" class="ghtx_tt">更换头像</a></td>
          </tr>
        </table></td>
		<td width="85%" align="left" valign="top">&nbsp;</td>
	  </tr>
	</table>

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

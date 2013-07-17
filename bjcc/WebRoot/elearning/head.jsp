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
<link type="text/css" href="${pageContext.request.contextPath }/css/head.css" rel="stylesheet" />
</head>
 
<body>

<!--head--> 
	
	<div class="head">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" style="color:#4b4b4b;">
        <tr>
          <td height="26" align="left" valign="middle">您好，欢迎光临北京长城网！</td>
          <td height="26" align="center" valign="middle">用户名：</td>
          <td height="26" align="center" valign="middle"><input type="text" name="textfield" /></td>
          <td height="26" align="center" valign="middle">密码：</td>
          <td height="26" align="center" valign="middle"><input type="text" name="textfield2" /></td>
          <td height="26" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/l1_logbt.gif" width="33" height="16" /></td>
          <td width="10" height="26" align="center" valign="middle">|</td>
          <td height="26" align="center" valign="middle"><a href="#" class="zc">注册</a></td>
          <td height="26" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/l1_logindex.gif" width="52" height="16" /></td>
          <td width="10" height="26" align="center" valign="middle">|</td>
          <td height="26" align="center" valign="middle"><a href="#">设为主页</a></td>
          <td width="10" height="26" align="center" valign="middle">|</td>
          <td height="26" align="center" valign="middle"><a href="#">网站地图</a></td>
        </tr>
      </table>
	</div>
	<div class="banner"><img src="${pageContext.request.contextPath }/images/banner.jpg" /></div>
	<div class="nav">
		<div style="float:left;"><img src="${pageContext.request.contextPath }/images/menu_l_bg.gif" /></div>
		<div class="nav_ct">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;">
          <tr>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img1.gif" width="44" height="49" /></td>
            <td height="18" align="center" valign="middle"><a href="#" class="nav_word">农村党建</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img2.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">工作进展</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img3.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">课件点播</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img4.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">课程预报</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img5.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">长城论坛</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img6.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">社区管理</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img7.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">健康驿站</a></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_line.gif" width="2" height="55" /></td>
            <td rowspan="3" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/menu_img8.gif" width="44" height="49" /></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">影视欣赏</a></td>
          </tr>
          <tr>
            <td height="18" align="center" valign="middle"><a href="#" class="nav_word">社区党建</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">区县动态</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">网上直播</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">学习通报</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">红色港湾</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">创先争优</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">科普园地</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">文艺戏曲</a></td>
          </tr>
          <tr>
            <td height="18" align="center" valign="middle"><a href="#" class="nav_word">两新党建</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">网站公告</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">咨询答疑</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">使用工具</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">村官在线</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">社会管理</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">生活指南</a></td>
            <td align="center" valign="middle"><a href="#" class="nav_word">图书在线</a></td>
          </tr>
        </table>
		</div>	
		<div style="float:right;"><img src="${pageContext.request.contextPath }/images/menu_r_bg.gif" /></div>
	</div>
	
	<div class="area">
		<div style="float:left;"><img src="${pageContext.request.contextPath }/images/menu_1_l.gif" /></div>
		<div class="area_ct">
			<ul>
				<li style="font-weight:bold;">区县站点：</li>
				<li><a href="#">东城</a></li>
				<li>|</li>
				<li><a href="#">西城</a></li>
				<li>|</li>
				<li><a href="#">朝阳</a></li>
				<li>|</li>
				<li><a href="#">海淀</a></li>
				<li>|</li>
				<li><a href="#">丰台</a></li>
				<li>|</li>
				<li><a href="#">石景山</a></li>
				<li>|</li>
				<li><a href="#">门头沟</a></li>
				<li>|</li>
				<li><a href="#">房山</a></li>
				<li>|</li>
				<li><a href="#">通州</a></li>
				<li>|</li>
				<li><a href="#">顺义</a></li>
				<li>|</li>
				<li><a href="#">大兴</a></li>
				<li>|</li>
				<li><a href="#">昌平</a></li>
				<li>|</li>
				<li><a href="#">平谷</a></li>
				<li>|</li>
				<li><a href="#">怀柔</a></li>
				<li>|</li>
				<li><a href="#">密云</a></li>
				<li>|</li>
				<li><a href="#">延庆</a></li>
			</ul>
		</div>
		<div style="float:right;"><img src="${pageContext.request.contextPath }/images/menu_1_r.gif" /></div>
	</div>
	
	<!--<div class="search">
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="35" align="left" valign="middle" style="font-size:14px; color:#d30101; font-weight:bold; "><img src="${pageContext.request.contextPath }images/sc_icon.gif" width="14" height="11" />站内搜索</td>
          <td height="35" align="left" valign="middle"><a href="#"></a> <table border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="25" align="left" valign="middle"><input type="radio" name="radiobutton" value="radiobutton" /></td>
                <td width="45" align="left" valign="middle">图文</td>
                <td width="25" align="left" valign="middle"><input type="radio" name="radiobutton" value="radiobutton" /></td>
                <td width="45" align="left" valign="middle">视频</td>
                <td width="50" align="left" valign="middle">关键字：</td>
                <td width="180" align="left" valign="middle"><input type="text" name="textfield3" style="width:170px;" /></td>
                <td width="60" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }images/sc_bt.gif" width="43" height="22" border="0" /></a></td>
              </tr>
            </table></td>
          <td width="120" height="35" align="left" valign="middle" style="font-size:14px; color:#d30101; font-weight:bold; "><img src="${pageContext.request.contextPath }images/sc_icon.gif" width="14" height="11" />人事任免动态</td>
          <td width="200" height="35" align="left" valign="middle"><marquee onmouseover=this.stop() onmouseout=this.start() width="200px">北京近期重要人事任免（5月30日）</marquee></td>
        </tr>
      </table>
	</div>-->
	
	<!--head--> 
	

</body>
</html>

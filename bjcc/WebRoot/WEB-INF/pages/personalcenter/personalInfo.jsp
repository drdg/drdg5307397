<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String num=request.getParameter("num");
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
function dxxck(){
	showTipsWindown(780, 464, "${pageContext.request.contextPath }/addForward.action");
}
function dxxck1(){
	showTipsWindown(780, 464, "${pageContext.request.contextPath }/unreadMessage.action");
}
</script>
</head>
<style>
body{ background-image:none; }
</style>
<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			style="margin-bottom: 8px;">
			<tr>
				<td width="101" height="29" align="center" class="right_tit">
					用户登录
				</td>
				<td width="126" align="right" background="${pageContext.request.contextPath }/images/news2_bg.gif">
					&nbsp;
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="2" style="border-top: 1px solid #D6D6D6;" height="120">
					<table width="93%" border="0" align="center" cellpadding="0"
						cellspacing="0" style="font- size: 14px;">

						<tr>
							<td width="45%" rowspan="4" align="center" valign="middle">
								<img class="img_kuang"
									src="${pageContext.request.contextPath }/images/img_tx.gif"
									width="88" height="99" />
							</td>
							<td height="38" align="left" valign="middle" class="hyn_td">
								<img src="${pageContext.request.contextPath }/images/jf_sun.gif"
									width="18" height="18" />
								欢迎您
							</td>
						</tr>
						<tr>
							<td height="38" align="left" valign="middle">
								<a href="#"><s:property
										value="#session.loginUserInfo.loginName" />
								</a>
							</td>
						</tr>
						<tr>
							<td height="28" align="left" valign="middle">
								<a href="#" onclick="return dxxck();"
									style="text-decoration: none"> <img
										src="${pageContext.request.contextPath }/images/dian03.gif"
										width="12" height="12" /> 短消息 </a>
								<span class="pinglunshu_r"><a href="#"
									onclick="return dxxck1();" style="text- decoration: none">${num}</a>
								</span>
							</td>
						</tr>
						<tr>
							<td height="8" align="left" valign="middle"></td>
						</tr>
						<tr>
							<td colspan="2" align="center" valign="middle"
								style="background- image: url(${pageContext.request.contextPath }/images/hengxian.gif); background-repeat: repeat- x;">
								&nbsp;
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>

							<td height="30" style="padding-left: 10px; width: 74px;">
								<a href="#"><img src="${pageContext.request.contextPath }/images/xxda.png" />
								</a>
							</td>
							<td  height="30" colspan="2" align="left" valign="bottom" >
							   <a href="<%=Constant.SNS_FORUM_LOGIN_URL %>" onmouseover="zttc('aa0', 'show');" onmouseout="zttc('aa0','hide');" target="_blank">
							    <img src="${pageContext.request.contextPath }/images/cgzxx.png" width="171" height="29" border="0" /></a>
							   <div style="position:relative; ">
								<div class="ycc" id="aa0" onmouseover="zttc('aa0', 'show');" onmouseout="zttc('aa0', 'hide');">
									<iframe src="<%=Constant.SNS_FORUM_THEME_CNT_URL %>?userId=<s:property value="#session.loginUserInfo.userId"/>" frameBorder="0" scrolling="no" marginwidth="0" marginheight="0" id="leftframe" width="171px" height="130px" border="0" style="position:relative;z-index: 999;"></iframe>
								</div>
								</div>
							   </td>
						</tr>
						<tr>
							<td height="30" style="padding-left: 10px; width: 74px;">
								<a target="_blank" href="<%=Constant.MODIFY_PERSON_MESSAGE %>"><img src="${pageContext.request.contextPath}/images/grzl.png" />
								</a>
							</td>
							<td  height="30" colspan="2" align="left" valign="bottom" >
							   <a href="<%=Constant.RB_FORUM_LOGIN_URL %>" onmouseover="zttc('aa1', 'show');" onmouseout="zttc('aa1','hide');" target="_blank">
							   <img src="${pageContext.request.contextPath }/images/hsgww.png" width="171" height="29" border="0" /></a>
							   <div style="position:relative; ">
								<div class="ycc" id="aa1" onmouseover="zttc('aa1', 'show');" onmouseout="zttc('aa1', 'hide');">
									<iframe src="<%=Constant.RB_FORUM_THEME_CNT_URL %>?userId=<s:property value="#session.loginUserInfo.userId"/>" frameBorder="0" scrolling="no" marginwidth="0" marginheight="0" id="leftframe" width="171px" height="130px" border="0" style="position:absolute;z-index: 999;"></iframe>
								</div>
								</div>
							   </td>
						</tr>
						<tr>
							<td height="30" style="padding-left: 10px; width: 74px;">
								<a href="#"><img src="${pageContext.request.contextPath }/images/xgma.png" /></a>
							</td>
							 <td  height="30" colspan="2" align="left" valign="bottom"  >
							   <a href="<%=Constant.JSPRUN_FORUM_LOGIN_URL %>" onmouseover="zttc('aa2', 'show');" onmouseout="zttc('aa2','hide');" target="_blank">
							   <img src="${pageContext.request.contextPath }/images/sxsbbsg.png" width="171" height="29" border="0" /></a>
							   <div style="position:relative; ">
								<div class="ycc" id="aa2" onmouseover="zttc('aa2', 'show');" onmouseout="zttc('aa2', 'hide');">
									<iframe src="<%=Constant.JSPRUN_FORUM_THEME_CNT_URL %>?userId=<s:property value="#session.loginUserInfo.userId"/>" frameBorder="0" scrolling="no" marginwidth="0" marginheight="0" id="leftframe" width="171px" height="130px" border="0" style="position:absolute;z-index: 999;"></iframe>
								</div>
								</div>
							   </td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
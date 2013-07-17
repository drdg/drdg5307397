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
<script language="javascript" type="text/javascript">

function closewin() {
	top.window.closeiframe();
	//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
	//closeWindown();
	
}

</script>
<style>
body{ background-image:none; }
</style>
</head>
<body>

			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news" style=" background-image:url(${pageContext.request.contextPath }/images/news2_bg.gif); background-repeat:repeat-x;">
					   <tr>
						<td width="30%" align="center" class="news_title"> 专题添加 </td>
						<td width="70%" align="center" valign="middle" class="xxjh_data">&nbsp;</td>
				       </tr>
					   <tr>
					   	<td colspan="2" align="center">
						<table width="85%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
                          <tr>
                            <td width="42%" align="left" valign="top">
							<div class="zt_list">
								<ul>
									<li>时政要闻</li>
									<li class="zt_list_tt1">时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li class="zt_list_tt1">时政要闻</li>
									<li class="zt_list_tt1">时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li class="zt_list_tt1">时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
								</ul>
							</div>
							</td>
                            <td width="16%" align="left" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="25" align="center" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/zttj_zuo.gif" width="44" height="17" border="0" /></a></td>
                              </tr>
                              <tr>
                                <td height="25" align="center" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/zttj_you.gif" width="44" height="17" border="0" /></a></td>
                              </tr>
                            </table></td>
                            <td width="42%" align="left" valign="top">
								<div class="zt_list">
								<ul>
									<li>时政要闻</li>
									<li class="zt_list_tt1">时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									<li>时政要闻</li>
									
								</ul>
							</div>
							</td>
                          </tr>
                          <tr>
                            <td height="50" colspan="3" align="center" valign="middle" style="border-top:#f5d2aa solid 1px;">
							<table border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="80" height="30" align="left" valign="middle">
								<a href="#"><img src="${pageContext.request.contextPath }/images/tijiao_bt.gif" width="67" height="26" border="0" /></a>
								</td>
                                <td width="80" height="30" align="left" valign="middle">
								<a href="#">
								<img src="${pageContext.request.contextPath }/images/quxiao_bt.gif" width="67" height="26" border="0" id="quxiao" onClick="closewin();" />
								</a></td>
                              </tr>
                            </table></td>
                          </tr>
                        </table></td>
					   </tr>
				  </table>
</body>
</html>
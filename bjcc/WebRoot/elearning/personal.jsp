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
							   <td colspan="2" align="center" valign="middle" style=" background-image:url(images/hengxian.gif); background-repeat:repeat-x;">&nbsp;</td>
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
</body>
</html>

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
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
			  <tr>
  				<td colspan="7"> <div class="wdkc_bt" style="margin-bottom:5px;">
                    <div style="width:196px; padding-top:5px; text-align:left; float:left; padding-left:12px;"><a href="#"><img src="${pageContext.request.contextPath }/images/xg_btt.png" /></a></div>

				  	<div style="float:left; width:380px;">
						<p style="width:86px; float:left; padding-top:5px;">
							<select name="select" id="select" style="width:80px; height:20px;" class="blue12">
							<option>课程名称</option>
							<option>名称一</option>
						  </select></p>
						<p style="width:157px; padding-top:4px; float:left;"><input class="searchInput" style=" width:150px;" type="text" name="textfield" id="textfield" /></p>
						<p style="width:57px; float:left; padding-top:6px;"><img src="${pageContext.request.contextPath }/images/sousuo_bt1.gif" /></p>
					</div>
				   </div></td>
              </tr>
              <tr>
                <td width="274" align="left" class="table_xuexi_title p_l_10">课件名称</td>
                <td width="105" class="table_xuexi_title">收藏时间</td>
                <td width="105" class="table_xuexi_title">时长</td>
                <td width="71" class="table_xuexi_title">学习计划</td>
                <td width="71" class="table_xuexi_title">学习</td>
                <td width="71" class="table_xuexi_title">删除</td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">中国宏观经济的展望宏观经展望宏观经济...</a></td>
                <td>2012-12-12&nbsp;&nbsp;00:00</td>
                <td>00:09:08</td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_jr.png" />&nbsp;加入</a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_bfan.png" /></a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_sc.png" /></a></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td class="p_l_10" align="left"><a href="#">中国宏观经济的展望宏观经展望宏观经济...</a></td>
                <td>2012-12-12&nbsp;&nbsp;00:00</td>
                <td>00:09:08</td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_jr.png" />&nbsp;加入</a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_bfan.png" /></a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_sc.png" /></a></td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">中国宏观经济的展望宏观经展望宏观经济...</a></td>
                <td>2012-12-12&nbsp;&nbsp;00:00</td>
                <td>00:09:08</td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_jr.png" />&nbsp;加入</a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_bfan.png" /></a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_sc.png" /></a></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td class="p_l_10" align="left"><a href="#">中国宏观经济的展望宏观经展望宏观经济...</a></td>
                <td>2012-12-12&nbsp;&nbsp;00:00</td>
                <td>00:09:08</td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_jr.png" />&nbsp;加入</a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_bfan.png" /></a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_sc.png" /></a></td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">中国宏观经济的展望宏观经展望宏观经济...</a></td>
                <td>2012-12-12&nbsp;&nbsp;00:00</td>
                <td>00:09:08</td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_jr.png" />&nbsp;加入</a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_bfan.png" /></a></td>
                <td><a href="#"><img src="${pageContext.request.contextPath }/images/gx_sc.png" /></a></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td colspan="6" align="right" class="p_l_10" style="padding-right:15px;" height="35">
				<a href="#">更多&nbsp;<img src="${pageContext.request.contextPath }/images/gs_xb.gif" /></a>
				
				</td>
              </tr>
            </table>
</body>
</html>

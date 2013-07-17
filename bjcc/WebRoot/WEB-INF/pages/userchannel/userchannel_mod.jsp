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
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript">

function closewin() {
	parent.window.closeiframe();
}

function save() {
	//rightchannel
	var ids = "";
	$("#rightchannel li").each(function(){
		ids = ids +$(this).attr("id")+",";
	});
//	if(ids=="") {
//		alert("请先添加专题");
//		return false;
//	}
	$("#userChannels").val(ids);
	submitFormByJson("${pageContext.request.contextPath }/saveUserChannelAjaxAction.action", "form1", callBackSave);
	return false;
}

var callBackSave = function(data) {
	if(data.result=="success") {
		parent.window.frames["zhuanti"].refreshpage();
		closewin();
	} else {
		alert("保存专题失败，请重新添加");
	}
	return false;
}

function toggleselect(obj) {
	$(obj).toggleClass('zt_list_tt1');
	return false;
}

function toright() {
	$("#leftchannel .zt_list_tt1").each(function(){
		var lihtml = "<li id=\""+$(this).attr("id")+"\" class=\"divli\"" +
				" onclick=\"return toggleselect(this);\" " +
				" ondblclick=\"return toggleselect(this);\" >"+ $(this).html() +"</li>";
		$("#rightchannel").append(lihtml);
		$(this).remove();
	});
	return false;
}

function toleft() {
	$("#rightchannel .zt_list_tt1").each(function(){
		var lihtml = "<li id=\""+$(this).attr("id")+"\" class=\"divli\"" +
				" onclick=\"return toggleselect(this);\" " +
				" ondblclick=\"return toggleselect(this);\" >"+ $(this).html() +
				"</li>";
			$("#leftchannel").append(lihtml);
			$(this).remove();
	});
	return false;
}
</script>
<style>
body{ background-image:none; }
</style>
</head>
<body>

<form id="form1" action="${pageContext.request.contextPath }/saveUserChannelAjaxAction.action" method="post">
	<input type="hidden" id = "userChannels" name = "userChannels"/>
</form>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news" style=" background-image:url(${pageContext.request.contextPath }/images/news2_bg.gif); background-repeat:repeat-x;">
					   <tr>
						<td width="30%" align="center" class="news_title"> 专题添加 </td>
						<td width="70%" align="center" valign="middle" class="xxjh_data">&nbsp;</td>
						<td align="right" class="xxjh_data" style="padding-right: 10px;"><img src="${pageContext.request.contextPath }/images/del.gif" width="12px" height="12px" onclick="return closewin();"/></td>
				       </tr>
				      
					   <tr>
					   	<td colspan="2" align="center">
						<table width="85%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
                          <tr>
                          	<th>待选择专题</th>
                          	<th></th>
                          	<th>已选择专题</th>
                          </tr>
                          <tr>
                            <td width="42%" align="left" valign="top">
							<div class="zt_list">
<%--							<select id = "userchannel" multiple="multiple" size="20" class="zt_list_select" onchange="return toggleselect(this);">--%>
								<ul id = "leftchannel">  
									<s:iterator value="notUserChannels" id="channel">
<%--									<option onclick="" ondblclick=""><s:property value="#channel.name"/></option>--%>
										<li id="<s:property value="#channel.id" />" onclick="return toggleselect(this);" ondblclick="return toggleselect(this);"><s:property value="#channel.name" /></li>
									</s:iterator>
<%--									<option class="zt_list_tt1">时政要闻</option>--%>
								</ul>
<%--							</select>--%>
							</div>
							</td>
                            <td width="16%" align="left" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="25" align="center" valign="middle"><a href="#" onclick="return toright();"><img src="${pageContext.request.contextPath }/images/zttj_zuo.gif" width="44" height="17" border="0" /></a></td>
                              </tr>
                              <tr>
                                <td height="25" align="center" valign="middle"><a href="#" onclick="return toleft();"><img src="${pageContext.request.contextPath }/images/zttj_you.gif" width="44" height="17" border="0" /></a></td>
                              </tr>
                            </table></td>
                            <td width="42%" align="left" valign="top">
								<div class="zt_list">
								<ul id = "rightchannel" >
									<s:iterator value="userChannels" id="channel">
										<li id="<s:property value="#channel.id" />" onclick="return toggleselect(this);" ondblclick="return toggleselect(this);"><s:property value="#channel.name" /></li>
									</s:iterator>
								</ul>
							</div>
							</td>
                          </tr>
                          <tr>
                            <td height="50" colspan="3" align="center" valign="middle" style="border-top:#f5d2aa solid 1px;">
							<table border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="80" height="30" align="left" valign="middle">
								<a href="#" onclick="return save();"><img src="${pageContext.request.contextPath }/images/tijiao_bt.gif" width="67" height="26" border="0" /></a>
								</td>
                                <td width="80" height="30" align="left" valign="middle">
								<a href="#" onclick="return closewin();" >
								<img src="${pageContext.request.contextPath }/images/quxiao_bt.gif" width="67" height="26" border="0" id="quxiao"/>
								</a></td>
                              </tr>
                            </table></td>
                          </tr>
                        </table></td>
					   </tr>
					   
<%--					   <tr>--%>
<%--                            <td height="50" colspan="3" align="center" valign="middle" style="border-top:#f5d2aa solid 1px;">--%>
<%--							<table border="0" cellspacing="0" cellpadding="0">--%>
<%--                              <tr>--%>
<%--                                <td width="80" height="30" align="left" valign="middle">--%>
<%--								<a href="#"><img src="${pageContext.request.contextPath }/images/tijiao_bt.gif" width="67" height="26" border="0" /></a>--%>
<%--								</td>--%>
<%--                                <td width="80" height="30" align="left" valign="middle">--%>
<%--								<a href="#">--%>
<%--								<img src="${pageContext.request.contextPath }/images/quxiao_bt.gif" width="67" height="26" border="0" id="quxiao" onClick="closewin();" />--%>
<%--								</a></td>--%>
<%--                              </tr>--%>
<%--                            </table></td>--%>
<%--                          </tr>--%>
				  </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教学答疑</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ssoLogin.js"></script>
		<script language="javascript" type="text/javascript">
			function gbcount(message) {
				var max = 300;
				if (message.value.length > max) {
					message.value = message.value.substring(0, max);
					alert("留言内容不能超过 300 个字符!");
				}
			}
			//验证输入信息
			function validateInput() {
				var isSubmit = true;
				if ("" == $.trim($("#validate").val())) {
					alert("请输入验证码！");
					$("#validate").focus();
					return;
				}
				if ("" == $.trim($("#cont").val())) {
					alert("请输入咨询内容！");
					$("#cont").focus();
					return;
				}
				ssoLogin(function(){$("#form").submit();});
			}
			//查看留言信息
			function viewMessage(){
				ssoLogin(function(){$("#viewLink")[0].click();});
			}
			//获取请求参数
			function getQueryString(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
				var r = window.location.search.substr(1).match(reg);
				if (r != null) {
					return unescape(r[2]);
				}
				return null;
			}
			$(function(){
				var error = '<s:property value="errorCode"/>';
		 		if("1"==error){
		 			alert("您尚未登录，请先登录！");
		 		}
		 		if("2"==error){
		 			alert("您输入的验证码不正确，请重新输入！");
		 		}
		 		if("-1"==error){
		 			viewMessage();
		 		}
		 		var typeId = getQueryString("typeId");
		 		if(null!=typeId && ""!=$.trim(typeId)){
		 			$("#typeId").val(typeId);
		 		}
		 	});
	</script>
	<style type="text/css">
		body,form{ margin:0; padding:0; }
		body{font-family:Arial; margin:0; padding:0; background-repeat:repeat-x; font-size:12px; background-image:url(../images/back.gif); background-repeat:repeat-x;}
		.zxdy_ct{ width:210px; height:auto; padding:10px;}
	</style>
	</head>
	<body>
		<form id="form" action="${pageContext.request.contextPath}/writeMessage.action" method="post">
			<span style="display:none;" id="error">
				<s:actionerror />
			</span>
			<a id="viewLink" href="http://192.168.6.31/bjzcw/wskt/zxdy/index.html" style="display:none;" target="_top"></a>
			<input type="hidden" name="typeId" id="typeId" value="<s:property value="typeId"/>"/>
			<div class="zxdy_ct">
			  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
					<td height="25" align="left" valign="middle">验证码：</td>
				  </tr>
				  <tr>
					<td height="25" align="left" valign="middle">
						<input name="valCode" type="text" id="validate" style="vertical-align: middle;width:100px;" maxlength="4" />
						<img id="valImg" src="${pageContext.request.contextPath}/randValidateCode.action" style="vertical-align: middle;" />
				 	</td>
				  </tr>
				  <tr>
					<td height="25" align="left" valign="middle">我要咨询：</td>
				  </tr>
				  <tr>
					<td height="160" align="left" valign="middle">
						<textarea name="messageContent" id="cont" style="width:160px; height:150px;" onkeydown="gbcount(this);" 
							onkeyup="gbcount(this);"><s:property value="messageContent"/></textarea>
					</td>
				  </tr>
				  <tr>
					<td height="35" align="left" valign="middle">
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img style="cursor:pointer;" src="images/tijiao.gif" width="51" onclick="validateInput()" height="18" /> 
						<img style="cursor:pointer;" src="images/chakan.gif" width="51" onclick="viewMessage()" height="18" />
					</td>
				  </tr>
				</table>
			  </div>
		</form>
	</body>
</html>

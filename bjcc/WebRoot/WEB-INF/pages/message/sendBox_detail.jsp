<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style_dxx.css" rel="stylesheet" />
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/program.js"></script> 
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个性化学习_收件箱_详细ϸ</title>
<script type="text/javascript">
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
 var url = "";
 if(n==0){
 	url = '${pageContext.request.contextPath }/receiveForward.action';
 	tli[0].className="hover";
 	tli[1].className="";
 	tli[2].className="";
 }else if(n==1){
 	url = '${pageContext.request.contextPath }/sendForward.action';
 	tli[1].className="hover";
 	tli[0].className="";
 	tli[2].className="";
 }else if(n==2){
 	url = '${pageContext.request.contextPath }/writeForward.action';
 	tli[2].className="hover";
 	tli[0].className="";
 	tli[1].className="";
 	
 }
document.location.href = url;
 }

	function del(receiveMsgId) {
		var url = "${pageContext.request.contextPath }/msg/delByReceiveId.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function transfer(receiveMsgId){
		var url = "${pageContext.request.contextPath }/msg/transferMessage.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function reply(receiveMsgId){
		var url = "${pageContext.request.contextPath }/msg/replyMessage.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	function back(){
		setTab(1,1);
	}
	function closewin() {
			parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
		}
</script>
<style>
body{ background-image:none; }
</style>
</head>
<body>
<form action="${pageContext.request.contextPath }/detailMessage.action">
<div class="dxxk">
	<div class="dxxkl">
		<div class="dxxqh"  id="menu1">
					<ul>
						<li><a href="#"  onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#" class="hover" onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#"  onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
		</div>
		<div class="dxxsjx" id="main1">
			<table width="741px;"  height="30" border="0" cellspacing="0" style="background:#fef8e6; color:#4f4f4f;">
				<tr>
			    	 <td style="width:100px; padding-left: 10px">
				    	<a href="#" onclick="back();" class="xhx">返回</a>
			        </td>
				</tr>
			</table>
				<strong>发信人：</strong>
			 	<s:property value="websiteMessage.sendUsername" /><br/><br/>			    	
				<strong>发信时间：</strong>
			 	 <s:property value="websiteMessage.sendTime" />	<br/><br/>		    	
				<strong>收信人：</strong>
				<s:iterator value="websiteMessage.listusers" id="receive">
			 		<s:property value="#receive.receiveName" />;
			 	</s:iterator><br/><br/>		    	
				<strong>主题：</strong>
			 	<b><s:property value="websiteMessage.msgTitle" /></b><br/><br/>		    	
				<strong>内容： </strong>
				<div style="width: 450px;margin-left: 40px;"><s:property value="websiteMessage.msgContent" /></div>
		</div>
	</div>
</div>
</form>
</body>
</html>

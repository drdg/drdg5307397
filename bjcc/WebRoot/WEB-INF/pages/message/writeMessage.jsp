<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>个性化学习_写信</title>
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
		function save(){
			//alert($("form:first").attr("action"));
			var msgTitle = $("#msgTitle").val();
			var msgContent = $("#msgContent").val();
			if($.trim(msgTitle) == null||$.trim(msgTitle) == ""){
			alert("标题不能为空 ！");
			return false;
			}
			if(msgTitle.length>64){
			alert("标题不能大于64个字符");
			return false;
			}
			if(checklength($("#msgContent"), 256, '短信内容不能超过256个长度，点确定只截取前256位，点取消继续编辑短信内容？') == false) {
				return false;
			}
			if(valReceiveUser() == false) {
				return false;
			}
			$("form:first").submit();
            return false;
            }
            
        // ajax  
       	function valReceiveUser() {
       		var bool = true;
       		var val = $("#receiveUsers").val();
       		if(val.length==0){
       		bool = false;
       		alert("请填写收信人！");
       		}
       		if(val.lenth>32){
       		bool = false;
       		alert("收信人长度不能超过32位！");
       		}
       		if(val.length!=0){
       			var reqUrl = "${pageContext.request.contextPath}/eWebsiteMessageJson.action";
				var data = {"receiveusers":val};
				requestByAjax(reqUrl, data, function(data) {
					if(data.notExistsUsers.length!=0){
						bool = false;
						alert("用户不存在："+data.notExistsUsers);
					};
				});
			}
			return bool;
        }
        function closewin() {
			parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
		} 
		function checklength(obj, maxlen, msg) {
			var val = $(obj).val();
			var len = val.length;
			if(len > maxlen){
				if(window.confirm(msg)){
					$(obj).val(val.substr(0, maxlen));
					return true;
				}else {
					obj.focus();
					return false;
				}
			}
			return true;
		}	   
	</script>
<style>
body{ background-image:none; }
</style>
</head>

<body>
<form action="<%=request.getContextPath()%>/saveMessage.action" method="post">	
<div class="dxxk">
<div class="dxxkl">
<div class="dxxqh"  id="menu1">
					<ul>
						<li><a href="#"  onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#"  onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#" class="hover" onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
</div>
	<div class="dxxsjx" id="main1">

		标&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text" id="msgTitle" name="websiteMessage.msgTitle" style="width: 300px;"/> <br /><br />
		收信人：<input type="text" id="receiveUsers" name="websiteMessage.receiveusers" style="width: 300px;" />（填写对方登录名,多个用户用;号隔开）<br /><br />
<!--        <div  class="lja"><a href="#">-->
<!--        <img src="${pageContext.request.contextPath }/images/ljtb.jpg" />&nbsp;&nbsp;插入超级链接</a></div>-->
       	
	
<div style="width:650px; height:264px;">  
<div style="width:50px; float:left;">内&nbsp;&nbsp;&nbsp;容:</div>   
<div style="float:left;">
  <textarea name="websiteMessage.msgContent" id = "msgContent" style="width:594px; height:260px;" onchange="checklength(this, 256, '内容不能超过256个长度，点确定只截取前256位，点取消继续编辑短信内容？');"></textarea>
</div>
</div>

<div class="dban1">
	<a href="#" onclick="save()" class="ann1">发送</a>
	<a href="#" onclick="javascript: window.history.back();" class="ann1" style="margin-left:19px;">返回</a>
</div>
   </div>    
</div>
</div>  
	</form>
</body>
</html>

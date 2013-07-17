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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个性化学习_转发</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style_dxx.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
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
</script>
<style>
body{ background-image:none; }
</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/saveTransferMessage.action" method="post">
<div class="dxxk">
	<div class="dxxkl"> 
		<div class="dxxqh"  id="menu1">
					<ul>
						<li><a href="#" class="hover" onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#"  onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#"  onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
		</div>
		
		<div class="dxxsjx" id="main1">
				<strong>标&nbsp;&nbsp;&nbsp;&nbsp;题：</strong>
				<input name="websiteMessage.msgTitle" style="width: 300px;" value="<s:property value="receiveMessage.websiteMessage.msgTitle" />" type="text" /><br/><br/>
			 	<strong>发信人：</strong>
			 	<s:property value="receiveMessage.receiveName" /><br/><br/>
	            <strong>收信人：</strong>
	            <input type="text" id="receiveUsers" name="websiteMessage.receiveusers" style="width: 300px;" onblur="valReceiveUser();"/>（填写对方昵称,多个用户用;号隔开）<br/><br/>
				<div style="width:650px; height:264px;">  
				<div style="width:50px; float:left;"><strong>内&nbsp;&nbsp;&nbsp;容:</strong></div>
				<div style="float:left;">
 				<textarea name="websiteMessage.msgContent" style="width:594px; height:260px;"><s:property value="receiveMessage.websiteMessage.msgContent" /></textarea>
				</div>
				<div>
		  			<a href="#" class="ann1"  onclick="save()" style="margin-left: 50px;" >转发</a>
		  			<a href="#" class="ann1"  onclick="javascript: window.history.back();" style="margin-left: 5px">返回</a>
		  		</div>
		</div>
		</div>
		
	</div>
</div>
</form>
</body>
</html>

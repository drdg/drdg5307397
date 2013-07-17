<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>点播在线用户</title>
		<script type="text/javascript">
			var updateRecId;
			//打开页面时记录点播在线用户
			window.onload = function() {
				var url = "${pageContext.request.contextPath }/liveJson/createOrderOnlineUser.action"
				var params = {};
				params.programId=getQueryString("programId");
				requestByJson(url,params,createCallback);
			}
			//创建点播在线用户后取得记录的ID
			var createCallback = function(result){
				updateRecId = result.playUserId;
			};
			
			//关闭页面时更显点播在线用户
			window.onunload = function() {
				if(null == updateRecId){
					return;
				}
				var url = "${pageContext.request.contextPath }/liveJson/updateOrderOnlineUser.action"
				var params = {};
				params.playUserId=updateRecId;
				requestByJson(url,params,createCallback);
			};
			//更新点播在线用户后不做任何处理
			var updateCallback = function(result){};
			
			//获取请求参数
			function getQueryString(name) {    
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");    
				var r = window.location.search.substr(1).match(reg);    
				if (r != null) {
					return unescape(r[2]);
				} 
				return null;   
		 }
		</script>
	</head>
	<body>

	</body>
</html>
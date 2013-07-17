<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'userstore.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/json2.js"></script>

<script type="text/javascript">

	/*
	 *异步验证ID是否重复
	 */
	function verId() {

		var reqUrl = "${pageContext.request.contextPath }/verifyIdUserStoreAjaxAction.action";
		var val_uid = $("#USER_ID").val();
		var val_pid = $("#PROGRAM_ID").val();
		var data = {"userId" : val_uid,"programId":val_pid};
		
		requestByAjax(reqUrl, data, function(data) {
			var message = data.verifyMessages;
			if(null != message){
				alert(message);
			}else{
				$("form:first").submit();
			}
		});
	}


	/*
	 * 通过URL方式请求后台Action，第一个参数为请求URL，第二个为请求时所传递数据
	 */
	function requestByAjax(reqUrl, data,callback){

		$.ajax({
	   		url:addUrlRandomParam(reqUrl),
	   		data:data,
	   		async:false,
	     	type:"post",
	     	dataType:"json",
	     	success:function(data){
	   			callback(data);
	   		},
	   		error:function(){
	        	alert("请求失败");
	     	}
		});
	}

	/*
	 * 为一个URL加上一个随机字符串参数，以避免浏览器缓存 
	 */
	function addUrlRandomParam(url) {
		var regex = /\?/;
		var randStr;
		if(regex.test(url)){
			randStr = "&rand=" + generateRandomStr(16);
		}else{
			randStr = "?rand=" + generateRandomStr(16);
		}
		return url+randStr;
	}

	/*
	 * 生成随机字符串，本函数从common.js中复制过来
	 */
	function generateRandomStr(n) {
		 var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	     var res = "";
	     for(var i = 0; i < n ; i ++) {
	         var id = Math.ceil(Math.random()*35);
	         res += chars[id];
	     }
	     return res;
	}
</script>
	</head>

	<body>
		用户收藏列表
		<table border="1">
			<tr>
				<td>
					ID
				</td>
				<td>
					USER_ID
				</td>
				<td>
					PROGRAM_ID
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator value="articles" id="article">
				<tr>
					<td>
						<s:property value="#article.id" />
					</td>
					<td>
						<s:property value="#article.programId" />
					</td>
					<td>
						<s:property value="#article.userId" />
					</td>

					<td>
						<a
							href="${pageContext.request.contextPath }/detailUserStoreAction.action?userStoreId=<s:property value="#article.id"/>">修改</a>|
						<a
							href="${pageContext.request.contextPath }/deleteUserStoreAction.action?userStoreId=<s:property value="#article.id"/>">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr />
		<form
			action="${pageContext.request.contextPath }/addUserStoreAction.action" method="post">
			<table>
				<tr>
					<td>
						ID:
					</td>
					<td>
						<input type="text" name="userStore.id">
					</td>
				</tr>
				<tr>
					<td>
						USER_ID:
					</td>
					<td>
						<input type="text" name="userStore.userId" id="USER_ID">
					</td>
				</tr>
				<tr>
					<td>
						PROGRAM_ID:
					</td>
					<td>
						<input type="text" name="userStore.programId" id="PROGRAM_ID">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="保存" id="butsub" onclick="verId()">
					</td>
				</tr>
			</table>
		</form>
		<s:debug></s:debug>

	</body>
</html>

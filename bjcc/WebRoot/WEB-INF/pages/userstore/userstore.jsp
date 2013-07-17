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
	 *�첽��֤ID�Ƿ��ظ�
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
	 * ͨ��URL��ʽ�����̨Action����һ������Ϊ����URL���ڶ���Ϊ����ʱ����������
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
	        	alert("����ʧ��");
	     	}
		});
	}

	/*
	 * Ϊһ��URL����һ������ַ����������Ա������������ 
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
	 * ��������ַ�������������common.js�и��ƹ���
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
		�û��ղ��б�
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
					����
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
							href="${pageContext.request.contextPath }/detailUserStoreAction.action?userStoreId=<s:property value="#article.id"/>">�޸�</a>|
						<a
							href="${pageContext.request.contextPath }/deleteUserStoreAction.action?userStoreId=<s:property value="#article.id"/>">ɾ��</a>
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
						<input type="button" value="����" id="butsub" onclick="verId()">
					</td>
				</tr>
			</table>
		</form>
		<s:debug></s:debug>

	</body>
</html>

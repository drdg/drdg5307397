<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题列表</title>
<style type="text/css">
	.tbl_user{
		width:900px;
		border-collapse:collapse;
		margin:40px 0 0 0;
		
	}
	
	.tbl_user th{
		border: 1px solid blue;
		background-color:grey;
		color:blue;
		padding:5px 20px;
	}
	.tbl_user td{
		border: 1px solid blue;
	}
</style>
</head>
<body>
	<table align="center" class="tbl_user">
		<tr>
			<th>ID</th>
			<th>主题标题</th>
			<th>主题描述</th>
			<th>直播日期</th>
			<th>直播内容</th>
		</tr>
		<s:iterator value="subjectList" var="subject" status="sta">
			<tr>
				<td><s:property value="#subject.subjectId"/></td>
				<td><a href="${pageContext.request.contextPath }/liveDetail.action?liveId=<s:property value="#subject.subjectId"/>"><s:property value="#subject.title"/></a></td>
				<td><s:property value="#subject.description" escapeJavaScript="false"/></td>
				<td><s:property value="publishDate"/></td>
				<td>
					<s:iterator value="#subject.contentList" var="con" status="staa">
						<s:if test="#staa.last">
							<s:property value="#staa.count"/>
						</s:if>
					</s:iterator>
				</td>
			</tr>
		</s:iterator>
		<!-- 
		<tr><td colspan="4"><jsp:include page="../global/paginationInclude.jsp"></jsp:include></td></tr>
		 -->
	</table>

</body>
</html>
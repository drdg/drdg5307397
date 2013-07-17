<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检索结果</title>
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
	.query_keyword{
		font-weight:bold;
		color:red;
	}
	.result p{
		padding:0;
		margin:0;
	}
</style>
<script type="text/javascript">
	$(function(){
		var time = $("#time").val();
		if(null==time || ""==time){
			time=0;
		}
		$(".time[value='" + time + "']").attr("checked","checked");
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/search.action" method="post">
		<div style="padding-bottom:20px;">
			<input type="text" name="condiBean.keyWord" value="<s:property value="condiBean.keyWord"/>"/>
			<div class="range">
				<span><input type="radio" class="time" name="condiBean.timeRange" value="0">全部</span>
				<span><input type="radio" class="time" name="condiBean.timeRange" value="1">一个月之内</span>
				<span><input type="radio" class="time" name="condiBean.timeRange" value="2">三个月之内</span>
				<span><input type="radio" class="time" name="condiBean.timeRange" value="3">半年之内</span>
				<span><input type="radio" class="time" name="condiBean.timeRange" value="4">一年之内</span>
				<input type="hidden" id="time" name="time" value="<s:property value="condiBean.timeRange"/>" />
			</div>
			<input type="submit" value="  检索  ">
			<span>耗时：<s:property value="times"/>ms</span><br>
		</div>
		
		<div>
			<s:iterator value="fileList" var="fl" status="index">
				<div class="result" style="padding-bottom:20px;">
					<p><a href="<s:property value="path"/>"><s:property value="title"/></a></p>
					<p><s:property value="content" escapeHtml="false"/></p>
					<p><s:property value="path"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="modifyDate"/></p>
				</div>
			</s:iterator>
			<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
		</div>
	</form>
</body>
</html>
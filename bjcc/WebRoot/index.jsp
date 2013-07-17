 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index page show</h1>
	<a href="${pageContext.request.contextPath }/liveList.action">直播列表</a>
	<a href="${pageContext.request.contextPath }/quxianList.action">区县排行</a>
	<a href="${pageContext.request.contextPath }/videoList.action">视频排行</a>
	<a href="${pageContext.request.contextPath }/hotCodeList.action">热词</a>
	<a href="${pageContext.request.contextPath }/programAction.action">视频搜索</a>
	<a href="${pageContext.request.contextPath }/calendar/indexRili.html">课程表(首页)</a>
	<a href="${pageContext.request.contextPath }/calendar/rili.html">课程表(教学服务栏目内)</a>
	<a href="${pageContext.request.contextPath }/addForward.action">写信</a>
	<a href="${pageContext.request.contextPath }/executeLearning.action">个人学习需求</a>
	<a href="${pageContext.request.contextPath }/recordBehavior.action">用户学习记录</a>
	<a href="${pageContext.request.contextPath }/prepareUserStoreAction.action">用户学习收藏</a>
	<a href="${pageContext.request.contextPath }/gotoSearch.action">全文检索</a>

</body>
</html>
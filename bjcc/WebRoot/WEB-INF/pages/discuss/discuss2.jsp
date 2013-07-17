<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>视频相关评论</title>
		<link rel=stylesheet href="${pageContext.request.contextPath }/css/style3.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/discuss.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.rater.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/Cookies.Class.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ssoLogin.js"></script>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript">
		
			//跳转到登录页面
			$(function() {
				if(!<s:property value="loginFlag"/>){
					alert("对不起，您还没有登录，请先登录！");
					document.getElementById("login").click();
				}
				var success = $("#success").val();
				if (success.length > 0) {
					alert("您的评论已经成功提交，感谢您的参与！");
					$("#success").val("");
				}
				var logInfo = $("#logInfo").val();
				$("#pingbtn").click(function() {
						ssoLogin(function() {
							$("#form").submit();
						});
					});
			});
		</script>
	</head>

	<body>
		<div class="spbf_ct1">
			<a href="<s:property value="loginUrl"/>" target="_top" id="login" style="display: none;"></a>
			<form id="form" action="${pageContext.request.contextPath }/createDiscuss.action" method="post">
				<input type="hidden" id="total" value="<s:property value='total'/>">
				<input type="hidden" id="avg" value="<s:property value='score'/>">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					style="line-height: 20px;">
					<tr>
						<td height="31" background="images/spbf_tt.gif" class="spbf_tt">
							<img src="images/spbfq_tt1.gif" width="13" height="11" />
							视频相关评论
						</td>
					</tr>
					<tr>
						<td>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="5" style="margin-top: 10px;">
								<tr>
									<td>
										<div style="float: left; margin-right: 25px;">
											<h4 style="font-size: 14px;">
												你的评分：
												<span id="choosingmark">当前默认评分是<strong
													class="pingfen">3</strong>分</span>
											</h4>
											<div id="thismark"></div>
										</div>
										<div style="float: left;">
											<h4 style="font-size: 14px;">
												网友评分：
												<span id="pnum"></span>
											</h4>
											<div id="curmark"></div>
										</div>
										<div style="clear: both;"></div>
									</td>
								</tr>
								<tr>
									<td height="60" align="center" valign="middle"
										bgcolor="#f9f9f9" style="border: #dadada solid 1px;">
										<textarea name="content" id="vcmword"
											style="width: 580px; height: 40px;"></textarea>
									</td>
								</tr>
								<tr>
									<td height="25" align="right" valign="middle">
										<input type="button" id="pingbtn" value="提交评分与评论" />
									</td>
								</tr>
								<tr>
									<td height="25" align="left" valign="middle" bgcolor="#f9f9f9">
										&nbsp;&nbsp;&nbsp;总共有
										<s:property value="total" />
										条评论
								</tr>
								<tr>
									<td height="25" align="left" valign="middle">
										<s:iterator var="discuss" value="list" id="dis" status="st">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0"
												style="border-bottom: #dadada dashed 1px; line-height: 20px;">
												<tr>
													<td width="10%" rowspan="3" align="left" valign="middle">
														<img src="images/touxinag.gif" width="48" height="48"
															style="padding: 1px; border: #dadada solid 1px;" />
													</td>
													<td width="90%" height="20" align="left" valign="middle">
														<a href="#" class="kjdb_word1"><s:property
																value="discussUser" />
														</a>
													</td>
												</tr>
												<tr>
													<td height="20" align="left" valign="middle">
														<s:property value="content" />
													</td>
												</tr>
												<tr>
													<td height="20" align="left" valign="middle"
														style="color: #999999">
														<s:property value="creationDate" />
													</td>
												</tr>
												<tr>
													<td align="left" valign="middle">
														&nbsp;
													</td>
													<td height="20" align="right" valign="middle"
														style="color: #999999"></td>
												</tr>
											</table>
										</s:iterator>
										<input type="hidden" name="logInfo" id="logInfo"
											value="<s:property value='logInfo'/>" />
										<input type="hidden" name="grade" id="score" value="" />
										<input type="hidden" name="articleID" id="articleID"
											value="<s:property value='articleID'/>" />
										<input type="hidden" name="type" id="type"
											value="<s:property value='type'/>" />
										<input type="hidden" name="siteId" id="siteId"
											value="<s:property value='siteId'/>" />
										<input type="hidden" name="success" id="success"
											value="<s:property value='success'/>" />
										<div class="kjdb_ct_1"
											style="text-align: center; margin-bottom: 8px; border: none;">
											<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>

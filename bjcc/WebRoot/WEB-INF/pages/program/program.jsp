<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>北京长城网</title>
		<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/program.js"></script> 
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
		<script> 
			var s = 8;/*可以改变收缩与展开的速度,试着修改看看效果*/
			var minheight = 35;/*可以改变收缩后的高度,试着修改看看效果*/
			var maxheight = 380;/*可以改变展开的最大高度,试着修改看看效果*/
				
			function shoppingcat() {
				var key = $("#key").text();
				alert(key);
				if (key == "展开") {
					$("#content").slideDown();
					$("#key").text("关闭");
				}
				if (key == "关闭") { 
					$("#content").slideUp();
					$("#key").text("展开");
		
				} 
			}
		</script>
		<style type="text/css">
			.search_item {
				width: 620px;
				height: auto;
				padding-bottom: 4px;
				margin-left: auto;
				margin-right: auto;
				font-size: 12px;
			}
			.search_item dl {
				padding: 0;
				margin-top: 0;
				margin-bottom: 0;
				clear: both;
				padding: 2px 0;
				*padding: 4px 0;
			}
			.search_item dt,dd {
				display: block;
				float: left;
				width: auto;
				padding: 0;
				margin: 1px 0;
				*margin: 3px 0;
				vertical-align: middle;
			}
			.search_item dt {
				height: 14px;
				font-weight: bold;
				color: #333333;
				width:80px;
			}
			.search_item dd {
				width:500px;
				*width:520px;
				color: #005AA0;
				margin-right: 2px;
				*margin-right: 5px;
			}
			.search_item a {
				cursor: pointer;
			}
			.search_item dd div{
				float: left; 
				white-space: nowrap;
				margin:0 10px 5px 0;
			}
			
			.seling {
				color: #FF0000;
			}
			.seled {
				background-color: #fbe8c7;
			}
			.span {
				padding-top: 70px;
				padding-right: 0px;
				padding-bottom: 160px;
				padding-left: 179px;
				font-size: 14px;
			}
			.slide{
				width: 98%;
				font-size: 12px;
				padding-right: 25px;
				*padding-right: 40px; 
				text-align: center;
			}
			.video_condi{
				margin-left: 6x;
				*margin-left: 20px;
			}
		</style> 
	</head>
		<body style="background-image:url('');">
			<form action="${pageContext.request.contextPath}/programAction.action" id="proForm" method="post" name="proForm">
				<input type="hidden" id="sourceOrg" name="condiBean.sourceOrg" value="<s:property value='condiBean.sourceOrg'/>" />
				<input type="hidden" id="date" name="condiBean.date" value="<s:property value='condiBean.date'/>" />
				<input type="hidden" id="source" name="condiBean.source" value="<s:property value='condiBean.source'/>" />
				<input type="hidden" id="tag" name="condiBean.tag" value="<s:property value='condiBean.tag'/>" />
				<input type="hidden" id="form" name="condiBean.form" value="<s:property value='condiBean.form'/>" />
				<input type="hidden" id="audien" name="condiBean.audien" value="<s:property value='condiBean.audien'/>" />
				<input type="hidden" name="showFlag" value="<s:property value='showFlag'/>" />
				<!-- hidden 检索条件 -->
					<div class="Contentbox">
						<div class="search video_condi" style="height: auto;" id="content">
							<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="40" align="right" valign="middle">
										<a id="reset" style="font-size: 12px;" class="sxtj">重置筛选条件</a>
									</td>
								</tr>
							</table>
							<div id="filter" class="search_item">
								<dl>
									<%String str=String.format("%tY", new Date()); 
							   long year=Long.parseLong(str);
							   %>

									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：
									</dt>
									<dd>
										<div class="items">
											<a class="f">全部</a>
										</div>
										<div class="items">
											<a id=""><%=year %></a>
										</div>
										<div class="items">
											<a><%=year-1 %></a>
										</div>
										<div class="items">
											<a><%=year-2 %></a>
										</div>
										<div class="items">
											<a><%=year-3 %></a>
										</div>
									</dd>
								</dl>
								
								<dl>
									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签：
									</dt>
									<dd>
										<div>
											<a class="f" fieldId="5"> 全部</a>
										</div>
										<s:iterator var="item" value="itemList" id="item" status="st">
											<s:if test="#item.conditionId==5">
												<div>
													<a id="<s:property value="id" />" fieldId="5"><s:property value="value" /></a>
												</div> 
											</s:if>
										</s:iterator>
									</dd>
								</dl>
								
								<dl>
									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										媒体类型：
									</dt>
									<dd>
										<div>
											<a class="f" fieldId="2">全部</a>
										</div>
										<s:iterator var="item" value="itemList" id="item" status="st">
											<s:if test="#item.conditionId==2">
												<div>
													<a id="<s:property value="id" />" fieldId="2"> <s:property value="value" /></a>
												</div>
											</s:if>
										</s:iterator>
									</dd>
								</dl>
							</div>
							<div id="slideDiv" class="search_item" style="display:
							<s:if test="'T'.toString()!=showFlag">
								 none;
							</s:if>
							<s:else>
								block;
							</s:else>
							">
								<dl>
									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										提供单位：
									</dt>
									<dd>
										<div class="items">
											<a class="f" fieldId="1" >全部</a>
										</div>
										<s:iterator var="item" value="itemList" id="item" status="st">
											<s:if test="#item.conditionId==1">
												<div>
													<a id="<s:property value="id" />" fieldId="1"><s:property value="value" /></a>
												</div>
											</s:if>
										</s:iterator>
									</dd>
								</dl>
								<dl>
									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										征集途径：
									</dt>
									<dd>
										<div>
											<a class="f" fieldId="3">全部</a>
										</div>
										<s:iterator var="item" value="itemList" id="item" status="st">
											<s:if test="#item.conditionId==3">
												<div>
													<a id="<s:property value="id" />" fieldId="3"><s:property value="value" /></a>
												</div>
											</s:if>
										</s:iterator>
									</dd>
								</dl>
								<dl>
									<dt style="color:#c90e09; font-weight:bold; line-height:25px;margin-top:0px;">
										学习对象：
									</dt>
									<dd>
										<div>
											<a class="f" fieldId="4">全部</a>
										</div>
										<s:iterator var="item" value="itemList" id="item" status="st">
											<s:if test="#item.conditionId==4">
												<div>
													<a id="<s:property value="id" />" fieldId="4"><s:property value="value" /></a>
												</div>
											</s:if>
										</s:iterator>
									</dd>
								</dl>
							</div>
						</div>
						<s:if test="showFlag=='T'.toString()">
							<div class="zkyc"><span id="key" class="slide">关闭</span></div>
						</s:if>
						<s:else>
							<div class="Zkyc1"><span id="key" class="slide">展开</span></div>
						</s:else>

						<div class="search"
							style="border-bottom: #cdcdcd dashed 1px; padding: 8px 0 0 0;">
							<table border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="260" align="center" style="font-size: 12px;" valign="middle">
										关键字：<input type="text" id="keyword" name="condiBean.keyWord" style="width: 200px;" value="<s:property value='condiBean.keyWord'/>" />
									</td>
									<td width="100" align="center" valign="middle">
										<a id="search"><img src="images/sousuo_bt.jpg" width="88" height="24" border="0" />
										</a>
									</td>
								</tr>
							</table>
						</div>



						<div class="Contentbox1">
				<s:if test="comList.size>0">		
			<s:iterator var="program" value="comList" id="pro" status="st">
							<table width="99%" border="0" cellspacing="0" cellpadding="0" >
								<tr>
									<td align="left" valign="middle">
										<div class="kjdb_ct_1" style="margin-left:20px;">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="23%">
														<a href="<s:property value='path'/>" target="_blank"><img src="http://web1.bjcc.gov.cn<s:property value='middle_image'/>" width="159" height="117"
															style="padding: 2px; border: #cdcdcd solid 1px;" /></a>
													</td>
													<td width="77%" align="left" valign="middle">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="20" colspan="2" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">片名：</span>
																	<a href="<s:property value='path'/>" target="_blank"><span class="neirong" style="width: 500px;font-size: 12px;"><s:property value="name"/></span></a>
																</td>
															</tr>
															<tr>
																<td width="50%" height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">主讲：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"><s:property value="speaker"/></span>
																</td>
																<td width="50%" height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">媒体类型：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"><s:property value="form"/></span>
																</td>
															</tr>
															<tr>
																<td height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">片长：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"><s:property value="timeLength"/>
																	</span>
																</td>
																<td height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">节目来源：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"><s:property value="provider"/></span>
																</td>
															</tr>
															<tr>
																<td height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">节目时间：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"><s:property value="createDate"/></span>
																</td>
																<!--<td height="20" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">浏览次数：</span>
																	<span class="neirong" style="width: 200px;font-size: 12px;"></span>
																</td>
															--></tr>
															<tr>
																<td height="40" colspan="2" align="left" valign="middle">
																	<span class="mingcheng" style="font-size: 12px;">视频介绍：</span>
																	<span class="neirong1"
																		style="width: 500px; height: 40px;font-size: 12px;"><s:property value="summary"/></span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>

										</div>  
										
									</td>
								</tr>
							</table>
							</s:iterator>
								<div class="kjdb_ct_1"
											style="text-align: center; margin-bottom: 8px; border: none;">
											<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
									 </div></s:if><s:else>
									 <div style="width:740;height:300;" class="span">抱歉！暂未找到符合条件的内容
									 	<p>建议您试试通过关键字查找喜欢的影片</p>
									 </div>
									 </s:else>
						</div>
					</div>
				</form>
			<map name="Map" id="Map">
				<area shape="rect" coords="606,12,704,39" href="#" />
			</map>
		</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/swfobject_source1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图文直播</title>
<style type="text/css">
	.title2{
		font:14pt bold;
		color:blue;
		margin:5px 0 2px 4px;
	}
</style>
<script type="text/javascript">
	var submitTimer;
	$(function(){
		setAutoTime();
	});
	
	//设定每隔一段时间自动刷新
	function setAutoTime(){
		var intevalTime = $("#refreshTime").val()*1000;
		submitTimer = setInterval(doSendForm, intevalTime);	
	}
	
	//立刻刷新
	function excuteRefresh(){
		clearInterval(submitTimer);
		doSendForm();
		setAutoTime();	
	}
	
	//ajax请求 
	function doSendForm() {
		var reqUrl = "${pageContext.request.contextPath}/liveJson/liveContentJson.action?liveId=" + ${liveId};
		requestByJson(reqUrl, null, callBack);
	}
	//回调函数 
	function callBack(result) {
		refreshContent(result);
		refreshPicture(result);
	}
	
	//刷新文字直播区
	function refreshContent(result){
		var contentBag = $("#cont_lst");
		//清空文字直播区
		contentBag.empty();
		//获取文字列表
		var contentList = $(result["contentList"]);
		if(0 == contentList.size()){
			pictureBag.append("暂无直播文字");
			return;
		}
		//遍历文字列表，把文字添加到指定的容器
		contentList.each(function(){
			var html = '<p style="word-wrap:break-word;word-break:break-all;border-bottom: 1px dotted #cccccc;">'
					 + ' <span class="orange">[' + $(this)[0]["spokesman"] +']:</span> '
					 + $(this)[0]["content"] +'&nbsp;&nbsp;&nbsp; '
					 + '<span style="color: #7F7F7F;font-size: 10px;">[' + $(this)[0]["spokeTime"]
					 + ']</span></p>';
							
				contentBag.append(html);
			});
	}
	
	//刷新图片直播区
	function refreshPicture(result){
		var pictureBag = $("#pic_lst");
		//清空图片直播区
		pictureBag.empty();
		//获取图片列表
		var pictureList = $(result["pictureList"]);
		if(0 == pictureList.size()){
			pictureBag.append("暂无直播图片");
			return;
		}
		pictureList.each(function(){
			var html = '<div style="margin-bottom:5px;">' 
				     + ' <img src="'+ $(this)[0]["url"] + '"'
					 + ' style="width:210px;" alt="' + $(this)[0]["title"] + '"/><br/>'
					 + $(this)[0]["title"] + '<br/>'
					 + '</div>';
		
				pictureBag.append(html);
			});
	}
</script>
</head>
<body>
	<div id="pageContainer" style="width:995px;padding:5px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
					<div id="Tab2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
							<tr>
								<td class="news_title">
									<div style="cursor: pointer;">
										<ul>
											<li id="two1" class="hover">
												大会介绍
											</li>
										</ul>
									</div>
								</td>
								<td align="right" background="images/news2_bg.gif">
									&nbsp;
								</td>
							</tr>
						</table>
						<div class="Contentbox" style="height: 175px; font-size: 14px; line-height: 24px; padding: 10px; padding-bottom: 0px;">
							<s:property value="liveSubject.description" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<br/>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
			<tr>
				<td align="center" class="news_title2">
					图文现场直播
				</td>
				<td align="right" valign="middle" class="tit_dqwz">
					&nbsp;
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="3" cellpadding="2" style="margin-bottom: 5px;" class="Contentbox">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="news1">
						<tr>
							<td width="120" height="29" align="center" class="right_tit">
								文字直播
							</td>
							<td width="643" align="center" background="images/news2_bg.gif">
								间隔：
								<select id="refreshTime" onchange="excuteRefresh()">
									<option value="30">30秒</option>
									<option value="60">1分钟</option>
									<option value="180" selected="selected">3分钟</option>
									<option value="300">5分钟</option>
								</select>
								自动刷新
								<a href="javascript:excuteRefresh()" style="text-decoration: underline;">立即刷新</a>
							</td>
						</tr>
						<tr>
							<td id="cont_lst" colspan="2" valign="top" style="border-top: 1px solid #D6D6D6; line-height: 25px; padding: 8px; font-size: 14px;">
								<s:if test="0==liveSubject.contentList.size()">
									暂无直播文字
								</s:if>
								<s:else>
									<s:iterator value="liveSubject.contentList" var="content" status="sta">
										<p style="word-wrap:break-word;word-break:break-all;border-bottom: 1px dotted #cccccc;">
											<span class="orange">[<s:property value="#content.spokesman"/>]:</span>
											<s:property value="#content.content" escapeHtml="false"/>&nbsp;&nbsp;
											<span style="color: #7F7F7F;font-size: 10px;">[<s:property value="#content.spokeTime"/>]</span>
										</p>
									</s:iterator>
								</s:else>
							</td>
						</tr>
					</table>
				</td>
				<td width="225" valign="top">
					<table width="99%" border="0" cellpadding="0" cellspacing="0" class="news1">
						<tr>
							<td width="101" height="29" align="center" class="right_tit">
								图片直播
							</td>
							<td width="126" align="right" background="images/news2_bg.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td id="pic_lst" colspan="2" align="center" valign="top" style="border-top: 1px solid #D6D6D6;">
								<s:if test="0==liveSubject.pictureList.size()">
									暂无直播图片
								</s:if>
								<s:else>
									<s:iterator value="liveSubject.pictureList" var="picture" status="sta">
										<div style="margin-bottom:5px;">
											<img src="<s:property value="#picture.url"/>"
												 style=" width:210px;"
												 alt="<s:property value="#picture.title"/>"/><br/>
											<s:property value="#picture.title"/><br/>
										</div>
									</s:iterator>
								</s:else>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	</body>
</html>
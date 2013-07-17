 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教学答疑</title>
		<link type="text/css" href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath}/css/style3.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ssoLogin.js"></script>
		<script language="javascript" type="text/javascript">
			function gbcount(message) {
				var max=300;
				if (message.value.length > max) {
					message.value = message.value.substring(0, max);
					$("#remain").val(0);
					alert("留言内容不能超过 300 个字符!");
				} else {
					$("#remain").text(max-message.value.length);
				}
			}
			//切换tab
			function setTab(m,n){ 
				$("#menu" + m + " a").attr("class","");
				$("#menu" + m + " a").eq(n).attr("class","hover");
				$("#main" + m + " ul").hide();
				$("#main" + m + " ul").eq(n).show();
				$("div[id^='page']").hide();
				$("#page" + n).show();
				$("input[name='showTabInx']").val(n);
			}
			//验证输入信息
			function validateInput(){
				var isSubmit = true;
				if(""==$.trim($("#validate").val())){
					$("#reqCode").show();
					isSubmit = false;
				}
				if(""==$.trim($("#cont").val())){
					$("#reqContent").show();
					isSubmit = false;
				}
				if(isSubmit){
					ssoLogin(function(){$("#form").submit();});
				}
			}
			//重填
			function clearContent(){
				$("#cont").val('');
				$("#remain").text(300);
			}
			//刷新验证码
			function refreshValidateCode(){
				var now = new Date().getTime();  
				$("#valImg").attr("src","${pageContext.request.contextPath}/randValidateCode.action?time=" + now);
			}
			//获取请求参数
			function getQueryString(name) {    
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");    
				var r = window.location.search.substr(1).match(reg);    
				if (r != null) {
					return unescape(r[2]);
				} 
				return null;   
		 	}
		 	$(function(){
		 		gbcount($("#cont")[0]);
		 		setTab(1,new Number('<s:property value="showTabInx"/>'));
		 		var error = '<s:property value="errorCode"/>';
		 		if("1"==error){
		 			alert("您尚未登录，请先登录！");
		 		}
		 		if("2"==error){
		 			alert("您输入的验证码不正确，请重新输入！");
		 		}
		 		if("-1"==error){
		 			alert("您的留言已经成功提交！");
		 		}
		 	});
	</script>
	<style type="text/css">
		.passed { color: #999999; }
		.contDiv {
			width:720px;
			word-wrap:word-break;
			word-break:break-all;
		}
	</style>
	</head>
	<body>
		<div id="content" style="width: 750px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="news">
				<tr>
					<td align="center" class="news_title">
						咨询答疑
					</td>
					<td valign="middle" class="tit_dqwz">
						<div class="zxdy_tab" id="menu1">
							<ul>
								<li>
									<a href="#" class="hover" onmousemove="setTab(1,0)">全部留言</a>
								</li>
								<li>
									<a href="#" onmousemove="setTab(1,1)">我的留言</a>
								</li>
							</ul>
						</div>
					</td>
				</tr>
			</table>

			<div class="Contentbox" style="width:748px;" id="main1">
				<ul>
					<s:iterator value="allMessage" var="msg">
						<!-- 留言——Start -->
						<li>
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="39" height="25" align="left" valign="middle">
										<img src="images/zxdy_ly.gif" width="33" height="19" />
									</td>
									<td width="546" align="left" valign="middle">
										<a href="#" class="kjdb_word1"><s:property value="msgName" />
										</a> 说：
										<span style="color: #959595;">
											<s:property value="createDateStr" />
										</span>
									</td>
									<td width="135" height="25" align="right" valign="middle">
										状态：
										<s:if test="status==0">
											<span class="alarm" style='display: inline-block;'>[处理中]</span>
										</s:if>
										<s:else>
											<span class="alarm" style='display: inline-block;'>[已回复]</span>
										</s:else>
									</td>
								</tr>
								<tr>
									<td height="25" colspan="3" align="left" valign="middle">
										<div class="contDiv">
											<s:property value="content" />
										</div>
									</td>
								</tr>
							</table>
						</li>
						<!-- 留言——End -->
						<s:if test="status==1">
							<!-- 回复——Start -->
							<li style="background-color: #fff; margin-top: 0;">
								<table border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46" height="25" align="left" valign="middle">
											<img src="images/zxdy_hf.gif" width="33" height="19" />
										</td>
										<td width="675" height="25" align="left" valign="middle">
											<span style="color:#be1928;" class="kjdb_word1">
											<s:if test="null==replyName||''==replyName"> 专家</s:if>
											<s:else><s:property value="replyName"/></s:else>
											</span> 
											说：
											<span style="color: #959595;"><s:property value="replyDateStr" /></span>
										</td>
									</tr>
									<tr>
										<td height="25" colspan="2" align="left" valign="middle">
											<div class="contDiv">
												<s:property value="replyContent" />
											</div>
										</td>
									</tr>
								</table>
							</li>
							<!-- 回复——END -->
						</s:if>
					</s:iterator>
				</ul>
				<div class="kjdb_ct_1" id="page0" style="text-align: center; margin-bottom: 8px; border: none;">
					<s:if test="1==allPage.currentPage">
						<strong><img src="images/icon5.gif" width="13" height="7" /><span>首 页</span> </strong>｜
						<strong><span>上一页</span></strong>｜
					</s:if>
					<s:else>
						<strong><img src="images/icon5.gif" width="13" height="7" />
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=1&myCurPage=<s:property value="myPage.currentPage"/>&showTabInx=0">首
								页</a> </strong>｜
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage-1"/>&myCurPage=<s:property value="myPage.currentPage"/>&showTabInx=0">上一页</a>
						</strong>｜
					</s:else>
					<s:if test="myPage.currentPage>=myPage.totalPage">
						<strong><span>下一页</span></strong>｜
						<strong><span>尾 页</span></strong>
					</s:if>
					<s:else>
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage+1"/>&myCurPage=<s:property value="myPage.currentPage"/>&showTabInx=0">下一页</a>
						</strong>｜
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.totalPage"/>&myCurPage=<s:property value="myPage.currentPage"/>&showTabInx=0">尾
								页</a>
						</strong> 
					</s:else>
					共 <s:property value="allPage.totalRecord" /> 个问题 共 <s:property value="allPage.totalPage" /> 页/第 <s:property value="allPage.currentPage" /> 页
				</div>
				<!-- 全部留言*****END -->

				<!-- 我的留言*****Start -->
				<ul style="display: none;">
					<s:iterator value="myMessage" var="msg">
						<!-- 留言——Start -->
						<li>
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="39" height="25" align="left" valign="middle">
										<img src="images/zxdy_ly.gif" width="33" height="19" />
									</td>
									<td width="546" align="left" valign="middle">
										<a href="#" class="kjdb_word1"><s:property value="msgName" />
										</a> 说：
										<span style="color: #959595;"> <s:property
												value="createDateStr" /> </span>
									</td>
									<td width="135" height="25" align="right" valign="middle">
										状态：
										<s:if test="status==0">
											<span class="alarm" style='display: inline-block;'>[处理中]</span>
										</s:if>
										<s:else>
											<span class="alarm" style='display: inline-block;'>[已回复]</span>
										</s:else>
									</td>
								</tr>
								<tr>
									<td height="25" colspan="3" align="left" valign="middle">
										<div class="contDiv">
											<s:if test="isAudit==0">
												<span class="passed">[未通过审核]</span>
											</s:if>
											<s:else>
												<span class="passed">[已通过审核]</span>
											</s:else>
											<s:property value="content" />
										</div>
									</td>
								</tr>
							</table>
						</li>
						<!-- 留言——End -->
						<s:if test="status==1">
							<!-- 回复——Start -->
							<li style="background-color: #fff; margin-top: 0;">
								<table border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46" height="25" align="left" valign="middle">
											<img src="images/zxdy_hf.gif" width="33" height="19" />
										</td>
										<td width="675" height="25" align="left" valign="middle">
											<span style="color:#be1928;" class="kjdb_word1">
											<s:if test="null==replyName||''==replyName"> 专家</s:if>
											<s:else><s:property value="replyName"/></s:else>
											</span>  说：
											<span style="color: #959595;"><s:property
													value="replyDateStr" /> </span>
										</td>
									</tr>
									<tr>
										<td height="25" colspan="2" align="left" valign="middle">
											<div class="contDiv">
												<s:property value="replyContent" />
											</div>
										</td>
									</tr>
								</table>
							</li>
							<!-- 回复——END -->
						</s:if>
					</s:iterator>
				</ul>
				<div class="kjdb_ct_1" id="page1" style="text-align: center; margin-bottom: 8px; border: none;display:none;">
					<s:if test="1==myPage.currentPage">
						<strong><img src="images/icon5.gif" width="13" height="7" /><span>首 页</span> </strong>｜
						<strong><span>上一页</span></strong>｜
					</s:if>
					<s:else>
						<strong><img src="images/icon5.gif" width="13" height="7" />
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage"/>&myCurPage=1&showTabInx=1">首
								页</a> </strong>｜
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage"/>&myCurPage=<s:property value="myPage.currentPage-1"/>&showTabInx=1">上一页</a>
						</strong>｜
					</s:else>
					<s:if test="myPage.currentPage>=myPage.totalPage">
						<strong><span>下一页</span></strong>｜
						<strong><span>尾 页</span></strong>
					</s:if>
					<s:else>
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage"/>&myCurPage=<s:property value="myPage.currentPage+1"/>&showTabInx=1">下一页</a>
						</strong>｜
						<strong>
							<a href="${pageContext.request.contextPath}/leaveMessageList.action?typeId=<s:property value="typeId"/>&curPage=<s:property value="allPage.currentPage"/>&myCurPage=<s:property value="myPage.totalPage"/>&showTabInx=1">尾
								页</a>
						</strong> 
					</s:else>
					共 <s:property value="myPage.totalRecord" /> 个问题 共 <s:property value="myPage.totalPage" /> 页/第 <s:property value="myPage.currentPage" /> 页
				</div>
				<!-- 我的留言*****END -->
				
				<!-- 新建留言*****Start -->
				<form id="form" action="${pageContext.request.contextPath}/createLeaveMessage.action" method="post">
					<input type="hidden" name="showTabInx" value="<s:property value="showTabInx"/>"/>
					<input type="hidden" name="typeId" value="<s:property value="typeId"/>"/>
					<input type="hidden" name="curPage" value="<s:property value="allPage.currentPage"/>"/>
					<input type="hidden" name="myCurPage" value="<s:property value="myPage.currentPage"/>"/>
					<div class="wyly" style="margin-left:7px;margin-bottom:2px;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="14%" height="30" align="center" valign="middle"
									bgcolor="#feebcb" style="font-size: 14px; font-weight: bold;">
									&nbsp;&nbsp;我要留言
								</td>
								<td height="30" colspan="2" align="right" valign="middle"
									bgcolor="#feebcb">
									* 请您先
									<span class="kjdb_word1">登录</span>！然后写下您的留言,感谢您对我们的支持&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td height="30" align="center" valign="middle">
									验证码：
								</td>
								<td height="30" colspan="2">
									<input name="valCode" type="text" id="validate" class="passcode" style="vertical-align:middle;" maxlength="4" size="10" />
									<img id="valImg" src="${pageContext.request.contextPath}/randValidateCode.action" style="vertical-align:middle;"/>
									<a class="passcodeLink" onclick="refreshValidateCode()">换一张</a>
									<span id="reqCode" style="color: red; display: none;"><br />请输入验证码</span>
								</td>
							</tr>
							<tr>
								<td height="100" align="center" valign="middle">
									内&nbsp;&nbsp;&nbsp;&nbsp;容：
								</td>
								<td height="100" colspan="2">
									<textarea name="messageContent" rows="2" cols="20" id="cont"
										onkeydown="gbcount(this);" onkeyup="gbcount(this);"
										style="width: 500px; height: 80px;"><s:property value="messageContent"/></textarea>
									<span id="reqContent" style="color: red; display: none;"><br />请输入留言内容</span>
								</td>
							</tr>
							<tr>
								<td height="30" align="center" valign="middle">
									&nbsp;
								</td>
								<td width="53%" height="30">
									最多输入300字符，您还可以输入<span id="remain">300</span>个字符。
								</td>
								<td width="33%">
									<input type="button" name="Submit" onclick="validateInput()" value="添加留言" />
									<input type="button" name="reset" onclick="clearContent()" value="重填" />
								</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>

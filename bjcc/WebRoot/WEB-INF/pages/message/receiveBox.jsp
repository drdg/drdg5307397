<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String showState = request.getAttribute("showState").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style_dxx.css" rel="stylesheet" />
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/program.js"></script> 
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个性化学习_发件箱ϸ</title>

<script type="text/javascript">
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
 var url = "";
 if(n==0){
 	url = '${pageContext.request.contextPath }/receiveForward.action';
 	tli[0].className="hover";
 	tli[1].className="";
 	tli[2].className="";
 }else if(n==1){
 	url = '${pageContext.request.contextPath }/sendForward.action';
 	tli[1].className="hover";
 	tli[0].className="";
 	tli[2].className="";
 }else if(n==2){
 	url = '${pageContext.request.contextPath }/writeForward.action';
 	tli[2].className="hover";
 	tli[0].className="";
 	tli[1].className="";
 	
 }
document.location.href = url;
 }
 	$(function(){
 		var showState = <%=showState%>;
		if(showState=="0"){
			$("#showState").html("只显示未读");
		}else if(showState=="1"){
			$("#showState").html("显示全部");
		}
		});
	function del(receiveMsgId) {
		var url = "${pageContext.request.contextPath }/msg/delByReceiveId.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function delAll() {
		var rids = $(":checkbox[name='ckItem']:checked");
		if (rids.length == 0) {
			alert("请选择要删除的信息");
			return;
		}
		var ids = "";
		var receiveMsgId = [];
		$(rids).each(function() {
			//receiveMsgId.push(item.value);
			ids = ids + $(this).val()+","
		});
		var url = "${pageContext.request.contextPath }/msg/delByReceiveIds.action?rids="+ids;
		document.location.href = url;
	}
	
	function reply(receiveMsgId){
		var url = "${pageContext.request.contextPath }/msg/replyMessage.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function transfer(receiveMsgId){
		var url = "${pageContext.request.contextPath }/msg/transferMessage.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function detail(receiveMsgId){
		var url = "${pageContext.request.contextPath }/msg/detailMessage.action?receiveMsgId="+receiveMsgId;
		document.location.href = url;
	}
	
	function unread(){
		var showState = $("#showState").html();
		if(showState=="只显示未读"){
		var url = "${pageContext.request.contextPath }/unreadMessage.action";
		document.location.href = url;
		}else if(showState=="显示全部"){
		var url = "${pageContext.request.contextPath }/receiveForward.action";
		document.location.href = url;
		}
	}
	function allcheck(){
		if($("#checkbox").attr("checked")==true){
			$("input[name='ckItem']").attr('checked','true');
		}
		if($("#checkbox").attr("checked")==false){
			$("input[name='ckItem']").removeAttr('checked');
		}
	}
	function closewin() {
			window.parent.loadperson();
			parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
		}
</script>
<style>
body{ background-image:none; }
</style>
</head>

<body>
<form action="">

<div class="dxxk">
<div class="dxxkl">
<div class="dxxqh"  id="menu1">
					<ul>
						<li><a href="#" class="hover" onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#"  onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#"  onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
					
</div>	
	<div class="dxxsjx" id="main1">
		<table  border="0" cellspacing="0" style="background: #fff3db; border: 1px solid #ffe3b0; color: #4f4f4f; width: 741px; height:35px; ">
			<tr>
					<td
						style="width: 35px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						<input type="checkbox" name="checkbox" id="checkbox" onclick="allcheck();"/>
					</td>
					<td
						style="width: 60px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						状态
					</td>
					<td
						style="width: 80px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						发信人
					</td>
					<td
						style="width: 118px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						标题
					</td>
					<td
						style="width: 250px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						内容
					</td>
					<td
						style="width: 130px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
						时间
					</td>
					<td style="width: 141px; text-align: center;">
						操作
					</td>
				</tr>
		</table>
		<div class="dxxnr">
			<table width="722" border="0" cellspacing="0" height="86">
			<%String style=""; %>
				<s:iterator value="receiveMessages" id="rms" status="index">
					<s:if test="#index.odd==false">
						<%style="treven"; %>
					</s:if>
					<s:else>
						<%style=""; %>
					</s:else>
				
					<tr class="<%=style%>">
						<td height="30px;" style="width: 35px; text-align: center;">
								<input type="checkbox" name="ckItem" value="<s:property value="#rms.receiveMsgId"/>" />
							</td>
							<td style="width: 60px; text-align: center;">
								<ul>
									<li>
										<s:if test="%{#rms.status==0}"><div style="color: red;">未读</div> </s:if>
										<s:if test="%{#rms.status==1}">已读</s:if>
									</li>
								</ul>
							</td>
							<td style="width: 80px; text-align: center;">
								<ul>
									<li>
										<s:property value="#rms.websiteMessage.sendUsername" />
									</li>
								</ul>
							</td>
							<td style="width: 118px; text-align:left;">
								<ul>
									<li>
										<a href="#" onclick="detail(<s:property value="#rms.receiveMsgId"/>)">
										<span style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 100px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;" ><s:property value="#rms.websiteMessage.msgTitle" /></span>
										</a>
									</li>

								</ul>
							</td>
							<td style="width: 223px;text-align:left;">
								
								<ul>
									<li >
											<span style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH:210px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;" ><s:property value="#rms.websiteMessage.msgContent" /></span>
									</li>

								</ul>
								
							</td>
							<td style="width: 130px; text-align: left;">
								<ul>
									<li>
										<s:property value="#rms.websiteMessage.sendTime" />
									</li>

								</ul>
							</td>
							<td style="width: 121px; text-align: center;">
								<a href="#" onclick="transfer(<s:property value="#rms.receiveMsgId"/>)">转发</a>
								<a href="#" onclick="reply(<s:property value="#rms.receiveMsgId"/>)">回复</a>
								<a href="javascript:void(0);" onclick="del(<s:property value="#rms.receiveMsgId"/>);" >删除</a>
							</td>
					</tr>

				</s:iterator>
					<tr class="table_xuexi_shen">
		                <td colspan="7" align="right" class="p_l_10">
							<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
						</td>
              		</tr>
			</table>


		</div>
		<div class="dban">
				<a href="#"  id="showState" class="ann" onclick="unread()"></a>
				<a href="#" class="ann" style="margin-left: 10px;" onclick="delAll();">批量删除</a>
		</div>
	</div>
</div>
</div>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	function del(id) {
		var url = "${pageContext.request.contextPath }/msg/delMessageById.action?id="+id;
		document.location.href = url;
	}
	function allcheck(){
		if($("#checkbox").attr("checked")==true){
			$("input[name='ckItem']").attr('checked','true');
		}
		if($("#checkbox").attr("checked")==false){
			$("input[name='ckItem']").removeAttr('checked');
		}
	}
	function delAll() {
		var ids = $(":checkbox[name='ckItem']:checked");
		if (ids.length == 0) {
			alert("请选择要删除的信息");
			return;
		}
		var eids = "";
		var id = [];
		$(ids).each(function() {
			eids = eids + $(this).val()+","
		});
		var url = "${pageContext.request.contextPath }/msg/delMessageByIds.action?ids="+eids;
		document.location.href = url;
	}
	function detail(id){
		var url = "${pageContext.request.contextPath }/msg/detailWebMessage.action?id="+id;
		document.location.href = url;
	}
	function closewin() {
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
						<li><a href="#"  onclick="setTab(1,0)">收件箱</a></li>
						<li><a href="#" class="hover" onclick="setTab(1,1)">发件箱</a></li>
						<li><a href="#"  onclick="setTab(1,2)">写信</a></li>
						<li style="margin-left:520px;margin-top: 4px;"><img src="${pageContext.request.contextPath }/images/del.gif" onclick="closewin();" width="12px" height="12px"/></li>
					</ul>
					
</div>	
	<div class="dxxsjx" id="main1">
		<table  border="0" cellspacing="0" style="background: #fff3db; border: 1px solid #ffe3b0; color: #4f4f4f; width: 741px; height:35px; ">
			<tr>
				<td style="width: 35px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
					<input type="checkbox"  name="checkbox" id="checkbox" onclick="allcheck();"/>
				</td>
				<td
					style="width: 73px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
					收信人
				</td>
				<td
					style="width: 100px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
					标题
				</td>
				<td
					style="width: 260px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
					内容
				</td>
				<td
					style="width: 130px; background: url(images/bkbg.gif) no-repeat right; text-align: center;">
					时间
				</td>
				<td style="width: 131px; text-align: center;">
					操作
				</td>
			</tr>

		</table>
		<div class="dxxnr">
			<table width="722" border="0" cellspacing="0" height="86">
			<%String style=""; %>
				<s:iterator value="sendMessage" id="msg" status="index">
					<s:if test="#index.odd==false">
						<%style="treven"; %>
					</s:if>
					<s:else>
						<%style=""; %>
					</s:else>
				
					<tr class="<%=style%>">
						<td height="30" style="width: 35px; text-align: center;">
							<input type="checkbox" name="ckItem" value="<s:property value="#msg.id" />"/>
						</td>
						<td style="width: 80px;text-align: center;">
							<ul>

								<li>
									<span style="DISPLAY: inline-block; OVERFLOW: hidden; WIDTH: 78px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;" >
										<s:iterator value="#msg.listusers" id="receive">
			 								<s:property value="#receive.receiveName" />;
			 							</s:iterator>
			 						</span>
								</li>

							</ul>
						</td>
						<td style="width: 108px; text-align:left;">
							<ul>

								<li>
									<a  href="#" onclick="detail(<s:property value="#msg.id"/>)">
									<span style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 100px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;" ><s:property value="#msg.msgTitle" /></span>
									</a>
								</li>

							</ul>
						</td>
						<td style="width: 260px; text-align:left;">
							<ul>
								<li>
									<span style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 260px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;" ><s:property value="#msg.msgContent" /></span>
								</li>
							</ul>
						</td>
						<td style="width: 130px; text-align: center;">
							<ul>
								<li>
								<s:property value="#msg.sendTime" />
								</li>
							</ul>
						</td>

						<td style="width: 131px; text-align: center;">
							<a href="javascript:void(0);" onclick="del(<s:property value="#msg.id" />);">删除</a>
						</td>

					</tr>

				</s:iterator>
					<tr class="table_xuexi_shen">
		                <td colspan="6" align="right" class="p_l_10">
							<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
						</td>
              		</tr>
			</table>


		</div>
		<div class="dban">
			<a href="#" class="ann" onclick="delAll();">批量删除</a>
		</div>
	</div>
</div>
</div>
</form>
</body>
</html>

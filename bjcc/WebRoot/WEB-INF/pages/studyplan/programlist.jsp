<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant, com.sino.bjcc.common.utility.DateTimeUtil" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String[] programIds = (String[])session.getAttribute("programIds");
	String[] names = (String[])session.getAttribute("names");
	String[] imgurls = (String[])session.getAttribute("imgurls");
	String[] channels = (String[])session.getAttribute("channels");
	String[] dates = (String[])session.getAttribute("dates");
	String[] speakers = (String[])session.getAttribute("speakers");
	String[] paths = (String[])session.getAttribute("paths");
	int len = 0;
	if(null!=programIds) {
		len = programIds.length;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/date/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.cookie.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/programlist.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script language="javascript" type="text/javascript">
	var row_num = 0;
	
	var s=8;/*可以改变收缩与展开的速度,试着修改看看效果*/
	var minheight=35;/*可以改变收缩后的高度,试着修改看看效果*/
	var maxheight=300;/*可以改变展开的最大高度,试着修改看看效果*/
$(function(){
	//if(null != $.cookie("programIds")) {
		//var arrProgramIds = $.cookie("programIds").split("$|@#&$");
		//var arrNames = $.cookie("names").split("$|@#&$");
		//var arrImgurls = $.cookie("imgurls").split("$|@#&$");
		//var arrChannels = $.cookie("channels").split("$|@#&$");
		//var arrSpeakers = $.cookie("speakers").split("$|@#&$");
		//var arrPaths = $.cookie("paths").split("$|@#&$");
	<%if(len>0){%>
		<%for (int i = 0; i < len; i++) {%> 
			addprogram("<%=programIds[i]%>", "<%=names[i]%>", "<%=imgurls[i]%>", "<%=channels[i]%>", "<%=speakers[i]%>", "<%=paths[i]%>", "<%=dates[i]%>");
		<%}%>
	<%} else {%>
		loadprogram();
	<%}%>
		//$(arrProgramIds).each(function(i){
		//	if(""!=arrProgramIds[i]){
		//		addprogram(arrProgramIds[i], arrNames[i], arrImgurls[i], arrChannels[i], arrSpeakers[i], arrPaths[i]);
		//	}
		//});
	//} else {
	//	loadprogram();
	//}
	
	$("#proForm").submit(function(){
		//var programIds = "";
		//var names = "";
		//var imgurls = "";
		//var channels = "";
		//var speakers = "";
		//var paths = "";
		//$("input[name='programIds").each(function(){
	//		programIds = programIds + $(this).val() + "$|@#&$";
		//});
	//	$("input[name='names").each(function(){
		//	names = names + $(this).val() + "$|@#&$";
		//});
		//$("input[name='imgurls").each(function(){
		//	imgurls = imgurls + $(this).val() + "$|@#&$";
		//});
		//$("input[name='channels").each(function(){
		//	channels = channels + $(this).val() + "$|@#&$";
		//});
		//$("input[name='speakers").each(function(){
		///	speakers = speakers + $(this).val() + "$|@#&$";
		//});
		//$("input[name='paths").each(function(){
		//	paths = paths + $(this).val() + "$|@#&$";
		//});
		//$.cookie("programIds", programIds);
		//$.cookie("names", names);
		//$.cookie("imgurls", imgurls);
	//	$.cookie("channels", channels);
		//$.cookie("speakers", speakers);
		//$.cookie("paths", paths);
		var bool = "false";
		submitAsyFormByJson("<%=request.getContextPath()%>/saveTempDataStudyPlanAjaxAction.action", "studyPlanForm", 
				function(data){
			if(data.result=="success") {
				bool = "true";
			}
		});
		if(bool=="true") {
			return true;
		}else {
			return false;
		}
	});
	return false;
});

function loadprogram() {
	var date = "<s:property value='slectDate'/>";
	var url = "${pageContext.request.contextPath }/loadStudyPlanAjaxAction.action";
	var params = {'qryDate':date};
	requestByAjax(url,params,function(data){
		var planlist = data.studyPlanList;
		var programlist = null;
		$(planlist).each(function(i){
			programlist = planlist[i].studyPrograms;
			$(programlist).each(function(j){
				addprogram(programlist[j].programId, programlist[j].programName, programlist[j].imgUrl, programlist[j].programType, programlist[j].speaker, programlist[j].path, date);
			});
		});
		return false;
	});
	return false;
}

function shoppingcat(){
	var key = document.getElementById("key").innerText;
	if(key.indexOf("展开")>=0){
		$("#content").slideDown();
		$("#key").text("关闭");
		$("#key").parent().attr("class","xk_zkyc");
		$("input[name='showFlag']").val("T");
	}else{
		$("#content").slideUp();
		$("#key").text("展开");
		$("#key").parent().attr("class","xk_zkyc1");
		$("input[name='showFlag']").val("F");
	}
	return false;
}

function addprogram(id, name, imgurl, channel, speaker, path, date) {

	if(speaker == null || speaker=="null") {
		speaker = "";
	}
	if(document.getElementById("program_td_" + id)!=null) {
		alert("该课程已经添加");
		return false;
	}
	//td.style.height="100px";
	
	var htm = 
		"<li id = program_td_"+ id +">" +
			"<input type=\"hidden\" name=\"programIds\" value="+id+">" +
			"<input type=\"hidden\" name=\"names\" value="+name+">" +
			"<input type=\"hidden\" name=\"imgurls\" value="+imgurl+">" +
			"<input type=\"hidden\" name=\"channels\" value="+channel+">" +
			"<input type=\"hidden\" name=\"speakers\" value="+speaker+">" +
			"<input type=\"hidden\" name=\"paths\" value="+path+">" +
			"<p>" +
				"<a href="+path+" target=\"_blank\"><img src=\"<%=Constant.PROGRAM_IMG_URL%>"+imgurl+"\" width=\"81\" height=\"61\" class=\"tp_dy\" /></href>" +
				"<a href="+path+" target=\"_blank\" class=\"zj_nrn\">"+name+"</a>" +
				"<a href="+path+" target=\"_blank\"><span class=\"zjys\">主讲："+speaker+"</span></a>" +
			"</p>" +
			"<br />" +
			"<input style=\"float: right\" onchange=\"return validate('"+id+"','"+date+"', this);\" class=\"Wdate\" size=\"9\" name=\"dates\" type=\"text\" value="+date+" onClick=\"WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'<%=DateTimeUtil.getNowStr() %>'})\">"+
			"<a href=\"#\" onclick=\"return delprogram("+id+");\" ><img src=\"images/xk_sc_bt.gif\" border=\"0\" /></a>" +
    	"</li>";
  	$("#programlist").append(htm);
	return false;
}

function validate(programid, date, obj) {
	var url = "${pageContext.request.contextPath }/validateProgramStudyPlanAjaxAction.action";
	var params = {'qryDate':obj.value, 'programId':programid};
	requestByAjax(url,params,function(data){
		if(data.result!="success") {
			alert("该课程在"+obj.value+"的学习计划中已经存在!");
			obj.value = date;
		}
	});
	return false;
}

function delprogram(id){
	$("#program_td_"+id).remove();
	return false;
}

function delallprogram() {
	$('li[id^=program_td_]').remove();
	return false;
}

function saveprogram(){
	if(document.getElementsByName("programIds").length == 0) {
//		alert("请选择要加入学习计划的课程");
		var url = "${pageContext.request.contextPath }/delStudyPlanAjaxAction.action";
		var params = {'qryDate':$("#studyTime").val()};
		requestByAjax(url,params,function(data){
			if(data.result=="success") {
				$.cookie("select_succ_flag", "success");
				$.cookie("isdelete", "yes");
				$.cookie("studyPlanId", data.studyPlanId);
				window.close();
			}else {
				$.cookie("select_succ_flag", "failed");
				alert("保存学习计划失败，请重新添加");
			}
		});
		return false;
	}
	submitFormByJson("<%=request.getContextPath()%>/save2StudyPlanAjaxAction.action", "studyPlanForm", 
		function( data ) {
			if (data.result=="success") {
				$.cookie("select_succ_flag", "success");
				$.cookie("programIds", null);
				$.cookie("names", null);
				$.cookie("imgurls", null);
				$.cookie("channels", null);
				$.cookie("speakers", null);
				$.cookie("paths", null);
				window.close();
			} else {
				$.cookie("select_succ_flag", "failed");
				alert("保存学习计划失败，请重新添加");
			}
			return false;
		}
	);
	return false;
}
</script>
<style type="text/css">

body{ background-image:none; }

#filter {
	height: auto;
	margin-left: auto;
	margin-right: auto;
	font-size: 12px;
}

#filter ul {
	padding: 0;
	margin-top: 0;
	margin-bottom: 0;
	clear: both;
	padding: 4px 0;
}

#filter li {
	color: #005AA0;
	margin-right: 8px;
}

#filter a {
	cursor: pointer;
}

.seling {
	color: #FF0000;
}

.seled {
	background-color: #fbe8c7;
	padding: 5px;
}
</style>
</head>
		<body>
		<div class="contant">
			<div style="margin:auto; overflow:hidden;">
				<iframe src="<%=Constant.HEAD_URL %>" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
			</div>
			
			
			<div class="study_tt">
			<div class="two_title_2">&nbsp;&nbsp;&nbsp;&nbsp;选&nbsp;&nbsp;&nbsp; 课</div>
		 </div>
		 
		 
			<div class="xk_tab">
				<div class="xk_tab_tt" id="menu_a1">
					<ul>
						<li><a href="#" class="hover" onmousemove="setTab1(1,0)">猜你喜欢</a></li>
						<li><a href="#" onmousemove="setTab1(1,1)">大家都看</a></li>
						<li><a href="#" onmousemove="setTab1(1,2)">热点推荐</a></li>
					</ul>
				</div>
				<div class="xk_tab_ct" id="main_a1">
					<ul>
					 	<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">创意农业思考与探索</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">历史文献纪录片《信仰》</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">城乡统筹与经济发展</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
					</ul>
					
					<ul style="display:none">
					 	<li>暂无内容</li>
					</ul>
					
					<ul style="display:none">
					 	<li>暂无内容</li>
					</ul>
				</div>
			</div>
			
			<form action="${pageContext.request.contextPath}/programAction.action" id="proForm" method="post" name="proForm">
				<input type="hidden" id="sourceOrg" name="condiBean.sourceOrg" value="<s:property value='condiBean.sourceOrg'/>" />
				<input type="hidden" id="date" name="condiBean.date" value="<s:property value='condiBean.date'/>" />
				<input type="hidden" id="source" name="condiBean.source" value="<s:property value='condiBean.source'/>" />
				<input type="hidden" id="tag" name="condiBean.tag" value="<s:property value='condiBean.tag'/>" />
				<input type="hidden" id="form" name="condiBean.form" value="<s:property value='condiBean.form'/>" />
				<input type="hidden" id="audien" name="condiBean.audien" value="<s:property value='condiBean.audien'/>" />
				<input type="hidden" name="showFlag" value="<s:property value='showFlag'/>" />
				<input type="hidden" name="selectTag" value="<s:property value='selectTag'/>" />
				<input type="hidden" name="slectDate" value="<s:property value='slectDate'/>" />
				
	<div class="xk_ct" id = "filter" style="height: auto;">
		<div class="search" id="content" style="height: auto;
			<s:if test="'T'.toString()!=showFlag">
				display: none;
			</s:if>
			margin-left:20px;"
		>
			<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
				 <tr>
					<td height="40" align="right" valign="middle"><a href="#" id="reset" class="sxtj">重置筛选条件</a></td>
				  </tr>
				  <tr>
					<td align="left" valign="middle">
						<div class="sstj">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<%String str=String.format("%tY", new Date()); 
							   long year=Long.parseLong(str);
							   %>
							<tr>
								<td width="10%" align="center" valign="top" class="leibie">
							    时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</td>
								<td width="90%" align="left" valign="top">
									<ul>
										<li><a class="f">全部</a></li>
										<li><a id=""><%=year %></a></li>
										<li><a ><%=year-1 %></a></li>
										<li><a ><%=year-2 %></a></li>
										<li><a ><%=year-3 %></a></li>
									</ul>
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<td align="left" valign="middle">
					<div class="sstj">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="10%" align="center" valign="top" class="leibie">
							   		 提供单位：</td>
							<td width="90%" align="left" valign="top">
								<ul>
									<li><a fieldId="1" class="f">全部</a></li>
									<s:iterator var="item" value="itemList" id="item" status="st">
										<s:if test="#item.conditionId==1">
											<li><a id="<s:property value="id" />" fieldId="1"> <s:property value="value" /></a></li>
										</s:if>
									</s:iterator>
								</ul>
							</td>
						</tr>
					</table>
					</div>
					</td>
				</tr>
				
				<tr>
					<td align="left" valign="middle">
						<div class="sstj">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="10%" align="center" valign="top" class="leibie">
									媒体类型：</td>
								<td width="90%" align="left" valign="top">
										<ul>
											<li><a fieldId="2" class="f">全部</a></li>
											<s:iterator var="item" value="itemList" id="item" status="st">
												<s:if test="#item.conditionId==2">
												 	<li>
														<a id="<s:property value="id" />" fieldId="2"> <s:property value="value" /> &nbsp;&nbsp;</a>
													</li>
												</s:if>
											</s:iterator>
										</ul>
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
				<tr>
					<td align="left" valign="middle">
						<div class="sstj">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="10%" align="center" valign="top" class="leibie">
									征集途径：</td>
								<td width="90%" align="left" valign="top">
										<ul>
											<li><a fieldId="3" class="f">全部</a></li>
											<s:iterator var="item" value="itemList" id="item" status="st">
												<s:if test="#item.conditionId==3">
												 	<li>
														<a id="<s:property value="id" />" fieldId="3"> <s:property value="value" /> &nbsp;&nbsp;</a>
													</li>
												</s:if>
											</s:iterator>
										</ul>
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<td align="left" valign="middle">
						<div class="sstj">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="10%" align="center" valign="top" class="leibie">
									学习对象：</td>
								<td width="90%" align="left" valign="top">
										<ul>
											<li><a fieldId="4" class="f">全部</a></li>
											<s:iterator var="item" value="itemList" id="item" status="st">
												<s:if test="#item.conditionId==4">
												 	<li>
														<a id="<s:property value="id" />" fieldId="4"> <s:property value="value" /> &nbsp;&nbsp;</a>
													</li>
												</s:if>
											</s:iterator>
										</ul>
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<td align="left" valign="middle">
						<div class="sstj">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="10%" align="center" valign="top" class="leibie">
									标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签：</td>
								<td width="90%" align="left" valign="top">
										<ul>
											<li><a fieldId="5" class="f">全部</a></li>
											<s:iterator var="item" value="itemList" id="item" status="st">
												<s:if test="#item.conditionId==5">
												 	<li>
														<a id="<s:property value="id" />" fieldId="5"> <s:property value="value" /> &nbsp;&nbsp;</a>
													</li>
												</s:if>
											</s:iterator>
										</ul>
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
			</table>
		</div>			
	</div>
		<s:if test="showFlag=='T'.toString()">
			<div class="xk_zkyc" onclick="shoppingcat()" style="text-align: center;"><span id="key" style="width:98%;font-size: 12px; text-align: center;margin-right: 25px;">关闭</span></div>
		</s:if>
		<s:else>
			<div class="xk_zkyc1" onclick="shoppingcat()" style="text-align: center;"><span id="key" style="width:98%;font-size: 12px;text-align: center;margin-right: 25px;">展开</span></div>
		</s:else>
		
		<div class="search" style="padding:8px 0 0 0;">
			<table border="0" align="center" cellpadding="0" cellspacing="0"  >
            	<tr>
                	<td width="260" align="center" valign="middle">关键字：
                    	<input type="text" name="condiBean.keyWord" style=" width:200px;" value="<s:property value='condiBean.keyWord'/>"/>
                    </td>
                  
                	<td width="100" align="center" valign="middle">
                		<a id = "search" href="#" ><img src="${pageContext.request.contextPath }/images/sousuo_bt.jpg" width="88" height="24" border="0" /></a>
                	</td>
           		</tr>
          	</table>
		</div>

		<div class="xk_ct_list">
			<ul>
				<s:iterator var="program" value="comList" id="pro" status="st">
					<li>
						<span class="xk_tab_ct_span1"><a href="<s:property value='path'/>" target="_blank"><img src="<%=Constant.PROGRAM_IMG_URL%><s:property value='middle_image'/>" border="0" style="width: 100%; height: 100%;"/></a></span>
						<span class="xk_tab_ct_span2"><a href="<s:property value='path'/>" target="_blank"><s:property value="name"/></a></span>
						<span class="xk_tab_ct_span3"><a href="<s:property value='path'/>" target="_blank">主讲：<s:property value="speaker"/></a></span>
						<span class="xk_tab_ct_span4"><a href="#" onclick="return addprogram('<s:property value="vId"/>', '<s:property value="name"/>', '<s:property value='middle_image'/>', '<s:property value="channel"/>', '<s:property value="speaker"/>', '<s:property value="path"/>', '<s:property value="slectDate"/>');"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
				</s:iterator>
			</ul>
		</div>
		
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="kjdb_ct_1" style="text-align: center; margin-top: 8px;">
						<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
					</div>
				</td>
			</tr>
		</table>
		
	</form>
	
	
	
	<div class="copyright">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height:24px;">
		  <tr>
			<td height="26" align="center" valign="middle" background="images/bottom_bg.gif" style="color:#fff;"><a href="#" class="nav_word">关于我们</a> | <a href="#" class="nav_word">网站地图</a> | <a href="#" class="nav_word">设为首页</a> | <a href="#" class="nav_word">加入收藏</a> | <a href="#" class="nav_word">联系我们</a> | <a href="#" class="nav_word">免责声明</a></td>
		  </tr>
		  <tr>
			<td height="120" align="center" valign="middle">主办：北京市农村党员干部现代远程教育工作领导协调小组办公室<br />
			  技术支持：北京市农林科学院农业科技信息研究所<br />
			  北京长城网：<a href="../lxwm/20100726/16702.html" target="_blank">http://www.bjcc.gov.cn</a><br />
		    备案/许可证编号为：京ICP备09056845号</td>
		  </tr>
	  </table>
	</div>
<form id = "studyPlanForm" action="${pageContext.request.contextPath }/save2StudyPlanAjaxAction.action">
	<input type="hidden" id="studyTime" name = "qryDate" value="<s:property value='slectDate'/>"/>
	<div class="xklb_fd">
		<div class="xklb_fd_tt">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="81%" height="28" align="left" valign="middle">选课列表</td>
				<td width="12%" height="28" align="right" valign="middle"><a href="#" onclick="return saveprogram();"><img src="${pageContext.request.contextPath }/images/xk_qbbc.gif" width="94" height="21" border="0" /></a></td>
				<td width="7%" height="28" align="right" valign="middle"><a href="#" onclick="return delallprogram();"><img src="${pageContext.request.contextPath }/images/xk_qingkong.gif" width="58" height="21" border="0" /></a></td>
				
			  </tr>
		  </table>
		</div>
		
		<div class="xklb-fd_ct" >
			<ul id = "programlist"></ul>
		</div>
	</div>
</form>
	</div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sino.bjcc.common.utility.DateTimeUtil, com.sino.system.constant.Constant"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/date/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.cookie.js"></script>
<script language="javascript" type="text/javascript">
function closewin() {
	parent.window.closeiframe();
}

function baocun() {
	submitAsyFormByJson("<%=request.getContextPath()%>/save2StudyPlanAjaxAction.action", "studyPlanForm", function(data) {
		if(data.result=="success") {
			$.each(data.studyPlanList, function(i, plan){
					if(plan.cnt=="0") {
						parent.window.frames["studyplan"].removetask(plan.studyPlanId);
					} else {
						parent.window.frames["studyplan"].addplan(plan);
					}
				}
			);
			submitAsyFormByJson("<%=request.getContextPath()%>/clearTempDataStudyPlanAjaxAction.action", "studyPlanForm", 
					function(data){
				if(data.result=="success") {
					$.cookie("select_succ_flag", "init");
					closewin();
				}
			});
		} else {
			alert("保存失败");
		}
	});
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

function qingkong() {
	$('#divOne ul li').remove();
	return false;
}

function delprogram(id) {
	$('#' + id).remove();
	return false;
}
</script>
<style type="text/css">
	body{ background-image:none;}
</style>

</head>

<body style="overflow: hidden;">

<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="news">
   	<tr>
		<td width="30%" align="center" class="news_title">已选课程 </td>
		<td width="70%" align="center" valign="middle" class="xxjh_data">&nbsp;</td>
		<td align="right" class="xxjh_data" style="padding-right: 10px;"><img src="${pageContext.request.contextPath }/images/del.gif" width="12px" height="12px" onclick="return closewin();"/></td>
	</tr>
</table>
<div class="xklb_fd_tt" style="width: 100%">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="77%" height="28" align="left" valign="middle">选课列表</td>
			<td width="13%" height="28" align="right" valign="middle"><a href="#" onclick="return baocun();"><img src="images/xk_qbbc.gif" width="94" height="21" border="0" /></a></td>
			<td width="10%" height="28" align="right" valign="middle"><a href="#" onclick="return qingkong();"><img src="images/xk_qingkong.gif" width="58" height="21" border="0" /></a></td>
		</tr>
	</table>
</div>


<form id = "studyPlanForm" action="${pageContext.request.contextPath }/save2StudyPlanAjaxAction.action">

<div id="divOne" class="xklb-fd_ct2" style="width: 100%; height:430px; overflow-x:hidden; overflow-y:auto; ">
    <ul>
      	<s:iterator value="studyPlanList" id="plan">
      		<input type="hidden" name="qryDate" value="<s:property value="#plan.studyTime"/>">
			<s:iterator value="#plan.studyPrograms" id="program">
				
				<li id="<s:property value="#program.programId"/>">
				<input type="hidden" name="programIds" value = "<s:property value="#program.programId"/>">
				<input type="hidden" name="names" value = "<s:property value="#program.programName"/>">
				<input type="hidden" name="channels" value = "<s:property value="#program.programType"/>">
				<input type="hidden" name="imgurls" value = "<s:property value="#program.imgUrl"/>">
				<input type="hidden" name="speakers" value = "<s:property value="#program.speaker"/>">
				<input type="hidden" name="paths" value = "<s:property value="#program.path"/>">
					<p>
						<a href="<s:property value="#program.path"/>" target="_blank"><img src="<%=Constant.PROGRAM_IMG_URL%><s:property value="#program.imgUrl"/>" width="81" height="61" class="tp_dy" /></a>
      					<a href="<s:property value="#program.path"/>" target="_blank" class="zj_nrn"><s:property value="#program.programName"/></a>
      					<a href="<s:property value="#program.path"/>" target="_blank"><span class="zjys">主讲：<s:property value="#program.speaker"/></span></a></p><br />
      					<input style="float: right" class="Wdate" onchange="return validate('<s:property value="#program.programId"/>', '<s:property value="qryDate"/>', this);" size="9" name="dates" type="text" value="<s:property value="qryDate"/>" onClick="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'<%=DateTimeUtil.getNowStr() %>'})">
      					<a href="#" onclick="return delprogram('<s:property value="#program.programId"/>');"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a>
				</li>
			</s:iterator>
		</s:iterator>
    </ul>
</div>
</form>
</body>
</html>
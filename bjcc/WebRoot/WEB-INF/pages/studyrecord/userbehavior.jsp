 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>个体用户学习记录</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/program.js"></script>
<script type='text/javascript' 
			src='${pageContext.request.contextPath }/js/jquery.cookie.js'></script> 
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js" charset="GB2312"></script>
<script language="javascript" type="text/javascript" >
   function addpingce(id){
   submitFormByJson("<%=request.getContextPath()%>/jumpEvaluation.action?testState=1&programId="+id, "from1", 
		function(data){
			if(data=="success"){
				 window.open("<%=request.getContextPath()%>/executeEvaluation.action?testState=1&programId="+id);
				 interval = setInterval(scanStudyPlan, 1000);
			}
			if(data=="successbaocun"){
				window.open("<%=request.getContextPath()%>/executeBaocunEvaluation.action?testState=1&programId="+id);
				interval = setInterval(scanStudyPlan, 1000);
			}
			if(data=="successtijiao"){
			window.open("<%=request.getContextPath()%>/executeWriteEvaluation.action?testState=1&programId="+id);
			}
			if(data=="fail"){
			alert("该课程不存在评测试卷！");
			return false;
			}
		}
	);
	return false;
   }
   function addchengxiao(id){
  	var ubrId= $("#ubrId").val();
    parent.parent.showTipsWindown(600, 445,"${pageContext.request.contextPath }/jumpResult.action?studyType=1&programId="+id+"&ubrId="+ubrId);
    return false;
   }
   function scanStudyPlan(){
   	if($.cookie("testState") == "tijiao") {
   		$("form:first").attr("target","_self");
		$("form:first").submit();
   		clearInterval(interval);
   		$.cookie("testState", null);
   	}else if($.cookie("testState") == "baocun"){
   		$("form:first").attr("target","_self");
		$("form:first").submit();
   		clearInterval(interval);
   		$.cookie("testState", null);
   	}else{
   		$.cookie("testState", null);
   	}
   }
</script>
</head>
<style>

body{ background-image:none; }
</style>
<body>
<form action="" method="post" name="from1" id="from1" >
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
              <tr>
                <td width="224" align="left" class="table_xuexi_title p_l_10">学习主题</td>
                <td width="130" class="table_xuexi_title">学习开始时间</td>
                <td width="130" class="table_xuexi_title">学习结束时间</td>
                <td width="71" class="table_xuexi_title">学习时长</td>
                <td width="71" class="table_xuexi_title">学习评测</td>
                <td width="71" class="table_xuexi_title">学习成效</td>
                </tr>
</table>
<div style="height: 160px;" class="table_xuexi">
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                <s:iterator value="userBehaviors" var="userBehavior">
              	<tr style="height: 20px;">
                <td width="224" height="20" class="p_l_10" align="left">
                <SPAN style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 224px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;"><s:property value="#userBehavior.resourcesName"/></SPAN></td>
                <td width="130"><s:date name="#userBehavior.visitStarttime" format="MM/dd/yy HH:mm:ss"/></td>
                <td width="130"><s:date name="#userBehavior.visitEndtime" format="MM/dd/yy HH:mm:ss"/></td>
                <td width="71"><s:property value="#userBehavior.visitLong"/>分钟</td>
                <td width="71">
<!--               <s:property value="#userBehavior.testState"/>-->
                <s:if test="%{#userBehavior.testState==0}">
                <a href="#"><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15"  onClick="return addpingce(<s:property value="#userBehavior.resourcesId"/>);" /></a>
                </s:if>
                <s:if test="%{#userBehavior.testState==1}">
                <a href="#"><img src="${pageContext.request.contextPath }/images/xxpc_ico1.gif" width="14" height="15"  onClick="return addpingce(<s:property value="#userBehavior.resourcesId"/>);" /></a>
                </s:if>
                </td>
                <td width="71">
                <input type="hidden" name="ubrId" id="ubrId" value="<s:property value="#userBehavior.ubrId"/>">
                <s:if test="%{#userBehavior.resultState==0}">
                <a href="#"><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16"  onClick="return addchengxiao(<s:property value="#userBehavior.resourcesId"/>);" /></a>
                </s:if>
                <s:if test="%{#userBehavior.resultState==1}">
                <a href="#"><img src="${pageContext.request.contextPath }/images/xxcx_ico1.gif" width="16" height="16"  onClick="return addchengxiao(<s:property value="#userBehavior.resourcesId"/>);" /></a>
                </s:if>
                </td>
                </tr>
             </s:iterator>
</table>
</div>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
              <tr class="table_xuexi_shen">
                <td colspan="6" align="right" class="p_l_10">
				<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
				</td> 
              </tr>
</table>
    </form>
</body>
</html>
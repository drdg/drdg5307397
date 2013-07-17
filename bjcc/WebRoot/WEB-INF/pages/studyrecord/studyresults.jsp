<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String resultState = request.getAttribute("resultState").toString();
String programName = request.getAttribute("programName").toString();
 %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="css/study.css" rel="stylesheet" />
<link type="text/css" href="css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
</head>
<script type="text/javascript" language="javascript">
	$(function(){
		$("#studyType").attr("value",${studyType}); 
		}); 
	function save(){
		var resultsContent = $("#resultsContent").val();
		var resultState = $("#resultState").val();
		if(resultsContent == null||resultsContent == ""){
			alert("需求内容不能为空 ！");
			return false;
			}
		if(checklength($("#resultsContent"), 500, '成效不能超过500个长度，点确定只截取前500位，点取消继续编辑成效？') == false) {
				return false;
			}
		if(resultState == '0'){
			submitFormByJson("<%=request.getContextPath()%>/saveUserRecordResult.action", "from1", callBacksave);
			}
		if(resultState == '1'){
			submitFormByJson("<%=request.getContextPath()%>/updateUserRecordResult.action", "from1", callBacksave);
		}
		

	}
	var callBacksave = function(data){
		var studyType=$("#studyType").find("option:selected").val();
			if(data=="success"){
				if(studyType==1){
				window.parent.frames["xxjl"].refreuser();
				}else if(studyType==2){
				window.parent.frames["xxjl"].refretrain();
				}
				window.parent.closeiframe();
			}else if(data=="updatesuccess"){
				if(studyType==1){
					window.parent.frames["xxjl"].refreuser();
				}else if(studyType==2){
					window.parent.frames["xxjl"].refretrain();
				}
					window.parent.closeiframe();
			}else{
			$("form:first").attr("action","${pageContext.request.contextPath }/jumpResult.action");
			$("form:first").submit();
			}
		}
	   function checklength(obj, maxlen, msg) {
			var val = $(obj).val();
			var len = val.length;
			if(len > maxlen){
				if(window.confirm(msg)){
					$(obj).val(val.substr(0, maxlen));
					return true;
				}else {
					obj.focus();
					return false;
				}
			}
			return true;
		}
		function closewin() {
			parent.parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
	
		}
			
</script>
<style>

body{ background-image:none; }
</style>

<body>

<form action="" method="post" name="from1" id="from1">	
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news" style=" background-image:url(images/news2_bg.gif); background-repeat:repeat-x;">
					   <tr>
						<td width="160px" align="center" class="news_title"> 学习成效 </td>
						<td align="center" valign="middle" class="xxjh_data">&nbsp;</td>
				      	<td align="right" style="padding-right: 10px;"><img src="${pageContext.request.contextPath }/images/del.gif" width="12px" height="12px" onClick="closewin();"></td>
				       </tr>
					   <tr>
					   	<td colspan="2" align="center">
						
						<table width="85%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
                          <tr>
                            <td width="10%" height="30" align="left" valign="middle">学习类型：</td>
                            <td width="90%" height="30" align="left" valign="middle">
							<select name="studyType" id="studyType" style="width:155px;" disabled="disabled">
								<option value="1">个人学习</option> 
								<option value="2">集体学习</option>
                            </select>
                            </td>
                          </tr>
                          <tr>
                            <td width="10%" height="30" align="left" valign="middle">内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：</td>
                            <td width="90%" height="30" align="left" valign="middle">
							<textarea name="resultsContent" id="resultsContent" onchange="checklength(this, 500, '成效不能超过500个长度，点确定只截取前500位，点取消继续编辑成效？');" cols="47" rows="20">${record.resultsContent}</textarea>
							<input type="hidden" name="programId" id="programId" value="${programId}"/>
							<input type="hidden" name="studyType" id="studyType" value="${studyType}"/>
							<input type="hidden" name="resultState" id="resultState" value="${resultState}"/>
							<input type="hidden" name="resultsId" id="resultsId" value="${record.resultsId}"/>
							<input type="hidden" name="state" id="state" value="${record.state}"/>
							<input type="hidden" name ="programName" id = "programName" value="${programName}"/>
							</td>
                          </tr>
                          <tr>
                            <td width="10%" height="50" align="left" valign="middle">&nbsp;</td>
                            <td width="90%" height="50" align="left" valign="middle"><table border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              	<c:choose>
                              		<c:when test="${resultState eq '0'}">
                              		<td width="80" height="30" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath}/images/tijiao_bt.gif" width="67" height="26" border="0" onclick="return save();"/></a></td>
                              		</c:when>
                              		<c:when test="${resultState eq '1'}">
                              		<td width="80" height="30" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath}/images/tijiao_xg.gif" width="67" height="26" border="0" onclick="return save();"/></a></td>
                              		</c:when>
                              	</c:choose>
                                <td width="80" height="30" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath}/images/quxiao_bt.gif" width="67" height="26" border="0" onclick="return closewin();" /></a></td>
                              </tr>
                            </table></td>
                          </tr>
                        </table></td>
					   </tr>
				  </table>
</form>
</body>
</html>

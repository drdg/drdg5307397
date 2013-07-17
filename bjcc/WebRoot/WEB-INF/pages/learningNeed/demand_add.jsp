<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>

<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
	<script type="text/javascript">
//		function save(){
//		 var title= $("#title").val();
//			var adviceContent = $("#adviceContent").val();
//			if($.trim(title) == null||$.trim(title) == ""){
//			alert("标题不能为空 ！");
//			return false;
//			}
//			if(adviceContent == null||adviceContent == ""){
//			alert("需求内容不能为空 ！");
//			return false;
//			}
//			if(checklength($("#title"), 30, '资源内容不能超过30个长度，点确定只截取前30位，点取消继续编辑资源内容？') == false) {
//				return false;
//			}
//			if(checklength($("#adviceContent"), 200, '资源内容不能超过200个长度，点确定只截取前200位，点取消继续编辑资源内容？') == false) {
//				return false;
//			}
//			$("form:first").attr("action","<%=request.getContextPath()%>/saveLearning.action");
//			$("form:first").submit();
//			
//            }
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
		function ajaxsave(){
		    var title= $("#title").val();
			var adviceContent = $("#adviceContent").val();
			if($.trim(title) == null||$.trim(title) == ""){
			alert("标题不能为空 ！");
			return false;
			}
			if($.trim(adviceContent) == null||$.trim(adviceContent) == ""){
			alert("需求内容不能为空 ！");
			return false;
			}
			if(title.length>16){
			alert("标题不能大于16位！");
			return false;
			}
			if(checklength($("#adviceContent"), 512, '需求内容不能超过512个长度，点确定只截取前512位，点取消继续编辑需求内容？') == false) {
				return false;
			}
			submitFormByJson("<%=request.getContextPath()%>/ajaxsaveLearning.action", "from1", callBacksave);
		}
		var callBacksave = function(data){
			if(data=="success"){
				window.parent.frames["xuqiu"].refre();
            	window.parent.closeiframe();
			}else{
			$("form:first").attr("action","${pageContext.request.contextPath }/addNeedsLearning.action");
			$("form:first").submit();
			}
		}
		function closewin() {
			parent.closeiframe();
		//$(top.window.frames["zhuanti"]).contents().find('#isread-text');
		//closeWindown();
		}	
	</script>
</head>

<style>

body{ background-image:none;}
</style>

<body>
<form action="" method="post" name="from1" id="from1">	

	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news" style=" background-image:url(${pageContext.request.contextPath }/images/news2_bg.gif); background-repeat:repeat-x;">
					   <tr>
						<td width="200px" align="center" class="news_title2" > 添加学习需求 </td>
						<td align="center" valign="middle" class="xxjh_data">&nbsp;</td>
						<td align="right" style="padding-right: 10px;"><img src="${pageContext.request.contextPath }/images/del.gif" width="12px" height="12px" onClick="closewin();"></td>
				       </tr>
					   <tr>
					   	<td colspan="2" align="center">
						
						<table width="85%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
                          <tr>
                            <td height="30" align="left" valign="middle">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题</td>
                            <td height="30" align="left" valign="middle">
<!--                            <textarea name="title" id="title" onchange="checklength(this, 30, '标题不能超过30个长度，点确定只截取前30位，点取消继续编辑标题？');" cols="47" rows="2"></textarea>-->
                            <input type="text" name="title" id="title" style="width:390px;" /> 
                            <span style="color: red">*</span>
                            </td>
                          </tr>
                          <tr>
                            <td width="10%" height="30" align="left" valign="middle">学习类型：</td>
                            <td width="90%" height="30" align="left" valign="middle">
							<select name="resourceClassified" id="resourceClassified" style="width:155px;">
								<option value="0">专家讲座</option> 
								<option value="1">会议录像</option>
								<option value="2">学术报告</option>
								<option value="3">实景外拍</option>
								<option value="4">网络课件</option>
								<option value="5">图文信息</option>
								<option value="6">网络动漫</option>
								<option value="7">动漫游戏</option>
                            </select>   <span style="color: red">*</span>                         
                            </td>
                          </tr>
                          <tr>
                            <td width="10%" height="30" align="left" valign="middle">内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：</td>
                            <td width="90%" height="30" align="left" valign="middle">
							<textarea name="adviceContent" id="adviceContent" onchange="checklength(this, 200, '资源内容不能超过200个长度，点确定只截取前200位，点取消继续编辑资源内容？');" cols="47" rows="20"></textarea>
							<span style="color: red">*</span>	
							<input type="hidden" name="userId" id="userId" value="${resource.userId}">
							<input type="hidden" name="userNm" id="userNm" value="${resource.userNm}">
							<input type="hidden" name="deptId" id="deptId" value="${resource.deptId}">
							<input type="hidden" name="deptName" id="deptName" value="${resource.deptNm}">
							</td>
                          </tr>
                          <tr>
                            <td width="10%" height="50" align="left" valign="middle">&nbsp;</td>
                            <td width="90%" height="50" align="left" valign="middle"><table border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="80" height="30" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/tijiao_bt.gif" width="67" height="26" border="0"  onclick="return ajaxsave();" /></a></td>
                                <td width="80" height="30" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/quxiao_bt.gif" width="67" height="26" border="0"  onClick="closewin();"  /></a></td>
                              </tr>
                              
                            </table></td>
                          </tr>
                        </table></td>
					   </tr>
</table>

</form>

</body>
</html>

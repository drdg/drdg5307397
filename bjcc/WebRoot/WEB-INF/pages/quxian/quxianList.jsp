<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区县排行列表</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="xxph_ct">
	<table width="220" bgcolor="#FFFFFF" border="0" cellspacing="0" cellpadding="0" id="xxph_ct_1" style="background-image:url(images/biaohao_1.gif); background-repeat:no-repeat;">
			  <tr>
				<td width="43%" height="30" align="center" valign="middle" bgcolor="#feebcb" style=" color:#dc0f00; font-weight:bold;">学习排行</td>
				<td width="57%" height="30" align="center" valign="middle" bgcolor="#feebcb"  style=" color:#dc0f00; font-weight:bold;">区县</td>
			  </tr>
			  <s:iterator  value="list">
			    <!-- s:property value="deptname"/-->
			    <tr>
				<td height="33" align="center" valign="middle" bordercolor="#FF9933">&nbsp;</td>
				<td height="33" align="center" valign="middle" bordercolor="#FF9933"><s:property /></td>
			    </tr>
		      </s:iterator>
			  
	</table>
	</div>
	
	
</body>
</html>
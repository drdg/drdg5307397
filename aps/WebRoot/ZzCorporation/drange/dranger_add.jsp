<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Dpoint"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
<title>配送范围</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/drange/css/dranger_add.css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/drange/js/jquery-1.4.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/drange/js/getaddress.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/drange/js/dranger_add.js"></script>

</head>

<body onLoad="setup()">
	<div class="mainDiv">
		<div class="topDiv">
			
		</div>
		<%
			ArrayList<_Dpoint> almodel = (ArrayList<_Dpoint>)request.getAttribute("almodel");
		%>
		<form action="<%=basePath %>Corporation?type=7&key=1&pageNow=1" method="post">
		<table border="1">
			<tr>
				<td width="90px;">配送点名称</td>
				<td>
					<select name="fk_dpid">
						<%
							for(_Dpoint model:almodel){
						%>
							<option value="<%=model.getDpid() %>"><%=model.getDpname() %></option>
						<%		
							}
						%>
						
					</select>
				</td>
			</tr>
			<tr>
				<td>配送范围点</td>
				<td>
					<select id="tid1" name="tid1" id="drend" name="drend_1"></select>
    				<select id="tid2" name="tid2" id="drend" name="drend_2"></select>
    				<select id="tid3" name="tid3" id="drend" name="drend_3"></select>
				</td>
			</tr>
			
			<tr>
				<td>首公斤价格</td>
				<td><input type="text" maxlength="5" id="drfkg" name="drfkg"/></td>
			</tr>
			<tr>
				<td>次公斤价格</td>
				<td><input type="text" maxlength="5" id="drokg" name="drokg"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="" id="sub"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>

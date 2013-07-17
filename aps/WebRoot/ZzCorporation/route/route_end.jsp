<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Route"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>设置途经路线</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/route/css/route_end.css"/>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/route/js/getaddress.js"></script>
</head>

<body onLoad="setup()">
	<div class="mainDiv">
		<div class="topDiv">
		
		</div>
		
		<%
			ArrayList<_Route> almodel = (ArrayList<_Route>)request.getAttribute("almodel");
		%>
		
		<form action="<%=basePath %>Corporation?type=2&key=7&pageNow=1" method="post">
		<table border="1">
			<tr>
				<td width="90px;">路线名称</td>
				<td>
					<select name="fk_rti" id="fk_rti">
						<%
							for(_Route model:almodel){
						%>
								<option value="<%=model.getRtid() %>"><%=model.getRtname()+" 起点："+model.getRtspoint() %></option>
						<%		
							}
						%>
						
					</select>
				</td>
			</tr>
			<tr>
				<td>路线途径点</td>
				<td>
					<select id="tid1" name="tid1"></select>
    				<select id="tid2" name="tid2"></select>
    				<select id="tid3" name="tid3"></select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="" id="sub" />
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>

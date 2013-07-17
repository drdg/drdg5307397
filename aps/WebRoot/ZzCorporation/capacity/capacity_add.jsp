<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.CapacityS"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
<title>运力设置</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/capacity/css/capacity_add.css" />
</head>

<body>
	<%
		ArrayList<CapacityS> almodel = (ArrayList<CapacityS>)request.getAttribute("almodel");
	%>

	<form action="<%=basePath %>Corporation?type=4&key=1&pageNow=1" method="post">
	<table border="1" class="mainDiv" align="center">
		<tr>
			<td width="75px;">选配送点</td>
			<td width="375px;">
				<select name="fk_dpid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getDpoint()){
					%>
							<option value="<%=model.getDpoint().getDpid() %>"><%="配送点名："+model.getDpoint().getDpname()+" 地址："+model.getDpoint().getDpaddress()+" 范围："+model.getDrange().getDrend() %></option>	
					<%			
							}
						}
					%>
					
				</select>
			</td>
			<td style="border:0px; text-align:center">设</td>
		</tr>
		<tr>
			<td>选择路线</td>
			<td>
				<select name="fk_rtid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getRoute() && null != model.getRw()){
					%>
								<option value="<%=model.getRoute().getRtid() %>"><%="路线名："+model.getRoute().getRtname()+"途经点："+model.getRw().getRwroutend() %></option>
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">置</td>
		</tr>
		<tr>
			<td>选择车辆</td>
			<td>
				<select name="fk_cid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getCar()){
					%>
							<option value="<%=model.getCar().getCid() %>"><%="车牌："+model.getCar().getCbrand()+"型号："+model.getCar().getCmodel() %></option>	
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">运</td>
		</tr>
		<tr>
			<td>选择司机</td>
			<td>
				<select name="fk_eid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getEmpDetail()){
					%>
								<option value="<%=model.getEmpDetail().getEmp().getEid() %>"><%="员工："+model.getEmpDetail().getEmp().getEname()+"电话："+model.getEmpDetail().getEmp().getEphone()+"配送点："+model.getEmpDetail().getDpoint().getDpname() %></option>
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">力</td>
		</tr>
		<tr>
			<td>选择状态</td>
			<td>
				<select name="capstate">
					<option value="空闲">空闲</option>
					<option value="忙碌">忙碌</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3"  style="border:0px;">
				<input type="submit" value="" id="sub" />
			</td>
		</tr>
		
	</table>
	</form>
</body>
</html>

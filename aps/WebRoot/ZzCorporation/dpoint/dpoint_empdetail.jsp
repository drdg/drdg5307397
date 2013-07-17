<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.aps.db.model._Dpoint" %>
<%@page import="com.aps.db.model.V_EmpDetail"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/dpoint/css/dpoint_list.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/dpoint/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/list.js"></script>

<title>查看配送点</title>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="#" method="post">
				<input type="text" class="sosotext"/>
				<input type="submit" value="" id="subsoso"/>
			</form>
		</div>
	</div>
	<div class="bodyDiv" style="width:2000px;height: 600px;">
		<table border="1">
			<tr align="center">
				<td>选取操作</td>
				<td>序号</td>
				<td>姓名</td>
				<td id="dne" class="dn">性别</td>
				<td id="dne" class="dn">年龄</td>
				<td id="dne" class="dn">生日</td>
				<td id="dne" class="dn">政治面貌</td>
				<td id="dne" class="dn">地址</td>
				<td>手机号</td>
				<td id="dne" class="dn">email</td>
				<td id="dne" class="dn">职位</td>
				<td id="dne" class="dn">部门</td>
				<td id="dne" class="dn">入职时间</td>
				<td>薪水</td>
				<td id="dne" class="dn">备注</td>
				<td id="dne" class="dn">状态</td>
				
				<td>权限描述</td>
				
				<td>配送点名称</td>
				<td id="dne" class="dn">配送点省份</td>
				<td>配送点地址</td>
				<td>配送点电话</td>
				<td id="dne" class="dn">配送点邮箱</td>
				<td id="dne" class="dn">配送点备注</td>
				
				<td>配送点途经点</td>
				<td>首公斤价格</td>
				<td>次公斤价格</td>
				<td>操作</td>
			</tr>
			<%
					ArrayList<V_EmpDetail> almodel = (ArrayList<V_EmpDetail>)request.getAttribute("almodel");
					V_EmpDetail cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(V_EmpDetail c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getEmp().getEname() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEsex() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEage() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEbirthday() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEpa() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEaddress() %></td>
					<td><%=c.getEmp().getEphone() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEemail() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEpost() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEdept() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEindate() %></td>
					<td><%=c.getEmp().getEsal() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEstate() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEnote() %></td>

					<td><%=c.getAuthority().getAudesc() %></td>
					
					<td><%=c.getDpoint().getDpname() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDppro() %></td>
					<td><%=c.getDpoint().getDpaddress() %></td>
					<td><%=c.getDpoint().getDptel() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDpemail() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDpnote() %></td>
					
					<td><%=c.getDrange().getDrend() %></td>
					<td><%=c.getDrange().getDrfkg() %></td>
					<td><%=c.getDrange().getDrokg() %></td>
					
					<td>删除|修改|<span class="detail">详情</span></td>
					</tr>
				<%		
					}
				%>
				<tr>
				<td colspan="27" align="left">
					<span>
						<%=cpage.getPageCount() %>条记录
					</span>
					<span>
						共<%=cpage.getPageS() %>页
					</span>
					<span id="dqpage">
						<%
							int pageDq = 1;
							if(!"1".equals(cpage.getPageNow())){
								pageDq = (Integer.valueOf(cpage.getPageNow())-1); 
							}
						%>
						当前第<%=pageDq %>页
					
					</span>
					<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=3&key=7&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=3&key=7&pageNow="+pageUp;
						}
					%>
					
					<a href="<%=urlUp %>">上一页</a>
					
					<%
						int pageNow = Integer.valueOf(cpage.getPageNow());
						String fcolor = "red";
						if(pageNow - 3 > 0){
							//													每页下面的数字数
							for(int p = 1,g = pageNow-3,z = Integer.valueOf(cpage.getPageNum()); p <= z && g <= Integer.valueOf(cpage.getPageS()); p++,g++){
								if(g == pageDq){
									fcolor = "yellow";
								}else{
									fcolor = "red";
								}
					%>
							<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
					<%			
							}
						}else{
							for(int p = 1,z = Integer.valueOf(cpage.getPageNum()); p <= z && p <= Integer.valueOf(cpage.getPageS()); p++){
								if(p == pageDq){
									fcolor = "yellow";
								}else{
									fcolor = "red";
								}
					%>
							<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=cpage.getPageS() %>">末页</a>
				</td>
			</tr>
				
			
		</table>
	</div>
</div>
</body>
</html>
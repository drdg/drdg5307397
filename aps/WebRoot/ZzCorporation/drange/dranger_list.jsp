<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.V_Dpoint_Drange"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
<title>配送范围</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/drange/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/drange/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/drange/js/list.js"></script>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="<%=basePath %>Corporation?type=7&key=4&pageNow=1" method="post">
				<input type="text" class="sosotext"/>
				<input type="submit" value="" id="subsoso"/>
			</form>
		</div>
	</div>
	<div class="bodyDiv">
		<table border="1">
			<tr align="center">
				<td>选取操作</td>
				<td>序号</td>
				<td>配送点名称</td>
				<td id="dne" class="dn">省份</td>
				<td id="dne" class="dn">地址</td>
				<td id="dne" class="dn">电话</td>
				<td id="dne" class="dn">邮箱</td>
				<td id="dne" class="dn">备注</td>
				<td>配送终点</td>
				<td>首公斤价格</td>
				<td>次公斤价格</td>
				<td>操作</td>
			</tr>
			<%
					ArrayList<V_Dpoint_Drange> almodel = (ArrayList<V_Dpoint_Drange>)request.getAttribute("almodel");
					V_Dpoint_Drange cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(V_Dpoint_Drange c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getDpoint().getDpname() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDppro() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDpaddress() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDptel() %></td>
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
				<td colspan="11" align="center">
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
					<a href="<%=basePath%>Corporation?type=7&key=4&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=7&key=4&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=7&key=4&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=7&key=4&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=7&key=4&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=7&key=4&pageNow=<%=cpage.getPageS() %>">末页</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>

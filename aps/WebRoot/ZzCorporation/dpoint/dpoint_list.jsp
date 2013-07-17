<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.aps.db.model._Dpoint" %>
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
	<div class="bodyDiv">
		<table border="1">
			<tr align="center">
				<td>选取操作</td>
				<td>序号</td>
				<td>名称</td>
				<td>省份</td>
				<td>地址</td>
				<td>电话</td>
				<td id="dne" class="dn">邮箱</td>
				<td id="dne" class="dn">备注</td>
				<td>操作</td>
			</tr>
			<%
					ArrayList<_Dpoint> almodel = (ArrayList<_Dpoint>)request.getAttribute("almodel");
					_Dpoint cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(_Dpoint c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getDpname() %></td>
					<td><%=c.getDppro() %></td>
					<td><%=c.getDpaddress() %></td>
					<td><%=c.getDptel() %></td>
					<td id="dne" class="dn"><%=c.getDpemail() %></td>
					<td id="dne" class="dn"><%=c.getDpnote() %></td>
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
					<a href="<%=basePath%>Corporation?type=3&key=5&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=3&key=5&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=3&key=5&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=3&key=5&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=3&key=5&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=3&key=5&pageNow=<%=cpage.getPageS() %>">末页</a>
				</td>
			</tr>
				
			
		</table>
	</div>
</div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Emp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>员工列表</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/emp/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/list.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/pageGunZhou.js"></script>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="<%=basePath %>ZzCorporation/emp/Corporation?type=6&key=6" method="post">
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
				<td>姓名</td>
				<td>性别</td>
				<td id="dne" class="dn">年龄</td>
				<td id="dne" class="dn">生日</td>
				<td id="dne" class="dn">政治面貌</td>
				<td>地址</td>
				<td>手机</td>
				<td>email</td>
				<td>职位</td>
				<td>部门</td>
				<td id="dne" class="dn">入职时间</td>
				<td id="dne" class="dn">薪水</td>
				<td id="dne" class="dn">状态</td>
				<td id="dne" class="dn">备注</td>
				<td>操作</td>
			</tr>
				<%
					ArrayList<_Emp> almodel = (ArrayList<_Emp>)request.getAttribute("almodel");
					_Emp cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(_Emp c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getEname() %></td>
					<td><%=c.getEsex() %></td>
					<td id="dne" class="dn"><%=c.getEage() %></td>
					<td id="dne" class="dn"><%=c.getEbirthday() %></td>
					<td id="dne" class="dn"><%=c.getEpa() %></td>
					<td><%=c.getEaddress() %></td>
					<td><%=c.getEphone() %></td>
					<td><%=c.getEemail() %></td>
					<td><%=c.getEpost() %></td>
					<td><%=c.getEdept() %></td>
					<td id="dne" class="dn"><%=c.getEindate() %></td>
					<td id="dne" class="dn"><%=c.getEsal() %></td>
					<td id="dne" class="dn"><%=c.getEstate() %></td>
					<td id="dne" class="dn"><%=c.getEnote() %></td>
					<td>删除|修改|<span class="detail">详情</span></td>
					</tr>
				<%		
					}
				%>
			
			<tr>
				<td colspan="17" align="center">
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
					<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=6&key=5&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=6&key=5&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=cpage.getPageS() %>">末页</a>
					
					<input type="text" onfocus="ufocus(this)" onblur="ublur()" style="background:transparent;width:30px;color:#00FF00;" id="gzz" readonly="true"/>
					<a href="#" onclick="sumSub()" id="agzz" style="border: 1px green solid;color: maroon">跳转</a>
				</td>
			</tr>
			
		</table>
	</div>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="GB18030" errorPage="../../Corporation?type=1&key=4"%>
<%@ page import="com.aps.db.model._Car" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
 <title>查看车辆</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/car/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/car/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/car/js/list.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/car/js/pageGunZhou.js"></script>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="<%=basePath%>Corporation?type=1&key=6" method="post">
				<input type="text" class="sosotext" name="sosotext"/>
				<input type="submit" value="" id="subsoso" onclick="return Pderr()"/>
			</form>
		</div>
	</div>
	<div class="bodyDiv">
		<table border="1">
			<tr align="center" id="ssv">
				<td>选取操作</td>
				<td>序号</td>
				<td>车牌号</td>
				<td>型号</td>
				<td>产地</td>
				<td id="dne" class="dn">出厂时间</td>
				<td id="dne" class="dn">购车时间</td>
				<td id="dne" class="dn">购车负责人</td>
				<td>体积</td>
				<td>容量</td>
				<td>操作</td>
			</tr>
				
			 	
				<%
					ArrayList<_Car> alcar = (ArrayList<_Car>)request.getAttribute("alcar");
					_Car cpage = alcar.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					for(_Car c:alcar){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getCbrand() %></td>
					<td><%=c.getCmodel() %></td>
					<td><%=c.getCorigin() %></td>
					<td id="dne" class="dn"><%=c.getCproduce() %></td>
					<td id="dne" class="dn"><%=c.getCbuy() %></td>
					<td id="dne" class="dn"><%=c.getCpripal() %></td>
					<td><%=c.getCapac() %></td>
					<td><%=c.getCvolume() %></td>
					<td>删除|修改|<span class="detail">详情</span></td>
					</tr>
				<%		
					}
				%>
			
			<tr style="border: 0px;">
				<td colspan="11" align="center" style="border: 0px;">
					<span>
						<%=cpage.getPageCount() %>条记录
					</span>
					<span>
						共<span id="pageS"><%=cpage.getPageS() %></span>页
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
					<a href="<%=basePath%>Corporation?type=1&key=5&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=1&key=5&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=1&key=5&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=1&key=5&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
					<%			
							}
						}else{
							for(int p = 1,z = Integer.valueOf(cpage.getPageNum()); p <= z; p++){
								if(p == pageDq){
									fcolor = "yellow";
								}else{
									fcolor = "red";
								}
					%>
							<a href="<%=basePath%>Corporation?type=1&key=5&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=1&key=5&pageNow=<%=cpage.getPageS() %>">末页</a>
					-♂->
					<input type="text" onfocus="ufocus(this)" ondblclick="sumClear()" onblur="ublur()" style="background:transparent;width:30px;color:yellow;border: 1px red solid;background-color: black;" id="gzz" readonly="true"/>
					<a href="<%=basePath%>Corporation?type=1&key=5&pageNow=" onclick="sumSub()" id="agzz" style="border: 1px silver solid;color: silver;">跳转</a>
				</td>
			</tr>
			
		</table>
	</div>
</div>
</body>
</html>


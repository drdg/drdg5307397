
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Olist"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>查看订单</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/orderlist/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/orderlist/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/orderlist/js/list.js"></script>
<style type="text/css">
a:link {
		color:#FF0000;
		text-decoration: none;
	}
	a:visited {
		text-decoration: none;
		color: #FF0000;
	}
	a:hover {
		text-decoration: none;
		color: #FF0000;
	}
	a:active {
		text-decoration: none;
		color: #FF0000;
	}
	
	a{
		width:55px;
		height:25px;
		border:1px #FF0000 solid;
		background-color:#000000;
	}
</style>
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
				<td>订单编号</td>
				<td>发货人姓名</td>
				<td>发货人电话</td>
				<td id="dne" class="dn">发货人地址</td>
				<td id="dne" class="dn">发货人邮编</td>
				<td id="dne" class="dn">发货人邮箱</td>
				<td>收货人姓名</td>
				<td>收货人电话</td>
				<td>收货人地址</td>
				<td id="dne" class="dn">收货人邮编</td>
				<td id="dne" class="dn">货物名称</td>
				<td id="dne" class="dn">货物类型</td>
				<td id="dne" class="dn">货物个数</td>
				<td id="dne" class="dn">货物重量</td>
				<td>配送站点</td>
				<td>收货站点</td>
				<td id="dne" class="dn">下单时间</td>
				<td>保险价值</td>
				<td id="dne" class="dn">短信通知</td>
				<td id="dne" class="dn">付款方式</td>
				<td id="dne" class="dn">备注信息</td>
				<td>操作</td>
			</tr>
				<%
					ArrayList<_Olist> almodel = (ArrayList<_Olist>)request.getAttribute("almodel");
					_Olist cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(_Olist c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getOlno()%></td>
					<td><%=c.getOlname()%></td>
					<td><%=c.getOlsendtel()%></td>
					<td id="dne" class="dn"><%=c.getOlsendaddress()%></td>
					<td id="dne" class="dn"><%=c.getOlsendcode()%></td>
					<td id="dne" class="dn"><%=c.getOlsendemail()%></td>
					<td><%=c.getOlinname()%></td>
					<td><%=c.getOlintel()%></td>
					<td><%=c.getOlinaddress()%></td>
					<td id="dne" class="dn"><%=c.getOlincode()%></td>
					<td id="dne" class="dn"><%=c.getOlgoodsname()%></td>
					<td id="dne" class="dn"><%=c.getOlgoodstype()%></td>
					<td id="dne" class="dn"><%=c.getOlgoodsnum()%></td>
					<td id="dne" class="dn"><%=c.getOlgoodsweight()%></td>
					<td><%=c.getOlgoodsaddress()%></td>
					<td><%=c.getOlingoodsadd()%></td>
					<td id="dne" class="dn"><%=c.getOldate()%></td>
					<td><%=c.getOlins()%></td>
					<td id="dne" class="dn"><%=c.getOlsnotice()%></td>
					<td id="dne" class="dn"><%=c.getOlpays()%></td>
					<td id="dne" class="dn"><%=c.getOlnote()%></td>
					<td>删除|修改|<span class="detail">详情</span></td>
					</tr>
				<%		
					}
				%>
				<tr>
				<td colspan="24" align="left">
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
					<a href="<%=basePath%>Corporation?type=10&key=4&pageNow=1">首页</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=10&key=4&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=10&key=4&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=10&key=4&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=10&key=4&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">下一页</a>
					<a href="<%=basePath%>Corporation?type=10&key=4&pageNow=<%=cpage.getPageS() %>">末页</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>

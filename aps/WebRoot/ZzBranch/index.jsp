<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.V_PdLogin"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
     <title>爱配送-站点控制管理</title>
		<link rel="stylesheet" href="<%=basePath %>ZzBranch/res/scripts/components/easyui/themes/default/easyui.css" type="text/css" />
		<link rel="stylesheet" href="<%=basePath %>ZzBranch/res/scripts/components/easyui/themes/icon.css" type="text/css" />
		<link rel="stylesheet" href="<%=basePath %>ZzBranch/res/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="<%=basePath %>ZzBranch/res/styles/common.css" type="text/css" />

		<script type="text/javascript" src="<%=basePath %>ZzBranch/res/scripts/lib/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=basePath %>ZzBranch/res/scripts/components/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>ZzBranch/res/scripts/common/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				top.menuCall('&nbsp;&nbsp;我的爱配送&nbsp;&nbsp;','<%=basePath%>JqAjax.jsp',false);
				tabCloseEven();
				showtime();
			});
			
			function showtime(){
			
				var d = new Date();
				var year = d.getFullYear();
				var month = d.getMonth() + 1;
				var day = d.getDate();
				
				var h=d.getHours()
				var m=d.getMinutes()
				var s=d.getSeconds()
				
				if(m < 10){
					m ="0"+m;
					
				}else if(s < 10){
					s = "0"+s;
				}

				var nowtime;
				nowtime = year+"/"+month+"/"+day+" "+h+":"+m+":"+s;
				
				$(".north-tool-wrap div font").html(nowtime);
				
				setTimeout('showtime()',500);
			}
		</script>
	</head>
    <body class="easyui-layout">
		<div region="north" class="north-back-main" style="height:80px" border="false" ondblclick="menuTop()">
			<!--<div class="north-back-logo"></div>-->
			<div class="north-tool-wrap">
				<div style="padding-left:160px;">
					<font color="#FF0000"></font> <span>欢迎<%=((V_PdLogin)session.getAttribute("vpl")).getEname()%>登录</span>
				</div>
				<div style="padding:25px 0px 0px 400px;">
					<a href="${ctx.contextPath}/rest/default/logout"><span class="icon-exitsystem"></span></a>
				</div>
			</div>
		</div>
		<div region="west" split="true" title="&nbsp;管理选项 &gt;&gt;操作菜单" icon="icon-destop"
			style="width: 280px;overflow: hidden;">
			<div class="easyui-accordion" fit="true" border="true" animate="false" style="padding-bottom:0.5px;">

				<!--配送点管理-->
				<div title="&nbsp;配送点信息" icon="icon-menu" style="padding:10px;">
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看配送点信息','<%=basePath%>Corporation?type=3&key=7&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看配送点信息
               			</a>
               		</div>
               	</div>
				

				<!--配送范围管理-->
               	<div title="&nbsp;配送范围管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('增加配送范围','<%=basePath%>Corporation?type=7&key=6');">
            				<span class="icon-submenu-frame icon-submenu"></span>增加配送范围
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看配送范围','<%=basePath %>Corporation?type=7&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看配送范围
               			</a>
               		</div>
               	</div>

			
				<!--订单管理-->
               	<div title="&nbsp;订单管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('增加订单','<%=basePath %>ZzBranch/res/Order/addorder.html');">
            				<span class="icon-submenu-frame icon-submenu"></span>增加订单
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看订单','<%=basePath %>Corporation?type=10&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看订单
               			</a>
               		</div>
               	</div>
				<!--交接单管理-->
				<div title="&nbsp;交接单管理" icon="icon-menu" style="padding:10px;">
				
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看交接单','<%=basePath %>Corporation?type=11&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看交接单
               			</a>
               		</div>
				</div>
				
				<!--报表管理-->
				<div title="&nbsp;报表管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看报表','<%=basePath %>ZzCorporation/statements/statements_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看报表
               			</a>
               		</div>
					
               	</div>
				
				<!--权限管理-->
				<div title="&nbsp;权限管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('增加权限','<%=basePath %>ZzCorporation/authority/au_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>增加权限
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看权限','<%=basePath%>Corporation?type=13&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看权限
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('授予权限','<%=basePath%>Corporation?type=13&key=6');">
            				<span class="icon-submenu-frame icon-submenu"></span>授予权限
               			</a>
               		</div>
               	</div>
				
				<!--用户管理-->
				<div title="&nbsp;客户管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('增加客户','<%=basePath %>ZzCorporation/customer/customer_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>增加客户
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('查看客户','<%=basePath %>Corporation?type=14&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>查看客户
               			</a>
               		</div>
               	</div>
				
			</div>
		</div>
		<div region="center">
			<div id="main-center" class="easyui-tabs" fit="true" border="false">
				<!--选项卡右键功能-->			
				<div id="mm" class="easyui-menu" style="width:150px;">
			        <div id="mm-tabclose">关闭</div>
			        <div id="mm-tabcloseall">关闭所有</div>
			        <div id="mm-tabcloseother">关闭其它页面</div>
			        <div class="menu-sep"></div>
			        <div id="mm-tabcloseright">关闭右侧所有页面</div>
			        <div id="mm-tabcloseleft">关闭左侧所有页面</div>
	  			</div>
			</div>
		</div>
		<div region="south" class="south-back-main" style="height:36px" border="false">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="center">爱配送物流后台管理中心--版权所有--盗版必究</td>
				</tr>
			</table>
		</div>
	</body>
</html>


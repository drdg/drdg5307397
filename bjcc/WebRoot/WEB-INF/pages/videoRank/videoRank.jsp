<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>点播排行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/tab.js" charset="GB2312"></script>
  </head>
  
  <body>
					<div class="dbph">
						<div class="jpkc_ct_left"  id="menu7">
							<div class="kcdb_tt" style="width:201px;">点播排行</div>
								<ul>
									<li><a style="cursor:pointer;" class="hover" onmousemove="setTab(7,0)">月排行</a></li>
									<li><a style="cursor:pointer;" onmousemove="setTab(7,1)">季排行</a></li>
									<li><a style="cursor:pointer;" onmousemove="setTab(7,2)">年排行</a></li>
								</ul>
					  </div>
							<div class="dbph_right" id="main7" >
								<ul>
								
								<s:iterator var="month" value="listMonth" status="status">	
								<li> <a target="_blank" href='http://192.168.6.31/bjzcw/wskt/kjdb/<s:property value="#month[4]"/><s:property value="#month[1]"/>.html'><s:property value="#month[0]"/></a></li>
								</s:iterator>
								
								</ul>
								
								<ul style="display:none;">
									<s:iterator var="season" value="listSeason">
								      <li> <a target="_blank" href='http://192.168.6.31/bjzcw/wskt/kjdb/<s:property value="#season[4]"/><s:property value="#season[1]"/>.html'><s:property value="#season[0]"/></a></li>
							        </s:iterator>
								</ul>
								
								<ul style="display:none;">
									<s:iterator var="year" value="listYear">  
								       <li> <a target="_blank" href='http://192.168.6.31/bjzcw/wskt/kjdb/<s:property value="#year[4]"/><s:property value="#year[1]"/>.html'><s:property value="#year[0]"/></a></li>
							        </s:iterator>
								</ul>
							</div>
					
					</div>
					
					         
  </body>
</html>

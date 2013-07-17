<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js" charset="GB2312"></script>
<script language="javascript" type="text/javascript">
var a = 0;
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("iframe"); 
 for(i=0;i<tli.length;i++){	 
  tli[i].className=i==n?"hover":"";  
  mli[i].style.display=i==n?"block":"none";  
 }
 a=n;
}
setTab(1,0);
</script>
</head>

<style>

body{ background-image:none; }
</style>

<body>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
					   <tr>
						<td width="112" align="center" class="news_title"> 我的课程</td>
						<td width="434" align="center" valign="middle" class="xxjh_data">
						
						 
						
						</td>
					    <td width="177" align="center" valign="middle" class="tit_dqwz">
							<div class="gxh_tab" id="menu1">
							<ul>
								<li><a href="#" class="hover"  onmousemove="setTab(1,0)">我的收藏</a></li>
								<li><a href="#" onmousemove="setTab(1,1)">学习计划</a></li>
							</ul>
							</div>
						</td>
				       </tr>
				  </table>
				 <div class="xxjl_ct" id="main1" style="padding:0px; width:723px; height:270px;">  	  
			<iframe id="geti" name="geti" src="${pageContext.request.contextPath }/elearning/userCollect.jsp" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="100%" border="0"> </iframe>
			<iframe id="studyplan" name="studyplan" src="${pageContext.request.contextPath }/prepareStudyPlanAction.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="100%" border="0"> </iframe>
		</div>

</body>
</html>

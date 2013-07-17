<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>用户个人学习记录</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/program.js"></script> 
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/ajax.js"></script>
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

	function selects(){
	   var 	select=$("#select").find("option:selected").text(); 
	   var textfield = $("#textfield").val();
		 if(a==0){
		 $("form:first").attr("target", "geti");
		 $("form:first").attr("action","<%=request.getContextPath()%>/userQueryBehavior.action");
		 $("form:first").submit();
		 }else if(a==1){
		 $("form:first").attr("target", "jiti");
		 $("form:first").attr("action","<%=request.getContextPath()%>/trainQueryBehavior.action");
		 $("form:first").submit();
		 }
	 return false;	
	}
	 function refreuser(){
	 		$("form:first").attr("target", "geti");
 			$("form:first").attr("action","${pageContext.request.contextPath }/userexecuteBehavior.action");
			$("form:first").submit();
 		}
 	function refretrain(){
 			$("form:first").attr("target", "jiti");
 			$("form:first").attr("action","${pageContext.request.contextPath }/trainexecuteBehavior.action");
			$("form:first").submit();
 		}
</script>
</head>
<style>

body{ background-image:none; }
</style>

<body>
<form action="" method="post" name="from1">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
					   <tr>
						<td width="112" align="center" class="news_title"> 学习记录</td>
						<td width="434" align="center" valign="middle" class="xxjh_data">
						
						  <table width="300" border="0" cellspacing="0" cellpadding="0">
						  <tr>
							<td width="86">
							<select name="select" id="select" style="width:80px; height:20px;" class="blue12">
							<option >学习主题</option>
						  </select>                  </td>
							<td width="157"><input class="searchInput" style=" width:150px;" type="text" name="textfield" id="textfield" /></td>
							<td width="57"><img src="${pageContext.request.contextPath }/images/sousuo_bt1.gif" onclick="return selects();"/></td>
						  </tr>
						</table>
						
						</td>
					    <td width="177" align="center" valign="middle" class="tit_dqwz">
							<div class="gxh_tab" id="menu1">
							<ul>
								<li><a href="#" class="hover"  onmousemove="setTab(1,0)">个人学习</a></li>
								<li><a href="#" onmousemove="setTab(1,1)">集体学习</a></li>
							</ul>
							</div>
						</td>
				       </tr>
				  </table>
				  </form>
				  <div class="xxjl_ct" id="main1">

				<iframe id="geti" name="geti" src="${pageContext.request.contextPath }/userexecuteBehavior.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="100%" border="0"> </iframe>
				<iframe id="jiti" name="jiti" src="${pageContext.request.contextPath }/trainexecuteBehavior.action" name="leftframe" frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" id="leftframe" width="100%" height="100%" border="0"> </iframe>
				  </div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>集体用户学习记录</title>
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
<script type="text/javascript" type="text/javascript">
  function addchengxiao(id){
    parent.parent.showTipsWindown(600, 445,"${pageContext.request.contextPath }/jumpResult.action?studyType=2&programId="+id);
    return false;
   }
</script>
</head>
<style>

body{ background-image:none; }
</style>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
					 <tr>
                		<td width="226" align="left" class="table_xuexi_title p_l_10">学习主题</td>
               			<td width="240" class="table_xuexi_title">学习内容</td>
                		<td width="80" class="table_xuexi_title">学习时间</td>
                		<td width="80" class="table_xuexi_title">创建时间</td>
                		<td width="71" class="table_xuexi_title">学习成效</td>
               		 </tr>
               		 </table>
<div style="height: 160px;" class="table_xuexi">               		 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
               		 <s:iterator value="trainMessages" id="trainMessage">
               		 <tr>
               		 	<td width="226" class="p_l_10" align="left">
               		 	<SPAN style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 220px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;"><s:property value="#trainMessage.trainTheme"/></SPAN></td>
                		<td width="240" class="p_l_10" align="left">
                		<SPAN style="DISPLAY: inline-block; FLOAT: left; OVERFLOW: hidden; WIDTH: 150px; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis;"><s:property value="#trainMessage.trainContent"/></SPAN></td>
                		<td width="80" class="p_l_10" align="left">
                		<s:property value="#trainMessage.trainTime"/>
                		</td>
                		<td width="80" class="p_l_10" align="left">
                		<s:property value="#trainMessage.creatTime"/>
                		</td>
                		<td width="71">
                		<s:if test="%{#trainMessage.resultState==0}" >
                		<a href="#"><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16"  onClick="return addchengxiao(<s:property value="#trainMessage.trainId"/>);" /></a>
                		</s:if>
                		<s:if test="%{#trainMessage.resultState==1}" >
                		<a href="#"><img src="${pageContext.request.contextPath }/images/xxcx_ico1.gif" width="16" height="16"  onClick="return addchengxiao(<s:property value="#trainMessage.trainId"/>);" /></a>
                		</s:if>
                		</td>
               		 </tr>
               		 </s:iterator>
</table>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
               		  <tr class="table_xuexi_shen">
                <td colspan="6" align="right" class="p_l_10">
					<jsp:include page="../global/paginationInclude.jsp"></jsp:include>
				</td> 
              </tr>
</table> 
</body>
</html>
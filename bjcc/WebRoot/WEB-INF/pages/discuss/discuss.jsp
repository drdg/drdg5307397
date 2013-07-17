<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>视频相关评论</title>
    <link rel=stylesheet
 href="${pageContext.request.contextPath }/css/style3.css" type="text/css" />
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/discuss.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery.rater.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/Cookies.Class.js"></script>
			<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/ajax.js"></script>
		
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 

  </head>
  
  <body>
    <div class="spbf_ct1"><form id="form1" action="discussAction?articleID=1" method="post">
    <input type="hidden" id="total" value="<s:property value='total'/>">
    <input type="hidden" id="avg" value="<s:property value='score'/>">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height:20px;">
				  <tr>
					<td height="31" background="images/spbf_tt.gif" class="spbf_tt"><img src="images/spbfq_tt1.gif" width="13" height="11" /> 视频相关评论</td>
				  </tr>
				  <tr>
					<td>
					<table width="95%" border="0" align="center" cellpadding="0" cellspacing="5" style="margin-top:10px;">
					  <tr> <td>
					  <div style="float:left; margin-right:25px;"> 
						  <h4 style="font-size:14px;">
							你的评分：<span id="choosingmark">当前默认评分是<strong class="pingfen">3</strong>分</span>
						  </h4>
						  <div id="thismark"></div>
					  </div>
					  <div style="float:left;">
							<h4 style="font-size:14px;">
							网友评分：<span id="pnum"></span>
							</h4>
							<div id="curmark"></div>
					 </div><div style="clear:both;"></div>
					 </td>
					  </tr>
                      <tr>
                        <td height="60" align="center" valign="middle" bgcolor="#f9f9f9" style="border:#dadada solid 1px;">
						<textarea name="content" id="vcmword" style="width:580px; height:40px;"></textarea>
						</td>
                      </tr>
                      <tr>
                        <td height="25" align="right" valign="middle">
                        <input type="button" id="pingbtn"  value="提交评分与评论" /></td>
                      </tr>
                      </table>
                    </td>
				  </tr>
			  </table>
</form>
		</div>
  </body>
</html>

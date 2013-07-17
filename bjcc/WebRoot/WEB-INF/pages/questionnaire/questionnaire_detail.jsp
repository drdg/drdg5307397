<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>北京长城网</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>

<body>
<div class="body">
 <iframe src="<%=Constant.HEAD_URL %>" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
	
	<!--head--> 
	<!--ct1--> 
 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title_r" style="margin-bottom:10px;">
   <tr> 
    <td width="185" height="35" class="two_title_1">调 查 问 卷</td>
    <td>&nbsp;
	</td>
   </tr>
  </table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-bottom:5px;">
  <tr>
   <td valign="top">
    <!-- 右侧列表开始 -->
    <div id="Tab3">
      <div class="Contentbox">
      
       <table width="100%" border="0" align="center" class="right_con">
      
         <tr>
           <td valign="top">
		   <!--单选列表开始-->
              <div class="fieldset">
			   <!--标题开始-->
			   <div id="div1" class="div_question">
                <div class="div_title_question_all">
                  <div class="div_title_question" style="background-color:#fff0d4; font-size:14px; color:#000000; text-align:center;">
				  <span style="color: red; font-size:12px;">※&nbsp;</span>问题列表<span style="color: red; font-size:12px;">&nbsp;※</span></div>
                  <div style="clear: both;"></div>
                </div>
               </div>
			<s:iterator id="question" value="questionnaire.quesnaireQuestions" status="st">
				<tr>
					<td style="white-space:normal; word-break:break-all; word-wrap:break-word;">
						<b><s:property value='#st.index+1'/> .&nbsp;<s:property value="#question.questionName"/><span style="color: red;">&nbsp;*</span></b>
					</td>
				</tr>
				<s:if test="%{#question.questionType==0}">
				
				 <s:iterator id="quesoption" value="#question.quesnaireQuesOptions">
					<tr style="height: 20px;">
						<td>
							<s:if test="%{#question.choose==0}">
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" 
								<s:if test="#quesoption.id==#quesoption.option_id">
									checked="checked"
								</s:if> disabled="disabled" /><s:property value="#quesoption.content"/>
							</s:if>
							<s:elseif test="%{#question.choose==1}">
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" 
								<s:if test="#quesoption.id==#quesoption.option_id">
									checked="checked"
								</s:if> disabled="disabled" /><s:property value="#quesoption.content"/>
							</s:elseif>
						</td>
					</tr>
				  </s:iterator>
				</s:if>
				<s:else>
					<tr style="height: 20px;">
					<td>
					&nbsp;&nbsp;&nbsp;&nbsp;<input size="150" type="text"
						<s:if test="#question.content!=null">
							value = "<s:property value="#question.content"/>"
						</s:if>
					readonly = "readonly" />
					</td>
					</tr>
				</s:else>
				</s:iterator>
              </div>
             
		   </td>
         </tr>
         <tr>
  			<td align="center">
  				<input type="button" onclick="return window.close();" value="关闭" style="background: url(${pageContext.request.contextPath }/images/an.jpg); width:67px; height:26px; border: 0px;"/>
  				
  			</td>
  		</tr>
       </table>
     </div>
    </div>
    <!-- 右侧列表结束 -->   </td>
  </tr>
 </table>
 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   <td colspan="3">
    <iframe src="<%=Constant.BOTTOM_URL %>" width="100%" height="100%" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
   </td>
  </tr>
 </table>
</div>
</body>
</html>
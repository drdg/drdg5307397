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
<link type="text/css" href="${pageContext.request.contextPath }/css/style_dxx.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
</head>

<body>

	<!--head--> 
<div class="body">
 <iframe src="<%=Constant.HEAD_URL %>" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
	
	<!--head--> 
	<!--ct1--> 
 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title_r" style="margin-bottom:10px;">
   <tr> 
    <td width="185" height="35" class="two_title_1">学 习 评 测 </td>
    <td>&nbsp;</a>
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
        <s:iterator id="test" value="test">
         <tr>
           <td height="35" align="center" class="mainred20">
           <s:property value="#test.programName"/>
           <div  style="padding-left: 640px"> 评测成绩：
    		<s:iterator id="record" value="record">
            	<s:property value="#record.achievement"/>
       	 	</s:iterator>
       	 	</div>
           </td>
         </tr>
         <tr>
           <td height="85" class="main12h" style="color:#000000;border:1px dotted #D40811; border-top:0px; padding:5px;"> 　　填充说明：${test.explain }</td>
         </tr>
         <tr>
           <td valign="top">
		   <!--单选列表开始-->
              <div class="fieldset">
			   <!--标题开始-->
              <DIV id="div1" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_title_question" style="background-color:#fff0d4; font-size:14px; color:#000000; text-align:center;">
				  <SPAN style="color: red; font-size:12px;">※&nbsp;</SPAN>选择题<SPAN style="color: red; font-size:12px;">&nbsp;※</SPAN></DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                </DIV>  
                
                    
            	<s:iterator id="question" value="#test.testQuestions" status="st">
				<tr>
					<td style="white-space:normal; word-break:break-all; word-wrap:break-word;">
						&nbsp;&nbsp;&nbsp;<b><s:property value='#st.index+1'/> .&nbsp;&nbsp;<s:property value="#question.questionTitle"/></b><SPAN style="color: red;">&nbsp;*</SPAN>
						<input type="hidden" name="questionId" value="<s:property value="#question.questionId"/>"/>
					</td>
				</tr>
				 <s:iterator id="quesoption" value="#question.options">
						<tr height="20px">
							<td style="white-space:normal; word-break:break-all; word-wrap:break-word;">
							<s:if test="%{#quesoption.changeState==null}">
									<s:if test="%{#question.questionType==1}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" disabled="disabled"/><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
									</s:if>
									<s:if test="%{#question.questionType==0}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" disabled="disabled"/><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
									</s:if>
							</s:if>
							<s:if test="%{#question.questionType==0}">
								<s:if test="%{#quesoption.changeState==1}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="radio" checked="checked" disabled="disabled"/><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
								</s:if>
								<s:if test="%{#quesoption.changeState==0}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" disabled="disabled"/><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
								</s:if>
							</s:if>
							<s:if test="%{#question.questionType==1}">
								<s:if test="%{#quesoption.changeState==1}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="checkbox" checked="checked" disabled="disabled" /><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
								</s:if>
								<s:if test="%{#quesoption.changeState==0}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="checkbox" disabled="disabled" /><s:property value="#quesoption.sequence"/>.<s:property value="#quesoption.optionContent"/>
								</s:if>
							</s:if>
							</td>
						</tr>
					</s:iterator>
					<tr style="font-weight: bold;color: red;"><td>&nbsp;&nbsp;&nbsp;正确答案：
					 <s:iterator id="quesoption" value="#question.options">
								<s:if test="%{#quesoption.rightAnswers==1}">
									<s:property value="#quesoption.sequence"/>&nbsp;&nbsp;
								</s:if>	
				  </s:iterator>
				</td>
			</tr>
				</s:iterator>
              </div>
             
             <!--单选列表结束-->
		   </td>
         </tr>
         </s:iterator>
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
	
	<!--ct1--> 


<map name="Map" id="Map"><area shape="rect" coords="606,12,704,39" href="#" /></map></body>
</html>

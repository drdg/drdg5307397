<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$(":checkbox[value='T']").bind("click",function(){
			if($(this).is(":checked")){
				$(this).parent().find(":text").removeAttr("disabled").focus();
			}else{
				$(this).parent().find(":text").attr("disabled","disabled");
			}
		});
	});
	function validateInput(){
		var isValidation = true;
		$(".div_question:has(.required)").each(function(){
			$(this).find(".div_table_radio_question").css("background-color","transparent");
			var isEmpty = false;
			//单选按钮、复选框
			if($(this).find(":checkbox").size()>0||$(this).find(":radio").size()>0){
				 if($(this).find(":checked").size()==0){
					isEmpty = true;
				 }
				 else if($(this).find(":checked").size()==1 && 
				 		 $(this).find(":checked:eq(0)").val()=="T" && 
				 		 $(this).find(":text:eq(0)").val()==""){
				 	//只选其他不填内容时
					isEmpty = true;				 	
				 }
			}
			//文本框（使用elseif为了排除单选按钮和复选框有其他的情况）
			else if($(this).find(":text").size()>0 && $(this).find(":text:eq(0)").val()==""){
				isEmpty = true;
			}
			//文本域
			else if($(this).find("textarea").size()>0 && $(this).find("textarea:eq(0)").val()==""){
				isEmpty = true;
			}
			//下拉列表
			else if($(this).find("select").size()>0 && $(this).find("select:eq(0)").val()==""){
				isEmpty = true;
			}
			if(isEmpty){
				isValidation = false;
				$(this).find(".div_table_radio_question").css("background-color","red");
			}
		});
		return isValidation;
	}
</script>

<style type="text/css">
.div_table_radio_question .qtext{
	width:800px;
	height:20px;
}
.qstext{
	width:690px;
}
.div_table_radio_question .qlbl{
	margin:0 20px 0 5px;
}
.div_table_radio_question .qarea{
	width:800px;
	height:78px;
}
.div_table_radio_question .qsel{
	width:300px;
	height:20px;
}
.div_table_radio_question .qlbl, .qcheck, .qradio, .qstext{
	vertical-align: middle;	
}
.survey_submit{
	background: url(images/tijiao.jpg) no-repeat 0px 0px;
	height:26px;
	width:70px;
	border:medium none;
}
</style>
<title>在线调查</title>
</head>
	<body>
	<div class="Contentbox" style="width:998px;">
		<form action="${pageContext.request.contextPath}/completeSurvey.action" method="post">
			<input type="hidden" name="surveyId" value="<s:property value="surveyId"/>" />
			<table style="width: 950px;" border="0" align="center" class="right_con">
				<tr>
					<td height="35" align="center" class="mainred20">
						<s:property value="survey.name" />
					</td>
				</tr>
				<tr>
					<td class="main12h" style="color: #000000; border: 1px dotted #D40811; border-top: 0px; padding: 5px;">
						<s:property value="survey.description"/>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<!--单选列表开始-->
						<div class="fieldset">
							<!--标题开始-->
							<DIV id="div1" class="div_question">
								<DIV class="div_title_question_all">
									<DIV class="div_title_question"
										style="background-color: #fff0d4; font-size: 14px; color: #000000; text-align: center;">
										<SPAN style="color: red; font-size: 12px;">※&nbsp;</SPAN>调查题目
										<SPAN style="color: red; font-size: 12px;">&nbsp;※</SPAN>
									</DIV>
									<DIV style="clear: both;"></DIV>
								</DIV>
							</DIV>
							<!--标题结束-->
							<s:iterator value="questionList" var="question" status="sta">
								<DIV class="div_question">
									<DIV class="div_title_question_all">
										<DIV class="div_topic_question">
											<B><s:property value="#sta.index+1"/></B>
											<s:if test="1==type || 3==type">
												<input type="hidden" name="answerList[<s:property value="#sta.index"/>].checkboxFlag" value="1" />
											</s:if>
											<input type="hidden" name="answerList[<s:property value="#sta.index"/>].questionID" value="<s:property value="ID"/>"/>
										</DIV>
										<DIV class="div_title_question">
											<s:property value="name"/>:
											<s:if test="1==required">
												<span class="required" style="color: red;">&nbsp;*</span>
											</s:if>
										</DIV>
										<DIV style="clear: both;"></DIV>
									</DIV>
									<DIV class="div_table_radio_question">
										<DIV class="div_table_clear_top"></DIV>
										<s:property value="questionHtml" escapeHtml="false"/>
										<DIV style="clear: both;"></DIV>
										<DIV class="div_table_clear_bottom"></DIV>
									</DIV>
								</DIV>
							</s:iterator>
						</div>
						<!--单选列表结束-->
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" class="survey_submit" value="" onclick="return validateInput();"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>
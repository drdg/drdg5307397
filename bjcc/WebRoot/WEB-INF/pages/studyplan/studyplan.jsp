<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/demos/cupertino/theme.css' />
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.css' />
		<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.print.css' media='print' />
		<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
		<script type='text/javascript' src='${pageContext.request.contextPath }/js/jquery.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath }/js/jquery.cookie.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/jquery/jquery-ui-1.8.23.custom.min.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath }/js/ajax.js'></script>
		<script type='text/javascript'>
	//学习计划日期
	var currdate = null;
	//定时器
	var interval = null;
	var json = [ {
//		'title' : 'All Day Event',
//		'start' : '2012-11-09',
//		'end' : '2012-11-09',
//		'backgroundColor' : 'fad38e',
//		'borderColor' : 'fad38e',
//		'textColor' : 'red',
//		'color' : 'yellow'
	}];
	$(document).ready(
			function() {
				var date = new Date();
				var d = date.getDate();
				var m = date.getMonth();
				var y = date.getFullYear();
				$('#calendar')
						.fullCalendar(
								{
									editable : true,
									disableDragging : true,
									height : 200,
									header : {
										left : '',
										center : '', //today, prev, next
										right : '' //right: 'month,agendaWeek,agendaDay'     title
									},
									selectable: true,
									titleFormat : 'yyyy-MM',
									buttonIcons : {
										prev : 'circle-triangle-w',
										next : 'circle-triangle-e'
									},
									monthNames : [ "1", "2", "3", "4",
											"5", "6", "7", "8", "9", "10",
											"11", "12" ],
									monthNamesShort : [ "1", "2", "3", "4",
											"5", "6", "7", "8", "9", "10",
											"11", "12" ],
									dayNames : [ "星期日", "星期一", "星期二", "星期三", "星期四",
											"星期五", "星期六" ],
									dayNamesShort : [ "星期日", "星期一", "星期二", "星期三",
											"星期四", "星期五", "星期六" ],
									today : [ "今天" ],
									firstDay : 1,
									buttonText : {
										today : '今天',
										month : '月',
										week : '周',
										day : '日',
										prev : '上一月',
										next : '下一月'
									},
									events : json,
									dayClick : handleday,
									eventClick : viewtask
<%--									eventClick : clicktask--%>
								});
				$('.fc-button-prev').unbind('click');
				$('.fc-button-prev').bind('click', prevmon);
				$('.fc-button-next').unbind('click');
				$('.fc-button-next').bind('click', nextmon);
				//gotodate(2012, 12);
			});
	//鼠标经过查看学习计划
	function viewtask(calEvent, jsEvent, view) {
		var date = $.fullCalendar.formatDate(calEvent.start, "yyyy-MM-dd");
		parent.showTipsWindown(600, 493,"${pageContext.request.contextPath }/queryProgramStudyPlanAction.action?qryDate="+date+"&rand="+Math.random());
		return false;
	}
	function handleday(date, allDay, jsEvent, view) {
		selectday(date);
	}
	//点击某天添加任务
	function addtask(obj) {
		$("#calendar").fullCalendar('renderEvent', obj, true);
	}
	//删除任务
	function removetask(taksid) {
		$("#calendar").fullCalendar('removeEvents', taksid);
	}
	//跳至某月
	function gotodate(year, mon) {
		$("#calendar").fullCalendar('gotoDate', year, mon);
	}
	//点击某任务
	function clicktask(calEvent, jsEvent, view) {
		selectday(calEvent.start);
		return false;
	}
	
	function selectday(date) {
		//alert($.fullCalendar.formatDate(date, "yyyy-MM-dd"));
		$("#calendar").fullCalendar( 'select', date, date, true );
		currdate = date;
		return false;
	}
	//点击上一月
	function prevmon() {
		$('#calendar').fullCalendar('prev');
		inityearmon();
		return false;
	}
	//点击下一月
	function nextmon() {
		$('#calendar').fullCalendar('next');
		inityearmon();
		return false;
	}

	function inityearmon(){
		var year = $.fullCalendar.formatDate($('#calendar').fullCalendar('getDate'), "yyyy");
		var mon = $.fullCalendar.formatDate($('#calendar').fullCalendar('getDate'), "MM");
		$('#headplan').contents().find('#year').html(year);
		$('#headplan').contents().find('#mon').html(mon);
		inittask();
		return false;
	}
	
	//去选课
	function xuanke() {
		if(currdate==null) {
			alert("请选择日期");
			return false;
		}
		var date = $.fullCalendar.formatDate(currdate, "yyyy-MM-dd");
		$.cookie("programIds", null);
		$.cookie("names", null);
		$.cookie("imgurls", null);
		$.cookie("channels", null);
		$.cookie("speakers", null);
		$.cookie("paths", null);
		bool = "false";
		submitAsyFormByJson("<%=request.getContextPath()%>/clearTempDataStudyPlanAjaxAction.action", "form1", 
				function(data){
			if(data.result=="success") {
				bool = "true";
			}
		});
		if(bool == "true") {
			window.open("${pageContext.request.contextPath }/programAction.action?selectTag=1&slectDate="+date+"&rand="+Math.random());
		}
		return false;
	}

function scanStudyPlan() {
	//选课去
		if($.cookie("select_succ_flag") == "success") {
			//clearInterval(interval);
			//删除学习计划
			if($.cookie("isdelete") == "yes") {
				removetask($.cookie("studyPlanId"));
				$.cookie("isdelete", null);
				$.cookie("studyPlanId", null);
				return false;
			}
			
			requestByAjax("${pageContext.request.contextPath }/dataLoadStudyPlanAjaxAction.action",{},
				function(data){
					$.each(data.studyPlanList, function(i, plan){
						if(plan.cnt=="0") {
							removetask(plan.studyPlanId);
						} else {
							addplan(plan);
						}
					}
				)});
			
			var bool = "false";
			submitAsyFormByJson("<%=request.getContextPath()%>/clearTempDataStudyPlanAjaxAction.action", "studyPlanForm", 
					function(data){
				if(data.result=="success") {
					bool = "true";
				}
			});
			$.cookie("select_succ_flag", "init");
			if(bool=="true") {
				return true;
			}else {
				return false;
			}
		} else if($.cookie("select_succ_flag") == "failed") {
			//clearInterval(interval);
			$.cookie("select_succ_flag", "init");
		}

		
}

	function inittask() {
		var url = "${pageContext.request.contextPath }/loadStudyPlanAjaxAction.action";
		var mon = $.fullCalendar.formatDate($('#calendar').fullCalendar('getDate'), "yyyy-MM");
		var params = {'qryMon':mon, 'queryTag':'main'};
		requestByAjax(url,params,loadPlanCallBack);
	}

	var loadPlanCallBack = function(data) {
		var tasklist = data.studyPlanList;
		$(tasklist).each(function(i){
			removetask(tasklist[i].studyPlanId);
			var obj = new Object();
			obj.id = tasklist[i].studyPlanId;
			obj.title = "已选课"+tasklist[i].cnt;
			obj.start = tasklist[i].studyTime;
			obj.backgroundColor = "fad38e";
			obj.borderColor = "fad38e";
			obj.textColor = "red";
			obj.color = "yellow";
			addtask(obj);
		});
	}

	function addplan(plan) {
		removetask(plan.studyPlanId);
		var obj = new Object();
		obj.id = plan.studyPlanId;
		obj.title = "已选课"+plan.cnt;
		obj.start = plan.studyTime;
		obj.backgroundColor = "fad38e";
		obj.borderColor = "fad38e";
		obj.textColor = "red";
		obj.color = "yellow";
		addtask(obj);
	}
	
	function delplan() {
		
		var url = "${pageContext.request.contextPath }/delStudyPlanAjaxAction.action";
		var date = $.fullCalendar.formatDate(currdate, "yyyy-MM-dd");
		var params = {'qryDate':date};
		requestByAjax(url,params,delPlanCallBack);
		return false;
	}

	var delPlanCallBack = function (data) {
		if( null != data.studyPlanId) {
			removetask(data.studyPlanId);
		}else{
			alert("删除学习计划失败");
		}
		return false;
	}
	
	$(function() {
		$.cookie("select_succ_flag", "init");
		inityearmon();
		interval = setInterval(scanStudyPlan, 1500);
	});
</script>
<style type="text/css">
body {
	background-color: white;
	background-image: none;
	margin-top: 0px;
	text-align: center;
	font-size: 11px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#calendar {
	background-color: white;
	width: 100%;
	height: 100%;
	margin-top: 1px;
}
</style>
	</head>
	<body>
		<div class="news" style="height: 100%">
			<iframe name="headplan" id = "headplan" src="${pageContext.request.contextPath }/headStudyPlanAction.action"
			 frameBorder="0" scrolling="no" marginwidth="0"
						marginheight="0" width="100%" height="30;"></iframe>
			<form id = "form1">
			<div id='calendar'></div>
			</form>
			
		</div>
	</body>
</html>
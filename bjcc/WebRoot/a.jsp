<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String datetime = request.getParameter("datetime");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>北京长城网</title>
		<link rel='stylesheet' type='text/css'
			href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/demos/cupertino/theme.css' />
		<link rel='stylesheet' type='text/css'
			href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.css' />
		<link rel='stylesheet' type='text/css'
			href='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.print.css'
			media='print' />
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/js/jquery.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/jquery/jquery-ui-1.8.23.custom.min.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/js/fullcalendar-1.5.4/fullcalendar/fullcalendar.min.js'></script>
		<script>
		var json = [ {
			'title' : 'All Day Event',
			'start' : '2012-11-09',
			'backgroundColor' : 'red'
		}, {
			'id' : 999,
			'title' : '看着好看',
			'start' : '2012-11-15',
			'allDay' : true,
			'backgroundColor' : 'blue'
		} ];
$(document).ready(function() {
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
	
	$('#calendar').fullCalendar( {
		editable : true,
		disableDragging : true,
		height : 200,
		header: {      
            left:  '',
            center: 'prev, next ',   //today, 
            right: 'title' //right: 'month,agendaWeek,agendaDay'     
        },
        titleFormat: 'yyyy-MM',
        buttonIcons:{prev: 'circle-triangle-w',next: 'circle-triangle-e'},
		monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],   
        monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],   
        dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],   
         dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],   
         today: ["今天"],   
         firstDay: 1,   
         buttonText: {   
           today: '今天',   
           month: '月',   
           week: '周',   
           day: '日',   
           prev: '上一月',   
           next: '下一月'  
         },   
		events : json,
		dayClick : handleday,
		eventClick: clicktask
	});
	$('.fc-button-prev').unbind('click');
	$('.fc-button-prev').bind('click', prevmon);
	$('.fc-button-next').unbind('click');
	$('.fc-button-next').bind('click', nextmon);
	
	//gotodate(2012, 12);
});

function handleday(date, allDay, jsEvent, view){
	//var datetime = date.format("yyyy-MM-dd");
	var datetime = $.fullCalendar.formatDate(date,"yyyy-MM-dd");
	updatedaytask(datetime);
	removetask(999);
	var obj = new Object();
	
	obj.id = 999;
	obj.title = "测试添加aaa";
	obj.start = '2012-11-15';
	//obj.start = datetime;
	addtask(obj);
	
	var strStyle = "help:no;minimize:no;maximize:yes;border:thick;statusbar:no;"
		+ "dialogWidth=800px;dialogHeight=650px;center:yes;status:no;edge: raised";
	var url = "${pageContext.request.contextPath }/a.jsp?datetime="+datetime+"&rand="+Math.random();
	//var win = window.showModalDialog(url,"添加问题",strStyle);
	//window.location.href = url;
	//alert(datetime);
}
//点击某天添加任务
function addtask(obj){
	$("#calendar").fullCalendar('renderEvent',obj,true);
}
//删除任务
function removetask(taksid) {
	$("#calendar").fullCalendar('removeEvents',taksid);
}
//跳至某月
function gotodate(year, mon) {
	$("#calendar").fullCalendar('gotoDate',year, mon);
}
//点击某任务
function clicktask(calEvent, jsEvent, view){
	//alert(calEvent.title+"..."+$.fullCalendar.formatDate(calEvent.start,"yyyy-MM-dd"));
	updatedaytask($.fullCalendar.formatDate(calEvent.start,"yyyy-MM-dd"));
}
//更新某天的任务
function updatedaytask(date) {
	alert(date);
}
//点击上一月
function prevmon(){
	$('#calendar').fullCalendar('prev');
	alert("prevmon:"+$.fullCalendar.formatDate($('#calendar').fullCalendar('getDate'),"yyyy-MM"));
}
//点击下一月
function nextmon(){
	$('#calendar').fullCalendar('next');
	alert("nextmon:"+$.fullCalendar.formatDate($('#calendar').fullCalendar('getDate'),"yyyy-MM"));
}
</script>
<style type="text/css">
body {
	background-color: white;
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	margin-top: 40px;
}

#calendar {
	background-color: white;
	width: 700px;
	height: 100%;
	margin: 0 auto;
}
</style>
</head>
	<body>
		<div id='calendar'></div>
	</body>
</html>
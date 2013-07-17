<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
<title>员工表</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/emp/css/add.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/gettime.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/getaddress.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/gunzhou.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/checked.js"></script>
</head>

<body onLoad="setup()">
	<!--主窗体-->
	<div class="mainDiv">
		<div class="bottom">
		
			<form action="<%=basePath %>Corporation?type=6&key=1&pageNow=1" method="post">
			<table  border="1"class="tab">
				<tr>
					<td>姓名</td>
					<td>
						<input type="text" id="ztcss" name="ename" maxlength="3" class="ename"/>
					</td>
					
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<label><input type="radio" value="男" checked="checked" name="esex"/>男</label>
						<label><input type="radio" value="女" name="esex"/>女</label>
					</td>	
				</tr>
				
				<tr>
					<td>生日</td>
					<td>
						<input type="text" name="ebirthday" readonly="true" onClick="setDay(this);" id="ztcss" class="ebir"/>&nbsp;age:
						<input type="text" value="24" name="eage" id="ztcss" readonly="true" class="eage" style="width:20px; border:1px #FF0000 solid; "/>岁
					</td>
					<td align="center" style="border:0px;">员</td>
				</tr>
				<tr>
					<td>政治面貌</td>
					<td>
						<label><input type="radio" value="团员" name="epa" checked="checked"/>团员</label>
						<label><input type="radio" value="党员" name="epa"/>党员</label>
						<label><input type="radio" value="无党人士" name="epa"/>无党人士</label>
					</td>
					<td align="center" style="border:0px;">工</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><select id="tid1" name="tid1"></select>
    					<select id="tid2" name="tid2"></select>
    					<select id="tid3" name="tid3"></select>
					</td>
					<td align="center" style="border:0px;">注</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" name="ephone" id="ztcss" class="ztcss" maxlength="11"/></td>
					<td align="center" style="border:0px;">册</td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="eemail"id="ztcss" class="eemail" style="width:120px;"/></td>
					
				</tr>
				<tr>
					<td>职位</td>
					<td>
						<select name="epost">
							<option value="司机">司机</option>
							<option value="员工">员工</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>部门</td>
					<td>
						<select name="edept">
							<option value="运输部门">车辆部门</option>
							<option value="财务部门">财务部门</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td>
						<input type="text" name="eindate" readonly="true" onClick="setDay(this);" id="ztcss">
					</td>
				</tr>
				<tr>
					<td>薪水</td>
					<td><input type="text" name="esal" onfocus="ufocus(this)" onblur="ublur(this)" id="ztcss" class="esal" maxlength="5" style="width:40px;"/>
						+<span id="esal1" class="esal1">1000</span>
						+<span id="esal1" class="esal2">2000</span>
						+<span id="esal1" class="esal3">4000</span>
						+<span id="esal1" class="esal4">8000</span>
					</td>
				</tr>
				<tr>
					<td>状态</td>
					<td>员工
						<select name="estate">
							<option >培训</option>
							<option >实习</option>
							<option >正式</option>
							<option >开除</option>
						</select>
					</td>
					
				</tr>
				<tr>
					<td>备注</td>
					<td>
						<textarea name="enote" id="ztcss" class="beizhu" style="height:120px; width:300px; font-size:18px; font-family:'楷体_GB2312';"></textarea>
					</td>
					<td><input type="submit" class="sub" value="" onclick="return pdsub()"/></td>
				</tr>
				
			</table>
			</form>	
		</div>	
	</div>
</body>
</html>

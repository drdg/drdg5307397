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
</head>

<style>

body{ background-image:none; }
</style>

<body>


<table width="100%" border="0" cellspacing="0" cellpadding="0" class="news">
					   <tr>
						<td width="112" align="center" class="news_title"> 学习记录</td>
						<td width="434" align="center" valign="middle" class="xxjh_data">
						
						  <table width="300" border="0" cellspacing="0" cellpadding="0">
						  <tr>
							<td width="86">
							<select name="select" id="select" style="width:80px; height:20px;" class="blue12">
							<option>课程名称</option>
							<option>名称一</option>
						  </select>                  </td>
							<td width="157"><input class="searchInput" style=" width:150px;" type="text" name="textfield" id="textfield" /></td>
							<td width="57"><img src="${pageContext.request.contextPath }/images/sousuo_bt1.gif" /></td>
						  </tr>
						</table>
						
						</td>
					    <td width="177" align="center" valign="middle" class="tit_dqwz">
							<div class="gxh_tab" id="menu1">
							<ul>
								<li><a href="#" class="hover"  onmousemove="setTab(1,0)">集体学习</a></li>
								<li><a href="#" onmousemove="setTab(1,1)">个人学习</a></li>
							</ul>
							</div>
						</td>
				       </tr>
				  </table>
				  
				  
				   
				  <div class="xxjl_ct" id="main1">
				  
				  
				  
				  
				  
				  
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xuexi">
              <tr>
                <td width="274" align="left" class="table_xuexi_title p_l_10">课件名称</td>
                <td width="105" class="table_xuexi_title">学习开始时间</td>
                <td width="105" class="table_xuexi_title">学习结束时间</td>
                <td width="71" class="table_xuexi_title">学习时长</td>
                <td width="71" class="table_xuexi_title">学习评测</td>
                <td width="71" class="table_xuexi_title">学习成效</td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">[选修课] 中国宏观经济的展望等...</a></td>
                <td>00:00:00</td>
                <td>00:09:08</td>
                <td>15小时</td>
                <td><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15" /></td>
                <td><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16" /></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td class="p_l_10" align="left"><a href="#">[选修课] 中国宏观经济的展望等...</a></td>
                <td>00:00:00</td>
                <td>00:09:08</td>
                <td>15小时</td>
                <td><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15" /></td>
                <td><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16" /></td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">[选修课] 中国宏观经济的展望等...</a></td>
                <td>00:00:00</td>
                <td>00:09:08</td>
                <td>15小时</td>
                <td><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15" /></td>
                <td><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16" /></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td class="p_l_10" align="left"><a href="#">[选修课] 中国宏观经济的展望等...</a></td>
                <td>00:00:00</td>
                <td>00:09:08</td>
                <td>15小时</td>
                <td><a class="icon16-block35" href="#"><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15" /></a></td>
                <td><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16" /></td>
                </tr>
              <tr>
                <td class="p_l_10" align="left"><a href="#">[选修课] 中国宏观经济的展望等...</a></td>
                <td>00:00:00</td>
                <td>00:09:08</td>
                <td>15小时</td>
                <td><img src="${pageContext.request.contextPath }/images/xxpc_ico.gif" width="14" height="15" /></td>
                <td><img src="${pageContext.request.contextPath }/images/xxcx_ico.gif" width="16" height="16" /></td>
                </tr>
              <tr class="table_xuexi_shen">
                <td colspan="6" align="right" class="p_l_10">
				
				第 1 页 &nbsp;共 2 页 &nbsp;共 9 门课程&nbsp;&nbsp;&nbsp;<a href="#">首 页</a> &nbsp;<a href="#">上一页</a> &nbsp;<a href="#"><span>下一页</span></a> &nbsp;<a href="#"><span>末 页</span></a> &nbsp;第
                  <input name="text" type="text" class="pageinput" style="width:30px;" />
                  页
                  <input name="提交" type="submit" class="pagebutton" value="跳转" />
				
				</td>
              </tr>
            </table>
				  
				  
				  
				  
				  
					
					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none;">
					  <tr>
						<td>暂无内容</td>
					  </tr>
					</table>
					
					
					
				  
				  
				  </div>

</body>
</html>

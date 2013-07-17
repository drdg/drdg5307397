<%@ page language="java" import="java.util.*, com.sino.system.constant.Constant" pageEncoding="UTF-8"%>
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
<title>选课页面</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/study.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style2.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath }/css/style3.css" rel="stylesheet" />

<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/js_gxh.js"></script>
<script language="javascript" type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/json2.js"></script>

<script language="javascript" type="text/javascript">
var s=8;/*可以改变收缩与展开的速度,试着修改看看效果*/
var minheight=35;/*可以改变收缩后的高度,试着修改看看效果*/
var maxheight=300;/*可以改变展开的最大高度,试着修改看看效果*/
$(function(){
	   document.getElementById("key").innerText="展开               ";
});
function shoppingcat(){
 var key = document.getElementById("key").innerText;
 if(key.indexOf("展开")>=0){
  content.style.pixelHeight+=s;
  if(content.style.pixelHeight<maxheight){
   setTimeout("shoppingcat();",1);
  }else{
   document.getElementById("key").innerText="关闭               ";
  }
 }else{
  content.style.pixelHeight-=s;
  if(content.style.pixelHeight>minheight){
   setTimeout("shoppingcat();",1);
  }else{
   document.getElementById("key").innerText="展开               ";
  }
 }
}
</script>
<style>
body{ background-image:none; }
</style>
</head>

<body>
	<div class="contant">
	
		<!--head--> 
		<div style="margin:auto; overflow:hidden;">
		<iframe src="<%=Constant.HEAD_URL %>" width="1000" height="300" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
		</div>
		
		<!--head--> 
		
	<!--ct1--> 
	
		 <div class="study_tt">
			<div class="two_title_2">&nbsp;&nbsp;&nbsp;&nbsp;选&nbsp;&nbsp;&nbsp; 课</div>
		 </div>	
		 
		 
			<div class="xk_tab">
				<div class="xk_tab_tt" id="menu_a1">
					<ul>
						<li><a href="#" class="hover"  onmousemove="setTab1(1,0)">猜你喜欢</a></li>
						<li><a href="#" onmousemove="setTab1(1,1)">大家都看</a></li>
						<li><a href="#" onmousemove="setTab1(1,2)">热点推荐</a></li>
					</ul>
				</div>
				<div class="xk_tab_ct" id="main_a1">
					<ul>
					 	<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">创意农业思考与探索</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">历史文献纪录片《信仰》</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">城乡统筹与经济发展</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
						<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>						</li>
					</ul>
					
					<ul style="display:none">
					 	<li>暂无内容</li>
					</ul>
					
					<ul style="display:none">
					 	<li>暂无内容</li>
					</ul>
				</div>
			</div>
			
			
			<div class="xk_ct">
			
			
			
			<div class="xk_zkyc1" id="key" onclick="shoppingcat()"><a class="xk_zkyc1" href="#"></a></div>
			
			<div class="search" style="padding:8px 0 0 0;">
			  <table border="0" align="center" cellpadding="0" cellspacing="0"  >
                <tr>
                  <td width="260" align="center" valign="middle">关键字：
                    <input type="text" name="textfield" style=" width:200px;" /></td>
                  
                  <td width="100" align="center" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/sousuo_bt.jpg" width="88" height="24" border="0" /></a></td>
                </tr>
              </table>
			</div>
			
			
			
			<div class="xk_ct_list">
			
				<ul>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">创意农业思考与探索</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					<li>
						<span class="xk_tab_ct_span1"><a href="#"><img src="${pageContext.request.contextPath }/images/video_img.jpg" border="0" /></a></span>
						<span class="xk_tab_ct_span2"><a href="#">企业营销中的营销热点推荐人生企业营销中的营销人生</a></span>
						<span class="xk_tab_ct_span3">主讲：张某</span>
						<span class="xk_tab_ct_span4"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_tj_bt.gif" border="0" /></a></span>					
					</li>
					

					


				
				</ul>
			</div>
			
			
			
			<div class="xk_yema" >
				<strong><img src="${pageContext.request.contextPath }/images/icon5.gif" width="13" height="7" /><a href="#">首 页</a></strong>｜<strong><a href="#">上一页</a></strong>｜<strong><a href="#">下一页</a></strong>｜<strong><a href="#">尾 页</a></strong>　共 30600 个问题　共 3060 页/第 1 页
			  </div>
			
			</div>
		 
		 
	<!--ct1--> 
	
	</div>
	
	<div class="copyright">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height:24px;">
		  <tr>
			<td height="26" align="center" valign="middle" background="${pageContext.request.contextPath }/images/bottom_bg.gif" style="color:#fff;"><a href="#" class="nav_word">关于我们</a> | <a href="#" class="nav_word">网站地图</a> | <a href="#" class="nav_word">设为首页</a> | <a href="#" class="nav_word">加入收藏</a> | <a href="#" class="nav_word">联系我们</a> | <a href="#" class="nav_word">免责声明</a></td>
		  </tr>
		  <tr>
			<td height="120" align="center" valign="middle">主办：北京市农村党员干部现代远程教育工作领导协调小组办公室<br />
			  技术支持：北京市农林科学院农业科技信息研究所<br />
			  北京长城网：<a href="../lxwm/20100726/16702.html" target="_blank">http://www.bjcc.gov.cn</a><br />
		    备案/许可证编号为：京ICP备09056845号</td>
		  </tr>
	  </table>

	</div>
	
	<div class="xklb_fd">
		<div class="xklb_fd_tt">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="77%" height="28" align="left" valign="middle">选课列表</td>
				<td width="12%" height="28" align="right" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_qbbc.gif" width="94" height="21" border="0" /></a></td>
				<td width="7%" height="28" align="right" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_qingkong.gif" width="58" height="21" border="0" /></a></td>
				<td width="4%" height="28" align="right" valign="middle" style="font-size:12px; font-weight:normal;"><a href="#">隐藏</a></td>
			  </tr>
		  </table>
		</div>
		
		<div class="xklb-fd_ct">
		
		<table width="98%" height="120" border="0" align="center" cellpadding="0" cellspacing="0" style="color:#7d7d7d;">
		  <tr>
			<td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="49%" rowspan="2" align="left" valign="middle" class="xk_fd_img"><img src="${pageContext.request.contextPath }/images/xk_fd_img.jpg" width="81" height="61" /></td>
                <td width="51%" height="40" align="left" valign="middle">
					<div class="xk_fd_tt_1"><a href="#">城乡与统筹经济的发展（下）</a></div>				</td>
              </tr>
              <tr>
                <td height="23" align="left" valign="middle">主讲：张某</td>
              </tr>
              <tr>
                <td height="30" colspan="2" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a></td>
              </tr>
            </table></td>
			<td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="49%" rowspan="2" align="left" valign="middle" class="xk_fd_img"><img src="${pageContext.request.contextPath }/images/xk_fd_img.jpg" width="81" height="61" /></td>
                <td width="51%" height="40" align="left" valign="middle"><div class="xk_fd_tt_1"><a href="#">城乡与统筹经济的发展（下）</a></div></td>
              </tr>
              <tr>
                <td height="23" align="left" valign="middle">主讲：张某</td>
              </tr>
              <tr>
                <td height="30" colspan="2" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a></td>
              </tr>
            </table></td>
			<td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="49%" rowspan="2" align="left" valign="middle" class="xk_fd_img"><img src="${pageContext.request.contextPath }/images/xk_fd_img.jpg" width="81" height="61" /></td>
                <td width="51%" height="40" align="left" valign="middle"><div class="xk_fd_tt_1"><a href="#">城乡与统筹经济的发展（下）</a></div></td>
              </tr>
              <tr>
                <td height="23" align="left" valign="middle">主讲：张某</td>
              </tr>
              <tr>
                <td height="30" colspan="2" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a></td>
              </tr>
            </table></td>
			<td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="49%" rowspan="2" align="left" valign="middle" class="xk_fd_img"><img src="${pageContext.request.contextPath }/images/xk_fd_img.jpg" width="81" height="61" /></td>
                <td width="51%" height="40" align="left" valign="middle"><div class="xk_fd_tt_1"><a href="#">城乡与统筹经济的发展（下）</a></div></td>
              </tr>
              <tr>
                <td height="23" align="left" valign="middle">主讲：张某</td>
              </tr>
              <tr>
                <td height="30" colspan="2" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a></td>
              </tr>
            </table></td>
			<td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="49%" rowspan="2" align="left" valign="middle" class="xk_fd_img"><img src="${pageContext.request.contextPath }/images/xk_fd_img.jpg" width="81" height="61" /></td>
                <td width="51%" height="40" align="left" valign="middle"><div class="xk_fd_tt_1"><a href="#">城乡与统筹经济的发展（下）</a></div></td>
              </tr>
              <tr>
                <td height="23" align="left" valign="middle">主讲：张某</td>
              </tr>
              <tr>
                <td height="30" colspan="2" align="left" valign="middle"><a href="#"><img src="${pageContext.request.contextPath }/images/xk_sc_bt.gif" border="0" /></a></td>
              </tr>
            </table></td>
		  </tr>
		</table>
		</div>
	</div>
</body>
</html>

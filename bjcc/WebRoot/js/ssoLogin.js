//验证登陆的页面调用单点登录接口往session中写入用户信息
function ssoLogin(callback){
	var iframe = $("<iframe>");
	iframe.bind("load",function(){callback();});
	iframe.attr("src","http://192.168.6.76/portal/portal.do?method=toBlankNavePage&navId=402886c73bac9a83013bad1140ed0001&front=front"); 
	iframe.attr("style","display:none"); 
	$("body").append(iframe);
}
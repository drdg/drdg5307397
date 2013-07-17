/*
调用实例
var cookie = new CookiesHandler();
cookie.SetCookie("asdf","1111" ,60);//60时间 秒
if(cookie.GetCookie("asdf")!=''&&cookie.GetCookie("asdf")!=null)
{
    document.writeln('直接取值');
    document.writeln(cookie.GetCookie("asdf"));
}
*/
function CookiesHandler()
{
    /*获得Cookie解码后的值*/
    this.GetCookieVal =function (offset){
	    var endstr = document.cookie.indexOf (";", offset);
	    if (endstr == -1)
	    endstr = document.cookie.length;
	    return unescape(document.cookie.substring(offset, endstr));
    }
   /*设置Cookie*/
    this.SetCookie = function (name, value){
	    var expdate = new Date();
	    var argv = this.SetCookie.arguments;
	    var argc = this.SetCookie.arguments.length;
	    var expires = (argc > 2) ? argv[2] : null;
	    var path = (argc > 3) ? argv[3] : null;
	    var domain = (argc > 4) ? argv[4] : null;
	    var secure = (argc > 5) ? argv[5] : false;
	    if(expires!=null) expdate.setTime(expdate.getTime() + (expires * 1000));
	    //alert(expdate);
	    document.cookie = name + "=" + escape (value) +((expires == null) ? "" : ("; expires="+ expdate.toGMTString()))
	    +((path == null) ? "" : ("; path=" + path)) +((domain == null) ? "" : ("; domain=" + domain))
	    +((secure == true) ? "; secure" : "");
    }
    /*删除Cookie*/
    this.DelCookie = function (name)
    {
	    var exp = new Date();
	    exp.setTime (exp.getTime() - 1);
	    var cval = GetCookie (name);
	    document.cookie = name + "=" + cval + "; expires="+ exp.toGMTString();
    }
    /*获得Cookie的原始值*/
    this.GetCookie = function GetCookie(name)
    {
	    var cookievalue;
	    var arg = name + "=";
	    var alen = arg.length;
	    var clen = document.cookie.length;
	    var i = 0;
	    while (i < clen)
	    {
		    var j = i + alen;
		    if (document.cookie.substring(i, j) == arg)
		    {
		       cookievalue = this.GetCookieVal (j);
		       break;
		    }
		    i = document.cookie.indexOf(" ", i) + 1;
		    if (i == 0) break;
	    }
	    return cookievalue;
    }
}